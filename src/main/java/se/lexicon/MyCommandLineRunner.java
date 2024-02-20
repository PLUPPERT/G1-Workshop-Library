package se.lexicon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.repository.AppUserDao;
import se.lexicon.repository.BookDao;
import se.lexicon.repository.BookLoanDao;
import se.lexicon.repository.DetailsDao;
import se.lexicon.entity.AppUser;
import se.lexicon.entity.Details;

import java.time.LocalDate;

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


    @Override
    public void run(String... args) {
        String dottedLine = "\n-------------------------------\n";

        Details details1 = new Details("test1@testing.te", "Ulp Testsson", LocalDate.now().minusDays(5));
        Details details2 = new Details("test2@testing.te", "Qwerty Testsson", LocalDate.now());
        Details details3 = new Details("test3@testing.te", "Test Testsson", LocalDate.now().minusYears(78));
        AppUser user1 = new AppUser("Tester_no_1", "aslkjgfsdlkgfj3245P", LocalDate.now(), details1);
        AppUser user2 = new AppUser("Tester_no_2", "aslkjgfsdlj3245P", LocalDate.now(), details2);
        AppUser user3 = new AppUser("Tester_no_3", "aslkjgfsdlkgfj32455555555P", LocalDate.now(), details3);

        appUserDao.create(user1);
        appUserDao.create(user2);
        appUserDao.create(user3);


    }
}
