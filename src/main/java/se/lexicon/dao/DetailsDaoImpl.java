package se.lexicon.dao;

import org.springframework.stereotype.Repository;
import se.lexicon.entity.Details;

import java.util.Collection;

@Repository
public class DetailsDaoImpl implements DetailsDao{
    @Override
    public Details findById(int id) {
        return null;
    }

    @Override
    public Collection<Details> findAll() {
        return null;
    }

    @Override
    public Details create(Details details) {
        return null;
    }

    @Override
    public Details update(Details details) {
        return null;
    }

    @Override
    public void delete(Details details) {

    }
}
