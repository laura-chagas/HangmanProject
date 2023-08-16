package Infra;

import Domain.Entity.PlayerClass;

import javax.persistence.*;
import java.util.Objects;

public class DAO
{
    private static EntityManagerFactory entityManagerFactory;

    public static void initialize() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }
    public  void addPlayer(PlayerClass playerClass) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            entityManager.persist(playerClass);

            entityTransaction.commit();
        }
        catch (Exception exception) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            entityManager.close();
        }
    }

    public PlayerClass loginPlayer(String email, String senha){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<PlayerClass> query = entityManager.createQuery("SELECT c FROM PlayerClass c WHERE c.email = :email", PlayerClass.class);
            query.setParameter("email", email);

            PlayerClass playerClass = query.getSingleResult();


            if(Objects.equals(senha, playerClass.getSenha())){
                return playerClass;
            } else {
                throw new NoResultException("Senha incorreta");
            }

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


    public static void incrementScore(PlayerClass playerClass) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            PlayerClass player = entityManager.find(PlayerClass.class,playerClass);


            if (!(player == null)) {
                player.setScorePlayer(playerClass.getScorePlayer());
                entityManager.merge(player);
            }

            entityTransaction.commit();
        }
        catch (Exception exception) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            entityManager.close();
        }
    }
}
