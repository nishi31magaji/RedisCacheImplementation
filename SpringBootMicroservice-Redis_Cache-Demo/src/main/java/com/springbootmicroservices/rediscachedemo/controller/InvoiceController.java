package com.springbootmicroservices.rediscachedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmicroservices.rediscachedemo.entity.Invoice;
import com.springbootmicroservices.rediscachedemo.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	InvoiceService service;

	@PostMapping("/saveInvoice")
	public Invoice saveInvoice(Invoice inv) {
		return service.saveInvoice(inv);

	}

	@PutMapping("/updateInvoice/{invId}")
	public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Integer invId) {
		return service.updateInvoice(inv, invId);
	}

	@DeleteMapping("/deleteInvoice/{invId}")
	public String deleteInvoice(@PathVariable Integer invId) {
		service.deleteInvoice(invId);
		return "Employee with id: "+invId+ "deleted!";
	}

	@GetMapping("/getInvoice/{invId}")
	public Invoice getInvoice(@PathVariable Integer invId) {
		return service.getInvoice(invId);
	}

	@GetMapping("/getAllInvoices")
	public ResponseEntity<List<Invoice>> getAllInvoices() {
		return ResponseEntity.ok(service.getAllInvoices());
	}

	
	/*
	 * @PutMapping("/refresh-cache/{cacheName}") public ResponseEntity<String>
	 * refreshCache(@PathVariable String cacheName) {
	 * service.refreshCache(cacheName); return ResponseEntity.ok("Cache " +
	 * cacheName + " has been refreshed."); }
	 */
}
