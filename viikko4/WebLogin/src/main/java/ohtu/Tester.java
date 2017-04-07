package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //onnistunut login, oikea-käyttäjätunnus, oikea-salasana
        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(5);

        //epäonnistunut login, o-k, v-s
        driver.get("http://localhost:4567/login");
        sleep(2);
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));
        sleep(2);
        element.submit();
        sleep(5);
        
        //epäonnistunut login, v-k
        driver.get("http://localhost:4567/login");
        sleep(2);
        element = driver.findElement(By.name("username"));
        element.sendKeys("kalle");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));
        sleep(2);
        element.submit();
        sleep(5);

        //uuden käyttäjätunnuksen luominen
        driver.get("http://localhost:4567/");
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(2);
        element = driver.findElement(By.name("username"));
        element.sendKeys("pelle");
        element = driver.findElement(By.name("password"));
        element.sendKeys("ellep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("ellep");
        element = driver.findElement(By.name("signup"));
        sleep(2);
        element.submit();
        sleep(5);

        //logout
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(3);
        element = driver.findElement(By.linkText("logout"));
        element.click();


        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
