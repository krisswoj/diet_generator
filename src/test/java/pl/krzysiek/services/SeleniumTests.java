package pl.krzysiek.services;

import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertNotNull;
        import static org.junit.Assert.assertTrue;
        import static org.junit.Assert.fail;

import java.util.Random;
        import java.util.concurrent.TimeUnit;

        import org.junit.*;
import org.openqa.selenium.Alert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.NoAlertPresentException;
        import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Ignore
public class SeleniumTests {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","src/test/java/pl/krzysiek/services/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8080";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private int number () {
        Random rand = new Random();
        int n = rand.nextInt(9999) + 1;

        return n;
    }

    @Test
    public void successfulRegistrationTest() throws Exception {
        String email = "Testowy" + number() + "@gmail.com";
        registration("1", "stefan", email, "Laftyjvgukhijst");
    }

    @Test
    public void failedRegistrationTest_email() throws Exception {

        failedRegistrationEmail("jasiu", "1", "grerfwrgttrerg", "Last");

    }

    @Test
    public void TooShortPassword() throws Exception {
        tooShortPassword("jasiu", "1", "kriss@wp.pl", "Last");
    }

    @Test
    public void manyWrongInputs() throws Exception {
        String email = "";
        registrationValidation ("", "1", email, "rf4545456");
    }



    private void registration (String name, String surname, String email, String password) throws Exception {
        driver.get(baseUrl + "/register");
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);

        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys(surname);

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(2000);
        assertEquals("User has been registered successfully", driver
                .findElement(By.cssSelector("span")).getText());

    }

    private void failedRegistrationEmail (String name, String surname, String email, String password) throws Exception {
        driver.get(baseUrl + "/register");
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);

        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys(surname);

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(2000);
        assertEquals("*Please provide a valid Email", driver
                .findElement(By.cssSelector("label.validation-message")).getText());

    }

    private void tooShortPassword(String name, String surname, String email, String password) throws Exception {

        driver.get(baseUrl + "/register");
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);

        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys(surname);

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(2000);
        assertEquals("*Your password must have at least 5 characters", driver
                .findElement(By.cssSelector("label.validation-message")).getText());
    }

    private void registrationValidation (String name, String surname, String email, String password) throws Exception {

        driver.get(baseUrl + "/register");
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);

        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys(surname);

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(2000);
        assertEquals("*Please provide your name", driver
                .findElement(By.id("wrongName")).getText());
        Thread.sleep(2000);
        assertEquals("*Please provide an email", driver
                .findElement(By.id("wrongEmail")).getText());

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}