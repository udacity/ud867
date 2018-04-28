package com.example.yasmeen.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.yasmeen.lib.JokeSmith;

import com.example.yasmeen.mylibrary.MainActivity2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void gotov(View view)
    {

        Intent intent= new Intent(this, MainActivity2.class);
        JokeSmith jokeSmith=new JokeSmith();
        intent.putExtra("joke", jokeSmith.getJoke());
        startActivity(intent);
    }
}
