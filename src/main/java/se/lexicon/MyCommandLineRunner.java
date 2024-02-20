package se.lexicon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.dao.AppUserDao;
import se.lexicon.dao.DetailsDao;
import se.lexicon.entity.AppUser;
import se.lexicon.entity.Details;

import java.time.LocalDate;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    final AppUserDao appUserDao;
    final DetailsDao detailsDao;

    public MyCommandLineRunner(AppUserDao appUserDao, DetailsDao detailsDao) {
        this.appUserDao = appUserDao;
        this.detailsDao = detailsDao;
    }

    @Override
    public void run(String... args) {
        String dottedLine = "\n-------------------------------\n";

        Details details1 = new Details("test1@testing.te", "Ulp Testsson", LocalDate.now().minusDays(5));
        Details details2 = new Details("test2@testing.te", "Qwerty Testsson", LocalDate.now());
        Details details3 = new Details("test3@testing.te", "Test Testsson", LocalDate.now().minusYears(78));
        AppUser user1 = new AppUser("Tester_no_1", "aslkjgfsdlkgfj3245P", LocalDate.now(), details1);
        AppUser user2 = new AppUser("Tester_no_2", "aslkjgfsdlj3245P", LocalDate.now(), details2);
        AppUser user3 = new AppUser("Tester_no_3", "aslkjgfsdlkgfj32455555555P", LocalDate.now(), details3);

        detailsDao.create(details1);
        detailsDao.create(details2);
        detailsDao.create(details3);

        appUserDao.create(user1);
        appUserDao.create(user2);
        appUserDao.create(user3);


        System.out.println(dottedLine);


        System.out.println(dottedLine);

        System.out.println("detailsDao.findById: ");
        System.out.println(detailsDao.findById(2));

        System.out.println(dottedLine);

        System.out.println("appUserDao.findById: ");
        System.out.println(appUserDao.findById(2));

        System.out.println(dottedLine);

        System.out.println("Details - update() : ");

        details3.setName("Updated Namesson");
        details3.setEmail("email@domain.org");
        details3.setBirthDate(LocalDate.now().minusYears(25));

        System.out.println("Before update:");
        System.out.println(detailsDao.findById(3));
        System.out.println("After update:");
        System.out.println(detailsDao.update(details3));
    }
}
