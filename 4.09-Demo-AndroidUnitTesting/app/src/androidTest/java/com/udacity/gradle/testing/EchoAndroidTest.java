package com.udacity.gradle.testing;

import android.test.AndroidTestCase;

public class EchoAndroidTest extends AndroidTestCase {
    public void testVerifyEchoResponse() {
        assertEquals("hello", Echo.echo("hello"));
    }

    public void testVerifyLoggingEchoResponse() {
        assertEquals("hello", Echo.echo("hello", true));
    }
}
