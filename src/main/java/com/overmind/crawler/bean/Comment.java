/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.overmind.crawler.bean;

import com.overmind.crawler.engine.ImdbPattern;

/**
 *
 * @author BrunaRocha
 */
public class Comment {
    
    public double rate;
    public String comment;
    public String url;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        String replace = url.replace("ref_=tt_urv", "sort=userRating&dir=desc&ratingFilter=0");
        
        this.url = ImdbPattern.HOME+replace; 
    }

    @Override
    public String toString() {
        return "Comment{" + "rate=" + rate + ", comment=" + comment + ", url=" + url + '}';
    }

    
}
