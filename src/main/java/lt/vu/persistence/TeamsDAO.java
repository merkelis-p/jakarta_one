package lt.vu.persistence;

import lt.vu.entities.Team;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TeamsDAO {

    @Inject
    private EntityManager em;

    public List<Team> loadAll() {
        return em.createNamedQuery("Team.findAll", Team.class).getResultList();
    }

    public List<Team> searchByNameFragment(String nameFragment) {
        return em.createQuery("SELECT t FROM Team t WHERE t.name LIKE :nameFragment", Team.class)
                .setParameter("nameFragment", "%" + nameFragment + "%")
                .getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Team team){
        this.em.persist(team);
    }

    public Team findOne(Integer id) {
        return em.find(Team.class, id);
    }
}
