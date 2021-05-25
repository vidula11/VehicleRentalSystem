package com.cg.ovms.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.ResourceNotFound;
import com.cg.ovms.repository.IDriverRepository;
import com.cg.ovms.repository.IVehicleRepository;
import com.cg.ovms.service.IVehicleService;

@Service
public class CVehicleService implements IVehicleService{
	@Autowired
	private IVehicleRepository vrepo;
	@Autowired
	private IDriverRepository drepo;
	@Override
	public Vehicle addVehicle(Vehicle vehicle,Integer did) {
		//Optional<Driver> d1=drepo.findById(did);
		Driver d1=drepo.findById(did).orElseThrow(()->new ResourceNotFound("Driver with id"+did+"not found"));
		vehicle.setDriver(d1);
		Vehicle v1=vrepo.save(vehicle);
		d1.setVehicle(v1);
		return vrepo.save(v1);
		}
}

