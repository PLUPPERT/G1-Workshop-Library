package se.lexicon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.Author;

import java.util.Collection;

@Repository
public interface AuthorDao extends CrudRepository<Author, String> {

}

