package com.udacity.gradle.builditbigger;

public interface JokerEndPointResult {
    void retrieveJoker(String joke);
    void showProgress(boolean show);
    void showNoInternetConnection();
}
