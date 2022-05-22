package otus.core.databaseClient;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import otus.core.entity.Course;
import otus.core.entity.Performance;
import otus.core.entity.User;


public class HibernateSessionCreator {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }

        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {

        return new Configuration()
                .configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Performance.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }

}
