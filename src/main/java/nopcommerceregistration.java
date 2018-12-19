
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;



public class nopcommerceregistration {

    protected static WebDriver driver;

    static String expectedRegisterSuccessMessage = "Your registration completed";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src\\browserdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        // OPEN URL
        driver.get("https://demo.nopcommerce.com");
        System.out.println("url open");
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        driver.findElement(By.xpath("//input[@ value='M']")).click();
        // driver.findElement(By.xpath("//input[@id='gender-male']    ")).click();
        driver.findElement(By.xpath("//input[@id=\"FirstName\"]")).sendKeys("nilesh");
        driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("patel");

        Select day = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")));
        day.selectByIndex(3);
        Select month = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]")));
        month.selectByVisibleText("January");
        Select year = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]")));
        year.selectByValue("1979");
        DateFormat dt = new SimpleDateFormat("MMddYYHHMMSS");
        Date date = new Date();
        String date1 = dt.format(date);
        driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("dasabc" + date1 + "@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"Company\"]")).sendKeys("dasgroup");
        WebElement checkbox = driver.findElement(By.xpath("//input[@id=\"Newsletter\"]"));
        checkbox.isSelected();
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id=\"register-button\"]")).click();
        String actualRegisterSuccessMessage = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();

        Assert.assertEquals("Test case failed", expectedRegisterSuccessMessage, actualRegisterSuccessMessage);
        //Assert.assertEquals("Test case is Passed",expectedRegisterSuccessMessage,actualRegisterSuccessMessage);
        driver.findElement(By.xpath("//a[@class=\"ico-logout\"]"));
        driver.quit();


    }



    @Test
    public void currency() {
        System.setProperty("webdriver.chrome.driver", "src\\browserdriver\\chromedriver.exe");
        driver = new

                ChromeDriver();
        driver.manage().

                timeouts().

                implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().

                window().

                fullscreen();
        driver.get("https://demo.nopcommerce.com");


    }
}