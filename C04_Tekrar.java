package day03_WebelementsLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Tekrar {
//1. Yeni bir class olusturun (TekrarTesti)










    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify),
        // eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
   driver.navigate().to("https://www.youtube.com");
   String actual=driver.getTitle();
   String expected="youtube";
   if (actual.equals(expected)){
       System.out.println("Youtube title testi PASS");
   }else{
       System.out.println("Youtube title testi FAILED \nactual sayfa basligi : "+actual);
   }
//3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.

String actualYoutubeUrl=driver.getCurrentUrl();
   String arananKelimeYoutubeUrl="youtube";
   if (actualYoutubeUrl.contains(arananKelimeYoutubeUrl)) {
       System.out.println("Youtube URL testi PASS");

   }else{
       System.out.println("Youtube URL testi FAILED \nactual Youtube url : "+actualYoutubeUrl);
   }
        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/

        driver.navigate().to("https:/www.amazon.com");

        //5. Youtube sayfasina geri donun
        driver.navigate().back();

        //6. Sayfayi yenileyin
        driver.navigate().refresh();


        //7. Amazon sayfasina donun
        driver.navigate().forward();
        //8. Sayfayi fulllscreen yapin
        driver.manage().window().fullscreen();
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        // Yoksa doğru başlığı(Actual Title) yazdırın.
             String actualAmazonTitle=driver.getTitle();
             String amazonArananKelime="Amazon";
               if (actualAmazonTitle.contains(amazonArananKelime)){
                    System.out.println("Amazon title testi PASS");

            }else {
                   System.out.println("Amazon title testi FAILED\nActual Amazon title : "+actualAmazonTitle);
    }
        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        String expectedAmazonUrl="https://www.amazon.com/";
        String actualAmazonUrl=driver.getCurrentUrl();
                if (expectedAmazonUrl.equals(actualAmazonUrl)){
                    System.out.println("Amazon URL testi PASS");
                }else{
                    System.out.println("Amazon URL testi FAILED\n actual Amazon URL : "+actualAmazonUrl);
                }
        //11.Sayfayi kapatin
        driver.close();
    }
}
