package com.example.android.clickcounter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ClickFragment extends Fragment {

    protected ClickCounter mClickCounter;
    protected TextView mTextView;
    private static String CLICK_COUNT_TAG = "derp";

    public ClickFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_click, container, false);

        if (null != savedInstanceState) {
            mClickCounter =  savedInstanceState.getParcelable(CLICK_COUNT_TAG);
        } else {
            mClickCounter = new ClickCounter();
        }

        mTextView = (TextView) rootView.findViewById(R.id.click_count_text_view);
        displayClickCount();
        Button button = (Button) rootView.findViewById(R.id.click_button);
        button.setOnClickListener(mListener);
        return rootView;
    }

    View.OnClickListener mListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            incrementClickCounter();
        }
    };

    void incrementClickCounter(){
        mClickCounter.increment();
        displayClickCount();
    }

    void displayClickCount(){
        mTextView.setText(Integer.toString(mClickCounter.getCount()));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CLICK_COUNT_TAG, mClickCounter);
    }


}
