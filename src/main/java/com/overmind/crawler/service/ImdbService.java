/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.overmind.crawler.service;

import com.overmind.crawler.bean.Comment;
import com.overmind.crawler.bean.Movie;
import com.overmind.crawler.engine.ImdbPattern;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.jsoup.nodes.Document;
 
/**
 *
 * @author BrunaRocha
 */
public class ImdbService {   
    
    
    public static void main(String[] args) throws IOException {
        System.out.println("Process....");
        
        ImdbSearch search = new ImdbSearch();           
        Document document = search.visit(ImdbPattern.HOME+search.findUrlList());        
        List<Movie> movies = search.findMovies(document);
        
        for(Movie movie : movies){
            movie = search.findMovie(movie);
            
            Comment comment = search.findComment(movie.getComment());
            
            movie.setComment(comment);   
        }
        
        Collections.sort(movies);
        
        System.out.println(movies);
    }
    
        
}
