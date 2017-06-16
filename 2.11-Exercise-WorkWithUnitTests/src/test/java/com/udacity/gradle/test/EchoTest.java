package com.udacity.gradle.test;

import com.udacity.gradle.Echo;
import org.junit.Assert;
import org.junit.Test;

public class EchoTest {
    @Test
    public void test() {
        Assert.assertEquals(Echo.echo("hello"), "hello");
    }
}
