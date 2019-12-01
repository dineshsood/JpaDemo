package com.example.demo.controller;

import com.example.demo.model.MovieData;
import com.example.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MoviesController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public List<MovieData> getMoviesByName( @RequestParam String nameContains
            , @RequestParam(required = false) String sortBy ) {

        List<MovieData> movieNames = this.movieService
                .getMoviesByName( nameContains, sortBy );

        return movieNames;
    }

}
