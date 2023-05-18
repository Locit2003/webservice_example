package com.book_store.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String findById(@PathParam("id") Integer bookId) {
		Gson gson = new Gson();
		Book book = bookStoreDao.getById(bookId);
		String rs = gson.toJson(book);
		return rs;
	}
	

	@PUT
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateBook(String data) {
		Gson son = new Gson();
		Book book = son.fromJson(data, Book.class);
		Boolean bl = bookStoreDao.update(book);
		String rs = son.toJson(bl);
		return rs;
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteBook(@PathParam("id") int id) {
		Gson son = new Gson();
		Boolean bl = bookStoreDao.delete(id);
		String rs = son.toJson(bl);
		return rs;
	}
}
