package com.film.godel.util;

import com.film.godel.dto.FilmDto;
import com.film.godel.entity.Film;
import org.springframework.stereotype.Service;

@Service
public class FilmToDTO {
    public FilmDto filmToDTO(Film film) {
        FilmDto dto = new FilmDto();

        dto.setDirectorFirstName(film.getDirector().getFirstName());
        dto.setDirectorLastName(film.getDirector().getLastName());
        dto.setDirectorBirthDate(film.getDirector().getBirthDate());
        dto.setFilmName(film.getName());
        dto.setFilmReleaseDate(film.getReleaseDate());
        dto.setFilmGenre(film.getGenre());

        return dto;
    }
}

