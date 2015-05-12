package com.udacity.gradle.testingexercise;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        TextView deviceTextView = (TextView) root.findViewById(R.id.device_textview);
        deviceTextView.setText(DeviceInfoGenerator.getDeviceInfo());

        TextView dateTextView = (TextView) root.findViewById(R.id.date_textview);
        dateTextView.setText(DeviceInfoGenerator.getDate());

        return root;
    }
}
