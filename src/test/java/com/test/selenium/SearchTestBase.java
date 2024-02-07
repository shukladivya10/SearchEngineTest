package com.test.selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SearchTestBase {
    protected WebDriver driver;
    protected Properties properties;

    public SearchTestBase() {
        loadProperties();
        initializeDriver();
    }

    private void loadProperties() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                System.err.println("Unable to find config.properties in the classpath.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private void initializeDriver() {
		WebDriverManager.chromedriver().browserVersion("121.0.6167.139").setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}