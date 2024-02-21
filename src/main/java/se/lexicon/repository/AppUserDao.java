package se.lexicon.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import se.lexicon.entity.AppUser;

@Repository
public interface AppUserDao extends CrudRepository<AppUser, String> {
    @Query("SELECT au FROM AppUser au WHERE au.username = :username")
    List<AppUser> findAppUserByUsername(String username);
}
