package se.lexicon.repository;

import org.springframework.stereotype.Repository;
import se.lexicon.entity.AppUser;

import java.util.Collection;

public interface AppUserDao {
    AppUser findById(int id);
    Collection<AppUser> findAll();
    AppUser create(AppUser appUser);
    void delete(AppUser appUser);
    AppUser update(AppUser appUser);
}
