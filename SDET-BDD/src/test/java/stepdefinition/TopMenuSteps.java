package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.BasePage;

public class TopMenuSteps extends BasePage {
	

    public TopMenuSteps(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Given("I want to navigate to the HCLTech website")
    public void i_want_to_navigate_to_the_hcl_tech_website() throws IOException {
        System.out.println("Navigating to HCLTech");
        initBrowser();
        acceptAllCookies();
    }

    @Then("I want to get the total count of menu items")
    public void i_want_to_get_the_total_count_of_menu_items() {
        System.out.println("Get total Main menu count and Sub menu count");
    }

    @Then("I want to display the Sub Menus with their corresponding Main Menu in the console")
    public void i_want_to_display_the_sub_menus_with_their_corresponding_main_menu_in_the_console() {
        System.out.println("Displaying Main menus and Sub menus");
    }
    
    public void initBrowser() throws IOException {
    	WebDriver driver = null;
    	FileInputStream fis;
    	Properties prop;
    	Properties envProp = null;
		fis = new FileInputStream("src\\test\\resources\\envProperties\\Configuration\\config.properties");
		prop = new Properties();
		prop.load(fis);

		if(prop.getProperty("ENV").equalsIgnoreCase("SIT")) {
			fis = new FileInputStream("src\\test\\resources\\envProperties\\SIT\\url.properties");
			envProp = new Properties();
			envProp.load(fis);
		} else if(prop.getProperty("ENV").equalsIgnoreCase("FT")) {
			fis = new FileInputStream("src\\test\\resources\\envProperties\\FT\\url.properties");
			envProp = new Properties();
			envProp.load(fis);
		}

		if(prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(prop.getProperty("Browser").equalsIgnoreCase("Mozilla")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(envProp.getProperty("homePage"));

	}
}
