package com.springbootmicroservices.rediscachedemo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springbootmicroservices.rediscachedemo.entity.Invoice;
import com.springbootmicroservices.rediscachedemo.exception.InvoiceNotFoundException;
import com.springbootmicroservices.rediscachedemo.repository.InvoiceRepository;
import com.springbootmicroservices.rediscachedemo.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceRepository repository;
	@Autowired
    private CacheManager cacheManager;

	@Override
	public Invoice saveInvoice(Invoice inv) {
		return repository.save(inv);
	}

	@Override
	@CachePut(value="Invoice", key="#invId")
	public Invoice updateInvoice(Invoice newInvoice, Integer invId) {
		Invoice oldInvoice = repository.findById(invId).orElseThrow(() -> new InvoiceNotFoundException("Invoice Not found"));
		oldInvoice.setInvAmount(newInvoice.getInvAmount());
		oldInvoice.setInvName(newInvoice.getInvName());
		return repository.save(oldInvoice);
		
	}

	@Override
	@CacheEvict(value="Invoice",key="#invId")
	public void deleteInvoice(Integer invId) {
	 	repository.deleteById(invId);
	}

	@Override
	@Cacheable(value="Invoice", key="#invId")
	public Invoice getInvoice(Integer invId) {
		// TODO Auto-generated method stub
		Invoice invoice = repository.findById(invId)
				.orElseThrow(()-> new InvoiceNotFoundException("Invoice Not found"));
		return invoice;
	}

	@Override
    @Cacheable(value="Invoice", sync=true)
	public List<Invoice> getAllInvoices() {
		return repository.findAll();
		
	}
	
    // A method to refresh your cache
	/*
	 * @Override public void refreshCache(String cacheName) { Cache cache =
	 * cacheManager.getCache(cacheName); if (cache != null) { cache.clear(); //
	 * Clearing the cache } }
	 */

}
