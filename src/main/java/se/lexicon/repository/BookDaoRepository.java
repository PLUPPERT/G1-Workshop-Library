package se.lexicon.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.Book;

import java.util.Collection;

@Repository
public class BookDaoRepository implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public Collection<Book> findAll() {
        return null;
    }

    @Override
    @Transactional
    public Book create(Book book) {
        return null;
    }

    @Override
    @Transactional
    public Book update(Book book) {
        return null;
    }

    @Override
    @Transactional
    public void delete(int id) {

    }
}
