package org.launchcode.greencoding.TravelUp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PostRatings")
public class PostRating extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private int rating;

    public PostRating () {}

    public PostRating(Long id, Users user, Post post, int rating) {
        super(id);
        this.user = user;
        this.post = post;
        this.rating = rating;
    }

    // Need assistance with code from lines 31-43

//    public static Iterable<Post> findByFieldAndValue(Integer searchField, String searchTerm, List<Post> all) {
//
//        ArrayList<Post> filter = new ArrayList<Post>();
//
//        ArrayList<Post> results = new ArrayList<Post>();

        // May delete lines 36-37
//        if(value.toLowerCase().equals("all")) {
//            return (ArrayList<Post>) allPosts;
//        }
//
//        return results;
//    }


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
