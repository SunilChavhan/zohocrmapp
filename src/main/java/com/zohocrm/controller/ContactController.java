package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Contact;
import com.zohocrm.service.BillingService;
import com.zohocrm.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private BillingService billingService;
	
	@RequestMapping("/listcontacts")
	public String listContacts(Model model) {
		List<Contact> contacts = contactService.getContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
		
	}
	@RequestMapping("/createBill")
	public String createBill(@RequestParam("id") long id,Model model) {
	    Contact contact = contactService.getContactById(id);
		model.addAttribute("contact", contact);
		return "generate_bill";
		
	}
	@RequestMapping("/saveBill")
	public String saveBill(@ModelAttribute("billing")Billing billing,Model model) {
		billingService.generateBill(billing);
		model.addAttribute("billing", billing);
		return "list_bills";
		
	}
	@RequestMapping("/listBillings")
	public String listBillings(Model model) {
		List<Billing> billings = billingService.getAllBillings();
		model.addAttribute("billings", billings);
		return "list_bills";
		
	}

}
