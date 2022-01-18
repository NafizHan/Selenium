package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //biz driver objesi olusturdugumuzda bos bir chrome browser açılır

       driver.get("https://www.amazon.com");
    //driver.get metodu driver a gideceği web adresini girmemizi sağlar.
    Thread.sleep(3000);
        //3 saniye açık kalır

        driver.close();
    //driver'i kapatır
    }

}
