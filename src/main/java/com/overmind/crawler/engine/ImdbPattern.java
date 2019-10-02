/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.overmind.crawler.engine;

import java.io.Serializable;

/**
 *
 * @author BrunaRocha
 */
public class ImdbPattern implements Serializable {
    
    public static final int MAX                 = 10;
    public static final String HOME             = "https://www.imdb.com/";
    //public static final String HOME_TESTE       = "https://www.imdb.com/list/ls002667873/";
    public static final String MENU             = "div.subNavListContainer > ul";
    public static final String MENU_LOWEST      = "div.full-table > div > div";
    public static final String MAIN_ELEMENT     = "div.mode-detail";
    public static final String MOVIES_ELEMENT   = "tbody.lister-list";
    public static final String MOVIE_URl        = "td.titleColumn > a";
    public static final String ORIGINAL_TITLE   = "div.originalTitle";
    public static final String RATE             = "div.ratingValue span[itemprop=\"ratingValue\"]";
    public static final String INFO_MOVIE       = "div.title_bar_wrapper";
    public static final String INFO_TECHNICAL   = "div.credit_summary_item";
    public static final String COMMENTS_URL     = "div.user-comments > a";
    public static final String COMMENT_ELEMENT = "div.lister-list";
    public static final String COMMENT_RATE     = "span.rating-other-user-rating > span";
    public static final String COMMENT          = "div.review-container > div > div.content > div";

}
