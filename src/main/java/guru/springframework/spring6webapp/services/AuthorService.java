package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.Domain.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    Iterable<Author> findAll();
}
