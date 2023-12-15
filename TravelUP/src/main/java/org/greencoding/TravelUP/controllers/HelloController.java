package org.greencoding.TravelUP.controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class HelloController {

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
