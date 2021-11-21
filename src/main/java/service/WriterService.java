package service;

import model.Writer;
import repository.WriterRepository;

import java.util.List;

public class WriterService {
    private final WriterRepository repository;

    public WriterService(WriterRepository repository) {
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
