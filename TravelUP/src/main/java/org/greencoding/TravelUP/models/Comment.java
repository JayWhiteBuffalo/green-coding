package org.greencoding.TravelUP.models;

import jakarta.persistence.*;

@Entity
@Table(name="Comments")
public class Comment extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "comment_text")
    private String commentText;

    public Comment(Long id, Users user, Post post, String commentText) {
        super(id);
        this.user = user;
        this.post = post;
        this.commentText = commentText;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}