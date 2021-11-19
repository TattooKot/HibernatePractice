package controller;

import model.Post;
import repository.hibernate.HibernatePostRepositoryImpl;
import service.PostService;

import java.util.Date;
import java.util.List;

public class PostController {
    private final PostService service = new PostService(new HibernatePostRepositoryImpl());

    public List<Post> getAllPosts(){
        return  service.getAll();
    }

    public Post getPostById(Integer id){
        return service.getById(id);
    }

    public Post createPost(Post post){
        return service.create(post);
    }

    public Post updatePost(Post post){
        post.setUpdated(new Date());
        return service.update(post);
    }

    public void deletePostById(Integer id){
        service.deleteById(id);
    }
}
