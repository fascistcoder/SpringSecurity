package com.example.resouceserver.reposiorty;


import com.example.resouceserver.model.Cards;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/05/22
 */
public interface CardRepository extends CrudRepository<Cards, Long> {
	List<Cards> findByEmail(String email);
}
