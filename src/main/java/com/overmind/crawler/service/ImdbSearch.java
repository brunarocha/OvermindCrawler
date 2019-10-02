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
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author BrunaRocha
 */
public class ImdbSearch {
    
    
     public Document visit(String URL){
        try {
            return Jsoup.connect(URL).get();              

        } catch (IOException e) {
            System.err.println("For '" + URL + "': " + e.getMessage());
        }
        
        return null;
    }
    
   
    public List<Movie> findMovies(Document document){ 
        List<Movie> movies = new ArrayList<Movie>(); 
        
        Elements elements = document.select(ImdbPattern.MOVIES_ELEMENT).select("tr");
       
        for(int i = 0; i < ImdbPattern.MAX; i++){
            Movie movie = new Movie();
            movie.setUrl(elements.eq(i).select(ImdbPattern.MOVIE_URl).attr("href"));
            
            movies.add(movie);
        }
        
        return movies;   
    }
    
    public Movie findMovie(Movie movie){
        Document document = this.visit(movie.getUrl());
        Elements elements = document.select(ImdbPattern.INFO_MOVIE);
        Elements summary  = document.select(ImdbPattern.INFO_TECHNICAL);            
        String title      = elements.select(ImdbPattern.ORIGINAL_TITLE).text();
        
        if(title == null || title.equals("")){
            title = elements.select("div.title_wrapper > h1").text();
        }
        
        movie.setTitle(title);
        movie.setRate(Double.parseDouble(elements.select(ImdbPattern.RATE).text()));
        movie.getComment().setUrl(document.select(ImdbPattern.COMMENTS_URL).last().attr("href"));
        
        for(Element director : summary.first().select("a")){
            movie.setDirector(director.text());
        }
        
        for(Element star : summary.last().select("a")){
            if(!star.attr("href").contains("fullcredits")){
                movie.setCast(star.text());
            }
        }
               
        return movie;
    }
    
    public Comment findComment(Comment comment){
        Document document = this.visit(comment.getUrl());
        Element element = document.select(ImdbPattern.COMMENT_ELEMENT).first();
        comment.setRate(Double.parseDouble(element.select(ImdbPattern.COMMENT_RATE).first().text()));
        comment.setComment(element.select(ImdbPattern.COMMENT).text());
        
        return comment;
    }
    
    public String findUrlList(){
        Document main     = this.visit(ImdbPattern.HOME);        
        Elements elements = main.select(ImdbPattern.MENU).first().select("a");
        String url        = "";
        
        for(Element element : elements){
            if(element.text().contains("Top Rated Movies")){
                url = element.attr("href");
                break;
            }
        }
        
        main = this.visit(ImdbPattern.HOME+url);        
        
        return main.select(ImdbPattern.MENU_LOWEST).last().select("a").attr("href");
    }
    
    public String findUrlLowestList(Document document){
        Elements elements = this.visit(ImdbPattern.HOME).select("div.subNavListContainer > ul").first().select("a");
        
        for(Element element : elements){
            if(element.text().contains("Top Rated Movies")){
                return element.text();
            }
        }
        
        return "";
    }
}