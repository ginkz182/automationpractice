package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(css = "ul.product_list div.product-image-container")
    WebElement firstProductCard;

    @FindBy(css = "ul#homefeatured li.hovered a.quick-view")
    WebElement firstCardQuickView;

    @FindBy(css = "div.fancybox-overlay")
    WebElement overlayBox;

    @FindBy(css = "div.fancybox-overlay iframe")
    WebElement overlayIframe;

    WebDriverWait wait = new WebDriverWait(driver, 15);
    String HOME_URL = "http://automationpractice.com/index.php";

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get(HOME_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("homefeatured")));
    }

    public void hoverFirstProduct() {
        scrollToElement(firstProductCard);

        Actions action = new Actions(driver);
        action.moveToElement(firstProductCard).perform();
    }

    public void clickQuickView() {
        wait.until(ExpectedConditions.visibilityOf(firstCardQuickView));
        firstCardQuickView.click();
    }

    public void switchToProductIframe() {
        wait.until(ExpectedConditions.visibilityOf(overlayBox));
        driver.switchTo().frame(overlayIframe);
    }

}
