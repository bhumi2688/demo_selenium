import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class demo {


    protected static WebDriver driver;


    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","src\\Browserdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //implicit wait applied to driver instance
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //asking driver to get the url
        driver.get("https://demo.nopcommerce.com/") ;
        //register for new user
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
         //First name
        driver.findElement(By.xpath("//Input[@name='FirstName']") ).sendKeys("Bhumi");
        //Last Name
        driver.findElement(By.xpath("//Input[@name='LastName']")).sendKeys("Patel");
        String userName =""+(int)(Math.random()*Integer.MAX_VALUE );
        String emailId= "Maria"+userName+"@gmail.com";

        driver.findElement(By.xpath("//Input[@name='Email']") ).sendKeys(emailId );
        //System.out.println(emailID);
        //enter password
       driver.findElement(By.xpath("//Input[@name='Password']")).sendKeys("bhumi26");
       //Enter Confirm password
       driver.findElement(By.xpath("//Input[@name='ConfirmPassword']") ).sendKeys("bhumi26");
       //Click registration button
       driver.findElement(By.xpath("//Input[@name='register-button']") ).click();

        //actual register message appears
        String actualRegisterationSuccessMessage =driver.findElement(By.xpath("//div[@class=\"result\"]") ).getText();
        Assert.assertEquals("Your registration completed",actualRegisterationSuccessMessage );

        //driver instance
        driver.quit();










    }
}
