package com.app.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

   // @Test(dataProvider = "getData")
   public void dataProviderTest(String userName)
   {
       System.out.println(userName);
   }
   @DataProvider
   public Object[][] getData()
   {
       return new Object[][] {
               {"prabhu"},
               {"krishnan"},
               {"Vaira"}
       };
   }

}
