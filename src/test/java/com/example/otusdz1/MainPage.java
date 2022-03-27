package com.example.otusdz1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public WebDriver driver;
     public SelenideElement coursesMenuItem = $x(".//p[@class='header2-menu__item-text' and text()='Курсы']");
     public SelenideElement testingSubmenuItem = $x("//div[contains(@class, 'header2-menu__subdropdown-wrapper')]/a[contains(@href, '/categories/testing')]");
     public SelenideElement dropDownTrigger = $x("//a[contains(@title, 'Тестирование')]/div[contains(@class, 'js-menu-subdropdown-trigger')]");
     public ElementsCollection pythonCourseMenuElement = $$x("//*[@title='Python QA Engineer']");
    public  ElementsCollection elCurses = $$x("//div[@class='lessons__new-item-container']");
    public ElementsCollection elements =$$x("//*[@class='header2-menu__item-text']");



    public SelenideElement searchByName(String searchValue) {
        elCurses.get(elCurses.size()-1).scrollIntoView(true);
        ElementsCollection elements = elCurses.filter(Condition.text(searchValue));
        Assert.assertTrue(
                elements.size()>0,
                "Ошибка!!! Не найден элемент со значением: "+ searchValue+" !!!"
                );
    return elements.first();
    }


public SelenideElement firstCourse()  {
    SimpleDateFormat date = new SimpleDateFormat("dd MMMM",new Locale("ru"));
    SelenideElement maxCurs = elCurses
            .filter(Condition.not(Condition.text("О дате старта будет")))
            .filter(Condition.not(Condition.text("10 000 ₽")))
            .filter(Condition.not(Condition.text("10 ₽")))
            .filter(Condition.not(Condition.text("В марте")))
            .filter(Condition.not(Condition.text("В мае")))
            .filter(Condition.not(Condition.text("В апреле")))
            .filter(Condition.not(Condition.text("В январе")))
            .filter(Condition.not(Condition.text("В феврале")))
            .filter(Condition.not(Condition.text("В июле")))
            .filter(Condition.not(Condition.text("В сенятабре")))
            .filter(Condition.not(Condition.text("В авгутсе")))
            .filter(Condition.not(Condition.text("В июне")))
            .filter(Condition.not(Condition.text("В сентябре")))
            .filter(Condition.not(Condition.text("В ноябре")))
            .filter(Condition.not(Condition.text("В декабре")))
            .stream()
            .reduce((a, b) ->
            {
                try {
                    return date.parse(a.$x(".//div[@class='lessons__new-item-start']").getText().substring(2))
                            .after(date.parse(b.$x(".//div[@class='lessons__new-item-start']").getText().substring(2))) ? b : a;
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }).orElseThrow(RuntimeException::new);
    return maxCurs;
}
    public SelenideElement lastCourse()  {
        SimpleDateFormat date = new SimpleDateFormat("dd MMMM",new Locale("ru"));
        ElementsCollection elCurses = $$x("//div[@class='lessons__new-item-container']");
        SelenideElement maxCurs = elCurses
                .filter(Condition.not(Condition.text("О дате старта будет")))
                .filter(Condition.not(Condition.text("10 000 ₽")))
                .filter(Condition.not(Condition.text("10 ₽")))
                .filter(Condition.not(Condition.text("В марте")))
                .filter(Condition.not(Condition.text("В мае")))
                .filter(Condition.not(Condition.text("В апреле")))
                .filter(Condition.not(Condition.text("В январе")))
                .filter(Condition.not(Condition.text("В феврале")))
                .filter(Condition.not(Condition.text("В июле")))
                .filter(Condition.not(Condition.text("В сенятабре")))
                .filter(Condition.not(Condition.text("В авгутсе")))
                .filter(Condition.not(Condition.text("В июне")))
                .filter(Condition.not(Condition.text("В сентябре")))
                .filter(Condition.not(Condition.text("В ноябре")))
                .filter(Condition.not(Condition.text("В декабре")))
                .stream()
                .reduce((a, b) ->
                {
                    try {
                        return date.parse(a.$x(".//div[@class='lessons__new-item-start']").getText().substring(2))
                                .after(date.parse(b.$x(".//div[@class='lessons__new-item-start']").getText().substring(2))) ? a : b;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }).orElseThrow(RuntimeException::new);
        return maxCurs;
    }

    public void printDateOfStartCourses(){
        {
            SimpleDateFormat date = new SimpleDateFormat("dd MMMM",new Locale("ru"));
            ElementsCollection elCurses = $$x("//div[@class='lessons__new-item-container']");

            elCurses.filter(Condition.not(Condition.text("О дате старта будет")))
                    .filter(Condition.not(Condition.text("10 000 ₽")))
                    .filter(Condition.not(Condition.text("10 ₽")))
                    .filter(Condition.not(Condition.text("В марте")))
                    .filter(Condition.not(Condition.text("В мае")))
                    .filter(Condition.not(Condition.text("В апреле")))
                    .filter(Condition.not(Condition.text("В январе")))
                    .filter(Condition.not(Condition.text("В феврале")))
                    .filter(Condition.not(Condition.text("В июле")))
                    .filter(Condition.not(Condition.text("В сенятабре")))
                    .filter(Condition.not(Condition.text("В авгутсе")))
                    .filter(Condition.not(Condition.text("В июне")))
                    .filter(Condition.not(Condition.text("В сентябре")))
                    .filter(Condition.not(Condition.text("В ноябре")))
                    .filter(Condition.not(Condition.text("В декабре")))
                    .forEach((value)->{
                        try {
                            System.out.println(date.parse( value.$x(".//div[@class='lessons__new-item-start']").getText().substring(2)));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }


    public MainPage moveToElementAndClickOnCourse(SelenideElement element) {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(element).click().build().perform();
        return new MainPage();
    }

    public MainPage moveAndWaitToElementAndClickOnCourse(ElementsCollection elements) {
        for (int i = 0; i < 5000; i++) {
            if(elements.size()>0){
                Actions actions = new Actions(WebDriverRunner.getWebDriver());
                actions.moveToElement(elements.get(0)).doubleClick().build().perform();
                break;
            }
        }

        return new MainPage();
    }


    public MainPage scrollToAndClock(SelenideElement element) {
        element.scrollIntoView(false);
        paintBeforeClickOn(element);
        element.click();
        deletePaintAfterClickOn(element);
        return new MainPage();
    }


    public void paintBeforeClickOn(WebElement element) {
        ((JavascriptExecutor)WebDriverRunner.getWebDriver()).executeScript("arguments[0].style.border='3px solid red'",element);
    }


    public void deletePaintAfterClickOn(WebElement element) {
        ((JavascriptExecutor)WebDriverRunner.getWebDriver()).executeScript("arguments[0].style.border='0px solid red'",element);

    }
    public MainPage moveToElement(WebElement element) {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(element).perform();
        return this;
    }


}
