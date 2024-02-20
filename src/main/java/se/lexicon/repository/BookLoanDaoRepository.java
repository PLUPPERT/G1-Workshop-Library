package se.lexicon.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.BookLoan;

import java.util.Collection;

@Repository
public class BookLoanDaoRepository implements BookLoanDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public BookLoan findById(int id) {
        return null;
    }

    @Override
    public Collection<BookLoan> findAll() {
        return null;
    }

    @Override
    @Transactional
    public BookLoan create(BookLoan bookLoan) {
        return null;
    }

    @Override
    @Transactional
    public BookLoan update(BookLoan bookLoan) {
        return null;
    }

    @Override
    @Transactional
    public void delete(int id) {

    }
}
