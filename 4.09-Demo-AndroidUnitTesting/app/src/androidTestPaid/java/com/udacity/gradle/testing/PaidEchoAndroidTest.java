package com.udacity.gradle.testing;

import android.test.AndroidTestCase;

import com.udacity.gradle.testing.paid.PaidEcho;

import java.util.Collection;

public class PaidEchoAndroidTest extends AndroidTestCase {
    public void testVerifyEchoResponse() {
        assertEquals("hello", Echo.echo("hello"));
    }

    public void testVerifyLoggingEchoResponse() {
        Collection<String> strings = PaidEcho.echo("hello", 10, true);
        assertEquals(strings.size(), 10);
        for (String string : strings) {
            assertEquals(string, "hello");
        }

        assertEquals("hello", Echo.echo("hello", true));
    }
}