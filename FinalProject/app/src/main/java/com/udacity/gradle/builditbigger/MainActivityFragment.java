package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private LinearLayout mViewLoading;
    private LinearLayout mViewNoInternet;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mViewLoading = root.findViewById(R.id.in_loading);
        mViewNoInternet = root.findViewById(R.id.in_no_internet);


        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    public void showProgress(boolean show){
        if(show) {
            mViewLoading.setVisibility(View.VISIBLE);
            mViewNoInternet.setVisibility(View.GONE);
        } else {
            mViewLoading.setVisibility(View.GONE);
        }
    }

    public void showNoInternetConnection(){
        mViewLoading.setVisibility(View.GONE);
        mViewNoInternet.setVisibility(View.VISIBLE);
    }

}
