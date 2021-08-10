package com.film.godel.controller;

import com.film.godel.service.FilmSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    FilmSearch filmSearch;

    @GetMapping("/")
    public String directors(
            @RequestParam(required = false, defaultValue = "") String lastName,
            @RequestParam(required = false, defaultValue = "1895-01-01") Date afterDate,
            @RequestParam(required = false) Date beforeDate,
            Map<String, Object> model) {
        model.put("films", filmSearch.getFilteredFilms(lastName, afterDate, beforeDate));
        model.put("dateAfter", afterDate.toString());
        if (beforeDate == null)
            beforeDate = new Date(new java.util.Date().getTime());
        model.put("dateBefore", beforeDate.toString());
        model.put("lastName", lastName);
        return "directors";
    }
}
