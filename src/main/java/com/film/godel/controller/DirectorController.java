package com.film.godel.controller;

import com.film.godel.entity.Director;
import com.film.godel.repo.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class DirectorController {

    @Autowired
    private DirectorRepo directorRepo;

    @GetMapping("/adddirector")
    public String addDirector(Map<String, Object> model) {
        return "adddirector";
    }


    @PostMapping("/adddirector")
    public String addDir(Director director, Map<String, Object> model) {
        Director directorFromDB = directorRepo.findByFirstNameAndLastName(director.getFirstName(), director.getLastName());

        if (directorFromDB != null) {
            model.put("message", "Director exists!");
            return "adddirector";
        }
        model.put("message", director.getFirstName() + " " + director.getLastName() + " added!");
        directorRepo.save(director);

        return "adddirector";

    }
}
