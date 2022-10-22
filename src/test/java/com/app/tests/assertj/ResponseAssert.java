package com.app.tests.assertj;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {


    private ResponseAssert(Response response, Class<?> selfType) {
        super(response, selfType);
    }

    public static ResponseAssert assertThat(Response response)
    {
        return  new ResponseAssert(response, ResponseAssert.class);
    }

    public ResponseAssert isSuccessfulPostResponse(){

        Assertions.assertThat(actual.getStatusCode())
                .withFailMessage(()->"Status code is not 201")
                .isEqualTo(201);
        return this;
    }

    public ResponseAssert hasHeaderApplicationJson(){
        Assertions
                .assertThat(actual.header("Content-Type"))
                .withFailMessage(()->"Header with Content-Type  as application/json is not present")
                .contains("application/json");
        return this;

    }

}
