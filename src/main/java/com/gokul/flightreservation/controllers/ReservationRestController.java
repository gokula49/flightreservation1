package com.gokul.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gokul.flightreservation.dto.ReservationUpdateRequest;
import com.gokul.flightreservation.entities.Reservation;
import com.gokul.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
    
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		
		return reservationRepository.findOne(id);
				}
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
	  
		Reservation reservation = reservationRepository.findOne(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepository.save(reservation);	
	}
	
	
	
	
}
   







