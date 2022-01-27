package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void handleWindow() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String windowHandleDegeri1= driver.getWindowHandle();
        System.out.println("ilk sayfanin window handle degeri : "+ driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String windowHandleDegeri2= driver.getWindowHandle();
        System.out.println("yeni acilan sayfanin window handle degeri : "+ driver.getWindowHandle());

        Set<String> handleDegerleri= driver.getWindowHandles();
        System.out.println(handleDegerleri);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");

//amazonun acık kaldıgı sayfay gec vre nuterlla araması yap
   driver.switchTo().window(windowHandleDegeri1);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

//best buy  acik olan sayfay gec ve title de Best Buy  içerdiğini test ediniz
        driver.switchTo().window(windowHandleDegeri2);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

//facebook un acık oldugu sayfaya geçin
//ve url nin    https://www.facebook.com oldugunu test ediniz

        Set<String> handleDegerleriSet = driver.getWindowHandles();

        String windowHandleDegeri3="";

        for (String each:handleDegerleriSet
             ) {
            if (!(each.equals(windowHandleDegeri1) || each.equals(windowHandleDegeri2) )){
                windowHandleDegeri3=each;
            }
        }
        System.out.println(windowHandleDegeri3);
        System.out.println(handleDegerleriSet);

        driver.switchTo().window(windowHandleDegeri3);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

    Thread.sleep(5000);
    }
    @AfterClass
    public  void teardown(){

        driver.quit();
    }
}
