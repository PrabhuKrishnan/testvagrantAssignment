package com.app.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class ApiUtils {

    private ApiUtils(){}

    @SneakyThrows
    public static String readJsonAndGetAsString(String filePath)
    {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    @SneakyThrows
    public static void storeStringAsJsonFile(String filePath, Response response)
    {
        Files.write(Paths.get(filePath),response.asByteArray());
    }





}
