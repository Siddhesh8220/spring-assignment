package com.springboot.assignment.entities;

public class Blog {

    private String heading;
    private String text;
    private String author;

    public Blog(String heading, String text, String author){
        this.heading = heading;
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}

