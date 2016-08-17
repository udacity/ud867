package com.example.udacity.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.udacity.example.jokes.JokeSmith;
import com.udacity.example.jokes.JokeWizard;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        JokeWizard myJokeWizard = new JokeWizard();
        String wizardJoke = myJokeWizard.tellAWizardJoke();
        TextView wizardTextView = (TextView) rootView.findViewById(R.id.wizardJokeTextView);
        wizardTextView.setText(wizardJoke);


        JokeSmith myJokeSmith = new JokeSmith();
        String handcraftedJoke = myJokeSmith.tellAHandCraftedJoke();
        TextView handcraftedJokeTextView = (TextView) rootView.findViewById(R.id.handcraftedJokeTextView);
        handcraftedJokeTextView.setText(handcraftedJoke);


        return rootView;
    }
}
