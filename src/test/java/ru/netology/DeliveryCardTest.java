package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class DeliveryCardTest {
    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }



@Test
public void test1() {
    String planningDate = generateDate(4);
    open("http://localhost:9999");
    $("[placeholder=\"Город\"]").setValue("Майкоп");
    $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
    $("[data-test-id='date'] input").setValue(planningDate);
    $("[name=\"name\"]").setValue("Конрилов Владислав");
    $("[name=\"phone\"]").setValue("+79543257464");
    $("[data-test-id=\"agreement\"]").click();
    $(withText("Забронировать")).click();
    $(withText("Встреча успешно забронирована на")).shouldBe(Condition.appear, Duration.ofSeconds(15));
    $(".notification__content")
            .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
            .shouldBe(Condition.visible);


}

}
