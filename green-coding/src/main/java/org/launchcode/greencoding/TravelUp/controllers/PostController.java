package org.launchcode.greencoding.TravelUp.controllers;

import org.launchcode.greencoding.TravelUp.models.data.CommentRepository;
import org.launchcode.greencoding.TravelUp.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Post")
public class PostController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;



}
