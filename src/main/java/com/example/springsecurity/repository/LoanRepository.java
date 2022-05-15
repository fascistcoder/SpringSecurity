package com.example.springsecurity.repository;

import com.example.springsecurity.model.Loans;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/05/22
 */
public interface LoanRepository extends CrudRepository<Loans, Long> {
	List<Loans> findByCustomerIdOrderByStartDateDesc(int customerId);
}
