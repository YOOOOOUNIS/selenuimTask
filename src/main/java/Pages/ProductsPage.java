package Pages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsPage {

    private WebDriver driver;

    // Constructor to initialize WebDriver
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get product names and prices
    public void getProductsNamesAndPrices() {
        By productName = By.className("a-size-medium");  // Locator for product name
        By productPrice = By.className("a-price-whole"); // Locator for product price

        // Get list of all product names and prices
        List<WebElement> names = driver.findElements(productName);
        List<WebElement> prices = driver.findElements(productPrice);

        // Map to store product names and prices
        Map<String, String> products = new HashMap<>();


        // Loop to extract product names and prices and store them in the map
        for (int i = 0; i < names.size(); i++) {
            String nameText = names.get(i).getText();
            String priceText = prices.get(i).getText();
            System.out.println("Product Name: " + nameText + ", Price: " + priceText);
            products.put(nameText, priceText);  // Add to the map
        }

        // Save the product data to a JSON file
        saveToJsonFile(products, "products.json");

    }

    // Method to save the product map to a JSON file
    public void saveToJsonFile(Map<String, String> data, String filePath) {
        // Create a Gson object with pretty printing enabled
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convert the Map to a JSON string
        String jsonString = gson.toJson(data);

        // Write the JSON string to the specified file
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonString);
            System.out.println("Data saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
