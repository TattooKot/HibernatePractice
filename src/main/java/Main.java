import org.hibernate.Session;
import service.Utils;
import view.LabelView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        initHibernate();

        LabelView labelView = new LabelView();

        System.out.println("Enter command:");
        Scanner scanner = new Scanner(System.in);
        String command;

        while (!(command = scanner.nextLine()).equals("q")){
            switch (command){
                case "get all labels" -> labelView.getAllLabels();
                case "get label by id" -> labelView.getLabelById();
                case "create label" -> labelView.createLabel();
                case "update label" -> labelView.updateLabel();
                case "delete label" -> labelView.deleteLabelById();
            }
        }
    }

    public static void initHibernate(){
        Session newSession = Utils.getNewSession();
        newSession.beginTransaction();
        newSession.close();
    }
}
