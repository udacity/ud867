package com.example.jokedisplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class JokeDisplayerActivity extends AppCompatActivity {

    private String mJoke = null;
    private TextView mTextViewJoke = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_displayer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();

        if (savedInstanceState != null) {
            // Will have to see what needs to be done here.
        }
        else if (intent != null && intent.hasExtra(getString(R.string.key_intent_joke))) {
            mJoke = intent.getStringExtra(getString(R.string.key_intent_joke));
        }

        mTextViewJoke = findViewById(R.id.tv_joke);

        if (mJoke != null) {
            mTextViewJoke.setText(mJoke);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
