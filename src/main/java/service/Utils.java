package service;

import model.Label;
import model.Post;
import model.Writer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utils {
    private static final Configuration configuration = new Configuration();
    private static SessionFactory sessionFactory = null;


    private Utils() {
    }

    private static void config(){
        configuration.addAnnotatedClass(Label.class);
        configuration.addAnnotatedClass(Post.class);
        configuration.addAnnotatedClass(Writer.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getNewSession(){
        if(sessionFactory == null) {
            config();
        }
        return sessionFactory.openSession();
    }

}
