package org.launchcode.greencoding.TravelUp.controllers;

import org.launchcode.greencoding.TravelUp.models.Post;
import org.launchcode.greencoding.TravelUp.models.PostRating;
import org.launchcode.greencoding.TravelUp.models.data.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private PostRepository postRepository;


    static HashMap<String, String> fieldChoices = new HashMap<>();
    static HashMap<Integer, String> fieldChoices1 = new HashMap<>();

    /// 29-40 Please advise, may need some help.
    public SearchController() {
        fieldChoices.put("all", "All Comments");
        fieldChoices.put("reviews", "Reviews");
        fieldChoices.put("locations", "Locations");
        fieldChoices1.put(0, "All Ratings");
        fieldChoices1.put(1, "1");
        fieldChoices1.put(2, "2");
        fieldChoices1.put(3, "3");
        fieldChoices1.put(4, "4");
        fieldChoices1.put(5, "5");

    }
    // Lines 40 and below
    @RequestMapping
    public String search(Model model) {
        model.addAttribute("fieldChoices", fieldChoices);
        model.addAttribute("fieldChoices1", fieldChoices1);
        return "search";


        }

    //// lines 39-47/51-70 need to be adjusted/updated. Having issues accessing PostMapping and GetMapping annotations
//    @GetMapping("results")
//    public String displaySearchResults(Model model, @RequestParam String searchTerm, @RequestParam Integer searchField) {
//
//
//        Iterable<Post> posts;
//
//        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")) {
//            posts = postRepository.findAll();
//        } else {
//            posts = PostRating.findByFieldAndValue(searchField, searchTerm, postRepository.findAll());
//        }
//
//        model.addAttribute("title", "Posts with comments and ratings");
//        model.addAttribute("fieldChoices", fieldChoices);
//        model.addAttribute("fieldChoices1", fieldChoices1);
//        model.addAttribute("posts", posts);
//        model.addAttribute("searchTerm", searchTerm);
//        model.addAttribute("searchField", searchField);
//
//        return "search";
}
