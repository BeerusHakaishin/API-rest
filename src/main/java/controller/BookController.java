package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Book;
import service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public List<Book> findAll() {
		return service.getBooks();
	}
	
	@GetMapping("/book/{id}")
	public Optional<Book> findById(@PathVariable Long id) {
		return service.getBookById(id);
	}
	
	@PostMapping("/saveBook")
	public Book saveBook(@RequestBody Book book) {
		return service.saveBook(book);
	}
	
	@PostMapping("/saveBooks")
	public List<Book> saveBooks(@RequestBody List<Book> books) {
		return service.saveBooks(books);
	}
	
	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {
		return service.updateBook(book);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable Long id) {
		return service.deleteBook(id);
	}
	}