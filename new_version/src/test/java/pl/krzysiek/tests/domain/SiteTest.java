//package pl.krzysiek.tests.domain;
//
//        import static org.junit.Assert.assertEquals;
//        import static org.junit.Assert.assertNotNull;
//        import static org.junit.Assert.assertTrue;
//        import static org.junit.Assert.fail;
//
//        import java.io.File;
//        import java.io.IOException;
//        import java.util.List;
//        import java.util.Random;
//        import java.util.concurrent.TimeUnit;
//
//        import org.junit.*;
//        import org.apache.commons.io.FileUtils;
//        import org.openqa.selenium.Alert;
//        import org.openqa.selenium.By;
//        import org.openqa.selenium.NoAlertPresentException;
//        import org.openqa.selenium.NoSuchElementException;
//        import org.openqa.selenium.OutputType;
//        import org.openqa.selenium.TakesScreenshot;
//        import org.openqa.selenium.WebDriver;
//        import org.openqa.selenium.WebElement;
//        import org.openqa.selenium.chrome.ChromeDriver;
//        import org.openqa.selenium.firefox.FirefoxBinary;
//        import org.openqa.selenium.firefox.FirefoxDriver;
//        import org.openqa.selenium.firefox.FirefoxOptions;
//        import org.openqa.selenium.interactions.Actions;
//
//@Ignore
//public class SiteTest {
//
//
//    private WebDriver driver;
//    private String baseUrl;
//    private boolean acceptNextAlert = true;
//    private StringBuffer verificationErrors = new StringBuffer();
//
//    @Before
//    public void setUp() throws Exception {
//        System.setProperty("webdriver.chrome.driver","src/test/java/pl/krzysiek/tests/domain/chromedriver");
//        driver = new ChromeDriver();
//        baseUrl = "http://automationpractice.com";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
//
//    private int number () {
//        Random rand = new Random();
//        int n = rand.nextInt(9999) + 1;
//
//        return n;
//    }
//
//    @Test
//    public void successfulRegistrationTest() throws Exception {
//        String email = "Testowy" + number() + "@gmail.com";
//        registration(email, "1", "Test", "Last", "21377", "Rolety tu i tam 22", "Ames", "17", "77722", "2", "500100900");
//    }
//
//    @Test
//    public void failedRegistrationTest_email() throws Exception {
//        //email
//        int n = number();
//        String email = "Testowy" + n;
//
//        failedRegistrationEmail(email, "1", "Test", "Last", "21377", "Rolety tu i tam 22", "Ames", "17", "77722", "2", "500100900");
//
//    }
//
//    private void failedRegistrationEmail (String email, String gender, String firstname, String lastname, String password,
//                                          String address, String city, String state, String zip, String country, String mobile_phone) throws Exception {
//        driver.get(baseUrl + "/index.php");
//        driver.findElement(By.cssSelector(".login")).click();
//        driver.findElement(By.id("email_create")).clear();
//        driver.findElement(By.id("email_create")).sendKeys(email);
//
//        driver.findElement(By.id("SubmitCreate")).click();
//
//        Thread.sleep(2000);
//        assertEquals(true, driver.findElement(By.cssSelector("#create_account_error")).isDisplayed());
//
//    }
//
//    @Test
//    public void failedRegistrationTest() throws Exception {
//        //firstname
//        int n = number();
//        String email = "Testowy" + n + "@gmail.com";
//
//        failedRegistration(email, "1", "Test1", "Last", "21377", "Rolety tu i tam 22", "Ames", "17", "77722", "2", "500100900");
//
//    }
//
//    private void failedRegistration (String email, String gender, String firstname, String lastname, String password,
//                                     String address, String city, String state, String zip, String country, String mobile_phone) throws Exception {
//        driver.get(baseUrl + "/index.php");
//        driver.findElement(By.cssSelector(".login")).click();
//        driver.findElement(By.id("email_create")).clear();
//        driver.findElement(By.id("email_create")).sendKeys(email);
//
//        driver.findElement(By.id("SubmitCreate")).click();
//
//        Thread.sleep(1000);
//        assertEquals(false, driver.findElement(By.cssSelector("#create_account_error")).isDisplayed());
//
//        //Title
//        driver.findElement(By.id("uniform-id_gender" + gender)).click();
//        assertEquals(true, driver.findElement(By.cssSelector("#id_gender1")).isSelected());
//
//        //Firstname
//        driver.findElement(By.id("customer_firstname")).clear();
//        driver.findElement(By.id("customer_firstname")).sendKeys(firstname);
//        assertNotNull(driver.findElement(By.id("customer_firstname")).getAttribute("value"));
//
//        //Lastname
//        driver.findElement(By.id("customer_lastname")).clear();
//        driver.findElement(By.id("customer_lastname")).sendKeys(lastname);
//        assertNotNull(driver.findElement(By.id("customer_lastname")).getAttribute("value"));
//
//        //e-mail
//        assertNotNull(driver.findElement(By.id("email")).getAttribute("value"));
//
//        //Password
//        driver.findElement(By.id("passwd")).clear();
//        driver.findElement(By.id("passwd")).sendKeys(password);
//        assertNotNull(driver.findElement(By.id("passwd")).getAttribute("value"));
//        assertTrue(driver.findElement(By.id("passwd")).getAttribute("value").length()>=5 );
//
//        //Address
//        driver.findElement(By.id("address1")).clear();
//        driver.findElement(By.id("address1")).sendKeys(address);
//        assertNotNull(driver.findElement(By.id("address1")).getAttribute("value"));
//
//        //City
//        driver.findElement(By.id("city")).clear();
//        driver.findElement(By.id("city")).sendKeys(city);
//        assertNotNull(driver.findElement(By.id("city")).getAttribute("value"));
//
//        //State
//        driver.findElement(By.cssSelector("#id_state > option:nth-child(" + state + ")")).click();
//        assertEquals("15", driver.findElement(By.id("id_state")).getAttribute("value"));
//
//        //Zip
//        driver.findElement(By.id("postcode")).clear();
//        driver.findElement(By.id("postcode")).sendKeys(zip);
//        assertNotNull(driver.findElement(By.id("postcode")).getAttribute("value"));
//        assertTrue(driver.findElement(By.id("postcode")).getAttribute("value").length()==5);
//
//        //Country
//        driver.findElement(By.cssSelector("#id_country > option:nth-child(" + country + ")")).click();
//        assertEquals("21", driver.findElement(By.id("id_country")).getAttribute("value"));
//
//        //Mobile phone
//        driver.findElement(By.id("phone_mobile")).clear();
//        driver.findElement(By.id("phone_mobile")).sendKeys(mobile_phone);
//        assertNotNull(driver.findElement(By.id("phone_mobile")).getAttribute("value"));
//
//        driver.findElement(By.id("submitAccount")).click();
//
//        Thread.sleep(1000);
//        if(driver.findElements(By.linkText("Sign out") ).size() != 0) {
//            driver.findElement(By.linkText("Sign out")).click();
//        }
//        else
//            assertTrue(true);
//
//        File scrFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile3, new File("target/AutomationPracticeTest3.png"));
//
//    }
//
//    private void registration (String email, String gender, String firstname, String lastname, String password,
//                               String address, String city, String state, String zip, String country, String mobile_phone) throws Exception {
//        driver.get(baseUrl + "/index.php");
//        driver.findElement(By.cssSelector(".login")).click();
//        driver.findElement(By.id("email_create")).clear();
//        driver.findElement(By.id("email_create")).sendKeys(email);
//
//        driver.findElement(By.id("SubmitCreate")).click();
//
//        Thread.sleep(1000);
//        assertEquals(false, driver.findElement(By.cssSelector("#create_account_error")).isDisplayed());
//
//        //Title
//        driver.findElement(By.id("uniform-id_gender" + gender)).click();
//        assertEquals(true, driver.findElement(By.cssSelector("#id_gender1")).isSelected());
//
//        //Firstname
//        driver.findElement(By.id("customer_firstname")).clear();
//        driver.findElement(By.id("customer_firstname")).sendKeys(firstname);
//        assertNotNull(driver.findElement(By.id("customer_firstname")).getAttribute("value"));
//
//        //Lastname
//        driver.findElement(By.id("customer_lastname")).clear();
//        driver.findElement(By.id("customer_lastname")).sendKeys(lastname);
//        assertNotNull(driver.findElement(By.id("customer_lastname")).getAttribute("value"));
//
//        //e-mail
//        assertNotNull(driver.findElement(By.id("email")).getAttribute("value"));
//
//        //Password
//        driver.findElement(By.id("passwd")).clear();
//        driver.findElement(By.id("passwd")).sendKeys(password);
//        assertNotNull(driver.findElement(By.id("passwd")).getAttribute("value"));
//        assertTrue(driver.findElement(By.id("passwd")).getAttribute("value").length()>=5 );
//
//        //Address
//        driver.findElement(By.id("address1")).clear();
//        driver.findElement(By.id("address1")).sendKeys(address);
//        assertNotNull(driver.findElement(By.id("address1")).getAttribute("value"));
//
//        //City
//        driver.findElement(By.id("city")).clear();
//        driver.findElement(By.id("city")).sendKeys(city);
//        assertNotNull(driver.findElement(By.id("city")).getAttribute("value"));
//
//        //State
//        driver.findElement(By.cssSelector("#id_state > option:nth-child(" + state + ")")).click();
//        assertEquals("15", driver.findElement(By.id("id_state")).getAttribute("value"));
//
//        //Zip
//        driver.findElement(By.id("postcode")).clear();
//        driver.findElement(By.id("postcode")).sendKeys(zip);
//        assertNotNull(driver.findElement(By.id("postcode")).getAttribute("value"));
//        assertTrue(driver.findElement(By.id("postcode")).getAttribute("value").length()==5);
//
//        //Country
//        driver.findElement(By.cssSelector("#id_country > option:nth-child(" + country + ")")).click();
//        assertEquals("21", driver.findElement(By.id("id_country")).getAttribute("value"));
//
//        //Mobile phone
//        driver.findElement(By.id("phone_mobile")).clear();
//        driver.findElement(By.id("phone_mobile")).sendKeys(mobile_phone);
//        assertNotNull(driver.findElement(By.id("phone_mobile")).getAttribute("value"));
//
//        driver.findElement(By.id("submitAccount")).click();
//
//        Thread.sleep(1000);
//        if(driver.findElements(By.linkText("Sign out") ).size() != 0) {
//            driver.findElement(By.linkText("Sign out")).click();
//        }
//        else
//            assertTrue(false);
//
//        File scrFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile3, new File("target/AutomationPracticeTest3.png"));
//
//    }
//
//    @Test
//    public void registrationValidationTest () throws Exception {
//        //sprawdzam czy poprawnie wyswietli komuniaty o bledzie
//        int n = number();
//        String email = "Testowy" + n + "@gmail.com";
//
//        registrationValidation (email, "1", "Test1", "Last1", "2137", "Rolety tu i tam 22", "Ames", "17", "77722", "2", "500100900");
//    }
//
//    private void registrationValidation (String email, String gender, String firstname, String lastname, String password,
//                                         String address, String city, String state, String zip, String country, String mobile_phone) throws Exception {
//        driver.get(baseUrl + "/index.php");
//        driver.findElement(By.cssSelector(".login")).click();
//        driver.findElement(By.id("email_create")).clear();
//        driver.findElement(By.id("email_create")).sendKeys(email);
//
//        driver.findElement(By.id("SubmitCreate")).click();
//
//        Thread.sleep(1000);
//        assertEquals(false, driver.findElement(By.cssSelector("#create_account_error")).isDisplayed());
//
//        //Title
//        driver.findElement(By.id("uniform-id_gender" + gender)).click();
//
//        //Firstname
//        driver.findElement(By.id("customer_firstname")).clear();
//        driver.findElement(By.id("customer_firstname")).sendKeys(firstname);
//
//        //Lastname
//        driver.findElement(By.id("customer_lastname")).clear();
//        driver.findElement(By.id("customer_lastname")).sendKeys(lastname);
//
//        //e-mail
//
//        //Password
//        driver.findElement(By.id("passwd")).clear();
//        driver.findElement(By.id("passwd")).sendKeys(password);
//
//        //Address
//        driver.findElement(By.id("address1")).clear();
//        driver.findElement(By.id("address1")).sendKeys(address);
//
//        //City
//        driver.findElement(By.id("city")).clear();
//        driver.findElement(By.id("city")).sendKeys(city);
//
//        //State
//        // driver.findElement(By.cssSelector("#id_state > option:nth-child(" + state + ")")).click();
//
//        //Zip
//        driver.findElement(By.id("postcode")).clear();
//        driver.findElement(By.id("postcode")).sendKeys(zip);
//
//        //Country
//        driver.findElement(By.cssSelector("#id_country > option:nth-child(" + country + ")")).click();
//
//        //Mobile phone
//        driver.findElement(By.id("phone_mobile")).clear();
//        driver.findElement(By.id("phone_mobile")).sendKeys(mobile_phone);
//
//        driver.findElement(By.id("submitAccount")).click();
//
//        Thread.sleep(500);
//        assertEquals("There are 4 errors", driver
//                .findElement(By.cssSelector("div.alert.alert-danger > p:nth-child(1)")).getText());
//
//
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
//    }
//
//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//
//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }
//}