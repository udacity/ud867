package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.builditbigger.idlingResource.LoadingJokerResource;
import com.udacity.gradle.builditbigger.presenter.JokerPresenterImpl;

import udacity.android.com.androidlibrary.AndroidLibraryMainActivity;

public class MainActivity extends AppCompatActivity implements JokerEndPointResult{

    private JokerPresenterImpl mJokerPresenterImpl;

    //Testing variable
    @Nullable
    private LoadingJokerResource mIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJokerPresenterImpl = new JokerPresenterImpl(this, this);
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

    public void tellJoke(View view) {
        mJokerPresenterImpl.fetchJokeFromApi();
        if (mIdlingResource != null) {
            mIdlingResource.setIdleState(false);
        }
    }

    @Override
    public void retrieveJoker(String joke) {
        if (mIdlingResource != null) {
            mIdlingResource.setIdleState(true);
        }
        Intent intent = new Intent(this, AndroidLibraryMainActivity.class);
        intent.putExtra(AndroidLibraryMainActivity.JOKER_TEXT, joke);
        startActivity(intent);
    }

    @Override
    public void showProgress(boolean show) {
        MainActivityFragment mainActivityFragment = (MainActivityFragment) getSupportFragmentManager().getFragments().get(0);
        mainActivityFragment.showProgress(show);
    }

    @Override
    public void showNoInternetConnection() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mIdlingResource != null) {
                    mIdlingResource.setIdleState(true);
                }
                MainActivityFragment mainActivityFragment = (MainActivityFragment) getSupportFragmentManager().getFragments().get(0);
                mainActivityFragment.showNoInternetConnection();
            }
        });
    }

    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        return getLoadingRecipesResource();
    }

    @VisibleForTesting
    private LoadingJokerResource getLoadingRecipesResource(){
        if (mIdlingResource == null) {
            mIdlingResource = new LoadingJokerResource();
        }
        return mIdlingResource;
    }

}
