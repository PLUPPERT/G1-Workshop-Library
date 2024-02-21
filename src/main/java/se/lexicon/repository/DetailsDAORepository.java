/*
package se.lexicon.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.Details;

import java.util.Collection;

@Repository
public class DetailsDAORepository implements DetailsDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Details findById(int id) {
        Details details = entityManager.find(Details.class, id);
        if (details == null) throw new RuntimeException("No details found with id: " + id);
        return details;
    }

    @Override
    public Collection<Details> findAll() {
        return entityManager.createQuery("SELECT d FROM Details d", Details.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    @Transactional
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    @Transactional
    public void delete(Details details) {
        entityManager.remove(details);
    }
}
*/
