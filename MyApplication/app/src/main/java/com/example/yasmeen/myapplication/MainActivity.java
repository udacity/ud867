package com.example.yasmeen.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.yasmeen.lib.JokeSmith;
import com.example.yasmeen.lib2.JokeWizard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JokeSmith jokeSmith=new JokeSmith();
        JokeWizard jokeWizard= new JokeWizard();
        TextView textView= (TextView)findViewById(R.id.text111);
        textView.setText(jokeSmith.getJoke().toString());
        TextView textView2= (TextView)findViewById(R.id.textView2);
        textView2.setText(jokeWizard.getJoke());
    }
}
