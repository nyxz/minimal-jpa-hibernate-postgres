package net.badowl.nyxz.minimal.jpa.hibernate;

import net.badowl.nyxz.minimal.jpa.hibernate.model.A;
import net.badowl.nyxz.minimal.jpa.hibernate.model.B;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            emf = Persistence.createEntityManagerFactory("nyxz-unit");
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            saveEntities(em);
//            removeBFromA(em);
//            cleanAll(em);
//            removeA(em, 4496363);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

    private static void cleanAll(EntityManager em) {
        final TypedQuery<A> aQuery = em.createQuery("SELECT a FROM A a", A.class);
        final List<A> aResultList = aQuery.getResultList();
        for (A a : aResultList) {
            em.remove(a);
        }
        final TypedQuery<B> bQuery = em.createQuery("SELECT b FROM B b", B.class);
        final List<B> bResultList = bQuery.getResultList();
        for (B b : bResultList) {
            em.remove(b);
        }
    }

    private static void removeBFromA(EntityManager em) {
        final A a = em.find(A.class, 4496363);
        a.setB(null);
        em.merge(a);
    }

    private static void removeA(EntityManager em, int id) {
        final A a = em.find(A.class, id);
        em.remove(a);
    }

    private static void saveEntities(EntityManager em) {
        final B b = new B().setLabel("Inan's B");
        final A a = new A().setLabel("Ivan").setB(b);
        b.setA(a);
        em.merge(a);
    }
}
