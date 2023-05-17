package com.book_store.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.book_store.dao.IBookStoreDao;
import com.book_store.dao.impl.BookStoreImpl;
import com.book_store.entity.Book;
import com.google.gson.Gson;

@Path("/book-api")
public class BookService {
	
	private IBookStoreDao bookStoreDao;
	
	public BookService() {
		bookStoreDao = new BookStoreImpl();
	}
	
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public String findAll() {
		Gson gson = new Gson();
		List<Book> list = bookStoreDao.getAllBook();
		String rs = gson.toJson(list);
		return rs;
	}
	
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertBook(String data) {
		Gson son = new Gson();
		Book book = son.fromJson(data, Book.class);
		Boolean bl = bookStoreDao.insert(book);
		String rs = son.toJson(bl);
		return rs;
	}
}
