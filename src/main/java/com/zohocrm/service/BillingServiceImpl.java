package com.zohocrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Billing;
import com.zohocrm.repository.BillingRepository;
@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingRepository billingRepo;
	
	
	@Override
	public void generateBill(Billing billing) {
		billingRepo.save(billing);
		
	}


	@Override
	public List<Billing> getAllBillings() {
		List<Billing> billings = billingRepo.findAll();
		return billings;
	}


	
}
	
	


		
		
	


