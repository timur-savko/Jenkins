package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TicketBuyForm {
    private final static String VALUE_ATTRIBUTE = "value";

    private WebElement mdlArrArea1;

    private WebElement mdlArrLocation1;

    @FindBy(css = "#JS_modulePlaneTicket > p > a")
    private WebElement formOpenButton;

    private WebElement mdlDepArea1;

    private WebElement mdlDepLocation1;

    private WebElement DEPARTURE_DATE_1_MONTH;

    private WebElement DEPARTURE_DATE_1_DAY;

    private WebElement DEPARTURE_DATE_2_MONTH;

    private WebElement DEPARTURE_DATE_2_DAY;

    private WebElement mdlFormSubmit;

    @FindBy(className = "mdlErrMsgUnit")
    private WebElement errorMessageBox;

    @FindBy(css = "#mdlTripType2 + label")
    private WebElement oneWay;

    private WebElement mdlNbAdt;

    private WebElement mdlNbChd;

    private WebElement mdlNbInf;

    public String getSelectedArrivalLocation() {
        return mdlArrLocation1.getAttribute(VALUE_ATTRIBUTE);
    }

    public void selectArrivalCountry(String countryName) {
        Select dropdown = new Select(mdlArrArea1);
        dropdown.selectByValue(countryName);
    }

    public void toggleForm() {
        formOpenButton.click();
    }

    public String getSelectedDepartureCountry() {
        return mdlDepArea1.getAttribute(VALUE_ATTRIBUTE);
    }

    public String getSelectedDepartureCity() {
        return mdlDepLocation1.getAttribute(VALUE_ATTRIBUTE);
    }

    public void selectDepartureMonth(String month) {
        Select dropdown = new Select(DEPARTURE_DATE_1_MONTH);
        dropdown.selectByValue(month);
    }

    public String getSelectedDepartureMonth() {
        return DEPARTURE_DATE_1_MONTH.getAttribute(VALUE_ATTRIBUTE);
    }

    public void selectDepartureDate(String date) {
        Select dropdown = new Select(DEPARTURE_DATE_1_DAY);
        dropdown.selectByValue(date);
    }

    public String getSelectedDepartureDate() {
        return DEPARTURE_DATE_1_DAY.getAttribute(VALUE_ATTRIBUTE);
    }

    public void selectReturningMonth(String month) {
        Select dropdown = new Select(DEPARTURE_DATE_2_MONTH);
        dropdown.selectByValue(month);
    }

    public String getSelectedReturningMonth() {
        return DEPARTURE_DATE_2_MONTH.getAttribute(VALUE_ATTRIBUTE);
    }

    public void selectReturningDate(String date) {
        Select dropdown = new Select(DEPARTURE_DATE_2_DAY);
        dropdown.selectByValue(date);
    }

    public String getSelectedReturningDate() {
        return DEPARTURE_DATE_2_DAY.getAttribute(VALUE_ATTRIBUTE);
    }

    public void submit() {
        mdlFormSubmit.submit();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessageBox.isDisplayed();
    }

    public void selectOneWay() {
        oneWay.click();
    }

    public boolean isReturningDateFieldsEnabled() {
        return DEPARTURE_DATE_2_MONTH.isEnabled() && DEPARTURE_DATE_2_DAY.isEnabled();
    }

    public void selectAdultsAmount(String amount) {
        Select dropdown = new Select(mdlNbAdt);
        dropdown.selectByValue(amount);
    }

    public void selectChildrenAmount(String amount) {
        Select dropdown = new Select(mdlNbChd);
        dropdown.selectByValue(amount);
    }

    public void selectInfantsAmount(String amount) {
        Select dropdown = new Select(mdlNbInf);
        dropdown.selectByValue(amount);
    }
}
