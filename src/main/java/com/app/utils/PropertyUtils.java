package com.app.utils;

import com.app.constants.FrameworkConstants;
import com.app.enums.PropertiesType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {
    }

    private static Properties properties = new Properties();
    private final static Map<String, String> MAP = new HashMap<>();

    static {
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getPropertyFilePath())) {
            properties.load(fis);
        } catch (IOException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        //properties.entrySet().forEach(e -> MAP.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            String key = String.valueOf(entry.getKey());
            String value = String.valueOf(entry.getValue());
            MAP.put(key, value);
        }
    }

    public static String getValue(PropertiesType key) {
        return MAP.get(key.name().toLowerCase());
    }
}
