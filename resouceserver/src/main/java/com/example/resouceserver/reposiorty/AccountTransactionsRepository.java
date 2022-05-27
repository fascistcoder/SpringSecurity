package com.example.resouceserver.reposiorty;

import com.example.resouceserver.model.AccountsTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/05/22
 */
public interface AccountTransactionsRepository extends CrudRepository<AccountsTransaction, Long> {
	List<AccountsTransaction> findAccountsTransactionByCustomerIdOrderByTransactionDateDesc(int customerId);
}
