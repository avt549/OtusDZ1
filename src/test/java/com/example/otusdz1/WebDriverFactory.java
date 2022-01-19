package com.example.otusdz1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;


public class WebDriverFactory {
//    public static String browserType = System.getProperty("browser");
    public static String browserType = "chrome";

    public static void setupDriver() {
        switch (browserType) {
            case "chrome":
                Configuration.startMaximized=true;
             Configuration.browser = "chrome";
                break;
            case "opera":
                Configuration.startMaximized=true;
                Configuration.browser = "opera";
                break;
            case "firefox":
                Configuration.startMaximized=true;
                 Configuration.browser = "fireFox";
                 break;
            default:
                System.out.println("тип драйвера не верный");
        }
    }
}
