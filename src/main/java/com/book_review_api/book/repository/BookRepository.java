package com.book_review_api.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book_review_api.book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
