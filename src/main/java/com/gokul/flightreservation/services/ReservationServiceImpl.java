package com.gokul.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokul.flightreservation.dto.ReservationRequest;
import com.gokul.flightreservation.entities.Flight;
import com.gokul.flightreservation.entities.Passenger;
import com.gokul.flightreservation.entities.Reservation;
import com.gokul.flightreservation.repos.FlightRepository;
import com.gokul.flightreservation.repos.PassengerRepository;
import com.gokul.flightreservation.repos.ReservationRepository;
import com.gokul.flightreservation.util.EmailUtil;
import com.gokul.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {

		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findOne(flightId);
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = "/home/gokula/Documents/reservations/reservation"+savedReservation.getId()+".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);
		
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return savedReservation;
	}

}
