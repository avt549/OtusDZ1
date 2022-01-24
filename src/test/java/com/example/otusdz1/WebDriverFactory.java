package com.example.otusdz1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


/***
 * 1-Реализовать Фабрику (WebDriverFactory),
 * которая будет получать значение из окружения и
 * запускать соответствующий браузер Браузеры: Chrome, Firefox, Opera
 */
public class WebDriverFactory {
    public static String browserType = System.getProperty("browser");
//    public static String browserType = "chrome";

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
