package service;

import model.Writer;
import repository.hibernate.HibernateWriterRepositoryImpl;

import java.util.List;

public class WriterService {
    private final HibernateWriterRepositoryImpl repository;

    public WriterService(HibernateWriterRepositoryImpl repository) {
        this.repository = repository;
    }

    public List<Writer> getAll(){
        return  repository.getAll();
    }

    public Writer getById(Integer id){
        return repository.getById(id);
    }

    public Writer create(Writer writer){
        return repository.create(writer);
    }

    public Writer update(Writer writer){
        return repository.update(writer);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
