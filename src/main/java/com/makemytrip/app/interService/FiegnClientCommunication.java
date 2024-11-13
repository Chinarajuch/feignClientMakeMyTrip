package com.makemytrip.app.interService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.makemytrip.app.binding.PassengerModel;
import com.makemytrip.app.binding.TicketModel;

@FeignClient(name="IRCTC")
public interface FiegnClientCommunication {
	
	
	@PostMapping("/irctc/bookTicket")
	ResponseEntity<TicketModel> bookTicket(@RequestBody PassengerModel pm);
	
	@GetMapping("/irctc/ticket/id/{ticketId}")
	ResponseEntity<TicketModel> getByTicketId(@PathVariable int ticketId);
	
	@DeleteMapping("/irctc/ticket/delete/id/{id}")
	ResponseEntity<String> cancelTicketById(@PathVariable int id);
	
	@PutMapping("/irctc/ticket/update/id/{id}")
	ResponseEntity<TicketModel> updateTicketDetailsById(@RequestBody PassengerModel passengerModel,@PathVariable int id);

	@GetMapping("/irctc/ticket/allTickets")
	ResponseEntity<List<TicketModel>> getAllTickets();
	
	@DeleteMapping("/irctc/ticket/deleteAllTickets")
	ResponseEntity<Boolean> deleteAllTickets();
	
	@GetMapping("/irctc/ticket/pnr/{pnr}")
	ResponseEntity<TicketModel> bookingStatusByPnr(@PathVariable String pnr);
}
