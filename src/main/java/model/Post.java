package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "posts")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "content", nullable = false, length = 10000)
    private String content;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "updated", nullable = false)
    private Date updated;

    @Column(name = "status")
    private PostStatus status;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Label> labels = new ArrayList<>();

    @Override
    public String toString() {
        return "id: " + id +
                "\nContent: " + content + '\n' +
                "Created: " + created + '\n' +
                "Updated: " + updated + '\n' +
                "Status: " + status + '\n' +
                "Labels: " + labels +
                "\n==================\n";
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}