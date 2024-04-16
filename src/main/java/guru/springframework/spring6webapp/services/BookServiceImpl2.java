package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.Domain.Book;
import guru.springframework.spring6webapp.repositories.BookRepository;

public class BookServiceImpl2 implements BookService {

    private final BookRepository bookRepository;
    public BookServiceImpl2(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
