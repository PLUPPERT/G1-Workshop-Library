package se.lexicon.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.AppUser;

import java.util.Collection;

@Repository
public class AppUserDAORepository implements AppUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AppUser findById(int id) {
        AppUser user = entityManager.find(AppUser.class, id);
        if (user == null) throw new RuntimeException("No AppUser found with id: " + id);
        return user;
    }

    @Override
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("select u from AppUser u", AppUser.class)
                .getResultList();
    }

    @Override
    @Transactional
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public void delete(AppUser appUser) {
        entityManager.remove(appUser);
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        entityManager.merge(appUser);
        return appUser;
    }

}
