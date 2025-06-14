package com.book_review_api.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book_review_api.book.mapper.BookMapper;
import com.book_review_api.book.model.Book;
import com.book_review_api.book.record.BookRecord;
import com.book_review_api.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Book findById(Long id){
		var book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		return book;
	}
	
	public Book save(BookRecord bookRecord) {
		var bookSaved = bookRepository.save(BookMapper.toBook(bookRecord));
		return bookSaved;
	}
	
	public Book put(BookRecord bookRecord, Long id) {
		var book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		book.setTitle(bookRecord.title());
		book.setAuthor(bookRecord.author());
		return bookRepository.save(book);
	}
	
	public void delete(Long id) {
		var book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		bookRepository.delete(book);
	}
}
