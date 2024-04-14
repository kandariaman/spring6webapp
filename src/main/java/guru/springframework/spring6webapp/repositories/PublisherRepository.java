package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.Domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
