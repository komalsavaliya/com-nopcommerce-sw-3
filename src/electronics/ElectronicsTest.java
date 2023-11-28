package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 1. Create the class ElectronicsTest
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
 * 1.1 Mouse Hover on “Electronics” Tab
 * 1.2 Mouse Hover on “Cell phones” and click
 * 1.3 Verify the text “Cell phones”
 * 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
 * 2.1 Mouse Hover on “Electronics” Tab
 * 2.2 Mouse Hover on “Cell phones” and click
 * 2.3 Verify the text “Cell phones”
 * 2.4 Click on List View Tab
 * 2.5 Click on product name “Nokia Lumia 1020” link
 * 2.6 Verify the text “Nokia Lumia 1020”
 * 2.7 Verify the price “$349.00”
 * 2.8 Change quantity to 2
 * 2.9 Click on “ADD TO CART” tab
 * 2.10 Verify the Message "The product has been added to your shopping cart" on Top
 * green Bar
 * After that close the bar clicking on the cross button.
 * 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.12 Verify the message "Shopping cart"
 * 2.13 Verify the quantity is 2
 * 2.14 Verify the Total $698.00
 * 2.15 click on checkbox “I agree with the terms of service”
 * 2.16 Click on “CHECKOUT”
 * 2.17 Verify the Text “Welcome, Please Sign In!”
 * 2.18 Click on “REGISTER” tab
 * 2.19 Verify the text “Register”
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “REGISTER” Button
 * 2.22 Verify the message “Your registration completed”
 * 2.23 Click on “CONTINUE” tab
 * 2.24 Verify the text “Shopping card”
 * 2.25 click on checkbox “I agree with the terms of service”
 * 2.26 Click on “CHECKOUT”
 * 2.27 Fill the Mandatory fields
 * 2.28 Click on “CONTINUE”
 * 2.29 Click on Radio Button “2nd Day Air ($0.00)”
 * 2.30 Click on “CONTINUE”
 * 2.31 Select Radio Button “Credit Card”
 * 2.32 Select “Visa” From Select credit card dropdown
 * 2.33 Fill all the details
 * 2.34 Click on “CONTINUE”
 * 2.35 Verify “Payment Method” is “Credit Card”
 * 2.36 Verify “Shipping Method” is “2nd Day Air”
 * 2.37 Verify Total is “$698.00”
 * 2.38 Click on “CONFIRM”
 * 2.39 Verify the Text “Thank You”
 * 2.40 Verify the message “Your order has been successfully processed!”
 * 2.41 Click on “CONTINUE”
 * 2.42 Verify the text “Welcome to our store”
 * 2.43 Click on “Logout” link
 * 2.44 Verify the URL is “https://demo.nopcommerce.com/”
 */

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.linkText("Electronics"));
        //mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //1.2 Mouse Hover on “Cell phones” and "Click"
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals("Incorrect Top Menu", expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.linkText("Electronics"));
        Thread.sleep(2000);

        //2.2 Mouse Hover on “Cell phones” and "Click"
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //2.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals("Incorrect Top Menu", expectedText, actualText);

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        Thread.sleep(2000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[@href ='/nokia-lumia-1020']"));

        //2.6 Verify the text “Nokia Lumia 1020”
        String expectedText8 = "Nokia Lumia 1020";
        String actualText8 = getTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));
        Assert.assertEquals(expectedText8, actualText8);

        //2.7 Verify the price “$349.00”
        String expectedText9 = "$349.00";
        String actualText9 = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals(expectedText9, actualText9);

        //2.8 Change quantity to 2
        toClear(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expected10 = "The product has been added to your shopping cart";
        String actualText10 = getTextFromElement(By.xpath(" // p[@class='content']"));
        Assert.assertEquals(expected10, actualText10);

        //close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[text()='Go to cart']"));

        //2.12 Verify the message "Shopping cart"
        String expected11 = "Shopping cart";
        String actualText11 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expected11, actualText11);

        //2.13 Verify the quantity is 2
        String expectedQuantity = "2";
        String actualQuantity = driver.findElement(By.xpath("//input[@class = 'qty-input']")).getAttribute("value");
        Assert.assertEquals("Incorrect quantity", expectedQuantity, actualQuantity);

        //2.14 Verify the Total $698.00
        String expected13 = "$698.00";
        String actualText13 = getTextFromElement(By.xpath("//span[text() = '$698.00']"));
        Assert.assertEquals(expected13, actualText13);


        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage4 = "Welcome, Please Sign In!";
        String actualMessage4 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedMessage4, actualMessage4);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));

        //2.19 Verify the text “Register”
        String expectedMessage5 = "Register";
        String actualMessage5 = getTextFromElement(By.xpath("//h1[normalize-space()='Register']"));
        Assert.assertEquals(expectedMessage5, actualMessage5);

        //2.20 Fill the mandatory fields
        clickOnElement(By.id("gender-male"));
        sendTextToElement(By.id("FirstName"), "Mary");
        sendTextToElement(By.id("LastName"), "John");
        sendTextToElement(By.name("DateOfBirthDay"), "6");
        sendTextToElement(By.name("DateOfBirthMonth"), "June");
        sendTextToElement(By.name("DateOfBirthYear"), "1966");
        final String randomEmail = randomEmail();
        sendTextToElement(By.id("Email"), randomEmail);
        sendTextToElement(By.id("Password"), "123456");
        sendTextToElement(By.id("ConfirmPassword"), "123456");


        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

        //2.22 Verify the message “Your registration completed”
        String expectedMessage6 = "Your registration completed";
        String actualMessage6 = getTextFromElement(By.className("result"));
        Assert.assertEquals("Incorrect message displayed", expectedMessage6, actualMessage6);
        Thread.sleep(2000);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping cart”
        String expectedMessage7 = "Shopping cart";
        String actualMessage7 = getTextFromElement(By.linkText("Shopping cart"));
        Assert.assertEquals("Incorrect message displayed", expectedMessage7, actualMessage7);

        //Click on login button
        clickOnElement(By.linkText("Log in"));

        //Verify the text "Welcome, Please Sign In!"
        String expectedMessage8 = "Welcome, Please Sign In!";
        String actualMessage8 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Incorrect Welcome Text!", expectedMessage8, actualMessage8);

        //Enter Email into Email Field
        sendTextToElement(By.id("Email"), randomEmail);

        //Enter Password into Password Field
        sendTextToElement(By.name("Password"), "123456");

        //Click on Login Button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.27 Fill the Mandatory fields
        sendTextToElement(By.id("BillingNewAddress_Company"), "JohnZink");
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "1");
        selectByValueFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "11");
        sendTextToElement(By.id("BillingNewAddress_City"), "Tulsa");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "8945 144th Street");
        sendTextToElement(By.id("BillingNewAddress_Address2"), "Tulsa,Oklahoma");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "74101");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "918-456-7890");
        sendTextToElement(By.id("BillingNewAddress_FaxNumber"), "1234556");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(2000);

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        Thread.sleep(3000);

        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleFromDropDown(By.id("CreditCardType"), "Visa");

        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Mary John");
        sendTextToElement(By.id("CardNumber"), "0000 0000 0000 0000");
        selectByValueFromDropDown(By.id("ExpireMonth"), "5");
        selectByValueFromDropDown(By.id("ExpireYear"), "2030");
        sendTextToElement(By.id("CardCode"), "5623");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card"
        String expectedText14 = "Payment Method: Credit Card";
        String actualText14 = getTextFromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals(expectedText14, actualText14);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedText15 = "Shipping Method: 2nd Day Air";
        String actualText15 = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        Assert.assertEquals(expectedText15, actualText15);

        //2.37 Verify Total is “$698.00”
        String expectedText16 = "$698.00";
        String actualText16 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698')]"));
        Assert.assertEquals(expectedText16, actualText16);

        //2.38Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.39 Verify the Text “Thank you”
        String expectedText17 = "Thank you";
        String actualText17 = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedText17, actualText17);

        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedText18 = "Your order has been successfully processed!";
        String actualText18 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(expectedText18, actualText18);

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.42 Verify the text “Welcome to our store”
        String expectedText19 = "Welcome to our store";
        String actualText19 = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        Assert.assertEquals(expectedText19, actualText19);

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String verifyUrl = "https://demo.nopcommerce.com/";
        String verifyUrl1 = driver.getCurrentUrl();
        Assert.assertEquals(verifyUrl,verifyUrl1);
    }
    @After
    public void tearDown() {

        closeBrowser();
    }
}
