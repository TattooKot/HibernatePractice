package repository.hibernate;

import model.Writer;
import org.hibernate.Session;
import repository.WriterRepository;
import service.Utils;

import java.util.List;

public class HibernateWriterRepositoryImpl implements WriterRepository {

    @Override
    public List<Writer> getAll() {
        Session session = Utils.getNewSession();
        List<Writer> writers = (List<Writer>) session.createQuery("from Writer a join fetch a.posts").list();
        session.close();
        return writers;
    }

    @Override
    public Writer getById(Integer id) {
        Session session = Utils.getNewSession();
        Writer writer = session.get(Writer.class, id);
        session.close();
        return writer;
    }

    @Override
    public Writer create(Writer writer) {
        Session session = Utils.getNewSession();
        session.beginTransaction();
        int id = (int) session.save(writer);
        session.getTransaction().commit();
        session.close();
        return getById(id);
    }

    @Override
    public Writer update(Writer writer) {
        Session session = Utils.getNewSession();
        session.beginTransaction();
        session.update(writer);
        session.getTransaction().commit();
        session.close();
        return writer;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = Utils.getNewSession();
        session.beginTransaction();
        session.delete(getById(id));
        session.getTransaction().commit();
        session.close();
    }
}
