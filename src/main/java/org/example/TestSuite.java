package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

        //open chrome browser:
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
            System.out.println("Your registration is Successfull.");
        }
        else {
            System.out.println("Your registration is NOT successful.");
        }

       // driver.quit();


    }

public static void sendKeys(By by,String text)
{
    driver.findElement(by).sendKeys(text);
}

public static void click(By by)
{
    driver.findElement(by).click();
}

public static void getTextFromElement(By by)
{
driver.findElement(by).getText();
}

    public static String randomDate()
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }

public static void driverWaitUnTillElementToBeClickable(By by,int time)
{
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
   wait.until(ExpectedConditions.elementToBeClickable(by));

}



}
