import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class cartmenu {
    WebDriver driver;
    @Given("I open Browser to login")
    public void iOpenBrowserToLogin() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver");
        driver = new ChromeDriver();
    }

    @And("Located saucedemo website on login page")
    public void locatedSaucedemoWebsiteOnLoginPage()throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @And("I want Enter username {string}")
    public void iWantEnterUsername(String searchValue) {
        driver.findElement(By.name("user-name")).sendKeys(searchValue);
    }

    @And("I want Enter password {string}")
    public void iWantEnterPassword(String searchValue) {
        driver.findElement(By.name("password")).sendKeys(searchValue);
    }

    @And("I want tap login button with enter")
    public void iWantTapLoginButtonWithEnter() {

        driver.findElement(By.name("login-button")).click();
    }

    @When("I tap on add cart button")
    public void iTapOnAddCartButton() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("I go to  cart menu")
    public void iGoToCartMenu() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).isDisplayed());
        driver.close();
        driver.quit();

    }
}
