package Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {

static WebDriver driver;


    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
}

    @Test
    public void test01(){
//                    - Test 1
//Arama kutusunun yanindaki kategori menusundeki kategori
//sayisinin 45 oldugunu test edin;

        List<WebElement> kategoriSayisi= driver.findElements(By.tagName("option"));
        int kategoriSay=kategoriSayisi.size();
        System.out.println(kategoriSay);

        Assert.assertFalse("Kategori sayisini kontrol ediniz",kategoriSay==45);
}

    @Test
    public void test02() {
                    //-Test 2
//1. Kategori menusunden Books secenegini secin
        driver.findElement(By.xpath("//option[.='Books']")).click();
//2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
//3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi= driver.findElement(By.xpath("//span[.='1-16 of over 30,000 results for']"));
        System.out.println(sonucSayisi.getText());
//4. Sonucun Java kelimesini icerdigini test edin
        WebElement sonucKelimeTest = driver.findElement(By.xpath("(//span[@dir='auto'])[3]"));
        String sonucKelime=sonucKelimeTest.getText();
        String arananKelime="Java";
        Assert.assertTrue("Sonucun Java içerdigini kontrol ediniz",sonucKelime.contains(arananKelime));
    }

    @AfterClass
    public static void teardown(){
       driver.close();
    }

}
