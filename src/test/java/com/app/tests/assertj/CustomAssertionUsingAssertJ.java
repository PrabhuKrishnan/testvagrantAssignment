package com.app.tests.assertj;

import com.app.annotations.FrameworkAnnotation;
import com.app.enums.CategoryType;
import com.app.requestBuilder.pojo.Employee;
import com.app.reports.ExtentReportLogger;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static com.app.requestBuilder.RequestBuilders.buildRequestForPostCalls;
import static com.app.utils.RandomUtils.*;

public class CustomAssertionUsingAssertJ {

    @FrameworkAnnotation(author = {"prabhu"}, category = {CategoryType.SMOKE})
    @Test(description = "To verify the Employees post call is working or not,using builder pattern to se serialize and De-serialize the request and response")
    public void customAssertionUsingAsserJ()
    {
        Employee employee = Employee
                .builder()
                .setId(getId())
                .setFirstName(getFirstName())
                .setLastName(getLastName())
                .build();

        RequestSpecification requestSpecification = buildRequestForPostCalls().body(employee);

        ExtentReportLogger.logRequest(requestSpecification); //to log the request to the extent report

        Response response = requestSpecification.post("/employees");


        ExtentReportLogger.logResponse(response.asPrettyString());

         /*ResponseAssert
                 .assertThat(response)
                 .isSuccessfulPostResponse()
                 .hasHeaderApplicationJson();*/

        EmployeeAssert
                .assertThat(employee)
                .hasName(employee.getFirstName());


    }
}
