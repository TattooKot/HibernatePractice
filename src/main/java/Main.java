import org.hibernate.Session;
import repository.hibernate.HibernatePostRepositoryImpl;
import service.Utils;
import view.LabelView;
import view.PostView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        initHibernate();

        LabelView labelView = new LabelView();
        PostView postView = new PostView();

        System.out.println("Enter command:");
        Scanner scanner = new Scanner(System.in);
        String command;

        while (!(command = scanner.nextLine()).equals("q")){
            switch (command){
                //labels commands
                case "get all labels" -> labelView.getAllLabels();
                case "get label by id" -> labelView.getLabelById();
                case "create label" -> labelView.createLabel();
                case "update label" -> labelView.updateLabel();
                case "delete label" -> labelView.deleteLabelById();
                //posts commands
                case "get all posts" -> postView.getAllPosts();
                case "get post by id" -> postView.getPostById();
                case "create post" -> postView.createPost();
                case "update post" -> postView.updatePostById();
                case "delete post" -> postView.deletePostById();
            }
        }
    }

    public static void initHibernate(){
        Session newSession = Utils.getNewSession();
        newSession.beginTransaction();
        newSession.close();
    }
}
