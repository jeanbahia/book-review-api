package com.book_review_api.book.mapper;

import com.book_review_api.book.model.Book;
import com.book_review_api.book.record.BookRecord;

public class BookMapper {
	public static BookRecord toBookRecord(Book book) {
		return new BookRecord(book.getId(), book.getTitle(), book.getAuthor());
	}
	
	public static Book toBook(BookRecord bookRecord) {
		var book = new Book();
		book.setTitle(bookRecord.title());
		book.setAuthor(bookRecord.author());
		return book;
	}
}
