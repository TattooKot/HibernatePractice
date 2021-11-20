package service;

import model.Post;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repository.hibernate.HibernatePostRepositoryImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PostServiceTest{
    private final HibernatePostRepositoryImpl repository = Mockito.mock(HibernatePostRepositoryImpl.class);
    private PostService service;

    @Before
    public void setUp(){
        service = new PostService(repository);
    }

    @Test
    public void testGetAll() {
        Post post = new Post();
        post.setContent("Content");
        List<Post> postList = Collections.singletonList(post);

        when(repository.getAll()).thenReturn(postList);

        List<Post> serviceAll = service.getAll();

        verify(repository).getAll();
        assertNotNull(serviceAll);
        assertFalse(serviceAll.isEmpty());
        assertEquals(postList, serviceAll);
    }

    @Test
    public void testGetById() {
        Post post = new Post();
        post.setContent("Content");

        when(repository.getById(1)).thenReturn(post);

        Post serviceById = service.getById(1);

        verify(repository).getById(1);
        assertNotNull(serviceById);
        assertEquals(post, serviceById);
    }

    @Test
    public void testCreate() {
        Post post = new Post();
        post.setContent("Content");

        when(repository.create(post)).thenReturn(post);

        Post created = service.create(post);

        verify(repository).create(post);
        assertNotNull(created);
        assertEquals(post, created);
    }

    @Test
    public void testUpdate() {
        Post post = new Post();
        post.setContent("Content");

        when(repository.update(post)).thenReturn(post);

        Post updated = service.update(post);

        verify(repository).update(post);
        assertNotNull(updated);
        assertEquals(post, updated);
    }

    @Test
    public void testDeleteById() {
        service.deleteById(1);
        verify(repository).deleteById(1);
    }
}