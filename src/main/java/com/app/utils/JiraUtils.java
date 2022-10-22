package com.app.utils;

import com.app.constants.FrameworkConstants;
import com.app.reports.ExtentReportLogger;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.app.requestBuilder.RequestBuilders.buildRequestForPostCalls;

public final class JiraUtils {

    private JiraUtils() {
    }

    public static String createIssueInJira(String errorMessage) {

        String resource = ApiUtils.readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath() + "createIssue.json")
                .replace("SUMMARY", "Own Account Transfer")
                .replace("DESCRIPTION", errorMessage);

        RequestSpecification requestSpecification =  buildRequestForPostCalls()
                .header("Authorization","Basic YWRtaW46YWRtaW4=")
                .body(resource);

        ExtentReportLogger.logRequest(requestSpecification);
        Response response = requestSpecification.post("/rest/api/2/issue/");
        ExtentReportLogger.logResponse(response.asPrettyString());

        return response.jsonPath().getString("key");
    }

}
