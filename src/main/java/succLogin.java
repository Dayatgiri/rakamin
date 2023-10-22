import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class succLogin {
    WebDriver driver;
    @Given("I Went open Browser")
    public void iWentOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver");
        driver = new ChromeDriver();
    }

    @And("I Located saucedemo website")
    public void iLocatedSaucedemoWebsite() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @And("I Enter right username {string} and password {string}")
    public void iEnterRightUsernameAndPassword(String searchValue, String searchValue2) {
        driver.findElement(By.name("user-name")).sendKeys(searchValue);
        driver.findElement(By.name("password")).sendKeys(searchValue2);
    }

    @When("I tap login button")
    public void iTapLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("redirect to main menu")
    public void redirectToMainMenu() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header_secondary_container']")).isDisplayed());
        driver.close();
        driver.quit();

    }
}
