package com.app.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class ApiUtils {

    private ApiUtils() {
    }

    public static String readJsonAndGetAsString(String filePath) {
        String readJsonAsString = null;
        try {
            readJsonAsString = new String(Files.readAllBytes(Paths.get(filePath)));

        } catch (IOException e) {
            throw new RuntimeException("FileNotFoundException occurred, check the file is present in this path or not test/resources/jsons/RCBTeam.json");
        }
        return readJsonAsString;
    }

}
