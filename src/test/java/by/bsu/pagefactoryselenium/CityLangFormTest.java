package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

public class CityLangFormTest {
    private final static String URL = "https://www.jal.com/index.html";

    private final static String CITY_NAME = "Moscow";

    private final static String RUSSIAN_LANGUAGE;

    static {
        String lang;
        try {
            lang = new String(
                    new byte[]{
                        (byte)0xd0,
                        (byte)0xa0,
                        (byte)0xd0,
                        (byte)0xa3,
                        (byte)0xd0,
                        (byte)0xa1,
                        (byte)0xd0,
                        (byte)0xa1,
                        (byte)0xd0,
                        (byte)0x9a,
                        (byte)0xd0,
                        (byte)0x98,
                        (byte)0xd0,
                        (byte)0x99
                    },
                    "UTF-8"
                );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            lang = "РУССКИЙ";
        }
        RUSSIAN_LANGUAGE = lang;
    }

    private WebDriver driver;

    @BeforeClass
    public void setupPage() {
        driver = Driver.getInstance();
        driver.get(URL);
    }

    @Test
    public void shouldSuggestedLanguageSwitchToRussianWhenMoscowIsChosen() {
        CityLangForm form = PageFactory.initElements(driver, CityLangForm.class);
        form.selectCity(CITY_NAME);
        String lang = form.getLanguageSelected();
        Assert.assertEquals(RUSSIAN_LANGUAGE, lang);
    }
}
