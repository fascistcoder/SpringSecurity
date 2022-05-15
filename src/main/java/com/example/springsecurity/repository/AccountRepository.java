package com.example.springsecurity.repository;

import com.example.springsecurity.model.Accounts;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/05/22
 */
public interface AccountRepository extends CrudRepository<Accounts, Long> {

	Accounts findByCustomerId(int customerId);
}
