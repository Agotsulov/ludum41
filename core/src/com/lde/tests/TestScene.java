package com.lde.tests;

import com.lde.Scene;

/**
 * Created by byzilio on 20.04.18.
 */

public class TestScene extends Scene{

    @Override
    public void init() {
        add(new TestObject(3,4));
    }
}
