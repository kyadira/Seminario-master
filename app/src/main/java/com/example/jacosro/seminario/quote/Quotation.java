package com.example.jacosro.seminario.quote;

/**
 * Created by kallileo on 07/02/2018.
 */

public class Quotation {

    private String author;
    private String text;

    public Quotation(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
