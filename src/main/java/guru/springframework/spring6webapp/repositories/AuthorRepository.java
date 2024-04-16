package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.Domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
