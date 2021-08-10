package com.film.godel.controller;

import com.film.godel.entity.Director;
import com.film.godel.entity.Film;
import com.film.godel.repo.DirectorRepo;
import com.film.godel.repo.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class FilmController {

    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private DirectorRepo directorRepo;

    @GetMapping("/addfilm")
    public String addF(Map<String, Object> model) {
        Iterable<Director> directors = directorRepo.findAll();
        model.put("directors", directors);
        return "addfilm";
    }


    @PostMapping("/addfilm")
    public String addFilm(Film film,
                          @RequestParam(name = "directorId") Long directorId,
                          Map<String, Object> model) {
        Film filmByDB = filmRepo.findByName(film.getName());
        Iterable<Director> directors = directorRepo.findAll();
        model.put("directors", directors);
        if (filmByDB != null) {
            model.put("message", "Film exists!");
            return "addfilm";
        }
        Optional<Director> director = directorRepo.findById(directorId);
        if (!director.isPresent()) {
            model.put("message", "Invalid director ID");
            return "addfilm";
        }
        film.setDirector(director.get());
        filmRepo.save(film);
        model.put("message", film.getName() + " added!");
        return "addfilm";

    }
}
