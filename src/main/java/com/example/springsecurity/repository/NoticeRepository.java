package com.example.springsecurity.repository;

import com.example.springsecurity.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/05/22
 */
public interface NoticeRepository extends CrudRepository<Notice, Long> {

	@Query(" select n from Notice n")
	List<Notice> findAllActiveNotices();

}