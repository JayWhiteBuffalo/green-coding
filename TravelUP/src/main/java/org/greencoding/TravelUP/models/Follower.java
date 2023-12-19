package org.greencoding.TravelUP.models;

import jakarta.persistence.*;

@Entity
@Table(name="Followers")
public class Follower extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "follower_user_id")
    private Users follower;

    @ManyToOne
    @JoinColumn(name = "following_user_id")
    private Users following;

    public Follower(Long id, Users follower, Users following) {
        super(id);
        this.follower = follower;
        this.following = following;
    }

    public Users getFollower() {
        return follower;
    }

    public void setFollower(Users follower) {
        this.follower = follower;
    }

    public Users getFollowing() {
        return following;
    }

    public void setFollowing(Users following) {
        this.following = following;
    }
}
