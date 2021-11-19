package view;

import controller.PostController;
import model.Label;
import model.Post;
import model.PostStatus;
import repository.hibernate.HibernateLabelRepositoryImpl;
import service.LabelService;

import java.util.*;

public class PostView {
    private final PostController controller = new PostController();
    private final LabelService labelService = new LabelService(new HibernateLabelRepositoryImpl());

    public void getAllPosts(){
        controller.getAllPosts()
                        .forEach(System.out::println);
    }

    public void getPostById(){
        Post post = getPostFromConsole();

        if(Objects.isNull(post)){
            return;
        }

        System.out.println(post);
    }

    public void createPost(){
        String content = getContentFromConsole();
        List<Label> labels = getLabelListFromConsole();

        Post post = new Post();
        post.setContent(content);
        post.setCreated(new Date());
        post.setUpdated(new Date());
        post.setStatus(PostStatus.UNDER_REVIEW);
        post.setLabels(labels);

        System.out.println("Post created:\n" + controller.createPost(post));
    }

    public void updatePostById(){
        Post post = getPostFromConsole();

        if(Objects.isNull(post)){
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(""" 
                            What you wanna change?:
                            1. Content
                            2. Post status
                            3. Label list
                                """);
        String param = scanner.nextLine();

        switch (param){
            case "1" -> post.setContent(getContentFromConsole());
            case "2" -> {
                System.out.println(""" 
                            What you wanna change?:
                            0. Deleted
                            1. Active
                            2. Under review
                                """);
                int status = getIdFromConsole();
                if(status == -1 || status > 2){
                    System.out.println("Wrong parameter, try again");
                    return;
                }
                post.setStatus(PostStatus.values()[status]);
            }
            case "3" -> post.setLabels(getLabelListFromConsole());
            default -> {
                System.out.println("Wrong parameter, try again");
                return;
            }
        }

        System.out.println("Post updated:\n" + controller.updatePost(post));

    }

    public void deletePostById(){
        Post post = getPostFromConsole();

        if(Objects.isNull(post)){
            return;
        }

        controller.deletePostById(post.getId());
        System.out.println("Post deleted");
    }

    private int getIdFromConsole(){
        Scanner scanner = new Scanner(System.in);
        String stringId = scanner.nextLine();

        if(!stringId.matches("\\d*")){
            return -1;
        }

        return Integer.parseInt(stringId);
    }

    private Post getPostFromConsole(){
        System.out.println("Enter id:");
        int id = getIdFromConsole();
        if(id == -1){
            System.out.println("Wrong id");
            return null;
        }

        Post post = controller.getPostById(id);

        if(Objects.isNull(post)){
            System.out.println("Post does not exist");
            return null;
        }

        return post;
    }

    private String getContentFromConsole(){
        System.out.println("Enter post content:");
        System.out.println("(for exit enter /q)");

        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while(!(line = scanner.nextLine()).equals("/q")){
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }

    private List<Label> getLabelListFromConsole(){
        List<Label> labels = new ArrayList<>();
        System.out.println("Enter labels id:");
        System.out.println("(For exit write any letter)");

        int labelId;
        while((labelId = getIdFromConsole()) != -1){
            Label label = labelService.getById(labelId);
            if(Objects.isNull(label)){
                System.out.println("Label does not exist try again");
                continue;
            }
            labels.add(label);
        }

        return labels;
    }
}
