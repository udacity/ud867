package com.udacity.gradle.builditbigger.presenter;

public interface JokerPresenter {
    void retrieveJoker(String joke);
    void showProgress(boolean show);
    void showNoInternetConnection();
}
