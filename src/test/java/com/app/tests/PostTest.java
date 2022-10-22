package com.app.tests;

import com.app.annotations.FrameworkAnnotation;
import com.app.constants.FCwithSingleton;
import com.app.constants.FrameworkConstants;
import com.app.enums.CategoryType;
import com.app.requestBuilder.pojo.Employee;
import com.app.reports.ExtentReportLogger;
import com.app.utils.ApiUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.app.requestBuilder.RequestBuilders.*;
import static com.app.utils.RandomUtils.*;

public class PostTest extends BaseTest {
    @FrameworkAnnotation(author = {"prabhu"}, category = {CategoryType.SMOKE})
    @Test(description = "To verify the Employees post call is working or not,using builder pattern to se serialize and De-serialize the request and response")
    public void postMethodRequestTest() {

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

        /*Assertions.assertThat(response.getStatusCode())
                .isEqualTo(201);*/
    }

    @FrameworkAnnotation(author = {"prabhu"}, category = {CategoryType.SMOKE})
    @Test(description = "To verify the Employees post request is working or not, using file to read and write the request")
    public void postRequestUsingExternalFile(Method method) {
        String resource = ApiUtils.readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath() + "request.json")
                .replace("fname", getFirstName())
                .replace("number", String.valueOf(getId()));

        RequestSpecification requestSpecification =
                buildRequestForPostCalls()
                        .body(resource);

        ExtentReportLogger.logRequest(requestSpecification);

        Response response = requestSpecification.post("/employees");
        ExtentReportLogger.logResponse(response.asPrettyString());

        ApiUtils.storeStringAsJsonFile(FrameworkConstants.getResponseJsonFolderPath() + method.getName() + "response.json", response);

       /* Assertions.assertThat(response.getStatusCode())
                .isEqualTo(201);*/

    }

    //using the singletonPattern
    @FrameworkAnnotation(author = {"prabhu"}, category = {CategoryType.SMOKE})
    @Test(description = "To verify the Employees post method is working or not,using singleton design factory to read the request and response")
    public void postRequestUsingExternalFile1(Method method) {
        String resource = ApiUtils.readJsonAndGetAsString(FCwithSingleton.getInstance().getRequestJsonFolderPath() + "request.json")
                .replace("fname", getFirstName())
                .replace("number", String.valueOf(getId()));

        RequestSpecification requestSpecification =
                buildRequestForPostCalls()
                        .body(resource);

        ExtentReportLogger.logRequest(requestSpecification);

        Response response = requestSpecification.post("/employees");

        ExtentReportLogger.logResponse(response.asPrettyString());

        ApiUtils.storeStringAsJsonFile(FCwithSingleton.getInstance().getResponseJsonFolderPath() + method.getName() + "response.json", response);

    }


}
