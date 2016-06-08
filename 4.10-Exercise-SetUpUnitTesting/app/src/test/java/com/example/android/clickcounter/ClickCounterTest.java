package com.example.android.clickcounter;

import junit.framework.Assert;

import org.junit.Test;

import static junit.framework.Assert.*;

public class ClickCounterTest {
    @Test
    public void testThatClickCounterIncrementsTheCountByOneOnSingleIncrement() {
        ClickCounter clickCounter = new ClickCounter();
        clickCounter.increment();
        assertEquals(1, clickCounter.getCount());
    }

    @Test
    public void testThatClickConterHasAnInitialCountAsZero() {
        ClickCounter clickCounter = new ClickCounter();
        assertEquals(0, clickCounter.getCount());
    }
}
