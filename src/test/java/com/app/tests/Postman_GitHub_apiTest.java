package com.app.tests;

import com.app.constants.FrameworkConstants;
import com.app.utils.ApiUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.app.utils.RandomUtils.getFirstName;
import static com.app.utils.RandomUtils.getId;
import static io.restassured.RestAssured.*;

public class Postman_GitHub_apiTest {
    //@Test
    public void getAllWorkspace() {
        Response response = given()
                .header("X-API-Key", "PMAK-6311b3952b489b32826aefe5-019784d85e6495c1a79955ac608d62ade5")
                .log()
                .all()
                .get("https://api.getpostman.com/collections");
        response.prettyPrint();

    }

  //  @Test
    public void getRepoFromGitHub() {
        Response response = given()
                .log()
                .all()
                .header("Accept", "application/vnd.github+json")
                .header("Authorization", "Bearer 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")
                .queryParam("per_page", 1)
                .get("https://api.github.com/user/repos");
        response.prettyPrint();
    }

   // @Test
    public void createGitHubRepoTest()
    {

        String resource = ApiUtils.readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath() + "createRepo.json")
                .replace("repoName", "apiTestRepo")
                .replace("RepoDescription", "Creating Repo Using Rest Assured API");

        Response postResponse = given()
                .log()
                .all()
                .header("Accept", "application/vnd.github+json")
                .header("Authorization", "Bearer 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")
                .body(resource)
                .post("https://api.github.com/user/repos");
        postResponse.prettyPrint();


    }

}
