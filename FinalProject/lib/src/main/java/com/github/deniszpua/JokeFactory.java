package com.github.deniszpua;

import java.util.Arrays;
import java.util.List;

public class JokeFactory {
    private final static List<String> JOKES = Arrays.asList(
        "Java: write once, debug everywhere"
        ,"Where is code - there is bugs"
        ,"Why Dead Beef always after Cafe Babe?"

    );

    public static String getNewJoke() {
        int nextJokeIdx = (int) (Math.random() * JOKES.size());
        return JOKES.get(nextJokeIdx);
    }

}
