package C00_tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.	“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2.	Username kutusuna “standard_user” yazdirin
      //  WebElement usernameKutusu= driver.findElement(By.id("user-name"));
     //   usernameKutusu.sendKeys("standard_user");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //3.	Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //4.	Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //5.	Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunİsmi= driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        System.out.println(ilkUrunİsmi.getText());
        ilkUrunİsmi.click();
        //6.	Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7.	Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_badge")).click();
        //8.	Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepettekiUrun = driver.findElement(By.className("inventory_item_name"));
        String sepettekiUrunAdi=sepettekiUrun.getText();
        String arananKelime="Sauce Labs Backpack";
        if (sepettekiUrunAdi.equals(arananKelime)){
            System.out.println("Sectiginiz urun PASS");
        }else{
            System.out.println("Sectiginiz urun FAILED");
        }


        //9.	Sayfayi kapatin

        driver.close();
    }
}
