import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
BaseUrl = https://courses.ultimateqa.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Click on ‘Sign In’ link
7. Print the current url
8. Enter the email to email field.
9. Enter the password to password field.
10. Click on Login Button.
11. Navigate to baseUrl.
12. Navigate forward to Homepage.
13. Navigate back to baseUrl.
14. Refresh the page.
15. Close the browser.
 */
public class MultiBrowserTest {
    //BaseUrl = https://courses.ultimateqa.com/
    static String baseUrl = "https://courses.ultimateqa.com/";

    //1. Setup Chrome browser
    static String browser = "Chrome";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        //2. Open URL
        driver.get(baseUrl);

        //3. Print the title of the page.
        String title = driver.getTitle();
        System.out.println("Title of the Page :"+title);

        //4. Print the current url
        System.out.println("The Current Url :" + driver.getCurrentUrl());

        //5. Print the page source.
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        //6. Click on ‘Sign In’ link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        Thread.sleep(5000);

        //7. Print the current url
        System.out.println("The Current Url :"+ driver.getCurrentUrl());

        //8. Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("abc123@aol.com");

        //9. Enter the password to password field
        WebElement passField = driver.findElement(By.id("user[password]"));
        passField.sendKeys("Password");

        //10. Click on Login Button
        WebElement logInLink = driver.findElement(By.xpath("//button[@type='submit']"));
        logInLink.click();
        Thread.sleep(5000);

        //11. Navigate to baseUrl
        driver.navigate().to(baseUrl);

        //12. Navigate forward to Homepage
        driver.navigate().forward();
        Thread.sleep(5000);

        //13. Navigate back to baseUrl
        driver.navigate().to(baseUrl);

        //14. Refresh the page
        driver.navigate().refresh();

        //close the browser
        driver.quit();
    }

}

