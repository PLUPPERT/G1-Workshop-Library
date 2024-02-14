package se.lexicon.dao;

import se.lexicon.entity.AppUser;
import se.lexicon.entity.Details;

import java.util.Collection;

public interface DetailsDao {
    Details findById(int id);
    Collection<Details> findAll();
    Details create(Details details);
    Details update(Details details);
    void delete(Details details);
}
