package TestPackage;

import Pages.ProductsPage;
import org.testng.annotations.Test;
import Base.BaseTests;

public class GetProducts extends BaseTests {


    @Test
    public void searchForProductAndGetElement() {
        ProductsPage productsPage = homePage.sendkeysToSearchElement();
        productsPage.getProductsNamesAndPrices();
    }

}
