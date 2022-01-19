package com.example.otusdz1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    ElementsCollection elCurses = $$x("//div[@class='lessons__new-item-container']");
    public ElementsCollection curses = $$x("//*[contains(@class, 'lessons__new-item-title')]");
    public ElementsCollection cursesDate = $$x("//div[contains(@class,'lessons__new-item-start')]|//div[contains(@class, 'lessons__new-item-time')]");


    public SelenideElement searchByName(String searchValue) {


if(elCurses.filter(Condition.text(searchValue)).size()>0) {
    return elCurses.filter(Condition.text(searchValue)).first();
}
else {
    System.out.println("Ошибка!!! Не найден элемент со значением: "+ searchValue+" !!!");
    return elCurses.get(elCurses.size()+1);
}
    }

    public SelenideElement searchByName1(String searchValue) {
        int index=0;
        for (int i = 0; i < curses.size(); i++) {
            index=i;
            if(curses.get(i).getText().contains(searchValue))break;
        }
        return curses.get(index);
    }

public void coursesByDate()  {

    for (int i = 0; i < cursesDate.size(); i++) {
        String day="";
        String month = "";
        String text = "";
        System.out.println(i+") "+cursesDate.get(i).getText());
        if(!cursesDate.get(i).getText().substring(0,7).contains("мес")) {
            if (!cursesDate.get(i).getText().substring(0, 6).contains("дате")) {
                if (!cursesDate.get(i).getText().substring(0, 1).contains("В")) {
                     text = cursesDate.get(i).getText();
                    if (cursesDate.get(i).getText().substring(0, 1).contains("С")) {
                        if (!cursesDate.get(i).getText().substring(2, 4).contains(" ")) {
                            day = cursesDate.get(i).getText().substring(2, 4);}
                        else{
                                day = cursesDate.get(i).getText().substring(2, 3);
                            }

                            if (cursesDate.get(i).getText().contains("года")) {
                                month = "0";
                            } else if (cursesDate.get(i).getText().substring(2,9).contains("янв")) {
                                month = "1";
                            } else if (cursesDate.get(i).getText().contains("февраля")) {
                                month = "2";
                            } else if (cursesDate.get(i).getText().contains("марта")) {
                                month = "3";
                            } else if (cursesDate.get(i).getText().contains("апреля")) {
                                month = "4";
                            } else if (cursesDate.get(i).getText().contains("мая")) {
                                month = "5";
                            } else if (cursesDate.get(i).getText().contains("июня")) {
                                month = "6";
                            } else if (cursesDate.get(i).getText().contains("июля")) {
                                month = "7";
                            } else if (cursesDate.get(i).getText().contains("августа")) {
                                month = "8";
                            } else if (cursesDate.get(i).getText().contains("сентября")) {
                                month = "9";
                            } else if (cursesDate.get(i).getText().contains("октября")) {
                                month = "10";
                            } else if (cursesDate.get(i).getText().contains("ноября")) {
                                month = "11";
                            } else if (cursesDate.get(i).getText().contains("декабря")) {
                                month = "12";
                            }

                            text = cursesDate.get(i).getText().substring(2, cursesDate.get(i).getText().length());
                        }
                    }
                    System.out.println(text+" "+month+" "+day);

            }
        }

}
}
    }