package com.app.tests;

import com.app.annotations.FrameworkAnnotation;
import com.app.constants.FrameworkConstants;
import com.app.enums.CategoryType;
import com.app.reports.ExtentReportLogger;
import com.app.utils.ApiUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static com.app.requestBuilder.RequestBuilders.*;

public class JiraTest extends  BaseTest {

    @FrameworkAnnotation(author = {"prabhu"}, category = {CategoryType.REGRESSION})
  //  @Test(description = "To verify used should be able to create the jira issue using the jira REST Api")
    public void createIssue() {

        String resource = ApiUtils.readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath()+"createIssue.json")
                .replace("SUMMARY", "Third party fund transfer is not working")
                .replace("DESCRIPTION", "Not able to select the credit option");

        RequestSpecification requestSpecification =  buildRequestForPostCalls()
                .header("Authorization","Basic YWRtaW46YWRtaW4=")
                .body(resource);


        ExtentReportLogger.logRequest(requestSpecification);
        Response response = requestSpecification.post("/rest/api/2/issue/");
        response.prettyPrint(); //printing the response in console
        ExtentReportLogger.logResponse(response.asPrettyString());

        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(201);






    }
}
