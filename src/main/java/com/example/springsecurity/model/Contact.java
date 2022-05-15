package com.example.springsecurity.model;

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
@Getter
@Setter
@Entity
@Table(name = "contact_messages")
public class Contact {
	@Id
	@Column(name = "contact_id")
	private String contactId;

	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "contact_email")
	private String contactEmail;

	private String subject;

	private String message;

	@Column(name = "create_date")
	private Date createDate;
}
