
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class SelenideListenerTest {
    @BeforeAll

    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";

    }
    @Test
    public void testIssueCheck() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".search-input").click();
        $("#query-builder-test").sendKeys("AbilovRuslan/demoqa_tests_20");
        $("#query-builder-test").submit();

        $(linkText("AbilovRuslan/demoqa_tests_20")).click();
        $("#issues-tab").click();
        $(withText("Нет проверки дня и месяца")).should(Condition.exist);


    }
}

