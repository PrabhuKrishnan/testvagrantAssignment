package com.app.utils;

public final class RandomUtils {

    private RandomUtils(){}

     public static int getId()
    {
       return  FakerUtils.getNumber(1, 3000);

    }

    public static String getFirstName()
    {
         return  FakerUtils.getFirstName();
    }

    public static String getLastName()
    {
        return FakerUtils.getLastName();

    }
}
