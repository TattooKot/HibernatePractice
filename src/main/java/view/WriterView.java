package view;

import controller.WriterController;
import model.Post;
import model.Writer;
import repository.hibernate.HibernatePostRepositoryImpl;
import service.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class WriterView {
    private final WriterController controller = new WriterController();
    private final PostService postService = new PostService(new HibernatePostRepositoryImpl());

    public void getAllWriters(){
        controller.getAll()
                .forEach(System.out::println);
    }

    public void createNewWriter(){

        System.out.println("Enter first name:");
        String firstName = getParamFromConsole();
        if(Objects.isNull(firstName)){
            return;
        }

        System.out.println("Enter last name:");
        String lastName = getParamFromConsole();
        if(Objects.isNull(lastName)){
            return;
        }

        List<Post> posts = getPostListFromConsole();

        Writer writer = new Writer();
        writer.setFirstname(firstName);
        writer.setLastname(lastName);
        writer.setPosts(posts);

        System.out.println("Writer created: " + controller.create(writer));

    }

    public void getWriterById(){
        Writer writer = getWriterFromConsole();

        if(Objects.isNull(writer)){
            return;
        }

        System.out.println(writer);
    }

    public void updateWriterById(){
        Writer writer = getWriterFromConsole();

        if(Objects.isNull(writer)){
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("What you wanna change?:\n" +
                "1. First name\n" +
                "2. Last name\n" +
                "3. Post list");
        String param = scanner.nextLine();

        switch (param){
            case "1" :
                System.out.println("Enter first name:");
                String firstName = getParamFromConsole();
                if(Objects.isNull(firstName)){
                    return;
                }
                writer.setFirstname(firstName);
                break;
            case "2":
                System.out.println("Enter last name:");
                String lastName = getParamFromConsole();
                if(Objects.isNull(lastName)){
                    return;
                }
                writer.setLastname(lastName);
                break;
            case "3" :
                writer.setPosts(getPostListFromConsole());
                break;
            default :
                System.out.println("Wrong parameter try again");
                return;

        }

        System.out.println("Writer updated:\n" + controller.update(writer));
    }

    public void deleteWriterById(){
        Writer writer = getWriterFromConsole();

        if(Objects.isNull(writer)){
            return;
        }

        controller.deleteById(writer.getId());
        System.out.println("Writer deleted");
    }

    private String getParamFromConsole(){
        Scanner scanner = new Scanner(System.in);
        String param = scanner.nextLine().trim();
        if(param.isEmpty()){
            System.out.println("Empty field, try again");
            return null;
        }
        return param;
    }

    private int getIdFromConsole(){
        Scanner scanner = new Scanner(System.in);
        String stringId = scanner.nextLine();

        if(!stringId.matches("\\d*") || stringId.isEmpty()){
            return -1;
        }

        return Integer.parseInt(stringId);
    }

    private List<Post> getPostListFromConsole(){
        List<Post> posts = new ArrayList<>();
        System.out.println("Enter post id:");
        System.out.println("(For exit write any letter)");

        int postId;
        while((postId = getIdFromConsole()) != -1){
            Post post = postService.getById(postId);
            if(Objects.isNull(post)){
                System.out.println("Post does not exist try again");
                continue;
            }
            if(posts.contains(post)){
                System.out.println("Post already added");
                continue;
            }
            posts.add(post);
        }
        return posts;
    }

    private Writer getWriterFromConsole(){
        System.out.println("Enter id:");
        int id = getIdFromConsole();
        if(id == -1){
            System.out.println("Wrong id");
            return null;
        }

        Writer writer = controller.getById(id);

        if(Objects.isNull(writer)){
            System.out.println("Writer does not exist");
            return null;
        }

        return writer;
    }
}
