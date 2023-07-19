package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    private static WebDriver driver;

    public static void main(String[] args) {
        // Set up WebDriver and open the web application
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.tokopedia.com/travel-entertainment");

        // Test button "Tiket Pesawat"
        testButton("Tiket Pesawat", "https://www.tokopedia.com/flight/");

        // Wait for 5 seconds before testing the next button
        sleep(10000);

        // Test button "Tiket Kereta Api"
        testButton("Tiket Kereta Api", "https://tiket.tokopedia.com/kereta-api/?ispulsa=1");

        // Wait for 5 seconds before testing the next button
        sleep(10000);

        // Test button "Hotel"
        testButton("Hotel", "https://www.tokopedia.com/hotel/");

        // Wait for 5 seconds before testing the next button
        sleep(10000);

        // Test button "Food & Voucher"
        testButton("Food & Voucher", "https://www.tokopedia.com/deals?ispulsa=1");

        // Wait for 5 seconds before testing the next button
        sleep(10000);

        // Test button "Tiket Event"
        testButton("Tiket Event", "https://www.tokopedia.com/events/");

        // Wait for 5 seconds before testing the next button
        sleep(10000);

        // Test button "Hiburan"
        testButton("Hiburan", "https://www.tokopedia.com/events/search?tags=&child_category_ids=3");

        // Wait for 5 seconds before testing the next button
        sleep(10000);

        // Test button "m.tix XXI"
        testButton("m.tix XXI", "https://www.tokopedia.com/top-up/mtix/");

        // Wait for 5 seconds before testing the next button
        sleep(10000);

        // Test button "Streaming"
        testButton("Streaming", "https://www.tokopedia.com/streaming/");

        // Wait for 5 seconds before testing the next button
        sleep(10000);

        // Test button "Voucher Game"
        testButton("Voucher Game", "https://www.tokopedia.com/voucher-game/");

        // Wait for 5 seconds before testing the next button
        sleep(10000);

        // Test button "Uang Elektronik"
        testButton("Uang Elektronik", "https://www.tokopedia.com/top-up/emoney/");

        // Close the WebDriver after testing all buttons
        driver.quit();
    }

    private static void testButton(String buttonLabel, String buttonLink) {
        System.out.println("Testing button: " + buttonLabel);

        WebElement button = driver.findElement(By.xpath("//a[@class='c_item' and div[@class='c_label' and text()='" + buttonLabel + "']]"));
        button.click();

        // Wait for the new page to load (you can use WebDriverWait if necessary)

        // Verify that the new page has been opened
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals(buttonLink)) {
            System.out.println("Test Case Passed: Successfully opened the '" + buttonLabel + "' page.");
        } else {
            System.out.println("Test Case Failed: Unable to open the '" + buttonLabel + "' page.");
        }
        sleep(5000);

        // Go back to the previous page
        driver.navigate().back();
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
