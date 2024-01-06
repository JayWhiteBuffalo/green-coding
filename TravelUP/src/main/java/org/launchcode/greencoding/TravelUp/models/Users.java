package org.launchcode.greencoding.TravelUp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Users")
public class Users extends AbstractEntity {

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Lob
    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PostRating> postRatings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ApplicationRating> applicationRatings;

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    private List<Follower> followers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LikeDislike> likeDislikes;

    public Users(Long id, String name, String email, String password, byte[] profilePicture, List<Post> posts, List<Comment> comments, List<PostRating> postRatings, List<ApplicationRating> applicationRatings, List<Follower> followers, List<LikeDislike> likeDislikes) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePicture = profilePicture;
        this.posts = posts;
        this.comments = comments;
        this.postRatings = postRatings;
        this.applicationRatings = applicationRatings;
        this.followers = followers;
        this.likeDislikes = likeDislikes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<PostRating> getPostRatings() {
        return postRatings;
    }

    public void setPostRatings(List<PostRating> postRatings) {
        this.postRatings = postRatings;
    }

    public List<ApplicationRating> getApplicationRatings() {
        return applicationRatings;
    }

    public void setApplicationRatings(List<ApplicationRating> applicationRatings) {
        this.applicationRatings = applicationRatings;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    public List<LikeDislike> getLikeDislikes() {
        return likeDislikes;
    }

    public void setLikeDislikes(List<LikeDislike> likeDislikes) {
        this.likeDislikes = likeDislikes;
    }
}
