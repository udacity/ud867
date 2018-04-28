package com.example.yasmeen.lib2;
import com.example.yasmeen.lib.JokeSmith;

public class JokeWizard {
    public String getJoke()
    {
        JokeSmith jokeSmith= new JokeSmith();
        return "Wizewd "+ jokeSmith.getJoke();
    }
}
