package com.example.resouceserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 14/05/22
 */
@Entity
@Table(name = "account_transactions")
@Getter
@Setter
public class AccountsTransaction {

	@Id
	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "account_number")
	private long accountNumber;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "transaction_date")
	private Date transactionDate;

	@Column(name = "transaction_summary")
	private String transactionSummary;

	@Column(name = "transaction_type")
	private String transactionType;

	@Column(name = "closing_balance")
	private String closingBalance;

	@Column(name = "transaction_amt")
	private String transactionAmt;

	@Column(name = "create_date")
	private String createDate;
}
