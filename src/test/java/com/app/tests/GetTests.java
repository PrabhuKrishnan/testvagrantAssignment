package com.app.tests;

import com.app.annotations.FrameworkAnnotation;
import com.app.enums.CategoryType;
import com.app.reports.ExtentReportLogger;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.app.requestBuilder.RequestBuilders.buildRequestForGetCalls;
import static org.assertj.core.api.Assertions.*;

public class GetTests extends BaseTest {

    @FrameworkAnnotation(author = {"prabhu"}, category = {CategoryType.SMOKE})
    @Test(description = "To verify the Employees get API is working or not")
    public void getEmployeesDetails() {

        Response response = buildRequestForGetCalls().get("/employees");

        response.prettyPrint();

        ExtentReportLogger.logResponse(response.asPrettyString());


        assertThat(response.getStatusCode())
                .isEqualTo(200);

        assertThat(response.jsonPath().getList("$").size())
                .isPositive()
                .as("Validating the json path is greater than the size 30")
                .isGreaterThan(50);


    }

    @FrameworkAnnotation(author = {"prabhu"}, category = {CategoryType.SMOKE})
    @Test(description = "To verify the API should return the employee details based on the ID", dataProvider = "getData")
    public void getEmployeeDetail(Integer id, String firstName) {
        Response response =
                buildRequestForGetCalls()
                        .pathParam("id", id)
                        .get("/employees/{id}");

        ExtentReportLogger.logResponse(response.asPrettyString());

        assertThat(response.getStatusCode())
                .isEqualTo(200);




            assertThat(response.jsonPath().getString("first_name"))
                    .as("Comparing the first name in the Response").isEqualTo(firstName)
                    .hasSizeBetween(1, 30);



    }


    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {854, "Elisha"},
                {648, "Lue"},
                {960, "Berry"}
        };

    }


}
