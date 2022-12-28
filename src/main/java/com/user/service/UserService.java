package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.Customer;

@Service
public interface UserService {

	Customer saveCustomer(Customer customer);

	List<Customer> getCustomers();

	Customer findCustomerByName(String customerName);

	Customer findCustomerById(String id);

}
