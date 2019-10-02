/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.overmind.crawler.bean;

import com.overmind.crawler.engine.ImdbPattern;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BrunaRocha
 */
public class Movie implements Comparable<Movie>  {
    
    private String title; 
    private double rate; 
    private List<String> directors; 
    private List<String> cast; 
    private String url;
    private Comment comment;
     
    public Movie() {
        this.directors  = new ArrayList<>();
        this.cast       = new ArrayList<>();
        this.comment    = new Comment();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }
    
    public void setDirector(String director) {
        this.directors.add(director);
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }
    
    public void setCast(String cast) {
        this.cast.add(cast);
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = ImdbPattern.HOME+url;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
    
    private String directors(){
        return String.join(", ", this.directors);
    }
    
    private String cast(){
        return String.join(", ", this.cast);
    }

    @Override
    public String toString() {
        return "\n*****************************************"+
            "\nTitle: "+this.getTitle() +
            //"\nURL: "+url+
            "\nRate: "+rate+
            "\nDirectors: "+this.directors()+
            "\nCast: "+this.cast()+
            "\nComment: "+comment.getComment()+
            "\n*****************************************";
    }

    @Override
    public int compareTo(Movie o) {
        return Double.compare(this.rate, o.getRate());
    }
    
    
}
