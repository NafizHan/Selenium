package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {
//1- Bir Class olusturalim KeyboardActions2

@Test
    public void test01() throws InterruptedException {
    //2- https://html.com/tags/iframe/ sayfasina gidelim
    driver.get("https://html.com/tags/iframe/");
// 3- video’yu gorecek kadar asagi inin
    Actions actions=new Actions(driver);
    actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

//4- videoyu izlemek icin Play tusuna basin
    WebElement iframe= driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
    driver.switchTo().frame(iframe);
    WebElement playTusuElemanı=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
    playTusuElemanı.click();


    //5- videoyu calistirdiginizi test edin
    WebElement pauseButton=driver.findElement(By.xpath("//button[@title='Duraklat (k)']"));
    pauseButton.click();
    Assert.assertTrue(pauseButton.isEnabled());
    Thread.sleep(10000);
    driver.switchTo().parentFrame();


}

}
