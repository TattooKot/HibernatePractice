package service;

import model.Label;
import repository.LabelRepository;

import java.util.List;

public class LabelService {
    private final LabelRepository repository;

    public LabelService(LabelRepository repository) {
        this.repository = repository;
    }

    public List<Label> getAll(){
        return repository.getAll();
    }

    public Label getById(Integer id){
        return repository.getById(id);
    }

    public Label create(Label label){
        return repository.create(label);
    }

    public Label update(Label label){
        return repository.update(label);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
