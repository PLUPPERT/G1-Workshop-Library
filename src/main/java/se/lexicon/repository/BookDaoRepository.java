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
        return entityManager.find(Book.class, id);
    }
    @Override
    public Collection<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
    }
    @Override
    @Transactional
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }
    @Override
    @Transactional
    public Book update(Book book) {
        return entityManager.merge(book);
    }
    @Override
    @Transactional
    public void delete(int id) {
        Book bookToDelete = findById(id);
        entityManager.remove(bookToDelete);
    }
}
