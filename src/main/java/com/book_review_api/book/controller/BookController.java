package com.book_review_api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book_review_api.book.mapper.BookMapper;
import com.book_review_api.book.record.BookRecord;
import com.book_review_api.book.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<BookRecord> findById(@PathVariable Long id) {
		return new ResponseEntity<>(BookMapper.toBookRecord(bookService.findById(id)), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<BookRecord> save(@RequestBody BookRecord bookRecord) {
		return new ResponseEntity<>(BookMapper.toBookRecord(bookService.save(bookRecord)), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<BookRecord> put(@RequestBody BookRecord bookRecord, @PathVariable Long id) {
		return new ResponseEntity<BookRecord>(BookMapper.toBookRecord(bookService.put(bookRecord, id)), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		bookService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
