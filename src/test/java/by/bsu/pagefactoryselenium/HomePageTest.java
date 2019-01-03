package by.bsu.pagefactoryselenium;

//import com.sun.org.apache.xml.internal.utils.SystemIDResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {
    private final static String URL = "https://airalgerie.dz/";

    private final static String SPECIAL_OFFER_TEXT = "OUR SPECIAL OFFERS";

    private final static String ERROR_MESSAGE = "Access to the website blocked";
//    private final static String ERROR_MESSAGE = "1 error(s)";

    private WebDriver driver;

    @BeforeClass
    public void setupPage() {
        driver = Driver.getInstance();
        driver.get(URL);
    }

    @Test
    public void shouldSuggestedTextChangedToEnglishLangWhenEnglishClicked() {
        HomePage action = PageFactory.initElements(driver, HomePage.class);
        action.clickEnglishButton();
        String message = action.getSelectedMessageToCheckLang();
        Assert.assertEquals(SPECIAL_OFFER_TEXT, message);
    }

    @Test
    public void shouldBookingFormOpenedAfterClickingOpenButton() {
        HomePage action = PageFactory.initElements(driver, HomePage.class);
        action.openBookingForm();
        Boolean isOpened = action.getIsBookAFlightFormOpened();
        Assert.assertTrue(isOpened);
    }

    @Test
    public void shouldManageFormOpenedAfterClickingOpenButton() {
        HomePage action = PageFactory.initElements(driver, HomePage.class);
        action.openManageMyBookingForm();
        Boolean isOpened = action.getIsManageMyBookingFormOpened();
        Assert.assertTrue(isOpened);
    }

    @Test(dependsOnMethods = {"shouldSubscribeFormThrowErrorWhenEnteredBadValue","shouldSuggestedTextChangedToEnglishLangWhenEnglishClicked","shouldBookingFormOpenedAfterClickingOpenButton","shouldManageFormOpenedAfterClickingOpenButton","shouldReturnInputDisabledWhenOneWayBtnClicked","shouldCannotBookAFlightWithoutValues"})
    public void shoudErrorMessageShownWhenBadValuesSetted() {
        HomePage action = PageFactory.initElements(driver, HomePage.class);
        action.openManageMyBookingForm();
        action.filltheManageForm("test", "123456");
        action.continueInManageForm();
        SearchResultsPage resultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        try {
            Thread.sleep(5000);
        }catch (Exception ex){
            System.out.print(ex.getMessage());
        }
        Assert.assertTrue(resultsPage.getIsErrorEqualsToExpected(ERROR_MESSAGE));
    }

    @Test
    public void shouldReturnInputDisabledWhenOneWayBtnClicked() {
        HomePage action = PageFactory.initElements(driver, HomePage.class);
//        action.openBookingForm();
        action.chooseOneWayFlightType();
        Assert.assertTrue(action.getIsReturnDateInputInactive());
    }

    @Test(dependsOnMethods = {"shouldBookingFormOpenedAfterClickingOpenButton"})
    public void shouldCannotBookAFlightWithoutValues() {
        HomePage action = PageFactory.initElements(driver, HomePage.class);
        action.openBookingForm();
        action.chooseFromCountry();
        action.clickBookAFlightInFormBtn();
        Assert.assertTrue(!action.getIsDepCountryThrowError());
    }

    @Test
    public void shoudFormClosed() {
        HomePage action = PageFactory.initElements(driver, HomePage.class);
        action.openBookingForm();
        action.closeForm();
        Assert.assertTrue(action.isFormClosed());
    }


    @Test
    public void shouldReturnInputBecomesActiveWhenTwoWayBtnClicked() {
        HomePage action = PageFactory.initElements(driver, HomePage.class);
        action.openBookingForm();
        action.chooseOneWayFlightType();
        Assert.assertTrue(action.getIsReturnDateInputInactive());
    }

    @Test
    public void shouldSubscribeFormThrowErrorWhenEnteredBadValue() {
        HomePage action = PageFactory.initElements(driver, HomePage.class);
        action.fillSubscribeForm("test");
        action.submitSubscription();
        Assert.assertTrue(action.getIsSubscribeFormThrowError());
    }

    @Test
    public void shouldCookiesBannerClosedWhenTheyAccepted() {
        HomePage action = PageFactory.initElements(driver, HomePage.class);
        action.closeCookies();
        Assert.assertTrue(action.isCookiesAccepted());
    }



}
