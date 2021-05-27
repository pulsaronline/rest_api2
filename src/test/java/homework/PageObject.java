package homework;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.response.Response;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PageObject extends CartAddTest {
     static void itemToCartApi() {
        Response response = given()
                .contentType(contentType)
                .body(body)
                .cookie(cookie)
                .when()
                .post(responseURL)
                .then()
                .statusCode(200)
                .log().body()
                .body(targetCondition, is(true))
                .extract().response();
        cartItems = response.jsonPath().get(targetElement);
        cartSize = Integer.parseInt(cartItems.substring(1, cartItems.length() - 1));
        getResponse(cartSize + 1);
/*        given()
                .contentType(contentType)
                .body(body)
                .cookie(cookie)
                .when()
                .post(responseURL)
                .then()
                .statusCode(200)
                .log().body()
                .body(targetCondition, is(true))
                .body(targetElement, is("(" + (cartSize + 1) + ")"));*/
    }

    static void itemToCartSelenide() {
        open("/build-your-cheap-own-computer");
        $("#add-to-cart-button-72").click();
        $("#topcartlink a[href='/cart']").shouldHave(text("(1)"));

        String nopCustomerCookie = WebDriverRunner.getWebDriver().manage().getCookieNamed("Nop.customer").getValue();
        System.out.println("Nop.customer = " + nopCustomerCookie);
        getResponse(2);
/*
        given()
                .contentType(contentType)
                .body(body)
                .cookie("Nop.customer", nopCustomerCookie)
                .when()
                .post(responseURL)
                .then()
                .statusCode(200)
                .log().body()
                .body(targetCondition, is(true))
                .body(targetElement, is("(2)"));
*/

//                .body(targetElement, is("(2)"));

        Selenide.refresh();
        $("#topcartlink a[href='/cart']").shouldHave(text("(2)"));
    }

    static Response getResponse(int cartSize){
        given()
                .contentType(contentType)
                .body(body)
                .cookie(cookie)
                .when()
                .post(responseURL)
                .then()
                .statusCode(200)
                .log().body()
                .body(targetCondition, is(true))
                .body(targetElement, is("(" + (cartSize) + ")"));
        return null;
    }
}
