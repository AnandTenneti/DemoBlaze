package com.tests;

import org.testng.annotations.DataProvider;

public class DataSupplier {

    @DataProvider(name = "productName")
    public String[] getProductName() {
        String[] data = new String[]{"Nexus 6", "HTC One M9", "Sony xperia z5"};
        return data;
    }

    @DataProvider(name = "CPnames")
    public String[][] getCPNames() {
        String[][] data = new String[][]{
                {"Laptops", "Sony vaio i7"},
                {"Phones", "HTC One M9"}};
        return data;
    }
}
