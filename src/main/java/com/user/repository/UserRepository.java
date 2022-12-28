package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.user.entity.Customer;

@Repository
public interface UserRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "select * from customer", nativeQuery = true)
	List<Customer> getAll();

	@Query(value = "select * from customer where customer_name = ?1", nativeQuery = true)
	Customer findCustomerByName(String customerName);

	@Query(value = "select * from customer where id = ?1", nativeQuery = true)
	Customer findById(String id);
}
