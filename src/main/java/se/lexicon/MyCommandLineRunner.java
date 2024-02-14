package se.lexicon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.dao.AppUserDao;
import se.lexicon.dao.DetailsDao;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    AppUserDao appUserDao;

    @Autowired
    DetailsDao detailsDao;

    @Override
    public void run(String... args) throws Exception {

    }
}
