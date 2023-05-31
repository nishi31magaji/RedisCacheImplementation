package com.springbootmicroservices.rediscachedemo.service;

import java.util.List;

import com.springbootmicroservices.rediscachedemo.entity.Invoice;

public interface InvoiceService {

	public Invoice saveInvoice(Invoice inv);
	public Invoice updateInvoice(Invoice inv,Integer invId);
	public void deleteInvoice(Integer invId);
	public Invoice getInvoice(Integer invId);
	public List<Invoice> getAllInvoices();
  //  public void refreshCache(String cacheName);

}
