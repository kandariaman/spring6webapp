package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.Domain.Author;
import guru.springframework.spring6webapp.Domain.Book;
import guru.springframework.spring6webapp.Domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import guru.springframework.spring6webapp.services.AuthorServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setISBN("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setISBN("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher penguin = new Publisher();
        penguin.setAddress("Oklhama");
        penguin.setCity("US");
        penguin.setZip(110011);
        penguin.setState("US");
        penguin.setPublisherName("Penguin");

        Publisher penguinPublisher = publisherRepository.save(penguin);
        dddSaved.setPublisher(penguinPublisher);
        noEJB.setPublisher(penguinPublisher);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");


//        System.out.println("Author Count : " + authorRepository.count());
//        System.out.println("Book Count : " + bookRepository.count());
//
//
//
//        System.out.println("Publisher is : " + penguinPublisher);
//        System.out.println("Count of publisher is : " + publisherRepository.count());
    }
}
