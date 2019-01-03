package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CityLangForm {
    private WebElement JS_countryList;

    private WebElement en;

    public void selectCity(String city) {
        Select dropdown = new Select(JS_countryList);
        dropdown.selectByVisibleText(city);
    }

    public String getLanguageSelected() {
        return en.getAttribute("innerText");
    }
}
