package com.exmample.joke_provider;

public class JokeProvider {

    private static final String [] JOKES = {
            "What are the two goals of a panda? 1) Get good rest to remove those bags under their eyes 2) Rest to get some color."
    };

    public static String getJoke(int index) {
        if (index > JOKES.length || index < 0) {
            return null;
        }
        else {
            return JOKES[index];
        }
    }
}
