package com.example.demo.service;

import com.example.demo.model.MovieData;
import com.example.demo.model.MovieResponse;
import com.example.demo.restclient.MovieRestClient;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    @Getter
    private final MovieRestClient movieRestClient;

    private final static String URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s";

    public List<MovieData> getMoviesByName( String movieName, String sortBy ){
        List<MovieData> movieDataList = this.getMoviesByName( movieName );

        // Command pattern implementation
        // Command interface is java.util.Comparator
        // Implementation is provided using lambda expression and "sortBy" parameter value
        if( movieDataList!=null
                && !movieDataList.isEmpty()
                && sortBy!=null
                && !sortBy.trim().isEmpty() ) {
            movieDataList.sort( MovieData.sortBy( sortBy.trim() ) );
        }

        return movieDataList ;
    }

    public List<MovieData> getMoviesByName( String movieName ) {

        if(movieName==null || movieName.trim().isEmpty()) {
            return Collections.emptyList() ;
        }

        String urlStr = String.format(URL, movieName.trim());

        MovieResponse movieResponse = this.getMovieResponseFrom( urlStr );

        int totalPages = movieResponse.getTotal_pages();

        int pageNum = 2;

        List<MovieData> movieDataList = new ArrayList<>( movieResponse.getData() );

        while( pageNum <= totalPages ) {

            urlStr =  urlStr + "&page=" + pageNum;
            movieResponse = this.getMovieResponseFrom( urlStr );

            if(movieResponse== null || movieResponse.getData()==null || movieResponse.getData().isEmpty()) {
                continue;
            }

            movieDataList.addAll( movieResponse.getData() ) ;

            pageNum++;
        }

        System.out.println( movieDataList );
        return movieDataList ;
    }

    public MovieResponse getMovieResponseFrom( String urlStr ){

        String jsonResponse = this.movieRestClient.getMoviesResponse(urlStr);

        Gson gson = new Gson();
        MovieResponse movieResponse = gson.fromJson(jsonResponse, MovieResponse.class);

        return movieResponse;
    }

}
