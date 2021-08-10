package com.film.godel.controller;

import com.film.godel.dto.FilmDto;
import com.film.godel.service.FilmSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("api")
public class FilmRestController {
    @Autowired
    FilmSearch filmSearch;

    @GetMapping
    public List<FilmDto> films(
            @RequestParam(required = false, defaultValue = "") String lastName,
            @RequestParam(required = false, defaultValue = "1895-01-01") Date afterDate,
            @RequestParam(required = false) Date beforeDate
    ) {
        return filmSearch.getFilteredFilmDtos(lastName, afterDate, beforeDate);

    }
}
