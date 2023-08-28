package com.hcltech.definitions;

import com.hcltech.utils.HelperClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public static void setUp() {

        HelperClass.setUpDriver();
    }

    @After
    public static void tearDown() {

        HelperClass.tearDown();
    }
}
