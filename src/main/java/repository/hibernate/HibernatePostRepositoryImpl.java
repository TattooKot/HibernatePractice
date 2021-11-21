package repository.hibernate;

import model.Post;
import org.hibernate.Session;
import repository.PostRepository;
import service.Utils;

import java.util.List;

public class HibernatePostRepositoryImpl implements PostRepository {
    @Override
    public List<Post> getAll() {
        Session session = Utils.getNewSession();
        List<Post> posts = (List<Post>) session.createQuery("FROM Post p join fetch p.labels").list();
        session.close();
        return posts;
    }

    @Override
    public Post getById(Integer id) {
        Session session = Utils.getNewSession();
        Post post = session.get(Post.class, id);
        session.close();
        return post;
    }

    @Override
    public Post create(Post post) {
        Session session = Utils.getNewSession();
        session.beginTransaction();
        post.setId((int) session.save(post));
        session.getTransaction().commit();
        session.close();
        return post;
    }

    @Override
    public Post update(Post post) {
        Session session = Utils.getNewSession();
        session.beginTransaction();
        session.update(post);
        session.getTransaction().commit();
        session.close();
        return post;
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
