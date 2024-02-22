package se.lexicon.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.entity.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@DataJpaTest
class BookLoanDaoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private BookLoanDao bookLoanDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AppUserDao appUserDao;
    @Autowired
    DetailsDao detailsDao;

    BookLoan bookLoan;
    Author author;
    Set<Book> bookSet = new HashSet<>();
    Book book;
    AppUser user;
    Details details;

    @BeforeEach
    void setUp() {
        details = new Details("test1@testing.te", "Testur Testsson", LocalDate.now().minusYears(15));
        user = new AppUser("Tester_no_1", "aslkjgfsdlkgfj3245P", LocalDate.now(), details);
        entityManager.persist(user);
//        appUserDao.save(user);
        bookSet.add(new Book("0123456789123", "THE Book", 50));
        author = entityManager.persist(new Author("Author", "Authland", bookSet));
        book = author.getWrittenBooks().stream()
                .filter(book1 -> book1.getTitle().equals("THE Book"))
                .findAny().orElse(null);
        bookLoan = entityManager.persist(new BookLoan(LocalDate.now(), LocalDate.now().plusDays(30), false, user, book));
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
        entityManager.persist(newUser);
        Book newBook = entityManager.persist(new Book("P123456789123", "THE Book 2", 50));
        Set<Book> newBookSet = Objects.requireNonNull(authorDao.findById("1").orElse(null)).getWrittenBooks();
        newBookSet.add(newBook);
        author.setWrittenBooks(newBookSet);
        entityManager.merge(author);
        BookLoan newBookLoan = entityManager.persist(new BookLoan(LocalDate.now(), LocalDate.now().plusDays(30), false, newUser, newBook));

        assertNotNull(bookLoanDao.findById(newBookLoan.getLoanId()));
    }

    @Transactional
    @Test
    void update() {
        bookLoan.setReturned(true);
        entityManager.merge(bookLoan);
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
