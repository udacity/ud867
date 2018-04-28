package com.example.yasmeen.libandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowingJoke extends AppCompatActivity {
    private static String joke ="Joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing_joke);
        Intent intent=getIntent();
        String returnJoke = intent.getStringExtra(joke);
        TextView textView = (TextView)findViewById(R.id.Joke);
        textView.setText(returnJoke);
    }
}
