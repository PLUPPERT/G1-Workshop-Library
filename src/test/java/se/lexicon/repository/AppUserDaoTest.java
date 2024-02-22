package se.lexicon.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.entity.AppUser;
import se.lexicon.entity.Details;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

@SpringBootTest
class AppUserDaoTest {

    @Autowired
    AppUserDao appUserDao;
    @Autowired
    DetailsDao detailsDao;
    Details details;
    AppUser user;

    @BeforeEach
    void setUp() {
        details = new Details("test1@testing.te", "Testur Testsson", LocalDate.now().minusYears(15));
        user = new AppUser("Tester_no_1", "aslkjgfsdlkgfj3245P", LocalDate.now(), details);
    }

    @Test
    void findAppUserByUsername() {
        appUserDao.save(user);

        int expectedNumOfUsers = 1;
        int actualNumOfUsers = appUserDao.findAppUserByUsername("Tester_no_1").size();

        assertEquals(expectedNumOfUsers, actualNumOfUsers);

    }
}
