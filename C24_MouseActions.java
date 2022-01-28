package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class C02_MouseActions extends TestBase {

    @Test
    public void amazonList() throws InterruptedException {
    //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
    //sağ üstte hello,signIn elementinin üzerinde mouse bekletin
    //açılan menü de new list linkine tiklayın
        Actions actions=new Actions(driver) ;
        WebElement helloElement = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(helloElement).perform();
        Thread.sleep(3000);
        WebElement createList= driver.findElement(By.xpath("//span[.='Create a List']"));
        actions.click(createList).perform();
        Thread.sleep(5000);

    //new list sayfasını açıldıgını test edin


}
}