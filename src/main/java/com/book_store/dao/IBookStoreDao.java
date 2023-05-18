package com.book_store.dao;

import java.util.List;

import com.book_store.entity.Book;

public interface IBookStoreDao {
	List<Book> getAllBook();
	Boolean insert (Book b);
	Book getById(int bookId);
	Boolean update(Book b);
	Boolean delete(int BookId);
}
