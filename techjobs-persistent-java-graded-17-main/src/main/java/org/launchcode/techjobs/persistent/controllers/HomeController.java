package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SkillRepository skillRepository;


    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");
        model.addAttribute("jobs", jobRepository.findAll());

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add") //responsible for processing form submissions
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {
        if (errors.hasErrors()) { //show error message for invalid data
            model.addAttribute("title", "Add Job");
            return "add";
        }

        Employer selectedEmployer = employerRepository.findById(employerId).orElse(null); //if the employer is found, it is assigned to selectedEmployer. If not found, selectedEmployer will be null
        //if (selectedEmployer != null) {
        newJob.setEmployer(selectedEmployer);

        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);

        newJob.setSkills(skillObjs);
        jobRepository.save(newJob);
        //} else {
            // Handle case when the selected employer is not found
       // }

        return "redirect:/";
    }

    /*@PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, Errors errors, Model model,
                                    @RequestParam int employers, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

        List<Employer> allEmployers = (List<Employer>) employerRepository.findAll();
        Employer selectedEmployer = null;

        for (Employer employer : allEmployers) {
            if (employer.getId() == employers) {
                selectedEmployer = employer;
                break;
            }
        }

        if (selectedEmployer != null) {
            newJob.setEmployer(selectedEmployer);

            List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);

            newJob.setSkills(skillObjs);
            jobRepository.save(newJob);
        } else {
            // Handle case when the selected employer is not found
        }

        return "redirect:/";
    }

   /*@PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model, @RequestParam int employer,
                                    @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            // Handle errors
        }

        List<Employer> allEmployers = (List<Employer>) employerRepository.findAll();

        Optional<Employer> result = allEmployers.stream()
                .filter(e -> e.getId() == employer)
                .findFirst();

        if (result.isPresent()) {
            Employer selectedEmployer = result.get();
            newJob.setEmployer(selectedEmployer);
        } else {
            // Handle the case where employer is not found
        }

        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
        newJob.setSkills(skillObjs);

        // Save the new job using the jobRepository (assuming you have a jobRepository)
        jobRepository.save(newJob);

        return "redirect:/add"; // Redirect to a suitable URL after submission
    }*/

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Job job = jobRepository.findById(jobId).orElse(null);

        if (job != null) {
            model.addAttribute("job", job); // Add the job object to the model
        } else {
            // Handle the case where the job is not found
            model.addAttribute("error", "Job not found");
        }

            return "view";
    }

}
