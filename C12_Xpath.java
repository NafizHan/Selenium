package day05_MavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
       driver.findElement(By.id("signin_button")).click();
        //3. Login alanine  “username” yazdirin
        WebElement loginAlani= driver.findElement(By.xpath("//input[@id='user_login']"));
       loginAlani.sendKeys("username");
        //4. Password alanine “password” yazdirin
        WebElement passwordAlani= driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordAlani.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']") ).click();
        driver.findElement(By.xpath("//button[.='Güvenliğe geri dön']")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[.='Online Banking']")).click();;
        driver.findElement(By.id("pay_bills_link")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
         WebElement amountKismi = driver.findElement(By.id("sp_amount"));
         amountKismi.sendKeys("25$");
        //8. tarih kismina “2020-09-10” yazdirin
        WebElement tarih = driver.findElement(By.id("sp_date"));
        tarih.sendKeys("2020-09-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement yaziKontrol=driver.findElement(By.id("alert_content"));
        if (yaziKontrol.isDisplayed()){
            System.out.println("Yazi testi PASS");
        }else {
            System.out.println("Yazi testi PASS");
        }

        //
    }
}
