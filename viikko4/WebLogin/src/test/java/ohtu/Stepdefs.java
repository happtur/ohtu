package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Stepdefs {
    WebDriver driver;
    String baseUrl = "http://localhost:4567";
    
    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();          
    } 
    
    @Given("^new user is selected$")
    public void new_user_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();          
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_and_password_are_given(String username, String password) throws Throwable {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }

    @Then("^system will respond \"([^\"]*)\"$")
    public void system_will_respond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @When("^incorrect username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void incorrect_username_is_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @When("^available and valid username \"([^\"]*)\" and valid password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are given$")
    public void correct_username_and_valid_password_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        createUser(username, password, passwordConfirmation);
    }
    
    @When("^too short username \"([^\"]*)\" and valid password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are given$")
    public void too_short_username_and_valid_password_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        createUser(username, password, passwordConfirmation);
    }
    
    @When("^available and valid username \"([^\"]*)\" and too short password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are given$")
    public void correct_username_and_too_short_password_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        createUser(username, password, passwordConfirmation);
    }
    
    @When("^available and valid username \"([^\"]*)\" and letter password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are given$")
    public void correct_username_and_letter_password_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        createUser(username, password, passwordConfirmation);
    }
    
    @When("^unavailable username \"([^\"]*)\" and valid password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are given$")
    public void unavailable_username_and_valid_password_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        createUser(username, password, passwordConfirmation);
    }
    
    @When("^available and valid username \"([^\"]*)\" and valid password \"([^\"]*)\" and incorrect password confirmation \"([^\"]*)\" are given$")
    public void correct_username_and_valid_password_and_wrong_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        createUser(username, password, passwordConfirmation);
    }
    
    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }
    
    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    
    @Then("^user is created$")
    public void user_is_created() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");
    }
    
    @Then("^user is not created and error \"([^\"]*)\" is reported")
    public void user_is_not_created(String errorMessage) throws Throwable {
        pageHasContent(errorMessage);
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 

    private void createUser(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit(); 
    }
}
