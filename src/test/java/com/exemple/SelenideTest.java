package com.exemple;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLog;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.*;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Selenide.open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("selenide");
        $(".header-search-input").submit();

        $(linkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $(withText("#1946")).should(Condition.exist);
    }
}
