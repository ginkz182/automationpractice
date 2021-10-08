Checkout Flow on HomePage
==================

Add Product to Cart and Verify Checkout Page
---------------------------------
* Given I am on homepage
* When I select an item and quick view
* And I change the quantity to "2" and size "M"
* And I click add to cart
* Then I should see correct product details in cart popup

* When I proceed to checkout page
* Then I should see the summary page with correct product details
