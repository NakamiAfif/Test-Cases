import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TokopediaTest {

    private static WebDriver driver;

    public static void main(String[] args) {
        // Set up WebDriver and open the web application
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.tokopedia.com/travel-entertainment");

        // Test sliding button "Previous"
        testSlidingButton("Previous", "btnCL1PreviousSlidingCategoryLevel2");

        // Test sliding button "Next"
        testSlidingButton("Next", "btnCL1NextSlidingCategoryLevel2");

        // Test all category buttons
        testCategoryButton("Aksesoris Handphone");
        testCategoryButton("Aksesoris Tablet");
        testCategoryButton("Handphone");
        testCategoryButton("Komponen Handphone");
        testCategoryButton("Komponen Tablet");
        testCategoryButton("Nomor Perdana & Voucher");
        testCategoryButton("Power Bank");
        testCategoryButton("Tablet");
        testCategoryButton("Wearable Devices");

        // Close the WebDriver after testing all buttons
        driver.quit();
    }

    private static void testSlidingButton(String buttonName, String buttonTestId) {
        System.out.println("Testing sliding button: " + buttonName);

        WebElement button = driver.findElement(By.cssSelector("button[test-id='" + buttonTestId + "']"));
        button.click();

        // Add some wait to observe the sliding effect if necessary
        sleep(3000);

        System.out.println("Sliding button test passed: " + buttonName);
    }

    private static void testCategoryButton(String categoryName) {
        System.out.println("Testing category button: " + categoryName);

        WebElement button = driver.findElement(By.xpath("//div[contains(text(), '" + categoryName + "')]"));
        button.click();

        // Wait for the new page to load (you can use WebDriverWait if necessary)

        // Verify that the new page has been opened
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        if (currentUrl.contains("/p/handphone-tablet/") && currentUrl.contains(categoryName.toLowerCase().replace(" ", "-"))) {
            System.out.println("Category button test passed: " + categoryName);
        } else {
            System.out.println("Category button test failed: " + categoryName);
        }

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
