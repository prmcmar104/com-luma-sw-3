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
public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        Thread.sleep(2000);
        // Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Men']"));
        // Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']"));
        // Click on Pants
        mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        // Mouse Hover on product name Cronus Yoga Pant and click on size 32.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverToElementAndClick(By.xpath("(//div[@class='swatch-option text'])[1]"));
        // Mouse Hover on product name Cronus Yoga Pant and click on colour Black.
        mouseHoverToElementAndClick(By.xpath("(//div[@class='swatch-option color'])[1]"));
        // Mouse Hover on product name Cronus Yoga Pant and click on ‘Add To Cart’ Button.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverToElementAndClick(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
        Thread.sleep(1000);
        // Verify the text You added Cronus Yoga Pant to your shopping cart.
        Assert.assertEquals("You added Cronus Yoga Pant to your shopping cart.",
                getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the text ‘Shopping Cart.'
        Assert.assertEquals("Shopping Cart",
                getTextFromElement(By.xpath("//span[@class='base']")));
        // Verify the product name ‘Cronus Yoga Pant’
        Assert.assertEquals("Cronus Yoga Pant",
                getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")));
        // Verify the product size ‘32’
        Assert.assertEquals("32",
                getTextFromElement(By.xpath("//dd[contains(text(),'32')]")));
        // Verify the product colour ‘Black’
        Assert.assertEquals("Black",
                getTextFromElement(By.xpath("//dd[contains(text(),'Black')]")));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
