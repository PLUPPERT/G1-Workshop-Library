package se.lexicon.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.entity.AppUser;
import se.lexicon.entity.Details;

import java.time.LocalDate;

@TestComponent
class AppUserDAORepositoryTest {

    @Autowired
    AppUserDao appUserDao;

    Details details;
    AppUser user;

    @BeforeEach
    void setUp() {
        details = new Details("test1@testing.te", "Ulp Testsson", LocalDate.now().minusYears(29));
        user = new AppUser("Tester_no_1", "aslkjgfsdlkgfj3245P", LocalDate.now(), details);
    }

/*    @AfterEach
    void tearDown() {

    }*/

    @Test
    void findById() {
        AppUser createdUser = appUserDao.create(user);
        int expectedId = createdUser.getAppUserId();
        int actualId = appUserDao.findById(expectedId).getAppUserId();

        Assertions.assertEquals(expectedId, actualId);
    }

    @Test
    void findAll() {
        Details details2 = new Details("test2@testing.te", "Another One", LocalDate.now().minusYears(39));
        AppUser user2 = new AppUser("Tester_no_2", "aslkjgf458?kgfj3245P", LocalDate.now(), details2);
        appUserDao.create(user);
        appUserDao.create(user2);

        int expectedNumOfUsers = 2;
        int actualNumOfUsers = appUserDao.findAll().size();

        Assertions.assertEquals(expectedNumOfUsers, actualNumOfUsers);
    }

    @Transactional
    @Test
    void create() {
        AppUser createdUser = appUserDao.create(user);
        Assertions.assertNotNull(createdUser);
    }

    @Transactional
    @Test
    void delete() {
        AppUser createdUser = appUserDao.create(user);
        int id = appUserDao.findById(createdUser.getAppUserId()).getAppUserId();

        appUserDao.delete(createdUser);

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            appUserDao.findById(id);
        }, "No AppUser found with id: " + id);

        Assertions.assertEquals("No AppUser found with id: " + id, thrown.getMessage());
    }

    @Transactional
    @Test
    void update() {
        AppUser originalUser = appUserDao.create(user);

        originalUser.setUsername("UpdatedUser");

        String expectedUserName = originalUser.getUsername();
        appUserDao.update(originalUser);
        String actualUserName = appUserDao.findById(originalUser.getAppUserId()).getUsername();

        Assertions.assertEquals(expectedUserName, actualUserName);
    }
}
