package com.udacity.gradle.builditbigger.model;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokerApi.JokerApi;
import com.udacity.gradle.builditbigger.presenter.JokerPresenter;
import com.udacity.gradle.builditbigger.utils.NetworkUtils;

import java.io.IOException;

/**
 * Reference: https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/77e9910911d5412e5efede5fa681ec105a0f02ad/HelloEndpoints
 */
public class JokerEndPointAsyncTask extends AsyncTask<Context, Void, String> {

    private static JokerApi mJokerApi = null;
    private static  final String JOKER_URL = "https://jokerendpoint.appspot.com/_ah/api/";
    private JokerPresenter mJokerPresenter;

    public JokerEndPointAsyncTask(JokerPresenter mJokerPresenter) {
        this.mJokerPresenter = mJokerPresenter;
    }

    @Override
    protected void onPreExecute() {
        mJokerPresenter.showProgress(true);

        if(mJokerApi == null) {
            JokerApi.Builder builder = new JokerApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(JOKER_URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            mJokerApi = builder.build();
        }
    }

    @Override
    protected String doInBackground(Context... contexts) {
            if(NetworkUtils.checkInternetConnection(contexts[0])){
                try {
                    return mJokerApi.getJoke().execute().getJoke();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            } else {
                mJokerPresenter.showNoInternetConnection();
                return null;
            }
    }

    @Override
    protected void onPostExecute(String result) {
        mJokerPresenter.showProgress(false);
        if(result != null){
            mJokerPresenter.retrieveJoker(result);
        }
    }
}
