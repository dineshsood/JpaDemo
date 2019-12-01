package com.example.demo.restclient;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieRestClient {

    public String getMoviesResponse( String urlStr ) {

        String jsonResponse = "";

        try {
            RestTemplate restTemplate = new RestTemplate();
            jsonResponse = restTemplate.getForObject( urlStr , String.class );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonResponse ;
    }

}

