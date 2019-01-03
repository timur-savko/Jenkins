package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TicketBuyFormTest {
    private final static String URL = "http://www.ru.jal.co.jp/rul/en/?city=MOW";

    private final static String ARRIVAL_COUNTRY = "AU_CM";

    private final static String EXPECTED_ARRIVAL_CITY = "SYD";

    private final static String EXPECTED_DEPARTURE_COUNTRY = "RU_CM";

    private final static String EXPECTED_DEPARTURE_CITY = "MOW";

    private WebDriver driver;

    private TicketBuyForm form;

    @BeforeClass
    public void pageSetup() {
        driver = Driver.getInstance();
        driver.get(URL);
        form = PageFactory.initElements(driver, TicketBuyForm.class);
    }

    @Test
    public void shouldDepartureCountryAndCityChangeToRussiaMoscowWhenRussianLangIsSelected() {
        String depCountry = form.getSelectedDepartureCountry();
        String depCity = form.getSelectedDepartureCity();
        Assert.assertEquals(EXPECTED_DEPARTURE_COUNTRY, depCountry);
        Assert.assertEquals(EXPECTED_DEPARTURE_CITY, depCity);
    }

    @Test
    public void shouldArrivalCityChangeToSydneyWhenAustraliaIsSelected() {
        form.toggleForm();
        form.selectArrivalCountry(ARRIVAL_COUNTRY);
        String cityName = form.getSelectedArrivalLocation();
        Assert.assertEquals(EXPECTED_ARRIVAL_CITY, cityName);
    }

    @Test(dependsOnMethods = {"shouldArrivalCityChangeToSydneyWhenAustraliaIsSelected"})
    public void shouldGetErrorMessageWhenDepartureDateIs8OctoberAndReturningDateIs3October() throws InterruptedException {
        String oldDepMonth = form.getSelectedDepartureMonth();
        String oldDepDate = form.getSelectedDepartureDate();
        String oldRetMonth = form.getSelectedReturningMonth();
        String oldRetDate = form.getSelectedReturningDate();
        form.selectDepartureMonth("10");
        form.selectDepartureDate("8");
        form.selectReturningMonth("10");
        form.selectReturningDate("3");
        form.submit();
        Thread.sleep(2000);
        Assert.assertTrue(form.isErrorMessageDisplayed());

//        restore
        form.selectDepartureMonth(oldDepMonth);
        form.selectDepartureDate(oldDepDate);
        form.selectReturningMonth(oldRetMonth);
        form.selectReturningDate(oldRetDate);
        form.toggleForm();
        form.toggleForm();
    }

    @Test(dependsOnMethods = {"shouldArrivalCityChangeToSydneyWhenAustraliaIsSelected"})
    public void shouldReturningDateFieldsBecomeDisabledWhenOneWayIsSelected() {
        form.selectOneWay();
        boolean isReturningDateFieldsEnabled = form.isReturningDateFieldsEnabled();
        Assert.assertFalse(isReturningDateFieldsEnabled);
    }

    @Test(dependsOnMethods = {"shouldArrivalCityChangeToSydneyWhenAustraliaIsSelected"})
    public void shouldGetErrorMessageWhenZeroAdultsSelected() throws InterruptedException {
        form.selectAdultsAmount("0");
        form.submit();
        Thread.sleep(2000);
        boolean gotError = form.isErrorMessageDisplayed();
        Assert.assertTrue(gotError);

//        restore
        form.toggleForm();
        form.toggleForm();
    }

    @Test(dependsOnMethods = {"shouldArrivalCityChangeToSydneyWhenAustraliaIsSelected"})
    public void shouldGetErrorMessageWhen1AdultAnd4ChildrenSelected() throws InterruptedException {
        form.selectAdultsAmount("1");
        form.selectChildrenAmount("4");
        form.submit();
        Thread.sleep(2000);
        boolean gotError = form.isErrorMessageDisplayed();
        Assert.assertTrue(gotError);

//        restore
        form.toggleForm();
        form.toggleForm();
    }

    @Test(dependsOnMethods = {"shouldArrivalCityChangeToSydneyWhenAustraliaIsSelected"})
    public void shouldGetErrorMessageWhen1AdultAnd2InfantsSelected() throws InterruptedException {
        form.selectAdultsAmount("1");
        form.selectChildrenAmount("0");
        form.selectInfantsAmount("2");
        form.submit();
        Thread.sleep(2000);
        boolean gotError = form.isErrorMessageDisplayed();
        Assert.assertTrue(gotError);

//        restore
        form.toggleForm();
        form.toggleForm();
    }
}
