package com.udacity.gradle.builditbigger.presenter;

import android.content.Context;

import com.udacity.gradle.builditbigger.JokerEndPointResult;
import com.udacity.gradle.builditbigger.model.JokerEndPointAsyncTask;

public class JokerPresenterImpl implements JokerPresenter {

    private JokerEndPointResult mJokerEndPointResult;
    private Context mContext;

    public JokerPresenterImpl(JokerEndPointResult jokerEndPointResult, Context context) {
        mJokerEndPointResult = jokerEndPointResult;
        mContext = context;
    }

    @Override
    public void retrieveJoker(String joke) {
        mJokerEndPointResult.retrieveJoker(joke);
    }

    @Override
    public void showProgress(boolean show) {
        mJokerEndPointResult.showProgress(show);
    }

    @Override
    public void showNoInternetConnection() {
        mJokerEndPointResult.showNoInternetConnection();
    }

    public void fetchJokeFromApi(){
        new JokerEndPointAsyncTask(this).execute(mContext);
    }
}
