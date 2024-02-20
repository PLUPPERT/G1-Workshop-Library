package se.lexicon.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.Book;
import se.lexicon.entity.BookLoan;

import java.util.Collection;

@Repository
public class BookLoanDaoRepository implements BookLoanDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public BookLoan findById(int id) {
        return entityManager.find(BookLoan.class, id);
    }

    @Override
    public Collection<BookLoan> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", BookLoan.class)
                .getResultList();
    }

    @Override
    @Transactional
    public BookLoan create(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Override
    @Transactional
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Override
    @Transactional
    public void delete(int id) {
        BookLoan loanedBook = findById(id);
        entityManager.remove(loanedBook);

    }

}
