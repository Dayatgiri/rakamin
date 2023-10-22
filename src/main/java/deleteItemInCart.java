import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class deleteItemInCart {
    WebDriver driver;
    @Given("Iwant open Browser to login")
    public void iwantOpenBrowserToLogin() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver");
        driver = new ChromeDriver();
    }

    @And("I Located saucedemo website on login page")
    public void iLocatedSaucedemoWebsiteOnLoginPage() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @And("I  Enter username {string}")
    public void iEnterUsername(String searchValue) {
        driver.findElement(By.name("user-name")).sendKeys(searchValue);
    }

    @And("I  Enter password {string}")
    public void iEnterPassword(String searchValue) {
        driver.findElement(By.name("password")).sendKeys(searchValue);
    }

    @And("I  tap login button with enter")
    public void iTapLoginButtonWithEnter() {
        driver.findElement(By.name("login-button")).sendKeys(Keys.ENTER);
    }
    @And("tap on add cart button")
    public void tapOnAddCartButton() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).sendKeys(Keys.ENTER);
    }

    @And("I want go to  cart menu")
    public void iWantGoToCartMenu() throws InterruptedException {
        driver.get("https://www.saucedemo.com/cart.html");
        Thread.sleep(1000);
        driver.findElement(By.name("continue-shopping")).isDisplayed();
    }

    @When("I delete item in cart")
    public void iDeleteItemInCart() {
        driver.findElement(By.name("remove-sauce-labs-backpack")).sendKeys(Keys.ENTER);
    }

    @Then("I back to product menu")
    public void iBackToProductMenu() {
        driver.findElement(By.name("continue-shopping")).sendKeys(Keys.ENTER);
        driver.close();
        driver.quit();
    }


}
