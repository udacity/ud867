package com.example.androidjokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Intent intent = getIntent();
        String joke  = intent.getStringExtra(EXTRA_JOKE);

        TextView tv_joke = findViewById(R.id.tv_joke);
        if (joke.isEmpty()){
            tv_joke.setText(getString(R.string.joke_unavailable_message));
        }
        else{
            tv_joke.setText(joke);
        }
    }
}
