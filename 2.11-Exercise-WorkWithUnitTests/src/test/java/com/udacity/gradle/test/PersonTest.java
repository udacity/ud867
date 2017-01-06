package com.udacity.gradle.test;

import com.udacity.gradle.Person;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    @Test
    public void test() {
        Person person = new Person("Jeremy");
        Assert.assertEquals(person.getName(), "Jeremy");
    }
}
