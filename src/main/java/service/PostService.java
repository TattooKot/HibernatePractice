package service;

import model.Post;
import repository.hibernate.HibernatePostRepositoryImpl;

import java.util.List;

public class PostService {
    private final HibernatePostRepositoryImpl repository;

    public PostService(HibernatePostRepositoryImpl repository) {
        this.repository = repository;
    }

    public List<Post> getAll(){
        return  repository.getAll();
    }

    public Post getById(Integer id){
        return repository.getById(id);
    }

    public Post create(Post post){
        return repository.create(post);
    }

    public Post update(Post post){
        return repository.update(post);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
