package se.lexicon.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.AppUser;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserDao extends CrudRepository<AppUser, String> {
    @Query("SELECT au FROM AppUser au WHERE au.username = :username")
    List<AppUser> findAppUserByUsername(String username);
}
