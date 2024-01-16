package org.launchcode.artgallery.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.artgallery.data.CountryInfoRepository;
import org.launchcode.artgallery.data.ReviewRepository;
import org.launchcode.artgallery.data.WeatherRepository;
import org.launchcode.artgallery.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CountryInfoRepository countryRepository;

    @Autowired
    private WeatherRepository weatherRepository;

    // Corresponds to http://localhost:8080/artworks
    @GetMapping("")
    public String displayArtworksPage(@RequestParam(required = false) Long countryId,
                                      @RequestParam(required = false) Integer weatherId,
                                      Model model,
                                      HttpSession session) {
        if (countryId != null) {
            Optional<CountryInfo> result = countryRepository.findById(countryId);
            if (result.isPresent()) {
                CountryInfo country = result.get();
                model.addAttribute("reviews", country.getReviews());
            }
        } else if (weatherId != null) {
            Optional<Weather> result;
            result = weatherRepository.findById(weatherId);
            if (result.isPresent()) {
                Weather style = result.get();
                model.addAttribute("reviews", style.getArtworks());
            }
        } else {
            model.addAttribute("reviews", reviewRepository.findAll());
        }
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        return "reviews/index";
    }

    // Corresponds to http://localhost:8080/artworks/details/1
    @GetMapping("/details/{reviewId}")
    public String displayArtworkDetailsPage(@PathVariable int reviewId, Model model, HttpSession session) {
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        Optional<Review> result = reviewRepository.findById(reviewId);
        if (result.isPresent()) {
            Review review = result.get();
            model.addAttribute("review", review);
            return "reviews/details";
        } else {
            return "reviews/index";
        }
    }

    // Corresponds to http://localhost:8080/artworks/add
    @GetMapping("/add")
    public String displayAddArtForm(Model model, HttpSession session) {
        List<CountryInfo> countries = (List<CountryInfo>) countryRepository.findAll();
        Collections.sort(countries, new CountryComparator());
        List<Weather> weather = (List<Weather>) weatherRepository.findAll();
        Collections.sort(weather, new WeatherComparator());
        model.addAttribute("review", new Review());
        model.addAttribute("countries", countries);
        model.addAttribute("weathers", weather);
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        return "reviews/add";
    }

    @PostMapping("/add")
    public String processAddArtForm(@ModelAttribute @Valid Review review,
                                    Errors errors,
                                    @RequestParam(required = false) List<Integer> weatherIds,
                                    Model model) {
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors());
            List<CountryInfo> countries = (List<CountryInfo>) countryRepository.findAll();
            Collections.sort(countries, new CountryComparator());
            List<Weather> weather = (List<Weather>) weatherRepository.findAll();
            Collections.sort(weather, new WeatherComparator());
            model.addAttribute("review", review);
            model.addAttribute("countries", countries);
            model.addAttribute("weathers", weather);
            return "reviews/add";
        } else {
            if (weatherIds != null) {
                List<Weather> selectedweathers = (List<Weather>) weatherRepository.findAllById(weatherIds);
                review.setWeather(selectedweathers);
            }
            reviewRepository.save(review);
            return "redirect:/reviews";
        }
    }


    @GetMapping("/update/{reviewId}")
    public String displayUpdateArtForm(@PathVariable int reviewId, Model model, HttpSession session) {
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        Optional<Review> result = reviewRepository.findById(reviewId);
        if (result.isPresent()) {
            Review review = result.get();
            List<CountryInfo> countries = (List<CountryInfo>) countryRepository.findAll();
            Collections.sort(countries, new CountryComparator());
            List<Weather> weather = (List<Weather>) weatherRepository.findAll();
            Collections.sort(weather, new WeatherComparator());
            model.addAttribute("review", review);
            model.addAttribute("countries", countries);
            model.addAttribute("weathers", weather);
            return "reviews/update";
        }

        return "redirect:/reviews";
    }

    @PostMapping("/update/{reviewId}")
    public String processUpdateArtForm(@PathVariable int reviewId,
                                       @ModelAttribute @Valid Review updatedReview,
                                       Errors errors,
                                       @RequestParam(required = false) List<Integer> weatherIds,
                                       Model model)

    {
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors());
            List<CountryInfo> countries = (List<CountryInfo>) countryRepository.findAll();
            Collections.sort(countries, new CountryComparator());
            List<Weather> weather = (List<Weather>) weatherRepository.findAll();
            Collections.sort(weather, new WeatherComparator());
            model.addAttribute("review", updatedReview);
            model.addAttribute("countries", countries);
            model.addAttribute("weathers", weather);
            return "reviews/update";
        } else {
            try {
                Optional<Review> result = reviewRepository.findById(reviewId);
                if (result.isPresent()) {
                    Review existingReview = result.get();
                    existingReview.setTitle(updatedReview.getTitle());
                    existingReview.setCity(updatedReview.getCity());
                    existingReview.setCountry(updatedReview.getCountry());
                    existingReview.setComment(updatedReview.getComment());
                    existingReview.setRate(updatedReview.getRate());

                    if (weatherIds != null) {
                        List<Weather> selectedWeathers = (List<Weather>) weatherRepository.findAllById(weatherIds);
                        existingReview.setWeather(selectedWeathers);
                    }

                    reviewRepository.save(existingReview);
                    return "redirect:/reviews/details/" + reviewId;
                } else {
                    return "redirect:/reviews";
                }
            } catch (Exception e) {
                model.addAttribute("error", "An error occurred while updating the review.");
                return "reviews/update";
            }
        }
    }





    // Corresponds to http://localhost:8080/artworks/delete
    @GetMapping("/delete")
    public String displayDeleteArtForm(Model model, HttpSession session) {
        model.addAttribute("reviews", reviewRepository.findAll());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        return "reviews/delete";
    }

    @PostMapping("/delete")
    public String processDeleteArtForm(@RequestParam(required = false) int[] reviewIds) {
        for (int id : reviewIds) {
            reviewRepository.deleteById(id);
        }
        return "redirect:/reviews";
    }

}


