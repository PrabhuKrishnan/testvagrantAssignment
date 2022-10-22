package com.app.constants;

import com.app.enums.PropertiesType;
import com.app.utils.PropertyUtils;
import lombok.Getter;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static @Getter
    final String requestJsonFolderPath = System.getProperty("user.dir")+"/src/test/resources/jsons/";
    private static @Getter
    final String responseJsonFolderPath = System.getProperty("user.dir")+"/test-output/";
    private static @Getter
    final String propertyFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
    private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static String extentReportFilePath = "";

    private static String createReportPath()
    {
            return EXTENT_REPORT_FOLDER_PATH+"/index.html";

    }





}
