package quru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @BeforeAll
    static void beforeAll() {

        Configuration.pageLoadTimeout = 60000;
        open("https://github.com");
    }

    @Test
    void findSelenideOnGitHub() {
        $("[name=q]").setValue("selenide").pressEnter();
        var firstRepositoryFound = $$("ul.repo-list li").first().$("a");
        firstRepositoryFound.click();
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $x("//a[text()='Soft assertions']").click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}


