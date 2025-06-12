package com.book_review_api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book_review_api.book.record.BookRecord;
import com.book_review_api.book.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping(path = "/{id}")
	public BookRecord findById(@PathVariable Long id) {
		return bookService.findById(id);
	}
}
