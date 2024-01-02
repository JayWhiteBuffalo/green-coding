package org.launchcode.greencoding.TravelUp.controllers;

import org.launchcode.greencoding.TravelUp.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class HomeController {
    @Autowired
    private ApplicationRatingRepository applicationRatingRepository;

    @Autowired
    private FollowerRepository followerRepository;

    @Autowired
    private LikeDislikeRepository likeDislikeRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostRatingRepository postRatingRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("locations")
    public String locations(){
        return "locations";
    }

    @GetMapping("addreview")
    public String addreview(){
        return "addreview";
    }

    @GetMapping("reviews")
    public String reviews(){
        return "reviews";
    }

    @GetMapping("createaccount")
    public String createaccount(){
        return "createaccount";
    }


}
