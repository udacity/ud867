package com.udacity.example.jokes;

import com.udacity.example.jokes.JokeSmith;

public class JokeWizard {
    public String tellAWizardJoke(){
        JokeSmith myJokeSmith = new JokeSmith();
        return "A Wizard says " + myJokeSmith.tellAHandCraftedJoke();
    }
}
