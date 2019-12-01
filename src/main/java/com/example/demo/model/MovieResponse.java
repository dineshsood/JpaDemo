package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class MovieResponse {
    int page;
    int per_page;
    int total;
    int total_pages;
    List<MovieData> data ;
}
