package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductIframe extends HomePage {

    //Iframe Elements
    @FindBy(id = "quantity_wanted")
    WebElement quantityInput;

    @FindBy(id = "group_1")
    WebElement sizeDropdown;

    @FindBy(css = "i.icon-plus")
    WebElement plusIcon;

    @FindBy(css = "h1[itemprop]")
    WebElement productName;

    @FindBy(css = "p#add_to_cart button")
    WebElement addToCartButton;

    public ProductIframe() {
        PageFactory.initElements(driver, this);
    }

    public void setQuantity(String qty) {
        quantityInput.clear();
        quantityInput.sendKeys(qty);
    }

    public void selectSize(String size) {
        Select sizeSelect = new Select(sizeDropdown);
        sizeSelect.selectByVisibleText(size);
    }

    public String getProductNameFromModal() {
        return productName.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
        driver.switchTo().parentFrame();
    }

}
