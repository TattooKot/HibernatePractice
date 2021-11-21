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
                case "get all labels" -> labelView.getAllLabels();
                case "get label by id" -> labelView.getLabelById();
                case "create label" -> labelView.createLabel();
                case "update label" -> labelView.updateLabel();
                case "delete label" -> labelView.deleteLabelById();
                case "get all posts" -> postView.getAllPosts();
                case "get post by id" -> postView.getPostById();
                case "create post" -> postView.createPost();
                case "update post" -> postView.updatePostById();
                case "delete post" -> postView.deletePostById();
                case "get all writers" -> writerView.getAllWriters();
                case "create writer" -> writerView.createNewWriter();
                case "get writer by id" -> writerView.getWriterById();
                case "update writer" -> writerView.updateWriterById();
                case "delete writer" -> writerView.deleteWriterById();
            }
        }
    }

    public static void initHibernate(){
        Session newSession = Utils.getNewSession();
        newSession.beginTransaction();
        newSession.close();
    }
}
