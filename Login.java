package pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath=("//input[@name='txtUsername']"))
	private WebElement Username;
	
	@FindBy(xpath=("//input[@name='txtPassword']"))
	private WebElement Password;
	
	@FindBy(xpath=("//input[@type='submit']"))
	private WebElement Login;
	
	public Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void sendUsername() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='txtUsername']")));
		Username.sendKeys("Admin");
	}
	
	public void sendPassword() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='txtPassword']")));
		Password.sendKeys("admin123");
	}
	
	public void clickOnLoginButton() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
		Login.click();
	}
}