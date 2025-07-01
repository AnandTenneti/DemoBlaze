package com.tests;

import org.testng.ITestListener;

import java.io.IOException;

public class ITestListenerClass extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(org.testng.ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        System.out.println("Error: " + result.getThrowable().getMessage());
        try {
            captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + "_failure");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
