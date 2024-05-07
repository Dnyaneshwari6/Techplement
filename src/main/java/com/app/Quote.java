package com.app;

public class Quote {
    private String text;

    public Quote() {
    }

    public Quote(String text) {
        this.text = text;
    }

    // Getters and setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}