package com.app.tests;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.app.utils.fixtures.Employee;
import com.app.utils.templates.EmployeeTemplate;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PostTestWithFixtureFactory {

    @BeforeSuite
    public void setUp() {

        FixtureFactoryLoader.loadTemplates("com.app.utils.templates");
    }


    @Test(dataProvider = "getData")
    public void fixtureFactoryTest(Employee employee, int statusCode) {

        Response response = given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(employee)
                .post("http://192.168.0.108:3000/employees");

        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(201);

    }

    @DataProvider
    public static Object[][] getData() {

        Employee valid = Fixture.from(Employee.class).gimme("valid");
        Employee invalidId = Fixture.from(Employee.class).gimme("invalidId");
        Employee invalidFirstName = Fixture.from(Employee.class).gimme("invalidFirstName");
        return new Object[][]{
                {valid,201},
                {invalidId,500},
                {invalidFirstName,201}
        };
    }

}
