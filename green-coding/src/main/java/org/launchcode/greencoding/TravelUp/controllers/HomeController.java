package org.launchcode.greencoding.TravelUp.controllers;

import org.launchcode.greencoding.TravelUp.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

/// Need to make a second locations
    @GetMapping("locations")
    public String locations(Model model){
        model.addAttribute("locations", postRepository.findAll());
        return "locations";
    }
//// Try to map this one out. Ex: /{Example} So we can go to the page we are searching on. /method for path and specific location instead of findAll.
    @GetMapping("locations_search")
    public String locations_search(Model model){
//        model.addAttribute("locations", postRepository.)
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
