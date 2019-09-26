package com.udacity.gradle.builditbigger;

import android.content.Context;

import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndpointsAsyncTaskTest{

    @org.junit.Test
    public void doInBackground() {
    }

    @org.junit.Test
    public void onPostExecute() {
    }

    @Test
    public void jokeNotNull(){
        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.execute(InstrumentationRegistry.getInstrumentation().getContext());
        try {
            String test = task.get(5, TimeUnit.SECONDS);
            Assert.assertTrue(!test.isEmpty());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}