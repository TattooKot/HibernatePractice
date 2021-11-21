package service;

import model.Post;
import repository.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
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
