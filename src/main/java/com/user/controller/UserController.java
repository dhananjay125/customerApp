package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.Customer;
import com.user.service.MailService;
import com.user.service.UserService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@PostMapping("/customer")
	public ResponseEntity<String> saveCustomerDetails(@RequestBody Customer customer) {
		userService.saveCustomer(customer);
		return new ResponseEntity<>("Customer details saved successfully...", HttpStatus.OK);
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = userService.getCustomers();
		return customerList;
	}

//	@GetMapping("/customers")
//	public String getAllCustomers(Model model) {
//		model.addAttribute("customers", userService.getCustomers());
//		return "customers";
//	}

	@GetMapping("/customer/name/{customerName}")
	public Customer findCustomer(@PathVariable String customerName) {
		Customer customer = userService.findCustomerByName(customerName);
		return customer;
	}

	@GetMapping("/customer/id/{id}")
	public Customer findCustomerWithId(@PathVariable String id) {
		Customer customer = userService.findCustomerById(id);
		return customer;
	}

	@RequestMapping("send-mail")
	public String send() {

		Customer customer = new Customer();
		customer.setEmail("dhananjay.chumbalkar@gmail.com");

		try {
			mailService.sendEmail(customer);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the customer.";
	}

	@RequestMapping("send-mail-attachment")
	public String sendWithAttachment() throws MessagingException {

		Customer customer = new Customer();
		customer.setEmail("dhananjay.chumbalkar@gmail.com"); //Receiver's email address

		/*
		 * Here we will call sendEmailWithAttachment() for Sending mail to the sender
		 * that contains a attachment.
		 */
		try {
			mailService.sendEmailWithAttachment(customer);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the customer.";
	}
}
