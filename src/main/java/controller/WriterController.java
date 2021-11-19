package controller;

import model.Writer;
import repository.hibernate.HibernateWriterRepositoryImpl;
import service.WriterService;

import java.util.List;

public class WriterController {
    private final WriterService service = new WriterService(new HibernateWriterRepositoryImpl());

    public List<Writer> getAll(){
        return  service.getAll();
    }

    public Writer getById(Integer id){
        return service.getById(id);
    }

    public Writer create(Writer writer){
        return service.create(writer);
    }

    public Writer update(Writer writer){
        return service.update(writer);
    }

    public void deleteById(Integer id){
        service.deleteById(id);
    }
}
