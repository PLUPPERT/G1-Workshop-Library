package se.lexicon.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.entity.AppUser;
import se.lexicon.entity.Book;
import se.lexicon.entity.BookLoan;
import se.lexicon.entity.Details;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

@SpringBootTest
class BookLoanDaoRepositoryTest {

    @Autowired
    private BookLoanDao bookLoanDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AppUserDao appUserDao;
    @Autowired
    DetailsDao detailsDao;

    BookLoan bookLoan;
    Book book;
    AppUser user;
    Details details;

    @BeforeEach
    void setUp() {
        details = new Details("test1@testing.te", "Testur Testsson", LocalDate.now().minusYears(15));
        user = new AppUser("Tester_no_1", "aslkjgfsdlkgfj3245P", LocalDate.now(), details);
        appUserDao.save(user);
        book = bookDao.create(new Book("0123456789123", "THE Book", 50, new HashSet<>()));
        bookLoan = bookLoanDao.create(new BookLoan(LocalDate.now(), LocalDate.now().plusDays(30), false, user, book));
    }

    @Test
    void findById() {
        BookLoan foundBookLoan = bookLoanDao.findById(bookLoan.getLoanId());
        assertEquals(bookLoan.getLoanId(), foundBookLoan.getLoanId());
    }

    @Test
    void findAll() {
        Collection<BookLoan> allBookLoans = bookLoanDao.findAll();

        assertFalse(allBookLoans.isEmpty());
        assertTrue(allBookLoans.contains(bookLoan));
    }
    @Transactional
    @Test
    void create() {
        Details newDetails = new Details("test1@testing.te", "Testur Testsson", LocalDate.now().minusYears(15));
        AppUser newUser = new AppUser("Tester_no_1", "aslkjgfsdlkgfj3245P", LocalDate.now(), newDetails);
        appUserDao.save(newUser);
        Book newBook = bookDao.create(new Book("P123456789123", "THE Book 2", 50, new HashSet<>()));
        BookLoan newBookLoan = bookLoanDao.create(new BookLoan(LocalDate.now(), LocalDate.now().plusDays(30), false, newUser, newBook));

        assertNotNull(bookLoanDao.findById(newBookLoan.getLoanId()));
    }

    @Transactional
    @Test
    void update() {
        bookLoan.setReturned(true);
        bookLoanDao.update(bookLoan);
        BookLoan updatedBookLoan = bookLoanDao.findById(bookLoan.getLoanId());
        assertTrue(updatedBookLoan.isReturned());
    }

    @Transactional
    @Test
    void delete() {
        int id = bookLoan.getLoanId();
        bookLoanDao.delete(id);
        assertNull(bookLoanDao.findById(id));

    }
}
