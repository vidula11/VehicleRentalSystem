package com.cg.ovms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.service.IBookingService;
import com.cg.ovms.service.IVehicleService;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {
	@Autowired
	private IVehicleService vservice;
	@PostMapping("/url/{did}")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle,@PathVariable Integer did) {
		return vservice.addVehicle(vehicle,did);
	}
}
