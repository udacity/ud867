package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.exmample.joke_provider.JokeProvider;
import com.example.jokedisplayer.*;

public class MainActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<String>,
        View.OnClickListener {

    private static final int GET_JOKE_TASK = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn_joke_button);
        button.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view, String joke) {
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }


    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        Loader<String> loader = null;

        switch (id) {
            case GET_JOKE_TASK:
                loader = new GoogleCloudEndpointTask(getApplicationContext());
                break;
            default:
                throw new UnsupportedOperationException(
                        "The id " + Integer.toString(id) + " is not supported."
                );
        }

        return loader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if (data != null && !data.isEmpty()) {
            Log.d("onLoadFinished", data);
            tellJoke(null, data);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) { }

    @Override
    public void onClick(View v) {
        if (getSupportLoaderManager() != null) {
            if (getSupportLoaderManager().getLoader(GET_JOKE_TASK) == null) {
                getSupportLoaderManager().initLoader(GET_JOKE_TASK, null, this).forceLoad();
            }
            else {
                getSupportLoaderManager().restartLoader(GET_JOKE_TASK, null, this).forceLoad();
            }
        }
    }
}
