package com.app.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtentReportLogger {

    private ExtentReportLogger() {
    }

    public static void pass(String message) {
        ExtentReportManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentReportManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    public static void skip(String message) {
        ExtentReportManager.getExtentTest().skip(message);
    }

    public static void info(String message) {
        ExtentReportManager.getExtentTest().info(message);
    }

    public static void logResponse(String message) {
        info("Response");
        ExtentReportManager.getExtentTest().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
    }

    public static void logRequest(RequestSpecification requestSpecification) {
        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);
        info("Request Details Below");
        for (Header header : query.getHeaders()) {
            info("Header Details: "+header.getName() + ":" + header.getValue());
        }
        ExtentReportManager.getExtentTest().info(MarkupHelper.createCodeBlock(query.getBody(), CodeLanguage.JSON));

    }


}
