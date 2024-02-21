package se.lexicon.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.entity.Book;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookDaoRepositoryTest {

    @Autowired
    private BookDao bookDao;
    Book testBook;
    @BeforeEach
    void setUp() {
        testBook = bookDao.create(new Book("abcd12345-xyz","TestBook",15));
    }

    @Test
    void findById() {
        Book foundBook = bookDao.findById(testBook.getBookId());
        assertNotNull(foundBook);
        assertEquals(testBook.getTitle(),foundBook.getTitle());
    }

    @Test
    void findAll() {
        Book book1 = new Book("java123","Introduction to JAVA",15);
        Book book2 = new Book("python123","Introduction to Python",15);

        bookDao.create(book1);
        bookDao.create(book2);

        int expectedNumOfBooks = 3;
        int actualNumOfBooks = bookDao.findAll().size();

        assertEquals(expectedNumOfBooks,actualNumOfBooks);
    }

    @Transactional
    @Test
    void create() {
        Book createdBook = bookDao.create(new Book("öbcd12345-xyz","Created Book",15));
        int id = createdBook.getBookId();

        assertNotNull(createdBook);
        assertEquals(createdBook.getTitle(),bookDao.findById(id).getTitle());
        assertEquals(createdBook.getIsbn(),bookDao.findById(id).getIsbn());
    }

    @Transactional
    @Test
    void update() {
        String newTitle = "Updated title";
        testBook.setTitle(newTitle);
        Book updatedBook = bookDao.update(testBook);

        assertEquals(newTitle, updatedBook.getTitle());
    }

    @Transactional
    @Test
    void delete() {
        int id = testBook.getBookId();
        bookDao.delete(id);
        assertNull(bookDao.findById(id));
    }
}
