package org.greencoding.TravelUP.models;

import jakarta.persistence.*;

@Entity
@Table(name="ApplicationRatings")
public class ApplicationRating extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private int rating;

    public ApplicationRating(Long id, Users user, int rating) {
        super(id);
        this.user = user;
        this.rating = rating;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}