package com.example.springsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/05/22
 */
@Entity
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int id;

	private String name;

	private String email;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@JsonIgnore
	private String pwd;

	private String role;

	@Column(name = "create_date")
	private String createDate;

	@JsonIgnore
	@OneToMany(mappedBy="customer",fetch= FetchType.EAGER)
	private Set<Authority> authorities;
}
