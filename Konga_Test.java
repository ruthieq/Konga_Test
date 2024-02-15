
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Konga_Test {

    //import the selenium webDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        // locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver/chromedriver.exe");
        //1.Open your Chrome browser
        driver = new ChromeDriver();
        // 2.Input your Konga Demo Page URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on the Login/Signup button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void positiveLogin() throws InterruptedException {
        //5. Input your Email Address on the Email Address field
        driver.findElement(By.id("username")).sendKeys("ruthiestar@yopmail.com");
        //6. Input your password on the password field
        driver.findElement(By.id("password")).sendKeys("Toluwa2#");
        //7. Click on Login
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 1)
    public void clickonAccesories() throws InterruptedException {
        //8. From All Categories, click on "Computers and Accesories"
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //9.  Click on the Laptop SubCategory
        driver.findElement(By.xpath(" //*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[2]/a/label/span")).click();
        Thread.sleep(5000);
        //10. Click on the Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(5000);
        //11. Add an item to cart(Apple Macbook Pro 13.3" Laptop)
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);
        //12. Click on My Cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(5000);
        //13. Click on Checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(10000);

    }

    @Test (priority = 2)
    public void paymentOption() throws InterruptedException {
        //17. Click on Pay Now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(5000);
        //18. Continue to Make Payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(10000);

    }

    @Test (priority = 3)
    public void invalidCardDetails() throws InterruptedException {
        //19i. Switch to iFrame view
        WebElement paymethod = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(5000);
        System.out.println("Payment Method");
        //19ii. Select Payment Method(Card)
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[3]/button/div/span[1]")).click();
        Thread.sleep(5000);
        //20. Input Invalid Card Number
        driver.findElement(By.id("card-number")).sendKeys("0123456789101");
        Thread.sleep(5000);
        //21. Input Date
        driver.findElement(By.id("expiry")).sendKeys("11/24");
        Thread.sleep(5000);
        //22. Input CVV
        driver.findElement(By.id("cvv")).sendKeys("123");
        Thread.sleep(5000);
        //23. Input Card Pin
        driver.findElement(By.xpath("//*[@id=\"card-pin-new\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[4]")).click();
        Thread.sleep(5000);
        //24. Click on Pay Now
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        Thread.sleep(5000);
        //25.Print Out Error Message
        WebElement error = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(error.getText());
        Thread.sleep(5000);
        //26. Close iFrame that displays card details
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(10000);
    }

    @AfterTest

    public void closebrowser() {
        //27. Quit the browser
        driver.quit();
    }
}





