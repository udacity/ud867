package com.udacity.gradle;

import com.google.common.base.Strings;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return Strings.emptyToNull(name);
    }
}
