package com.makemytrip.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makemytrip.app.binding.PassengerModel;
import com.makemytrip.app.binding.TicketModel;
import com.makemytrip.app.interService.FiegnClientCommunication;

@RestController
@RequestMapping("/makemytrip")
public class MainController {
	
	private FiegnClientCommunication fiegnClientCommunication;
	
	public MainController(FiegnClientCommunication fiegnClientCommunication) {
		this.fiegnClientCommunication = fiegnClientCommunication;
	}
	
	@PostMapping("/bookTicket")
	public ResponseEntity<TicketModel> bookTicket(@RequestBody PassengerModel pm)
	{
		return fiegnClientCommunication.bookTicket(pm);
	}
	@GetMapping("/ticket/id/{ticketId}")
	public ResponseEntity<TicketModel> getByTicketId(@PathVariable int ticketId)
	{
		return fiegnClientCommunication.getByTicketId(ticketId);
	}
	@DeleteMapping("/ticket/delete/id/{id}")
	public ResponseEntity<String> cancelTicketById(@PathVariable int id)
	{
		return fiegnClientCommunication.cancelTicketById(id);
	}
	@PutMapping("/ticket/update/id/{id}")
	public ResponseEntity<TicketModel> updateTicketDetailsById(@RequestBody PassengerModel passengerModel,@PathVariable int id) {
		return fiegnClientCommunication.updateTicketDetailsById(passengerModel, id);
	}
	@GetMapping("ticket/allTickets")
	public ResponseEntity<List<TicketModel>> getAllTickets(){
		return fiegnClientCommunication.getAllTickets();
	}
	@DeleteMapping("/ticket/deleteAllTickets")
	public ResponseEntity<Boolean> deleteAllTickets() {
		return fiegnClientCommunication.deleteAllTickets();
	}
	@GetMapping("ticket/pnr/{pnr}")
	public ResponseEntity<TicketModel> bookingStatusByPnr(@PathVariable String pnr) {
		return fiegnClientCommunication.bookingStatusByPnr(pnr);
	}
	

}
