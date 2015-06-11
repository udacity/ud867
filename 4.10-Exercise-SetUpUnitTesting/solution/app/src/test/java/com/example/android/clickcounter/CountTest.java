package com.example.android.clickcounter;

import com.example.android.clickcounter.ClickCounter;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.Before;


public class CountTest  {

    private ClickCounter mCounter;


    @Before
    public void setUpCounter(){
        mCounter = new ClickCounter();
    }

    @Test
    public void testInitialCount() {
        Assert.assertEquals( mCounter.getCount(), 0);
    }

    @Test
    public void testIncrement(){
        int previousValue = mCounter.getCount();
        mCounter.increment();
        int postValue = mCounter.getCount();
        Assert.assertEquals(previousValue + 1, postValue);
    }




}