package org.greencoding.TravelUP.models;

import jakarta.persistence.*;

@Entity
@Table(name="PostRatings")
public class PostRating extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private int rating;

    public PostRating(Long id, Users user, Post post, int rating) {
        super(id);
        this.user = user;
        this.post = post;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
