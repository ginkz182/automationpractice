package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartModal extends HomePage {

    @FindBy(id = "layer_cart")
    WebElement cartModal;

    @FindBy(id = "layer_cart_product_title")
    WebElement cartProductName;

    @FindBy(id = "layer_cart_product_attributes")
    WebElement cartProductAttribute;

    @FindBy(id = "layer_cart_product_quantity")
    WebElement cartProductQty;

    @FindBy(css = "div#layer_cart a.button")
    WebElement proceedToCheckoutButton;

    WebDriverWait wait = new WebDriverWait(driver, 15);

    public CartModal() {
        PageFactory.initElements(driver, this);
    }

    public void waitPopupLoad() {
        wait.until(ExpectedConditions.visibilityOf(cartModal));
    }

    public String getProductName() {
        return cartProductName.getText();
    }

    public String getProductQty() {
        return cartProductQty.getText();
    }

    public String getProductSize() {
        return cartProductAttribute.getText().split(", ")[1];
    }

    public void clickProceedToCheckOutButton() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
    }
}
