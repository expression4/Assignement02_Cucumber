package ass.stepdef;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class planningAMeeting {

    @Before
    public void create(){
        WebDriverManager webDriverManager = WebDriverManager.getInstance("chrome");
        webDriverManager.setup();
        System.out.println("Downloaded version : " + webDriverManager.getDownloadedDriverVersion());
        System.out.println("Path :" + webDriverManager.getDownloadedDriverPath());
    }
    WebDriver driver;

    @Given("Sign-in to JioMeet stage")
    public void sign_in_to_jio_meet_stage_https_rc_jiomeet_jio_com() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(options);
        driver.get("https://rc.jiomeet.jio.com/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("Click on Plan a meeting option")
    public void click_on_plan_a_meeting_option() {
        driver.findElement(By.xpath("//div[text()='Plan a Meeting']")).click();
        driver.findElement(By.id("username")).sendKeys("e2e_x6hghgyuer@getnada.com");
        driver.findElement(By.id("proceedButton")).click();
        driver.findElement(By.id("password")).sendKeys("Passw0rd!");
        driver.findElement(By.id("signinButton")).click();
        driver.findElement(By.xpath("//div[text()='Plan a Meeting']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Then("Select checkbox and Don’t allow Guest user")
    public void select_checkbox_don_t_allow_guest_user() {
        driver.findElement(By.xpath("//label[@for='defaultUnchecked2']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @And("Scroll till Schedule button")
    public void scroll_till_schedule_button() {
        WebElement scroll = driver.findElement(By.xpath("//button[@type='submit']"));
        Actions action = new Actions(driver);
        action.moveToElement(scroll);
        action.perform();
    }

    @And("Click on Close button in the displayed window")
    public void click_on_close_button_in_the_displayed_window() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[text()=' Close ']")).click();
    }

    @After
    public void quit(){
        driver.quit();
    }
}