package com.example.resouceserver.reposiorty;

import com.example.resouceserver.model.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/05/22
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
