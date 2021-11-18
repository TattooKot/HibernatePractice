package view;

import controller.LabelController;
import model.Label;

import java.util.Objects;
import java.util.Scanner;

public class LabelView {
    private final LabelController controller = new LabelController();

    public void getAllLabels(){
        System.out.println(controller.getAll());
    }

    public void getLabelById(){
        int id = getIdFromConsole();

        if(id == -1){
            return;
        }

        System.out.println(controller.getById(id));

    }

    public void createLabel(){
        String name = getNameFromConsole();

        if(Objects.isNull(name)){
            return;
        }

        System.out.println("Label created:\n" + controller.create(new Label(name)));

    }

    public void updateLabel(){
        int id = getIdFromConsole();

        if(id == -1){
            return;
        }

        Label label = controller.getById(id);

        String name = getNameFromConsole();

        if(Objects.isNull(name)){
            return;
        }

        label.setName(name);

        System.out.println("Label updated: " + controller.update(label));

    }

    public void deleteLabelById(){
        int id = getIdFromConsole();

        if(id == -1){
            return;
        }

        controller.deleteById(id);

        System.out.println("Label deleted");
    }

    private int getIdFromConsole(){
        System.out.println("Enter label id:");
        Scanner scanner = new Scanner(System.in);
        String stringId = scanner.nextLine();

        if(!stringId.matches("\\d*")){
            System.out.println("Wrong id");
            return -1;
        }

        int id = Integer.parseInt(stringId);
        Label label = controller.getById(id);

        if(Objects.isNull(label)){
            System.out.println("Label does not exist");
            return -1;
        }

        return id;
    }

    private String getNameFromConsole(){
        System.out.println("Enter label name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();

        if(name.isEmpty()){
            System.out.println("Name can`t be empty, try again");
            return null;
        }

        return name;
    }
}
