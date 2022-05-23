package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class TestSuite {

protected static WebDriver driver;


    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","src/test/java/drivers/chromedriver.exe");

        //open Chrome browser:
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        // click on register button
        driver.findElement(By.className("ico-register")).click();

        // enter firstname
       // driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Allan");
           sendKeys(By.id("FirstName"),"AllanBhai");


        //enter last name
        //driver.findElement(By.id("LastName")).sendKeys("Sugar");
           sendKeys(By.id("LastName"),"SugarBhai");


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

        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();
        if(expectedMessage.equals(actualMessage))
        {
            System.out.println("Your registration is Successful.");
        }
        else {
            System.out.println("Your registration is NOT successful.");
        }

       // driver.quit();


    }

    //method for send keys or filling in texts
       public static void sendKeys(By by,String text)
       {
        driver.findElement(by).sendKeys(text);
       }

       //Method for clicking

       public static void click(By by)
      {
       driver.findElement(by).click();
      }

      //method for getting text from element via locator

      public static void getTextFromElement(By by)
      {
      driver.findElement(by).getText();
      }


     //Method for printing DATE & TIME STAMP

    public static String randomDate()
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMYyyyHHMmSs");
        return formatter.format(date);
    }

    //Method for driver until Element is clickable.

    public static void driverWaitUnTillElementToBeClickable(By by,int time)
    {

   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
   wait.until(ExpectedConditions.elementToBeClickable(by));

   }

    //Method for driver until Element Contains URL FRACTION.

   public static void driverWaitUnitElementContainsUrlFraction(By by,int time,String FractionUrl)
  {

  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(time));
  wait1.until(ExpectedConditions.urlContains("FractionUrl"));

  }

  //Method for driver wait till Element Located by locator.

   public static void driverWaitUntilElementLocated(By by,int time)
   {
    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(time));
    wait2.until(ExpectedConditions.presenceOfElementLocated(by));

   }

   //Method for driver wait till Elements Title Contains.

    public static void driverWaitUntilElementsTitleContains(By by,int time,String TitleContains)
    {
        WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait4.until(ExpectedConditions.titleContains(TitleContains));

    }

    //Method for driver wait till Contains FULL URL.

    public static void driverWaitUntilContainsUrl(int time,String url)
    {

    WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(time));
    wait5.until(ExpectedConditions.urlContains(url));

    }

    //Method for driver till Presence of Element Located via locator.

    public static void driverWaitUntilPresenceOfElementLocated(By by, int time)
    {
        WebDriverWait wait6 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait6.until(ExpectedConditions.presenceOfElementLocated(by));
    }

     // Method for driver till Invisibility of Web Element.

    public static void driverWaitUntilInvisibilityOfWebElement( int time, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    //Method for driver till Alert is Present.

    public static void driverWaitUntilAlertIsPresent(int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //Method for driver till Attribute To Be.

    public static void driverWaitUntilAttributeToBe(int time,By by, String attribute, String value)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBe(by,attribute,value));

    }

    //Method for driver waiting till Attribute to be NOT Empty.

    public static void driverWaitUntilAttributeToBeNotEmpty(int time,WebElement element, String attribute)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    //Method for driver wait till element to be selected by locator.

    public static void driverWaitUntilElementToBeSelected(int time, By by)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    //Method for driver waiting till Text to be.

    public static void driverWaitUntilTextToBe(int time, By by, String value)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by,value));

    }



}
