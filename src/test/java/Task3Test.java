import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Task3Test {
    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;

    }
    @Test
    void Task3() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("[id=firstName]").setValue("Danil");
        $("[id=lastName]").setValue("Kopylov");
        $("[id=userEmail]").setValue("danil.kopylov2015@yandex.ru").pressEnter();
        $("label[class=custom-control-label]").click();
        $("[id=userNumber]").setValue("9817571195");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]>[value='1992']").click();
        $("[class=react-datepicker__month-select]>[value='0']").click();
        $(".react-datepicker__month .react-datepicker__day--003").click();
        $("[id=subjectsContainer]").click();
        $("[id=subjectsInput]").setValue("Maths").pressEnter();
$("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label").click();
$("[id=uploadPicture]").uploadFromClasspath("Danil.jpeg");
        $("[id=currentAddress]").click();
        $("[id=currentAddress]").setValue("Mirgorodskaya 14");
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Delhi").pressEnter();
        $("[id=submit]").submit();

        $("[class=table-responsive]").shouldHave(Condition.text("Danil Kopylov"));
        $("[class=table-responsive]").shouldHave(Condition.text("danil.kopylov2015@yandex.ru"));
        $("[class=table-responsive]").shouldHave(Condition.text("3 January,1992"));
        $("[class=table-responsive]").shouldHave(Condition.text("Male"));
        $("[class=table-responsive]").shouldHave(Condition.text("9817571195"));
        $("[class=table-responsive]").shouldHave(Condition.text("Maths"));
        $("[class=table-responsive]").shouldHave(Condition.text("Reading"));
        $("[class=table-responsive]").shouldHave(Condition.text("Danil.jpeg"));
        $("[class=table-responsive]").shouldHave(Condition.text("Mirgorodskaya 14"));
        $("[class=table-responsive]").shouldHave(Condition.text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
    }