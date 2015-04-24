package com.udacity.gradle.testing.paid;

import org.junit.Test;

import java.util.Collection;

public class PaidEchoTest {
    @Test
    public void verifyEchoResponse() {
        Collection<String> strings = PaidEcho.echo("hello", 10);
        assert strings.size() == 10;
        for (String string : strings) {
            assert string.equals("hello");
        }
    }

    @Test
    public void verifyLoggingEchoResponse() {
        Collection<String> strings = PaidEcho.echo("hello", 10, true);
        assert strings.size() == 10;
        for (String string : strings) {
            assert string.equals("hello");
        }
    }
}
