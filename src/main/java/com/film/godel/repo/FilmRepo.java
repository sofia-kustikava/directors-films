package com.film.godel.repo;

import com.film.godel.entity.Director;
import com.film.godel.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface FilmRepo extends JpaRepository<Film, Long> {
    Film findByName(String name);

    List<Film> findByDirectorAndReleaseDateBetween(Director director, Date dateAfter, Date dateBefore);

    List<Film> findByReleaseDateBetween(Date dateAfter, Date dateBefore);


}
