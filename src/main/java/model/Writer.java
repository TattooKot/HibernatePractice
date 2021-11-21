package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "writers")
@Entity
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", length = 50)
    private String firstname;

    @Column(name = "lastname", length = 50)
    private String lastname;

    @OneToMany
    private List<Post> posts = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder postsId = new StringBuilder();
        posts.forEach(p -> postsId.append("Post: ").append(p.getId()).append("\n"));

        return "id: " + this.id + "\n" +
                "name: " + firstname + ' ' + lastname + "\n" +
                "posts:\n" + postsId +
                "========\n";
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}