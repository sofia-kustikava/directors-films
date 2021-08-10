package com.film.godel.service;

import com.film.godel.dto.FilmDto;
import com.film.godel.entity.Director;
import com.film.godel.entity.Film;
import com.film.godel.repo.DirectorRepo;
import com.film.godel.repo.FilmRepo;
import com.film.godel.util.FilmToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmSearch {
    @Autowired
    FilmRepo filmRepo;
    @Autowired
    DirectorRepo directorRepo;
    @Autowired
    FilmToDTO filmToDTO;

    public List<Film> getFilteredFilms(
            String lastName,
            Date afterDate,
            Date beforeDate) {

        if (lastName == null) lastName = "";
        if (beforeDate == null) beforeDate = new Date(new java.util.Date().getTime());
        if (afterDate == null) afterDate = Date.valueOf("1895-01-01");
        if (!lastName.equals("")) {
            List<Director> directors = directorRepo.findByLastNameIsLike(lastName + "%");
            List<Film> films = new ArrayList<>();
            for (Director director : directors) {
                films.addAll(filmRepo.findByDirectorAndReleaseDateBetween(director, afterDate, beforeDate));
            }
            return films;

        } else return filmRepo.findByReleaseDateBetween(afterDate, beforeDate);
    }

    public List<FilmDto> getFilteredFilmDtos(String lastName,
                                             Date afterDate,
                                             Date beforeDate) {
        return getFilteredFilms(lastName, afterDate, beforeDate).stream()
                .map(filmToDTO::filmToDTO)
                .collect(Collectors.toList());
    }
}
