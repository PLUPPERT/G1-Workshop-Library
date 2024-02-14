package se.lexicon.dao;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.AppUser;

import java.util.Collection;

@Repository
public class AppUserDaoImpl implements AppUserDao {
    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return null;
    }

    @Override
    @Transactional
    public AppUser create(AppUser appUser) {
        return null;
    }

    @Override
    public void delete(AppUser appUser) {

    }
}
