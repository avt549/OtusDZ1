package com.example.otusdz1;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static org.testng.Assert.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();
//public String url = "https://otus.ru";
public String url = "https://otus.ru/categories/programming/";


    @BeforeClass
    public static void setUpAll() {
        WebDriverFactory.setupDriver();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        open(url);
    }

    @Test
    public void search1() {
        System.out.println(mainPage.searchByName("Специализация").getText());
        System.out.println(mainPage.searchByName("QA").getText());
    }
    @Test
    public void search2() {
        SimpleDateFormat date = new SimpleDateFormat("dd MMMM",new Locale("ru"));

        ElementsCollection elCurses = $$x("//div[@class='lessons__new-item-container']");

         SelenideElement maxCurs= elCurses.filter(Condition.not(Condition.text("О дате старта будет")))
                 .filter(Condition.not(Condition.text("10 000 ₽")))
                 .filter(Condition.not(Condition.text("В "))).
//                 forEach((value)-> {
//                     value.$x(".//div[@class='lessons__new-item-start']").getText().substring(2)
//                 }
//                 )
                 stream().reduce((a,b)->
                 {
                     try {
                         return  date.parse(a.getText()).after(date.parse(b.getText())) ? b:a;
                     } catch (ParseException e) {
                         e.printStackTrace();
                     }
                     return null;
                 }).get();

                 elCurses.filter(Condition.not(Condition.text("В ")))
                 .forEach((value)->{
                     try {
                         date.parse(    value.$x(".//div[@class='lessons__new-item-start']").getText().substring(2));
                     } catch (ParseException e) {
                         e.printStackTrace();
                     }
                 });
    }




    @Test
    public void search3() {
        SimpleDateFormat date = new SimpleDateFormat("dd MMMM",new Locale("ru"));
        ElementsCollection elCurses = $$x("//div[@class='lessons__new-item-container']");

                elCurses.filter(Condition.not(Condition.text("О дате старта будет")))
                .filter(Condition.not(Condition.text("10 000 ₽")))
                .filter(Condition.not(Condition.text("В ")))
                .forEach((value)->{
                    try {
                        System.out.println(date.parse( value.$x(".//div[@class='lessons__new-item-start']").getText().substring(2)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                });
    }
}
