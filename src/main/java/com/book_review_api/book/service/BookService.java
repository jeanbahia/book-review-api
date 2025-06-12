package com.book_review_api.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book_review_api.book.record.BookRecord;
import com.book_review_api.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public BookRecord findById(Long id){
//		var book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
//		var bookRecord = new BookRecord(book.getId(), book.getTitle(), book.getAuthor());
//		return bookRecord;
		return new BookRecord(1L, "Clean Code", "Robert C. Martin");
	}
}
