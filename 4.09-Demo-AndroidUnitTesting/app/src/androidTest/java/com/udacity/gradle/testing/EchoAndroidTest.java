package com.udacity.gradle.testing;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class EchoAndroidTest {

    @Test
    public void testVerifyEchoResponse() {
        assertEquals("hello", Echo.echo("hello"));
    }

    @Test
    public void testVerifyLoggingEchoResponse() {
        assertEquals("hello", Echo.echo("hello", true));
    }
}
