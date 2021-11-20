package service;

import model.Writer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repository.hibernate.HibernateWriterRepositoryImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WriterServiceTest {
    private final HibernateWriterRepositoryImpl repository = Mockito.mock(HibernateWriterRepositoryImpl.class);
    private WriterService service;

    @Before
    public void setUp(){
        service = new WriterService(repository);
    }

    @Test
    public void testGetAll() {
        Writer writer = new Writer();
        writer.setFirstname("Name");
        List<Writer> writers = Collections.singletonList(writer);

        when(repository.getAll()).thenReturn(writers);

        List<Writer> serviceAll = service.getAll();

        verify(repository).getAll();
        assertNotNull(serviceAll);
        assertFalse(serviceAll.isEmpty());
        assertEquals(writers, serviceAll);
    }

    @Test
    public void testGetById() {
        Writer writer = new Writer();
        writer.setFirstname("Name");

        when(repository.getById(1)).thenReturn(writer);

        Writer serviceById = service.getById(1);

        verify(repository).getById(1);
        assertNotNull(serviceById);
        assertEquals(writer, serviceById);
    }

    @Test
    public void testCreate() {
        Writer writer = new Writer();
        writer.setFirstname("Name");

        when(repository.create(writer)).thenReturn(writer);

        Writer created = service.create(writer);

        verify(repository).create(writer);
        assertNotNull(created);
        assertEquals(writer, created);
    }

    @Test
    public void testUpdate() {
        Writer writer = new Writer();
        writer.setFirstname("Name");

        when(repository.update(writer)).thenReturn(writer);

        Writer updated = service.update(writer);

        verify(repository).update(writer);
        assertNotNull(updated);
        assertEquals(writer, updated);
    }

    @Test
    public void testDeleteById() {
        service.deleteById(1);
        verify(repository).deleteById(1);
    }
}