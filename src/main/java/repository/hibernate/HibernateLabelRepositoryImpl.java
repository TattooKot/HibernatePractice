package repository.hibernate;

import model.Label;
import org.hibernate.Session;
import repository.LabelRepository;
import service.Utils;

import java.util.List;

public class HibernateLabelRepositoryImpl implements LabelRepository {

    @Override
    public List<Label> getAll() {
        Session session = Utils.getNewSession();
        session.beginTransaction();
        List<Label> labels = session.createQuery("select a from Label a ", Label.class).list();
        session.close();
        return labels;
    }

    @Override
    public Label getById(Integer id) {
        Session session = Utils.getNewSession();
        session.beginTransaction();
        Label label = session.get(Label.class, id);
        session.close();
        return label;
    }

    @Override
    public Label create(Label label) {
        Session session = Utils.getNewSession();
        session.beginTransaction();
        label.setId((int) session.save(label));
        session.getTransaction().commit();
        session.close();
        return label;
    }

    @Override
    public Label update(Label label) {
        Session session = Utils.getNewSession();
        session.beginTransaction();
        session.update(label);
        session.getTransaction().commit();
        session.close();
        return label;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = Utils.getNewSession();
        session.beginTransaction();
        session.delete(session.load(Label.class, id));
        session.getTransaction().commit();
        session.close();
    }
}