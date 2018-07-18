package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class GoogleCloudEndpointTask extends AsyncTaskLoader<String> {

    private static MyApi myApi = null;

    public GoogleCloudEndpointTask(Context context) {
        super(context);
    }

    @Nullable
    @Override
    public String loadInBackground() {
        if (myApi == null) {
            MyApi.Builder apiBuilder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null).
                    setRootUrl("http://localhost:8080/_ah/api/").
                    setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApi = apiBuilder.build();
        }

        try {
            return myApi.sayHi("random").execute().getData();
        }
        catch (IOException e) {
            return e.getMessage();
        }

        // return null;
    }
}
