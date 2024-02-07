package com.test.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SearchEngineTest extends SearchTestBase {

    @BeforeMethod
    @Parameters("searchEngine")
    public void setUp(@Optional String searchEngine) {
        String url = properties.getProperty(searchEngine + ".url");
        if (url == null) {
            System.out.println("Invalid search engine specified.");
            System.exit(1);
        }

        driver.get(url);
    }

    @Test
    @Parameters({"searchQuery", "expectedLinkText"})
    public void searchAndAssertResults(@Optional String searchQuery, @Optional String expectedLinkText) {
 
        // Perform a search (replace "your query" with the actual search query)
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchQuery);
        searchBox.submit();

        // Wait until the search results container is present
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#search"))); // Adjust the selector as needed

        // Find the first search result link
        WebElement firstResultLink = driver.findElement(By.cssSelector("div#search a"));

        // Print the link text
        String linkText = firstResultLink.getText();
        System.out.println("First Result Link Text: " + linkText);

        // Assert that the link text contains the search query
        // Assert that the link text contains the expected link text from TestNG parameters
        assertLinkTextContainsExpectedText(linkText, expectedLinkText);
    }

    private void assertLinkTextContainsExpectedText(String linkText, String expectedLinkText) {
        // Perform assertions on the link text
        // For example, check if the link text contains the expected text from TestNG parameters
        // Adjust assertions based on your requirements
        Assert.assertTrue(linkText.toLowerCase().contains(expectedLinkText.toLowerCase()),
                "Link text contains the expected text");
    }
    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}