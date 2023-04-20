package ClasesBasicasSelenium.TestNgAnotations;

import org.testng.ITestListener;

public class ListenerDemo implements ITestListener {

    public void onTestFailure(org.testng.ITestResult result) {
        System.out.println("Fail, this message is from ITListener");

    }

    public void onTestSuccess(org.testng.ITestResult result) {
        System.out.println("success, this message is from ITListener");
    }
}
