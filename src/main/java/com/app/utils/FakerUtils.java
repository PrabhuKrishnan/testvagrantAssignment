package com.app.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils(){}

    private static final Faker FAKER = new Faker();

      static int getNumber(int startValue, int endValue)
    {
        return FAKER.number().numberBetween(startValue,endValue);
    }

      static String getFirstName()
    {
        return FAKER.name().firstName();
    }

      static String getLastName(){
        return FAKER.name().lastName();
    }
}
