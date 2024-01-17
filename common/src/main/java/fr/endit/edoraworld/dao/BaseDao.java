package fr.endit.edoraworld.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.endit.edoraworld.SessionFactoryManager;

public abstract class BaseDao<T> {
    // to tell the class actually which type of class you use.
    protected abstract Class<T> getClassType();

    // to create data in your database
    public void create(T data) {
        Session session = SessionFactoryManager.getInstance().getSessionFactory().openSession();
        try {
            session.clear();
            session.beginTransaction();
            session.persist(data);
            session.getTransaction().commit();
        } catch (final Exception e) {
            // makes sure no invalid data get saved.
            if (session.getTransaction() != null && session.getTransaction().isActive())
                session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // to update data in your database (be carefully with that, there are different
    // ways using the CriteriaBuilder)
    public void update(T data) {
        Session session = SessionFactoryManager.getInstance().getSessionFactory().openSession();
        try {
            session.clear();
            session.beginTransaction();
            session.merge(data);
            session.flush();
            session.getTransaction().commit();
        } catch (final Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive())
                session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(T data) {
        Session session = SessionFactoryManager.getInstance().getSessionFactory().openSession();
        try {
            session.clear();
            session.beginTransaction();
            session.remove(data);
            session.getTransaction().commit();
        } catch (final Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive())
                session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Query<T> createNamedQuery(final String queryName) {
        Session session = SessionFactoryManager.getInstance().getSessionFactory().openSession();
        return session.createNamedQuery(queryName, this.getClassType());
    }
}
