package se.lexicon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.entity.*;
import se.lexicon.repository.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    AppUserDao appUserDao;
    @Autowired
    DetailsDao detailsDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    BookLoanDao bookLoanDao;
    @Autowired
    AuthorDao authorDao;


    @Override
    public void run(String... args) {
        /*String dottedLine = "\n-------------------------------\n";

        Details details1 = new Details("test1@testing.te", "Ulp Testsson", LocalDate.now().minusDays(5));
//        Details details2 = new Details("test2@testing.te", "Qwerty Testsson", LocalDate.now());
//        Details details3 = new Details("test3@testing.te", "Test Testsson", LocalDate.now().minusYears(78));
        AppUser user1 = new AppUser("Tester_no_1", "aslkjgfsdlkgfj3245P", LocalDate.now(), details1);
       AppUser user2 = new AppUser("Tester_no_2", "aslkjgfsdlj3245P", LocalDate.now(), details2);
//        AppUser user3 = new AppUser("Tester_no_3", "aslkjgfsdlkgfj32455555555P", LocalDate.now(), details3);
//
        appUserDao.save(user1);
//        appUserDao.create(user2);
//        appUserDao.create(user3);

        authorDao.save(new Author("Author", "Authland", new HashSet<>()));
        Book book = bookDao.create(new Book("0123456789123", "THE Book", 50, new HashSet<>()));
        bookLoanDao.create(new BookLoan(LocalDate.now(), LocalDate.now().plusDays(30), false, user1, book));

        Book bookToAdd = bookDao.findById(1);
        Author author = authorDao.findById("1").orElse(new Author());
        Set<Book> books = new HashSet<>();
        books.add(bookToAdd);
        author.setWrittenBooks(books);

        authorDao.save(author);*/

    }
}
