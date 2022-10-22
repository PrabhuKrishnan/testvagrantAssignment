package com.app.constants;

import lombok.Getter;

import java.util.Objects;

@Getter
public class FCwithSingleton {

    private FCwithSingleton() {
    }

    private  final String requestJsonFolderPath = System.getProperty("user.dir") + "/src/test/resources/jsons/";
    private  final String responseJsonFolderPath = System.getProperty("user.dir")+"/test-output/";
    private static FCwithSingleton instance = null;

    //synchronized - this keyword is to handle the multiple threads
    public static synchronized FCwithSingleton getInstance() {
        if (Objects.isNull(instance)) {
            instance = new FCwithSingleton();
        }
        return instance;
    }
}
