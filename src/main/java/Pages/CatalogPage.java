package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {


    @Step("Выбор производителя")
    /**
     * Метод устанавливает фильтр по производителю
     * Автор: [Юлия Константинова]
     */
    public void selectManufacturer(String manufacturer) {

        SelenideElement manufacturerElement = $(By.xpath("//span[text()='" + manufacturer + "']"));
        manufacturerElement.click();
        if (!manufacturerElement.exists()) {
            $(By.xpath("//span[text()='Показать всё']/parent::button[@aria-expanded='false']")).click();
            manufacturerElement.scrollTo().click();
        }

    }

    @Step("Проверка на соответствие фильтру")
    /**
     * Метод проверяет, что товары в выдаче соответствуют фильтру
     * Автор: [Юлия Константинова]
     */
    public CatalogPage checkFilter(String model) {
        ElementsCollection resultSearch = $$x("//div[@data-test-id='virtuoso-item-list']");
        resultSearch.find(text(model)).shouldHave(text(model).because("Товары с фильтром '" + model + "' не найдены в списке."));
        return page(CatalogPage.class);
    }
}
