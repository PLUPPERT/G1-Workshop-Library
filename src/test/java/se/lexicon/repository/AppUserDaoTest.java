package se.lexicon.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.entity.AppUser;
import se.lexicon.entity.Details;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppUserDaoTest {

    @Autowired
    AppUserDao appUserDao;
    @Autowired
    DetailsDao detailsDao;
    Details details;
    AppUser user;

    @BeforeEach
    void setUp() {
        details = new Details("test1@testing.te", "Ulp Testsson", LocalDate.now().minusDays(5));
        user = new AppUser("Tester_no_1", "aslkjgfsdlkgfj3245P", LocalDate.now(), details);
    }

    @Test
    void findAppUserByUsername() {
//        detailsDao.save(details);
        appUserDao.save(user);

        int expectedNumOfUsers = 1;
        int actualNumOfUsers = appUserDao.findAppUserByUsername("Tester_no_1").size();

        Assertions.assertEquals(expectedNumOfUsers, actualNumOfUsers);

    }
}
