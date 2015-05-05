package com.udacity.gradle.testing.paid;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collection;

public class PaidEchoTest {
    @Test
    public void verifyEchoResponse() {
        Collection<String> strings = PaidEcho.echo("hello", 10);
        assertEquals(strings.size(), 10);
        for (String string : strings) {
            assertEquals(string, "hello");
        }
    }

    @Test
    public void verifyLoggingEchoResponse() {
        Collection<String> strings = PaidEcho.echo("hello", 10, true);
        assertEquals(strings.size(), 10);
        for (String string : strings) {
            assertEquals(string, "hello");
        }
    }
}
