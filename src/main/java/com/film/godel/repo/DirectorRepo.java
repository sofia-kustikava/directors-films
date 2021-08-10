package com.film.godel.repo;

import com.film.godel.entity.Director;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DirectorRepo extends CrudRepository<Director, Long> {
    Director findByFirstNameAndLastName(String fN, String lN);
    List<Director> findByLastNameIsLike(String string);
}
