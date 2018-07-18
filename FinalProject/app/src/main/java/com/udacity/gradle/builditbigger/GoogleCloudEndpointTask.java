package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

public class GoogleCloudEndpointTask extends AsyncTaskLoader<String> {

    public GoogleCloudEndpointTask(Context context) {
        super(context);
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return null;
    }
}
