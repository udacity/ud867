package com.udacity.gradle.testing;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.testing.paid.PaidEcho;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class PaidEchoAndroidTest {

    @Test
    public void testVerifyEchoResponse() {
        assertEquals("hello", Echo.echo("hello"));
    }

    @Test
    public void testVerifyLoggingEchoResponse() {
        Collection<String> strings = PaidEcho.echo("hello", 10, true);
        assertEquals(strings.size(), 10);
        for (String string : strings) {
            assertEquals(string, "hello");
        }

        assertEquals("hello", Echo.echo("hello", true));
    }
}