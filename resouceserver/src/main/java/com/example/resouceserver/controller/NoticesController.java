package com.example.resouceserver.controller;

import com.example.resouceserver.model.Notice;
import com.example.resouceserver.reposiorty.NoticeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/05/22
 */
@RestController
@AllArgsConstructor
public class NoticesController {
	private NoticeRepository noticeRepository;

	@GetMapping("/notices")
	public List<Notice> getNotices() {
		List<Notice> notices = noticeRepository.findAllActiveNotices();
		return !notices.isEmpty() ? notices : null;
	}
}
