package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    // ...Exercise3...




    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.id("cookieChoiceDismiss")).click();
        //fill the firstname
       WebElement firstname= driver.findElement(By.xpath("//input[@name='firstname']"));
       firstname.sendKeys("Nafiz");
        //fill the lastname
        WebElement lastname= driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("Han");
        //check the gender
        driver.findElement(By.xpath("//input[@id='sex-0']")).click();
        //check the experience
        driver.findElement(By.xpath("//input[@id='exp-0']")).click();
        //fill the date
        WebElement date=driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.sendKeys("26.06.1992");
        //choose your profession -> Automation Tester
        WebElement prof=   driver.findElement(By.id("profession-1"));
        prof.click();
        prof.sendKeys(Keys.PAGE_DOWN);
        //choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        //choose your continent -> Antartica
        driver.findElement(By.xpath("//option[.='Antartica']")).click();
        //choose your command  -> Browser Commands
        driver.findElement(By.xpath("//option[.='Browser Commands']")).click();
        //click submit button
        driver.findElement(By.xpath("//button[.='Button']")).click();
    }
}
