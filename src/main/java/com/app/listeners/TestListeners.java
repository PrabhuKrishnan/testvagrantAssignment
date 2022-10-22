package com.app.listeners;

import com.app.annotations.FrameworkAnnotation;
import com.app.reports.ExtentReport;
import com.app.reports.ExtentReportLogger;
import com.app.utils.JiraUtils;
import org.testng.*;

import java.util.Arrays;

public class TestListeners implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {

        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.assignAuthor(result
                .getMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(FrameworkAnnotation.class).author());

        ExtentReport.assignCategory(result
                .getMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(FrameworkAnnotation.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportLogger.pass(result.getMethod().getMethodName() + " is passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportLogger.fail(result.getThrowable().getMessage());
        ExtentReportLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        //String issueInJira = JiraUtils.createIssueInJira(String.valueOf(result.getThrowable()));
        //ExtentReportLogger.fail("Issue Created in Jira: " + "http://localhost:8080/browse/"+issueInJira);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportLogger.skip(result.getMethod().getMethodName() + " is skipped ");
    }

    @Override
    public void onStart(ISuite suite) {

        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

}
