package com.example.otusdz1;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    MainPage mainPage = new MainPage();
public String url = "https://otus.ru/categories/programming/";

    @BeforeClass
    public static void setUpAll() {
        WebDriverFactory.setupDriver();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {open(url);
    }

    /**
     * Проверка задания-
     * "Реализовать Метод фильтр по названию курса" - позитивный кейс
     */
    @Test
    public void searchByName() {
        System.out.println(mainPage.searchByName("Специализация").getText());
    }

    /**
     * Проверка задания-
     * "Метод выбора курса, стартующего раньше всех
     * /позже всех (при совпадении дат - выбрать любой) при помощи reduce"
     */
    @Test
    public void testReturnFirstCourseAndLastCourse() {
        mainPage.printDateOfStartCourses();
        System.out.println("-------------------------------");
        System.out.println(mainPage.firstCourse().getText());
        System.out.println("-------------------------------");
        System.out.println(mainPage.lastCourse().getText());
    }

    /**
     * Проверка задания-
     * "Реализовать движение мыши при помощи и выбор курса при помощи библиотеки Actions"
     */
    @Test ()
    public void testMoveTo() {
        mainPage
                .moveToElement(mainPage.coursesMenuItem)
                .moveToElement(mainPage.coursesMenuItem)
                .moveToElement(mainPage.testingSubmenuItem)
                .moveToElement(mainPage.dropDownTrigger)
                .moveToElementAndClickOnCourse(mainPage.pythonCourseMenuElement.get(0));
    }


    /**
     * Проверка задания-
     * " Реализовать подсветку элементов перед нажатием,
     * после нажатия вернуть данные в исходное состояние"
     */
    @Test
    public void testPaintBeforeClick() {
        mainPage.scrollToAndClock(mainPage.elements.get(0));
        mainPage.scrollToAndClock(mainPage.elements.get(1));
        mainPage.scrollToAndClock(mainPage.elements.get(2));
        mainPage.scrollToAndClock(mainPage.elements.get(3));
        mainPage.scrollToAndClock(mainPage.elements.get(4));

    }
}
