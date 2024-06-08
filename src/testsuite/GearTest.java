package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Created by Jay Vaghani
 */
public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        Thread.sleep(2000);
        // Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));
        // Click on Bags
        mouseHoverToElementAndClick(By.xpath("//span[normalize-space()='Bags']"));
        // Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        // Verify the text ‘Overnight Duffle’
        Assert.assertEquals("Overnight Duffle",
                getTextFromElement(By.xpath("//span[@class='base']")));
        // Change Qty 3
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        Thread.sleep(1000);
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        Assert.assertEquals("You added Overnight Duffle to your shopping cart.",
                getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the product name ‘Overnight Duffle’
        Assert.assertEquals("Overnight Duffle",
                getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']")));
        //Verify the Qty is ‘3’
        Assert.assertEquals("3",
                getAttributeValue(By.xpath("//input[@title='Qty']"), "value"));
        // Verify the product price ‘$135.00’
        Assert.assertEquals("$135.00",
                getTextFromElement(By.xpath("(//span[@class='cart-price']//span)[2]")));
        // Change Qty to ‘5’
        sendTextToElement(By.xpath("(//input[@class='input-text qty'])[1]"), "5");
        // Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        Thread.sleep(1000);
        // Verify the product price ‘$225.00’
        Assert.assertEquals("$225.00",
                getTextFromElement(By.xpath("(//span[@class='cart-price']//span)[2]")));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}