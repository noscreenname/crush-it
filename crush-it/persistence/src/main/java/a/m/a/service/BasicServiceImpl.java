package a.m.a.service;

import a.m.a.HibernateFactory;
import a.m.a.entity.BasicEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasicServiceImpl<K extends Serializable, E extends BasicEntity<K>> implements BasicService<K, E> {

    @Nonnull
    private Class<E> entityClass;

    public BasicServiceImpl(@Nonnull Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Nonnull
    public Optional<E> get(@Nonnull K id) {
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            E entity = session.get(entityClass, id);
            tx.commit();
            return Optional.ofNullable(entity);
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }

    @Nonnull
    public K create(@Nullable E entity) {
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Serializable id = session.save(entity);
            tx.commit();
            return (K) id;
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }

    @Override
    public void update(@Nonnull E entity) {
        K id = checkIdNotNull(entity);
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(entityClass.getName(), id);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }

    @Override
    public void delete(@Nonnull E entity) {
        checkIdNotNull(entity);
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }


    @Nonnull
    public List<E> getAll() {
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            List entities = session.createCriteria(entityClass).list();
            tx.commit();
            return castAllOrEmptyList(entities);
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }

    private K checkIdNotNull(E entity) {
        K id = entity.getId();
        if (id == null) {
            throw new IllegalStateException("%s entity's id shouldn't be null");
        }
        return id;
    }

    @Nonnull
    protected List<E> castAllOrEmptyList(@Nullable List entities) {
        ArrayList<E> result = new ArrayList<>();
        if (entities != null) {
            for (Object entity : entities) {
                //noinspection unchecked
                result.add((E) entity);
            }
        }
        return result;
    }
}
