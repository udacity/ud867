package com.udacity.gradle.variantactivities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FlavorFragment extends Fragment {
    public FlavorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flavor, container, false);

        // TODO: Add listener to add activity button to launch "paid" activity

        return view;
    }
}
