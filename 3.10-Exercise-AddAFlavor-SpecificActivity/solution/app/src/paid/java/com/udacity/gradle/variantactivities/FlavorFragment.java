package com.udacity.gradle.variantactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.udacity.gradle.variantactivities.paid.PaidActivity;

public class FlavorFragment extends Fragment {
    public FlavorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flavor, container, false);
        Button button = (Button) view.findViewById(R.id.launch_activity_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PaidActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}
