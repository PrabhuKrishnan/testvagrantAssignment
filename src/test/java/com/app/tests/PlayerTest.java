package com.app.tests;

import com.app.annotations.FrameworkAnnotation;
import com.app.enums.CategoryType;
import com.app.reports.ExtentReportLogger;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static com.app.requestBuilder.RequestBuilders.buildRequestForGetCalls;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @FrameworkAnnotation(author = {"prabhu"}, category = {CategoryType.SMOKE})
    @Test(description = "To verify that the team has only 4 foreign players")
    public void getEmployeesDetails() {



        Response response = buildRequestForGetCalls().get("/employees");

    }

}
