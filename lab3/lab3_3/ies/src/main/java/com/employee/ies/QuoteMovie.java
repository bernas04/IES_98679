package com.employee.ies;

/* This class is responsible to join Movie and Quote classes, by "showId" attribute */

public class QuoteMovie{

    private String quote;
    private int showId;
    
    public QuoteMovie(String quote, int showId) {
        this.quote = quote;
        this.showId = showId;
    }

    public String getQuote() {
        return quote;
    }

    
    public int getShowId() {
        return showId;
    }

   

    

}