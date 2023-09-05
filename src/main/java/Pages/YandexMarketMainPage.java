package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YandexMarketMainPage {
    @Step("Клик на кнопку 'Каталог'")
    /**
     * Метод кликает на кнопку Каталог на главной странице
     * Автор: [Юлия Константинова]
     */
    public YandexMarketMainPage click() {
        $(By.xpath("//button[.//span[text()='Каталог']]")).click();
        return page(YandexMarketMainPage.class);

    }

    @Step("Наведение мыши на раздел '{category}'")
    /**
     * Метод Наводит мышь на раздел 'Электроника'
     * Автор: [Юлия Константинова]
     */
    public YandexMarketMainPage hover(String category) {
        $(By.xpath("//a/span[text()='" + category + "']")).hover();
        return page(YandexMarketMainPage.class);
    }

    @Step("Клик на подкатегорию '{subcategory}'")
    /**
     * Метод кликает на подкатегорию 'Смартфоны'
     * Автор: [Юлия Константинова]
     */
    public YandexMarketMainPage clickOnSubCategory(String subcategory) {
        $(By.xpath("//a[text()=' " + subcategory+"']")).click();
        return page(YandexMarketMainPage.class);
    }
}
