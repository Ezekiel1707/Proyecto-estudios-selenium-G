package base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends BasePage {

    public static ExtentReports extentReport;
    public static String extentReportPrefix;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public ExtentManager() throws IOException {
        super();
    }

    public static ExtentReports getReport() {
        if (extentReport == null) {

            setupExtentReports("Estudios-Selenium_g");
        }
        return extentReport;
    }

    public static ExtentReports setupExtentReports(String testName) {
        System.out.println("setup report");
        System.out.println(testName);
        extentReport = new ExtentReports();
        String ExtentSparkReporterFolder = System.getProperty("user.dir") + "/test-output/Reports/"+extentReportsPrefix_Name(testName)+"/" +
                extentReportsPrefix_Name(testName);
        ExtentSparkReporter spark = new ExtentSparkReporter(ExtentSparkReporterFolder+ ".html");
        extentReport.attachReporter(spark);

        extentReport.setSystemInfo("Tester", "My Name");
        spark.config().setReportName("Regresion test");
        spark.config().setTheme(Theme.DARK);
        return extentReport;
    }

    public static String extentReportsPrefix_Name(String testName) {
        String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        extentReportPrefix = testName + "_" + date;
        return extentReportPrefix;
    }

    public static void flushReport() {
        extentReport.flush();
    }

    public synchronized static ExtentTest getTest() {
        return extentTest.get();
    }

    public synchronized static ExtentTest createTest(String name, String description) {
        ExtentTest test = extentReport.createTest(name, description);
        extentTest.set(test);
        return getTest();

    }

    public synchronized static void log(String message) {
        getTest().info(message);

    }

    public synchronized static void pass(String message) {
        getTest().pass(message);

    }

    public synchronized static void fail(String message) {
        getTest().fail(message);

    }

    public synchronized static void attachImage() {
        getTest().addScreenCaptureFromPath(getScreenshotDestination());

    }

}