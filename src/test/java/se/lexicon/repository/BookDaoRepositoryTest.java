package se.lexicon.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.entity.Book;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookDaoRepositoryTest {

    @Autowired
    private BookDao bookDaoRepository;
    Book testBook;
    @BeforeEach
    void setUp() {
        testBook = new Book("abcd1234-xyz","TestBook",15);
        bookDaoRepository.create(testBook);
    }

    @Test
    void findById() {

        Book foundBook = bookDaoRepository.findById(testBook.getBookId());
        Assertions.assertNotNull(foundBook);
        Assertions.assertEquals(testBook.getTitle(),foundBook.getTitle());
    }

    @Test
    void findAll() {
        Book book1 = new Book("java123","Introduction to JAVA",15);
        Book book2 = new Book("python123","Introduction to Python",15);

        bookDaoRepository.create(book1);
        bookDaoRepository.create(book2);

        int expectedNumOfBooks = 2;
        int actualNumOfBooks = bookDaoRepository.findAll().size();

        Assertions.assertEquals(expectedNumOfBooks,actualNumOfBooks);
    }

    @Transactional
    @Test
    void create() {
        Book createdBook = bookDaoRepository.create(testBook);

        Assertions.assertNotNull(createdBook.getBookId());
        assertEquals(testBook.getTitle(),createdBook.getTitle());
        assertEquals(testBook.getIsbn(),createdBook.getIsbn());
    }

    @Transactional
    @Test
    void update() {
        testBook.setTitle("Updated title");
        Book updatedBook = bookDaoRepository.update(testBook);

        Assertions.assertEquals(testBook.getTitle(),updatedBook.getTitle());
    }

    @Transactional
    @Test
    void delete() {
        bookDaoRepository.delete(testBook.getBookId());
        assertNull(testBook);
    }
}
