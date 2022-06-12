package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import javax.lang.model.element.Element;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TrailTestSuite {

    //Global variable for webDriver
protected static WebDriver driver;


@BeforeMethod // Before method for opening the window with url

public static void openWebBrowser()
{
    System.setProperty("webdriver.chrome.driver","src/test/java/drivers/chromedriver.exe");

    //open chrome browser
    driver = new ChromeDriver();

    //Implicit wait for 10 seconds
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    //Maximise browser window
    driver.manage().window().maximize();

     //Opening url
    driver.get("https://demo.nopcommerce.com/");

}

//@AfterMethod
//Method for closing web browser
public static void driverQuit()
{
    driver.quit();
}

@Test  // Test cases for user should be able to register successfully.
    public void userShouldBeAbleToRegisterSuccessfully()
    {

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

          //Assert Equals for verification of expected v actual result
            AssertEqualsExpectedVsActual("Your registration completed",By.className("result"),"Your registration is NOT successful");

    }

    @Test //User can able to buy various gift cards & checkout by Money order
    public void userShouldBeAbleToBuyVariousDigitalGiftCards()
    {
        //Click on Gift cards on Homepage
        click(By.xpath("//div[@class='menu-toggle']/preceding::a[@href='/gift-cards']"));

        //click on $25 gift card link
        click(By.xpath("//h2/a[@href='/25-virtual-gift-card']"));

        //Enter Recipient's name
        sendKeys(By.xpath("//input[@id='giftcard_43_RecipientName']"),"Sir Lord Allan Sugar");

        //Enter recipient's Email
        sendKeys(By.xpath("//input[@id='giftcard_43_RecipientEmail']"),"abc@gmail.com");

        //Enter Your name
        sendKeys(By.xpath("//input[@id='giftcard_43_SenderName']"),"Ish Ish");

        //Enter Your Email address
        sendKeys(By.xpath("//input[@id='giftcard_43_SenderEmail']"),"xyz@gmail.com");

        //Enter Your Message
        sendKeys(By.xpath("//textarea[@id='giftcard_43_Message']"),"Many many Happy returns of the day");

        //Clear number inside quantity
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_43']")).clear();

        //Enter Number of quantities need
       sendKeys(By.xpath("//input[@id='product_enteredQuantity_43']"),"2");

        //Click on Add to cart button
        click(By.xpath("//button[@id='add-to-cart-button-43']"));

        //------------------------------------------ Adding $50 gift card to add to cart--------------------

        //click on Gift cards option on top header
        click(By.xpath("//span[@itemprop=\"name\"]"));

        //click on $50 Gift Card link
        click(By.xpath("//h2/a[@href=\"/50-physical-gift-card\"]"));

        //Assert Verification of $50 Physical gift Card
        AssertEqualsExpectedVsActual("$50 Physical Gift Card",By.xpath("//div[@class=\"product-name\"]/h1"),"This is not $50 gift card");

        //Enter Recipient's Name
        sendKeys(By.xpath("//input[@id=\"giftcard_44_RecipientName\"]"),"JD & GAMITA");

        //Enter Sender Name
        sendKeys(By.xpath("//input[@id=\"giftcard_44_SenderName\"]"),"ISH");

        //Enter Message
        sendKeys(By.xpath("//textarea[@id=\"giftcard_44_Message\"]"),"Thank you for sharing your knowledge with us");

        //click & clear qty area
        driver.findElement(By.xpath("//input[@id=\"product_enteredQuantity_44\"]")).clear();

        //click & enter 2 qty in Qty area
        sendKeys(By.xpath("//input[@id=\"product_enteredQuantity_44\"]"),"2");

        //click on add to cart button
        click(By.xpath("//button[@id=\"add-to-cart-button-44\"]"));
//-----------------------------------adding $100 gift card------------------------------------------------------
        //click on Gift cards option on top header
        click(By.xpath("//span[@itemprop=\"name\"]"));

        //click on $100 Physical gift card
        click(By.xpath("//h2/a[@href='/100-physical-gift-card']"));

        //Enter Recipient's Name
        sendKeys(By.xpath("//input[@id='giftcard_45_RecipientName']"),"JD & GAMITA");

        //Enter Your Name
        sendKeys(By.xpath("//input[@id='giftcard_45_SenderName']"),"ISH");

        //Enter Message
        sendKeys(By.xpath("//textarea[@id='giftcard_45_Message']"),"Gift for you all, please share with Vipul & RD");

        //click & clear Qty text box
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_45']")).clear();

        //Enter right Qty
        sendKeys(By.xpath("//input[@id='product_enteredQuantity_45']"),"5");

        //Click on Add to cart button
        click(By.xpath("//button[@id='add-to-cart-button-45']"));

        //Click & go to shopping cart
        click(By.xpath("//span[@class='cart-label']"));

        //----------------------------------------SHOPPING CART PAGE-------------------------------------------

        //GIFT WRAPPING OPTION TO YES
        selectDropDownByValue(By.xpath("//select[@id='checkout_attribute_1']"),"2");

        //Click on agree T&C's
        click(By.xpath("//input[@id='termsofservice']"));

        //Click on checkout button
        click(By.xpath("//button[@id='checkout']"));

        //Click on CHECKOUT AS GUEST
        click(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));

        //Enter First name
        sendKeys(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"IsHiSH");

        //Enter Last name
        sendKeys(By.xpath("//input[@id='BillingNewAddress_LastName']"),"MaCmAc");

        //Enter Email
        sendKeys(By.xpath("//input[@id='BillingNewAddress_Email']"),"raju+1@gmail.com");

        //Select Country
        selectDropDownByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"233");

        //Enter City Name
        sendKeys(By.xpath("//input[@id='BillingNewAddress_City']"),"Wembley");

        //Enter Address 1
        sendKeys(By.xpath("//input[@id='BillingNewAddress_Address1']"),"83, Automation Drive,");


        //Enter Zip/PostalCode
        sendKeys(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HA0 4GF");

        //Enter Phone Number
        sendKeys(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07677890098");

        //Click on Continue button
        click(By.xpath("//button[@onclick='Billing.save()']"));

        //Click on Radio button NEXT DAY AIR
        click(By.xpath("//input[@id='shippingoption_1']"));

        //Assert Verification for selection of Next Day Air
        AssertEqualsExpectedVsActual("The one day air shipping",By.xpath("//ul[@class='method-list']/li[2]/div[@class='method-description']"),"You have selected wrong shipping otpion");

        //Click on Continue button
        click(By.xpath("//button[@onclick='ShippingMethod.save()']"));

        //Click on continue button .... Payment Method page with Check/Money Order Auto selected
        click(By.xpath("//button[@onclick='PaymentMethod.save()']"));

        //Payment Information Assert verification
        AssertEqualsExpectedVsActual("Pay by cheque or money order",By.xpath("//div[text()='Pay by cheque or money order']"),"You have selected wrong payment method");

        //Click on Continue button
        click(By.xpath("//button[@onclick='PaymentInfo.save()']"));

        //Payment  Assert Verification
        AssertEqualsExpectedVsActual("Payment Method: Check / Money Order",By.xpath("//li[@class='payment-method']"),"You have selected wrong option");

        //Click on Confirm Button
        click(By.xpath("//button[@onclick='ConfirmOrder.save()']"));

        //Click on Here for order details link
       // click(By.xpath("//a[@href='/orderdetails/1031']"));


        //Click on Continue
        click(By.xpath("//button[@onclick='setLocation(\"/\")']"));

    }
 @Test
    public void userShouldBeAbleToPurchaseCamera()
    {
        //From homepage, click on electronics
        click(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));


        //Click on Camera & photo
        click(By.xpath("//h2/a[@title='Show products in category Camera & photo']"));

        //click on Sort by & select A to Z option
        selectDropDownByValue(By.xpath("//select[@id='products-orderby']"),"5");

        driverWaitUnTillElementToBeClickable(By.xpath("//a[.='Nikon D5500 DSLR']/following::button[1]"), 30);

//      click(By.xpath("//select[@id='products-orderby']/option[2]"));

        // Make Sure Driver click outside the sort by dropdown menu
        click(By.xpath("//div[@class='page-title']"));

        click(By.xpath("//a[.='Nikon D5500 DSLR']/following::button[1]"));
        //Click on Nikon D5500 DSLR camera add to cart button
//        click(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/13/1/1\"),!1']"));

        //Click & clear Qty box on shopping cart page
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_14']")).clear();

        //Enter the Right Qty needed in the Qty Box
        sendKeys(By.xpath("//input[@id='product_enteredQuantity_14']"),"2000");

        //Click on add to cart button for Nikon D5500 DSLR - BLACK
        driverWaitUnTillElementToBeClickable(By.xpath("//button[@id='add-to-cart-button-14']"),15);
        click(By.xpath("//button[@id='add-to-cart-button-14']"));

        //Click on Shopping cart on top page
         click(By.xpath("//span[@class='cart-label']"));

        // Select Gift wrapping option to YES
        click(By.xpath("//select[@id='checkout_attribute_1']/option[2]"));

        //Click on agree T&C's
        click(By.xpath("//input[@id='termsofservice']"));

        //Click on checkout button
        click(By.xpath("//button[@id='checkout']"));





    }
//----------------------------UTIL METHODS-----------------------------------------------------------------//
    //Method for send Keys
public static void sendKeys(By by,String text)
{
    driver.findElement(by).sendKeys(text);
}

//Method for find Elements & click
public static void click(By by)
{
    driver.findElement(by).click();
}

//Method for Get Text from Element
public static void getTextFromElement(By by)
{
driver.findElement(by).getText();
}

//Method for generating random date
    public static String randomDate()
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }

    //Explicit method for element to be clickable
public static void driverWaitUnTillElementToBeClickable(By by,int time)
{
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
   wait.until(ExpectedConditions.elementToBeClickable(by));

}

//Explicit method for element to be visible
    public static void driverWaitUntilPresenceOfElement(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

//Method for comparing expected v actual
public static void AssertEqualsExpectedVsActual(String expected,By by,String errorMessage)
{
    String expectedResult = expected;
    String actualResult = driver.findElement(by).getText();
    Assert.assertEquals(expectedResult,actualResult,errorMessage);
}


//Method for select drop down with value

    public static void selectDropDownByValue(By by, String Value)
    {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(Value);

    }



}
