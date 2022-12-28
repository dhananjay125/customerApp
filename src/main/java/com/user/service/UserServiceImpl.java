package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.Customer;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Customer saveCustomer(Customer customer) {

		Customer customer1 = userRepository.save(customer);
		return customer1;
	}

	@Override
	public List<Customer> getCustomers() {

		List<Customer> customerList = userRepository.getAll();
		return customerList;
	}

	@Override
	public Customer findCustomerByName(String customerName) {

		Customer customer = userRepository.findCustomerByName(customerName);
		return customer;
	}

	@Override
	public Customer findCustomerById(String id) {

		Customer customer = userRepository.findById(id);
		return customer;
	}

}
