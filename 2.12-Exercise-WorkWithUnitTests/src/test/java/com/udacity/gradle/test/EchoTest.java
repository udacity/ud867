package com.udacity.gradle.test;

import com.udacity.gradle.Echo;
import org.junit.Test;

public class EchoTest {
    @Test
    public void test() {
        assert Echo.echo("hello").equals("hello");
    }
}