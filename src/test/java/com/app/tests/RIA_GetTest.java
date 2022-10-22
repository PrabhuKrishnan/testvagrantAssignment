package com.app.tests;

import com.app.annotations.FrameworkAnnotation;
import com.app.constants.FrameworkConstants;
import com.app.enums.CategoryType;
import com.app.utils.ApiUtils;
import com.google.gson.JsonArray;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import static com.app.requestBuilder.RequestBuilders.buildRequestForGetCalls;
import static org.assertj.core.api.Assertions.assertThat;

public class RIA_GetTest {

    @FrameworkAnnotation(author = {"prabhu"}, category = {CategoryType.SMOKE})
    @Test(description = "To verify the Employees get API is working or not")
    public void getTest(Method method) {
        Response response = buildRequestForGetCalls().get("/entries");
        // response.prettyPrint();
        //ApiUtils.storeStringAsJsonFile(FrameworkConstants.getResponseJsonFolderPath() + method.getName() + "Response.json", response);

        Map<String, String> map = response.jsonPath().get("entries[0]");
        System.out.println(map);

      /*  assertThat(map)
                .containsKey("API")
                .containsValue("AdoptAPet1");*/

        Assert.assertTrue(map.containsKey("API"),"API");
        Assert.assertTrue(map.containsValue("AdoptAPet"),"AdoptAPet1");


    }

}
