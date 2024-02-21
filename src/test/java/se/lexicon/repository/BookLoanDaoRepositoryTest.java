package se.lexicon.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.entity.BookLoan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class BookLoanDaoRepositoryTest {

    @Autowired
    private BookLoanDao bookLoanDao;

    private BookLoan testBookLoan;

    @BeforeEach
    void setUp() {
        testBookLoan = new BookLoan();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void findById() {
        BookLoan createdBookLoan = bookLoanDao.create(testBookLoan);
        BookLoan foundBookLoan = bookLoanDao.findById(testBookLoan.getLoanId());
        Assertions.assertEquals(createdBookLoan.getLoanId(), foundBookLoan.getLoanId());
    }

    @Test
    void findAll() {
        Collection<BookLoan> allBookLoans = bookLoanDao.findAll();

        assertFalse(allBookLoans.isEmpty());
        assertTrue(allBookLoans.contains(testBookLoan));
    }

    @Test
    void create() {
        BookLoan newBookLoan = new BookLoan();

        bookLoanDao.create(newBookLoan);
        assertNotNull(newBookLoan.getLoanId());
    }

    @Test
    void update() {
        testBookLoan.setReturned(true);
        bookLoanDao.create(testBookLoan);
        BookLoan updatedBookLoan = bookLoanDao.findById(testBookLoan.getLoanId());
        assertTrue(updatedBookLoan.isReturned());
    }

    @Test
    void delete(int id) {
        bookLoanDao.delete(id);
        assertNull(bookLoanDao.findById(testBookLoan.getLoanId()));

    }
}
