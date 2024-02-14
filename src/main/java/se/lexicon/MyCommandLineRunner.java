package se.lexicon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.dao.AppUserDao;
import se.lexicon.dao.DetailsDao;
import se.lexicon.entity.AppUser;
import se.lexicon.entity.Details;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    AppUserDao appUserDao;

    @Autowired
    DetailsDao detailsDao;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {
        Details details_1 = new Details("test1@testing.te", "Ulp Testsson", LocalDate.now().minusDays(5));
        Details details_2 = new Details("test2@testing.te", "Qwerty Testsson", LocalDate.now());
        Details details_3 = new Details("test3@testing.te", "Test Testsson", LocalDate.now().minusYears(78));
        AppUser user_1 = new AppUser("Tester_no_1", "aslkjgfsdlkgfj3245P", LocalDate.now(), details_1);
        AppUser user_2 = new AppUser("Tester_no_2", "aslkjgfsdlj3245P", LocalDate.now(), details_2);
        AppUser user_3 = new AppUser("Tester_no_3", "aslkjgfsdlkgfj32455555555P", LocalDate.now(), details_3);
        //System.out.println(detailsDao.create(details_1));
        //System.out.println(appUserDao.create(user_1));
        detailsDao.create(details_1);
        detailsDao.create(details_2);
        detailsDao.create(details_3);

        appUserDao.create(user_1);
        appUserDao.create(user_2);
        appUserDao.create(user_3);

        //detailsDao.findAll().forEach(System.out::println);

        System.out.println("\n-------------------------------\n");

        //appUserDao.findAll().forEach(System.out::println);

        System.out.println("\n-------------------------------\n");

        System.out.println("detailsDao.findById: ");
        System.out.println(detailsDao.findById(2));

        System.out.println("\n-------------------------------\n");

        System.out.println("appUserDao.findById: ");
        System.out.println(appUserDao.findById(2));
    }
}
