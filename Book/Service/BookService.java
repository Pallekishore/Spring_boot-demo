package com.java.project.Book.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.java.project.Book.Entity.Book;
import com.java.project.Book.Repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public Book getBookById(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + id));

	}

	public Page<Book> getAllBooks(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}
	
	public List<Book> getAllBooks() {

		List<Book> list = (List<Book>) bookRepository.findAll();
		if (list.isEmpty()) {
			throw new NoSuchElementException("List Is Emplty");
		}
		return list;

	}

	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	public Book updateBook(Long id, Book bookDetails) {
		return bookRepository.findById(id).map(book -> {
			book.setTitle(bookDetails.getTitle());
			book.setAuthor(bookDetails.getAuthor());
			book.setPublishedYear(bookDetails.getPublishedYear());
			book.setActive(bookDetails.isActive());
			return bookRepository.save(book);
		}).orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + id));
	}

	public void deleteByBookId(Long id) {
		bookRepository.deleteById(id);

	}

	public List<Book> FetchBookByBookName(String bookName) {
		return bookRepository.findByTitle(bookName);
	}

	public List<Book> findByActiveBooks() {
		return bookRepository.findByActiveIsTrue();
	}

	
	

}
