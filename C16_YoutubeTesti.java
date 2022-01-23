package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeTesti {
    //1) Bir class oluşturun: YoutubeAssertions
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

    static WebDriver driver;
    @BeforeClass
    public  static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");

    }
    @Test
    public void titleTest(){
        //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle= driver.getTitle();
        String expectedtitle="YouTube";
        Assert.assertEquals("TitleTest gozden geciriniz",expectedtitle,actualTitle);

    }
    @Test
    public void imageTest(){
        //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
        Assert.assertTrue("ImageTest gozden geciriniz",image.isDisplayed());

    }
    @Test
    public void searchBoxTest(){
        //     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox= driver.findElement(By.xpath("//input[@name='search_query']"));
        Assert.assertTrue("SearchBoxTest gozden geciriniz", searchBox.isEnabled());

    }
    @Test
    public void wrongTitleTest(){
        //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle= driver.getTitle();
        String expectedtitle="youtube";
        Assert.assertFalse("WrongTitleTest gozden geciriniz",actualTitle.contains(expectedtitle));

    }
    @AfterClass
    public static void teardown(){

       driver.close();
    }

}
