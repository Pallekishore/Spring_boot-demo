package com.java.project.Book.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.project.Book.Entity.Book;
import com.java.project.Book.Service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	private BookService bookService;

//	@GetMapping("/all")
//    public Page<Book> getAllBooks(Pageable pageable) {
//        return bookService.getAllBooks(pageable);
//    }
	@GetMapping("/all")
	    public Page<Book> getAllBooks(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size
	    ) {
	        return bookService.getAllBooks(PageRequest.of(page, size));
	    }
	@GetMapping
	public List<Book> getAllBooks() {
		return (List<Book>) bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}

	@GetMapping("/search")
	public List<Book> getBooksByBookName(@RequestParam("bookName") String bookName) {
		return bookService.FetchBookByBookName(bookName);
	}

	@GetMapping("/activeBooks")
	public List<Book> getActiveBooks() {
		return bookService.findByActiveBooks();
	}

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
		return bookService.updateBook(id, bookDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteByBookId(id);
	}
}
