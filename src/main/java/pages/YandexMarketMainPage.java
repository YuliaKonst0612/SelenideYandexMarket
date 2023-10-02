package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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
        $(By.xpath("//span[text()]=' " + subcategory + "']")).click();
        return page(YandexMarketMainPage.class);
    }


    @Step("Выбор производителя '{manufacturer}'")
    /**
     * Метод устанавливает фильтр по производителю
     * Автор: [Юлия Константинова]
     */
    public YandexMarketMainPage selectManufacturer(String manufacturer) {

        SelenideElement manufacturerElement = $(By.xpath("//span[text()='" + manufacturer + "']"));
        manufacturerElement.click();
        if (!manufacturerElement.exists()) {
            $(By.xpath("//span[text()='Показать всё']/parent::button[@aria-expanded='false']")).click();
            manufacturerElement.scrollTo().click();

        }
        return page(YandexMarketMainPage.class);
    }


    @Step("Проверка на соответствие фильтру по модели '{model}'")
    /**
     * Метод проверяет, что товары в выдаче соответствуют фильтру по модели
     * Автор: [Юлия Константинова]
     */
    public YandexMarketMainPage checkFilter(String model) {
        while (true) {
            ElementsCollection resultSearch = $$x("//div[@data-test-id='virtuoso-item-list']");
            SelenideElement item = resultSearch.find(text(model));

            item.should(exist.because("Товар с фильтром"  + model +  "не найден"));

            // Переход на следующую страницу
            if (!goToNextPage()) {

                break;
            }
        }

        return page(YandexMarketMainPage.class);
    }


    public boolean goToNextPage() {
        SelenideElement nextPageButton = $(By.xpath("//div[@data-baobab-name='next']"));

        if (nextPageButton.isEnabled()) {
            nextPageButton.click();
            return true; // Переход выполнен успешно
        } else {
            return false; // Нет больше страниц
        }
    }

}