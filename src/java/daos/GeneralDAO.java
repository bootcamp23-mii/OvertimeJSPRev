
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author milhhamafemi
 */
public class GeneralDAO<T> implements DAOInterface<T> {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private T t;

    public GeneralDAO(SessionFactory factory, Class<T> t) {
        try {
            this.factory = factory;
            this.t = t.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GeneralDAO() {

    }

    private String getQuery(String keyword) {

        String query = "From " + t.getClass().getSimpleName();
        if (!keyword.equals("")) {
            query += " where ";
            for (Field field : t.getClass().getDeclaredFields()) {
                if (!field.getName().contains("UID") && !field.getName().contains("List")) {
                    query += field.getName() + " like '%" + keyword + "%' OR ";
                }
            }
            query = query.substring(0, query.lastIndexOf("OR"));
        }
        return query + " order by 1";
    }

    @Override
    public List<T> getData(Object keyword) {
        List<T> obj = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            obj = session.createQuery(getQuery(keyword + "")).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return obj;
    }

    @Override
    public List<T> getByMang(Object keyword) {
        List<T> obj = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            obj = session.createQuery("FROM Overtime WHERE status = 'STA01' and timesheet in(from TimeSheet where employee in(from Employee where manager = '" + keyword + "'))").list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return obj;
    }

    @Override
    public T getById(Object id) {
        T obj = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
//            ClassMetadata classMetadata =  sessionFactory.getClassMetadata(t.getClass());
            obj = (T) session.createQuery("FROM " + t.getClass().getSimpleName()
                    + " WHERE " + factory.getClassMetadata(t.getClass()).getIdentifierPropertyName()
                    + " = '" + id + "'").uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return obj;
    }

    @Override
    public boolean saveOrDelete(T entity, boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(entity);
            } else {
                session.delete(entity);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<T> login(Object username) {
        List<T> obj = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            obj = session.createQuery("FROM " + t.getClass().getSimpleName() + " WHERE ID = '" + username + "'").list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return obj;
    }

    public List<T> getByKarByMang(Object id) {
        List<T> obj = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            obj = session.createQuery("FROM " + t.getClass().getSimpleName() + " WHERE manager = '" + id + "'").list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return obj;
    }

    @Override
    public List<T> empOvertime(Object keyword) {
        List<T> obj = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            obj = session.createQuery("from Overtime where status = 'STA01' and timesheet in(from TimeSheet where employee = '" + keyword + "')").list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return obj;
    }

//    GANTI LONG / INT
    @Override
    public Long salCount(Object keyword) {
//        String obj = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
//        try {

        Long obj = (Long) session.createQuery("select sum(timeduration) from Overtime where status = 'STA02' and timesheet in(from TimeSheet where employee ='" + keyword + "')").uniqueResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        return obj;
        return obj;
    }

    @Override
    public List<T> history(Object keyword) {
        List<T> obj = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            obj = session.createQuery("from Overtime where status != 'STA01' and timesheet in(from TimeSheet where employee = '" + keyword + "')").list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return obj;
    }

}
