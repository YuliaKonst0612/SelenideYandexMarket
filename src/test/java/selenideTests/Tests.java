package selenideTests;

import Pages.CatalogPage;
import Pages.YandexMarketMainPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static com.codeborne.selenide.Selenide.*;

public class Tests extends BaseTests {
    CatalogPage catalogPage = new CatalogPage();
    YandexMarketMainPage yandexMarketMainPage = new YandexMarketMainPage();

    @ParameterizedTest
    @CsvSource({"Apple"})
    @Feature("Выбор товаров на Yandex market")
    @DisplayName("Проверка выбора товаров с фильтром 'Бренд(производитель)'")
    public void runTest(String manufacturer) {
        open(baseUrl);
        yandexMarketMainPage.click();
        yandexMarketMainPage.hover("Электроника");
        yandexMarketMainPage.clickOnSubCategory("Смартфоны");
        catalogPage.selectManufacturer(manufacturer);
        catalogPage.checkFilter("Iphone");

    }
}