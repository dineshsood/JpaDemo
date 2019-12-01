package com.example.demo.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Comparator;

@Data
public class MovieData {
    @SerializedName("Title")
    String title;
    @SerializedName("Year")
    Integer year;
    String imdbID;

    public static Comparator<MovieData> sortBy( String sortBy ) {

        Comparator<MovieData> sortByComparator = Comparator.comparing(a -> a.title);

        if( "year".equalsIgnoreCase( sortBy ) ) {
            sortByComparator = Comparator.comparing(a -> a.year);
        } else if( "imdbID".equalsIgnoreCase( sortBy ) ) {
            sortByComparator = Comparator.comparing(a -> a.imdbID);
        }

        return sortByComparator ;
    }

}
