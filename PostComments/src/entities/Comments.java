package entities;

import java.util.ArrayList;
import java.util.List;

public class Comments {

    private List<String> comments = new ArrayList<>();

    public Comments() {
    }

    public Comments(List<String> comments) {
        this.comments = comments;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }
}
