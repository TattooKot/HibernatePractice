package controller;

import model.Label;
import repository.hibernate.HibernateLabelRepositoryImpl;
import service.LabelService;

import java.util.List;
import java.util.Objects;

public class LabelController {
    private final LabelService service = new LabelService(new HibernateLabelRepositoryImpl());

    public List<Label> getAll(){
        return service.getAll();
    }

    public Label getById(Integer id){
        return service.getById(id);
    }

    public Label create(Label label){
        if(Objects.isNull(label)){
            throw new NullPointerException("Label null in controller");
        }
        return service.create(label);
    }

    public Label update(Label label){
        return service.update(label);
    }

    public void deleteById(Integer id){
        service.deleteById(id);
    }
}
