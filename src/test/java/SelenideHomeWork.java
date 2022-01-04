import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideHomeWork {

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void shouldFindSoftAssertionsInWiki() {
        open("https://github.com/"); //открыть страницу
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter(); //в поиске ввести selenide
        $$("ul.repo-list li").first().$("a").click(); //заходим в первый результат
        $("h1").shouldHave(textCaseSensitive("selenide / selenide")); //в заголовке h1 должен быть текст selenide / selenide
        $x("//*[@data-content='Wiki']").click(); //перейти на Wiki
        $(".Layout-sidebar").$(withText("more page")).click(); //Раскрыть все вкладки, нажав more page
        $(".Layout-sidebar").$(byText("SoftAssertions")).click(); //дойти до SoftAssertions, зайти
        $(byText("Using JUnit5 extend test class:")).parent().sibling(0) //проверить, что встречается текcт Using JUnit5 extend test class:
                .shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));

        }
    @AfterEach
    void AfterEach() {
        clearBrowserCookies(); }
    // closeWebDriver() //или/или }

}
