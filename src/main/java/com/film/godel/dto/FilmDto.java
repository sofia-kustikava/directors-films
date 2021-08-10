package com.film.godel.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class FilmDto {
    String directorFirstName;
    String directorLastName;
    Date directorBirthDate;
    String filmName;
    Date filmReleaseDate;
    String filmGenre;
}
