package com.gokul.flightreservation.services;

import com.gokul.flightreservation.dto.ReservationRequest;
import com.gokul.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
