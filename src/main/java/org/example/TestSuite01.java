package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestSuite01
{

        protected static WebDriver driver;

        @BeforeMethod //METHOD FOR OPENING DRIVER & WEB HOMEPAGE
        public static void openBrowser()
        {
            System.setProperty("webdriver.chrome.driver","src/test/java/drivers/chromedriver.exe");

            //open Chrome browser:
            driver = new ChromeDriver();

            //Implicit wait method :
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Maximizing chrome window:
            driver.manage().window().maximize();

            //Driver to type URL :
            driver.get("https://demo.nopcommerce.com/");
        }

        @AfterMethod // METHOD FOR QUITING DRIVER
        public void driverQuit()
        {
            driver.quit();
        }

        @Test  //TEST CASE FOR BUILT YOUR OWN COMPUTER & ADD TO SHOPPING CART

        public void userShouldAbleToAddBuiltYourOwnComputerToShoppingCart()
        {
            //Click on computers on HOMEPAGE
            click(By.xpath("//ul[@class='top-menu notmobile']/li/a[@href='/computers']"));

            //Click on Desktop
            click(By.xpath("//h2/a[@href='/desktops']"));

            //Click on add to cart
            click(By.xpath("//button[contains(@onclick,'/addproducttocart/catalog/1/1/1')]"));

            //Assert Verification Point for correct product name
            assertExpectedEqualsActual("Build your own computer",By.xpath("//h1[contains(text(),'Build your own computer')]"),"You are on the wrong product");

            //Select 2.2Ghz Processor from dropdown
            selectDropdownByValue(By.id("product_attribute_1"),"1");

            //Select 2GB RAM from dropdown
            selectDropdownByValue(By.id("product_attribute_2"),"3");

            //Click on HDD 320gb radio button
            click(By.id("product_attribute_3_6"));

            //Click on OS Vista Premium radio button
            click(By.id("product_attribute_4_9"));

            //Click on Acrobat reader Software
            click(By.id("product_attribute_5_11"));

            //Click on Total Commander
            click(By.id("product_attribute_5_12"));

            //Click on Add to Cart button
            click(By.xpath("//button[@id='add-to-cart-button-1']"));

            //Click on Shopping cart
            click(By.xpath("//span[@class=\"cart-label\"]"));

            //Assert point to verify Shopping cart
            assertExpectedEqualsActual("Shopping cart",By.linkText("Shopping cart"),"You are on wrong webpage");

            //Assert point to verify correct product in the shopping cart
            assertExpectedEqualsActual("Build your own computer",By.xpath("//a[@class=\"product-name\"]"),"You have added wrong product int the basket");

        }

        @Test // TEST CASE FOR REFER PRODUCT TO FRIEND VIA EMAIL

        public void userShouldBeAbleToReferProductToFriendViaEmail()
        {
            //Registration Process
            userShouldBeAbleToRegisterSuccessfully();

            //Click on NopCommerce logo for homepage
            click(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));

            //Clicking on Build your own computer
            click(By.xpath("//h2/a[@href=\"/build-your-own-computer\"]"));

            //Click on  Email a friend
            click(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]"));

            //Enter friend's email address
            sendKeys(By.xpath("//input[@class=\"friend-email\"]"),"ecoguru@gmail.com");

            //Enter Your email address
            //sendKeys(By.xpath("//input[@class=\"your-email\"]"),"randomemail@gmail.com");

            //Enter Personal Message
            sendKeys(By.xpath("//textarea[@class=\"your-email\"]"),"You can buy this product. Kind regards, Ish");

            //Click on SEND EMAIL button
            click(By.xpath("//button[@name=\"send-email\"]"));

            //Assert Verification for message sent
            assertExpectedEqualsActual("Your message has been sent.",By.xpath("//div[@class='result']"),"Your Email message has NOT sent to your friend");


        }

        @Test //TEST CASE FOR USER SHOULD BE ABLE TO CHANGE CURRENCY FROM USD TO EURO

        public void userShouldBeAbleToChangeCurrencyFromUsdToEuro()
        {
            //Select Euro from Dropdown Menu in currency section on the homepage
            selectDropdownByText(By.xpath("//select[@id=\"customerCurrency\"]"),"Euro");

            //Go to Product & verify change of price for build your own computer in euros
            assertExpectedEqualsActual("€1032.00",By.xpath("//div[@style='width:100%']/following::div[3]/span[contains(text(),'€1032.00')]"),"Your Price is Not changed to EUROs");

        }


        @Test //TEST CASE FOR USER BE ABLE TO REGISTER SUCCESSFULLY

        public void userShouldBeAbleToRegisterSuccessfully()
        {
            // click on register button
            driver.findElement(By.className("ico-register")).click();

            //select on male or female
            driver.findElement(By.xpath("//input[@id='gender-male']")).click();

            // enter firstname
            // driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Allan");
            sendKeys(By.id("FirstName"),"AllanBhai");


            //enter last name
            //driver.findElement(By.id("LastName")).sendKeys("Sugar");
            sendKeys(By.id("LastName"),"SugarBhai");

            //Date of birth
            selectDropdownByValue(By.xpath("//select[@name='DateOfBirthDay']"),"2");

            //Month of birth
            selectDropdownByValue(By.xpath("//select[@name='DateOfBirthMonth']"),"9");

            //Year of the birth
            selectDropdownByValue(By.xpath("//select[@name='DateOfBirthYear']"),"1980");


            //EMAIL address
            //driver.findElement(By.id("Email")).sendKeys("easy123@mail.com");
            sendKeys(By.id("Email"),"easy"+randomDate()+"@mail.com");


            //password field
            // driver.findElement(By.id("Password")).sendKeys("12345678");
            sendKeys(By.id("Password"),"12345678");


            //Confirm Password
            // driver.findElement(By.id("ConfirmPassword")).sendKeys("12345678");
            sendKeys(By.id("ConfirmPassword"),"12345678");

            //click on Register button on the button of the page

            //driver.findElement(By.id("register-button")).click();
            click(By.id("register-button"));

            //Assert Confirmation for REGISTRATION successful.
            String expectedMessage = "Your registration completed";
            String actualMessage = driver.findElement(By.className("result")).getText();
            Assert.assertEquals(expectedMessage,actualMessage,"Your registration is NOT successful");


        }

        //........................../////////Utilities//////////..............................................

           //Driver Send Keys Method

        public static void sendKeys(By by,String text) //Send Keys
        {
            driver.findElement(by).sendKeys(text);
        }

        //Driver Click Method

        public static void click(By by) //Driver clicking on element with locator
        {
            driver.findElement(by).click();
        }

        //Driver get Text from Element Method

        public static void getTextFromElement(By by) //Driver get text with locator
        {
            driver.findElement(by).getText();
        }

        //Random date Method

        public static String randomDate()   //Date & Time generation method
        {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMYyyyHHMmSs");
            return formatter.format(date);
        }

        //Explicit wait method for Element to be clickable

        public static void driverWaitUnTillElementToBeClickable(By by,int time)
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();

        }

        //Explicit wait method for Element contains URL Fraction

        public static void driverWaitUnitElementContainsUrlFraction(By by,int time,String FractionUrl)
        {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait1.until(ExpectedConditions.urlContains("FractionUrl"));
        }

         //Explicit wait method for Element for Presence of element located

        public static void driverWaitUntilPresenceOfElementLocated(By by,int time)
        {
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait2.until(ExpectedConditions.presenceOfElementLocated(by));

        }

    public static void driverWaitUntilElementIsClickable(By by,int time)
    {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait2.until(ExpectedConditions.elementToBeClickable(by));

    }


        //Explicit wait method for Elements Title Contains

        public static void driverWaitUntilElementsTitleContains(int time,String TitleContains)
        {
            WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(time));
            wait4.until(ExpectedConditions.titleContains(TitleContains));

        }


        //Explicit wait method for wait until contains full URL

        public static void driverWaitUntilContainsUrl(int time,String url)
        {

            WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(time));
            wait5.until(ExpectedConditions.urlContains(url));

        }

         //Explicit wait method for Invisibility of WebElement

        public static void driverWaitUntilInvisibilityOfWebElement( int time, WebElement element)
        {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
            wait.until(ExpectedConditions.invisibilityOf(element));

        }

         //Explicit wait method for Element to be Selected

        public static void driverWaitUntilToBeSelected(int time, By by)
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.elementToBeSelected(by));
        }

        //Method for select from dropdown menu by VALUE

        public static void selectDropdownByValue(By by,String value)
        {
            Select dropdown = new Select(driver.findElement(by));
            dropdown.selectByValue(value);
        }

        //Method for Assert Equals for comparing Actual v/s Expected Result

        public static void assertExpectedEqualsActual(String expected,By by,String errorMessage)
        {
            String expectedResult = expected;
            String actualResult = driver.findElement(by).getText();
            Assert.assertEquals(expectedResult,actualResult,errorMessage);
        }

        //Method for select from dropdown menu by Visible TEXT

        public static void selectDropdownByText(By by, String textValue)
        {
            Select dropdown = new Select(driver.findElement(by));
            dropdown.selectByVisibleText(textValue);
        }



    }

