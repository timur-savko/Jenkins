package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "/html/body/header/div/div[1]/nav/div/ul/li[2]")
    private WebElement englishBtn;

    @FindBy(xpath = "/html/body/div[3]/div/div[1]/h2")
    private WebElement specialOfferText;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[1]")
    private WebElement bookAFlightBtn;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]")
    private WebElement manageMyBookingBtn;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[1]")
    private WebElement bookAFlightForm;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[2]")
    private WebElement manageMyBookingForm;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement lastname;

    @FindBy(xpath = "//*[@id=\"bknumber\"]")
    private WebElement bookingReference;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[2]/form/div/div[3]/button")
    private WebElement continueButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[1]/form/div[2]/div/label[2]")
    private WebElement oneWayButton;

    @FindBy(xpath = "//*[@id=\"seladate1\"]")
    private WebElement returnDateInput;

    @FindBy(xpath = "//*[@id=\"selddate1\"]")
    private WebElement departureDateInput;

    @FindBy(xpath = "//*[@id=\"seldcity1\"]")
    private WebElement fromCountryInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[1]/form/div[3]/div/div[8]/button")
    private WebElement bookAFlightInFormBtn;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[4]")
    private WebElement closeFormBtn;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[1]/form/div[2]/div/label[1]")
    private WebElement twoDirectionsBtn;

    @FindBy(xpath = "//*[@id=\"teq-newsletter-footer-form\"]/input[1]")
    private WebElement subscribeInput;

    @FindBy(xpath = "//*[@id=\"teq-newsletter-footer-form\"]/input[4]")
    private WebElement submitSubscriptionBtn;

    @FindBy(xpath = "/html/body/header/div/img")
    private WebElement homeBtn;

    @FindBy(xpath = "/html/body/div[1]/div/div")
    private WebElement closeCookiesBtn;

    @FindBy(xpath = "/html/body/div[1]")
    private WebElement cookiesBanner;


    public void clickEnglishButton() {
        englishBtn.click();
    }

    public String getSelectedMessageToCheckLang() {
        return specialOfferText.getAttribute("innerText");
    }

    public void openBookingForm(){
        bookAFlightBtn.click();
    }

    public Boolean getIsBookAFlightFormOpened(){
        return bookAFlightForm.getAttribute("class").contains("active");
    }

    public void openManageMyBookingForm(){
        manageMyBookingBtn.click();
    }

    public Boolean getIsManageMyBookingFormOpened(){
        return manageMyBookingForm.getAttribute("class").contains("active");
    }

    public void filltheManageForm(String lname, String bReference){
        lastname.sendKeys(lname);
        bookingReference.sendKeys(bReference);
    }

    public void continueInManageForm(){
        continueButton.click();
    }

    public void chooseOneWayFlightType(){
        oneWayButton.click();
    }

    public Boolean getIsReturnDateInputInactive(){
        return Boolean.valueOf(returnDateInput.getAttribute("disabled"))==true;
    }

    public void chooseFromCountry(){
        fromCountryInput.sendKeys("Moscow");
    }

    public Boolean getIsDepCountryThrowError(){
        return departureDateInput.getAttribute("class").contains("error");
    }

    public void clickBookAFlightInFormBtn(){
        bookAFlightInFormBtn.click();
    }

    public void closeForm(){
        closeFormBtn.click();
    }

    public boolean isFormClosed(){
        return !bookAFlightForm.getAttribute("class").contains("active");
    }

    public void changeFromOneToTwoDirections(){
        twoDirectionsBtn.click();
    }

    public Boolean getIsReturnDateInputBecomesActive(){
        return Boolean.valueOf(returnDateInput.getAttribute("disabled"))==false;
    }

    public void fillSubscribeForm(String email){
        subscribeInput.sendKeys(email);
    }

    public Boolean getIsSubscribeFormThrowError(){
        return subscribeInput.getAttribute("style").contains("red");
    }

    public void submitSubscription(){
        submitSubscriptionBtn.click();
    }

    public void closeCookies(){
        closeCookiesBtn.click();
    }

    public boolean isCookiesAccepted(){
        return !cookiesBanner.getAttribute("style").contains("none");
    }


}
