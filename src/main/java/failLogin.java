import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class failLogin {
    WebDriver driver;
    @Given("open Browser")
    public void openBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver");
        driver = new ChromeDriver();
    }

    @And("Located saucedemo site")
    public void locatedSaucedemoSite() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @And("Input username {string} and password {string}")
    public void inputUsernameAndPassword(String searchValue, String searchValue2) {
        driver.findElement(By.name("user-name")).sendKeys(searchValue);
        driver.findElement(By.name("password")).sendKeys(searchValue2);
    }

    @When("Hit login button")
    public void hitLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("Error pop up should be appear")
    public void errorPopUpShouldBeAppear() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed());
        driver.close();
        driver.quit();

    }
}
