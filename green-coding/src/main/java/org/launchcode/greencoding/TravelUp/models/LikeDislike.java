package org.launchcode.greencoding.TravelUp.models;

import jakarta.persistence.*;

@Entity
@Table(name="LikesDislikes")
public class LikeDislike extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Column(name = "is_like")
    private boolean isLike;

    public LikeDislike(Long id, Users user, Comment comment, boolean isLike) {
        super(id);
        this.user = user;
        this.comment = comment;
        this.isLike = isLike;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}