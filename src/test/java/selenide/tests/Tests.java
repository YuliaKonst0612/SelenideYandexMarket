package selenide.tests;
import pages.YandexMarketMainPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static com.codeborne.selenide.Selenide.*;

public class Tests extends BaseTests {


    @ParameterizedTest
    @CsvSource({"Apple,Iphone"})
    @Feature("Выбор товаров на Yandex market")
    @DisplayName("Проверка выбора товаров с фильтром 'Бренд(производитель)'")
    public void runTest(String manufacturer, String model) {
        open(baseUrl,YandexMarketMainPage.class)
                .click()
                .hover("Электроника")
                .clickOnSubCategory("Смартфоны")
                .selectManufacturer(manufacturer)
                .checkFilter(model);

    }
}