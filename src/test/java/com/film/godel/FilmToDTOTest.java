package com.film.godel;

import com.film.godel.dto.FilmDto;
import com.film.godel.entity.Director;
import com.film.godel.entity.Film;
import com.film.godel.util.FilmToDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
public class FilmToDTOTest {


    @Test
    public void filmToDTOTest(){
        FilmToDTO filmToDTO = new FilmToDTO();
        FilmDto filmDto = new FilmDto();
        java.sql.Date birthDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.sql.Date releaseDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        filmDto.setDirectorFirstName("firstName");
        filmDto.setDirectorLastName("lastName");
        filmDto.setDirectorBirthDate(birthDate);
        filmDto.setFilmName("name");
        filmDto.setFilmReleaseDate(releaseDate);
        filmDto.setFilmGenre("genre");

        Assert.assertEquals(filmDto, filmToDTO.filmToDTO(new Film("name",
                releaseDate,
                "genre",
                new Director("firstName",
                        "lastName",
                        birthDate
                ))));

    }
}
