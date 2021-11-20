package service;

import model.Label;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repository.hibernate.HibernateLabelRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LabelServiceTest {
    private final HibernateLabelRepositoryImpl repository = Mockito.mock(HibernateLabelRepositoryImpl.class);
    private LabelService service;

    @Before
    public void setUp(){
        service = new LabelService(repository);
    }

    @Test
    public void testGetAll() {
        List<Label> labelList = new ArrayList<>();
        labelList.add(new Label("Label 1"));
        labelList.add(new Label("Label 2"));
        labelList.add(new Label("Label 3"));
        when(repository.getAll()).thenReturn(labelList);

        List<Label> serviceAll = service.getAll();
        verify(repository, atLeastOnce()).getAll();
        assertNotNull(serviceAll);
        assertFalse(serviceAll.isEmpty());
        assertEquals(labelList, serviceAll);
    }

    @Test
    public void testGetById() {
        Label label = new Label("label");
        when(repository.getById(1)).thenReturn(label);

        Label tested = service.getById(1);

        verify(repository, atLeastOnce()).getById(1);
        assertNotNull(tested);
        assertEquals(label, tested);
    }

    @Test
    public void testCreate() {
        Label label = new Label("label");
        when(repository.create(label)).thenReturn(label);

        Label created = service.create(label);

        verify(repository, atLeastOnce()).create(label);
        assertNotNull(created);
        assertEquals(label, created);
    }

    @Test
    public void testUpdate() {
        Label label = new Label("label");
        when(repository.update(label)).thenReturn(label);

        Label updated = service.update(label);

        verify(repository, atLeastOnce()).update(label);
        assertNotNull(updated);
        assertEquals(label, updated);
    }

    @Test
    public void testDeleteById() {
        service.deleteById(1);
        verify(repository).deleteById(1);
    }
}