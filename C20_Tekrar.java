package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

// Navigate to website  https://testpages.herokuapp.com/styled/index.html
     driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

// Under the  ORIGINAL CONTENTS
// click on Alerts
        driver.findElement(By.xpath("//a[@id='alerts']")).click();
// print the URL
        String URL= driver.getCurrentUrl();
        System.out.println("1.URL : "+URL);
// navigate back
        driver.navigate().back();
// print the URL
        String URL2= driver.getCurrentUrl();
        System.out.println("2.URL : "+URL2);
// Click on Basic Ajax
        driver.findElement(By.xpath("//a[@id='basicajax']")).click();
// print the URL
        String URL3= driver.getCurrentUrl();
        System.out.println("3.URL : "+URL3);
// enter value-> 20 and Enter
        WebElement value= driver.findElement(By.id("lteq30"));
        value.sendKeys("20"+ Keys.ENTER);
// and then verify Submitted Values is displayed open page
        WebElement verify = driver.findElement(By.xpath("//p[.='Submitted Values']"));
        if (verify.isDisplayed()){

            System.out.println("verify test PASS");
        }else {
            System.out.println("verify test  FAILED");
        }

// close driver
        driver.close();




    }


}
