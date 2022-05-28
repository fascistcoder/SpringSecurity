package com.example.resouceserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 14/05/22
 */
@Entity
@Getter
@Setter
public class Accounts {

	private String email;

	@Column(name="account_number")
	@Id
	private long accountNumber;

	@Column(name="account_type")
	private String accountType;

	@Column(name = "branch_address")
	private String branchAddress;

	@Column(name = "create_date")
	private String createDate;
}
