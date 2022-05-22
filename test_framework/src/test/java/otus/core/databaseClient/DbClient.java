package otus.core.databaseClient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DbClient {

    private static Session session;

    public static void createSession() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public static void closeSession() {
        session.close();
    }

    public static <T> void insert(final T entity) {
        createSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        closeSession();
    }

    public static <T> T getById(final Class<T> clazz, final int id) {
        createSession();
        var result = session.get(clazz, id);
        closeSession();
        return result;
    }
}
