package com.example.springsecurity.repository;

import com.example.springsecurity.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/05/22
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByEmail(String email);
}
