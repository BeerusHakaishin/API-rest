package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Book;
import repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	public Book saveBook(Book book) {
		return repository.save(book);
	}
	
	public List<Book> saveBooks(List<Book> books) {
		return repository.saveAll(books);
	}
	
	public List<Book> getBooks() {
		return repository.findAll();
	}

	public Optional<Book> getBookById(Long id) {
		return repository.findById(id);
	}
	
	public String deleteBook(Long id) {
		repository.deleteById(id);
		return "Livre n°" + id + " supprime de la database";
	}
	
	public Book updateBook(Book book) {
		Book existingBook = repository.findById(book.getId()).orElse(null);
		existingBook.setTitle(book.getTitle());
		existingBook.setDescription(book.getDescription());
		existingBook.setAuthor(book.getAuthor());
		return repository.save(existingBook);
	}
}
