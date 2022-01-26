package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Alerts {
//● Bir class olusturun: Alerts

    WebDriver driver;
    WebElement sonucYazisiElementi;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

}
    @Test
    public void acceptAlertsTest(){

//● Bir metod olusturun: acceptAlert
//1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
// “You successfully clicked an alert” oldugunu test edin.
        sonucYazisiElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String expectedSonucYazisi="You successfully clicked an alert";
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);

}
    @Test
    public void dismissAlertsTest(){

//● Bir metod olusturun: dismissAlert
//2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();


// result mesajının “successfuly” icermedigini test edin.
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String istenmeyenKelime="successfuly";
        Assert.assertFalse(actualSonucYazisi.contains(istenmeyenKelime));

    }
    @Test
    public void sendKeyAlertsTest(){

//● Bir metod olusturun: sendKeysAlert
//3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna     tıklayın ve
     driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
     driver.switchTo().alert().sendKeys("Nafiz");
     driver.switchTo().alert().accept();
// result mesajında isminizin görüntülendiğini doğrulayın
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String arananKelime="Nafiz";
        Assert.assertTrue(actualSonucYazisi.contains(arananKelime));

    }

    @AfterClass
    public void tearDown(){




    }



}
