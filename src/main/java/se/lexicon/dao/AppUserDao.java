package se.lexicon.dao;

import se.lexicon.entity.AppUser;

import java.util.Collection;

public interface AppUserDao {
    AppUser findById(int id);
    Collection<AppUser> findAll();
    AppUser create(AppUser appUser);
    void delete(AppUser appUser);
}
