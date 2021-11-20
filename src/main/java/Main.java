import org.hibernate.Session;
import service.Utils;
import view.LabelView;
import view.PostView;
import view.WriterView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        initHibernate();

        LabelView labelView = new LabelView();
        PostView postView = new PostView();
        WriterView writerView = new WriterView();

        System.out.println("Enter command:");
        Scanner scanner = new Scanner(System.in);
        String command;

        while (!(command = scanner.nextLine()).equals("q")){
            switch (command) {
                case "get all labels":
                    labelView.getAllLabels();
                    break;
                case "get label by id":
                    labelView.getLabelById();
                    break;
                case "create label":
                    labelView.createLabel();
                    break;
                case "update label":
                    labelView.updateLabel();
                    break;
                case "delete label":
                    labelView.deleteLabelById();
                    break;
                case "get all posts":
                    postView.getAllPosts();
                    break;
                case "get post by id":
                    postView.getPostById();
                    break;
                case "create post":
                    postView.createPost();
                    break;
                case "update post":
                    postView.updatePostById();
                    break;
                case "delete post":
                    postView.deletePostById();
                    break;
                case "get all writers":
                    writerView.getAllWriters();
                    break;
                case "create writer":
                    writerView.createNewWriter();
                    break;
                case "get writer by id":
                    writerView.getWriterById();
                    break;
                case "update writer":
                    writerView.updateWriterById();
                    break;
                case "delete writer":
                    writerView.deleteWriterById();
                    break;
            }
        }
    }

    public static void initHibernate(){
        Session newSession = Utils.getNewSession();
        newSession.beginTransaction();
        newSession.close();
    }
}
