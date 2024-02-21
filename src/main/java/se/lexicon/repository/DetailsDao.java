package se.lexicon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.Details;

@Repository
public interface DetailsDao extends CrudRepository<Details, String> {

}
