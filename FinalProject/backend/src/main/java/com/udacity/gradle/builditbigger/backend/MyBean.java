package com.udacity.gradle.builditbigger.backend;

import com.example.jokeslib.JokeProvider;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        myData = new JokeProvider().getJoke();
        return myData;
    }
}