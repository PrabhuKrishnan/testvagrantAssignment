package com.app.requestBuilder;

import com.app.enums.PropertiesType;
import com.app.utils.PropertyUtils;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public final class RequestBuilders {

    private RequestBuilders() {
    }

    public static RequestSpecification buildRequestForGetCalls() {
        return given()
                .baseUri(PropertyUtils.getValue(PropertiesType.BASEURL))
                .log()
                .all();
    }

    public static RequestSpecification buildRequestForPostCalls() {
        return given()
                .config(RestAssuredConfig.config()
                        .logConfig(LogConfig.logConfig().blacklistHeader("Authorization", "Content-Type")))
                .baseUri(PropertyUtils.getValue(PropertiesType.BASEURL))
                .header("Content-Type", ContentType.JSON)
                .log()
                .all();
    }
}
