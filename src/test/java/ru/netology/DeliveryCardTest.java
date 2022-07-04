package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryCardTest {

@Test
public void test1() {
    open("http://localhost:9999");
    $("[placeholder=\"Город\"]").setValue("Майкоп");
    $("[placeholder=\"Дата встречи\"]").setValue("5.07.1000");
    $("[name=\"name\"]").setValue("Конрилов Владислав");
    $("[name=\"phone\"]").setValue("+79543257464");
    $("[data-test-id=\"agreement\"]").click();
    $(withText("Забронировать")).click();
    $(withText("Встреча успешно забронирована на")).shouldBe(Condition.appear, Duration.ofSeconds(15));



}

}
