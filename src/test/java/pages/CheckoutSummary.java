package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutSummary extends BasePage {

    @FindBy(id = "cart_summary")
    WebElement cartSummaryTable;

    @FindBy(css = "tr.first_item p.product-name")
    WebElement firstProductName;

    @FindBy(css = "tr.first_item td.cart_description")
    WebElement firstProductDesc;

    @FindBy(css = "tr.first_item input.cart_quantity_input")
    WebElement firstProductQty;

    WebDriverWait wait = new WebDriverWait(driver, 15);

    public CheckoutSummary() {
        PageFactory.initElements(driver, this);
    }

    public String getFirstProductName() {
        return firstProductName.getText();
    }

    public String getFirstProductQuantity() {
        return firstProductQty.getAttribute("value");
    }

    public String getFirstProductSize() {
        return firstProductDesc.getText().split("Size : ")[1];
    }

    public void waitPageLoad() {
        wait.until(ExpectedConditions.visibilityOf(cartSummaryTable));
    }
}
