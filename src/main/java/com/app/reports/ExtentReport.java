package com.app.reports;

import com.app.enums.CategoryType;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {
    }

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    public static void initReports() {

        if(Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
            extentReports.attachReporter(spark);
        }
    }

    public static void createTest(String testCaseName) {
        ExtentTest extentTest = extentReports.createTest(testCaseName);
        ExtentReportManager.setExtentTest(extentTest);
    }

    public static void assignAuthor(String[] authors) {
        for (String author : authors) {
            ExtentReportManager.getExtentTest().assignAuthor(author);

        }
    }

    public static void assignCategory(CategoryType[] categories) {
        for (CategoryType category : categories) {
            ExtentReportManager.getExtentTest().assignCategory(category.toString());
        }
    }

    public static void flushReports() {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
        ExtentReportManager.unLoad();
    }

}
