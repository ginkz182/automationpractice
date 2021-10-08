package steps;

import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import pages.CartModal;
import pages.CheckoutSummary;
import pages.HomePage;
import pages.ProductIframe;

public class HomePageProductsSteps {

    HomePage homePage = new HomePage();
    ProductIframe productIframe = new ProductIframe();
    CartModal cartModal = new CartModal();
    CheckoutSummary checkoutSummary = new CheckoutSummary();

    String selectedQty, selectedSize, selectedProductName;

    @Step("Given I am on homepage")
    public void navigateToHomePage() {
        homePage.navigateToHomePage();
    }

    @Step("When I select an item and quick view")
    public void selectFirstItem() {
        homePage.hoverFirstProduct();
        homePage.clickQuickView();
    }

    @Step("And I change the quantity to <qty> and size <size>")
    public void changeQuantityAndSize(String qty, String size) {
        homePage.switchToProductIframe();
        productIframe.setQuantity(qty);
        productIframe.selectSize(size);

        //store expected value
        selectedQty = qty;
        selectedSize = size;
        selectedProductName = productIframe.getProductNameFromModal();
    }

    @Step("And I click add to cart")
    public void clickAddToCart() {
        productIframe.clickAddToCartButton();
    }

    @Step("Then I should see correct product details in cart popup")
    public void verifyProductCart() {
        cartModal.waitPopupLoad();
        Assertions.assertEquals(selectedProductName, cartModal.getProductName(),
                "Product Name doesn't match selected");
        Assertions.assertEquals(selectedQty, cartModal.getProductQty(),
                "Product Quantity doesn't match selected");
        Assertions.assertEquals(selectedSize, cartModal.getProductSize(),
                "Product Size doesn't match selected");
    }

    @Step("When I proceed to checkout page")
    public void proceedToCheckOut() {
        cartModal.clickProceedToCheckOutButton();
    }

    @Step("Then I should see the summary page with correct product details")
    public void verifySummaryPage() {
        checkoutSummary.waitPageLoad();
        Assertions.assertEquals(selectedProductName, checkoutSummary.getFirstProductName(),
                "Product Name doesn't match selected");
        Assertions.assertEquals(selectedQty, checkoutSummary.getFirstProductQuantity(),
                "Product Quantity doesn't match selected");
        Assertions.assertEquals(selectedSize, checkoutSummary.getFirstProductSize(),
                "Product Size doesn't match selected");
    }
}
