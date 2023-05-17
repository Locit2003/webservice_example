package com.book_store.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.book_store.dao.IBookStoreDao;
import com.book_store.entity.Book;
import com.book_store.hibernate.utils.HibernateUtil;

public class BookStoreImpl implements IBookStoreDao{

	@Override
	public List<Book> getAllBook() {
		Session session = HibernateUtil.geSessionFactory().openSession();
		try {
			List<Book> list = session.createQuery("from Book",Book.class).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean insert(Book b) {
		Session session = HibernateUtil.geSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(b);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
	
	public static void main(String[] args) {
		List<Book> list = new BookStoreImpl().getAllBook();
	}
	
}
