package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage {

    //    @FindBy(xpath = "//*[@id=\"alert-title-global-error-message\"]/strong")
    @FindBy(xpath = "/html/body/div/div[1]/div/h1[1]")
    private WebElement errorMessage;

    public Boolean getIsErrorEqualsToExpected(String message){
        return errorMessage.getAttribute("innerText").equals(message);
    }
}
