package se.lexicon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.Details;

import java.util.Collection;

@Repository
public interface DetailsDao extends CrudRepository<Details, String> {
    /*Details findById(int id);
    Collection<Details> findAll();
    Details create(Details details);
    Details update(Details details);
    void delete(Details details);*/
}
