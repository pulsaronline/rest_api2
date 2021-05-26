package homework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.step;
import static org.hamcrest.Matchers.is;
import static io.qameta.allure.Allure.step;


public class CartAddTest extends TestBase {
    static String cookie = "Nop.customer=9c507dd9-2fab-4633-b831-5214d2d805b1; " +
            "ARRAffinity=06e3c6706bb7098b5c9133287f2a8d510a64170f97e4ff5fa919999d67a34a46;" +
            " __utmc=78382081; __utmz=78382081.1621929098.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none);" +
            " NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=72;" +
            " __RequestVerificationToken=V9YjoKcoyLyrnlBDub3cIZwdP3gIb4NZNCNFkU0JJT1eiI_MZdxfhoak7oEZnmslxndswF0yDytFToIlyBtyuhvVo_nzJ8eicLSkyqlepgE1;" +
            " NOPCOMMERCE.AUTH=35665E3247F30C7BD67D496C9B92B231912339EC7E318DDDFCC9ACBF6740B6AD6EFA020170DB0F05B64DD65DE49949B2A07036FD627AEC099B326569" +
            "45F560638EBDF203E6D53A79EB319EE218E45FEA1FAF4B204B6BE2DBC8E0EA0572072CDE9FEF0A0F2930792596718B11323BCC1E5F79511FBCD30BF1A6D3C9C2BD995842D2" +
            "BDB011696CE8C2D265D2E93E89F44C; __atuvc=11%7C21; __atuvs=60ae8cd2f8d95158000; __utma=78382081.934014627.1621929098.1621932426.1622052051.3;" +
            " __utmt=1; __utmb=78382081.1.10.1622052051";
    static String contentType = "application/x-www-form-urlencoded; charset=UTF-8";
    static String body = "product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1";
    static String responseURL = "http://demowebshop.tricentis.com/addproducttocart/details/72/1";
    static String targetCondition = "success";
    static String targetElement = "updatetopcartsectionhtml";
    static String cartItems = "";
    static int cartSize = 0;

    @Test
    void addItemToCartAndCheckTheItemAddedTest() {
        //expected cart size
        //cart size+=1
        step("Добавляем один и тот же товар в корзину", PageObject::addItemToCart);
        step("Проверяем что товар добавлен в корзину", PageObject::checkQuantityItems);
    }
}
