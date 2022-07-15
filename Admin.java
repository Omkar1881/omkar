package pomPackage;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//b[text()='Admin']")
	private WebElement admin;
	
	@FindBy(xpath="//input[@id='searchSystemUser_userName']")
	private WebElement UserName;
	
	@FindBy(xpath="//select[@name='searchSystemUser[userType]']")
	private WebElement UserRole;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement EmployeeName;
	
	@FindBy(xpath="//select[@name='searchSystemUser[status]']")
	private WebElement Status;
	
	@FindBy(xpath="(//input[@name='chkSelectRow[]'])[18]")
	private WebElement Checkbox;
	
	public Admin(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void clickOnAdmin()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Admin']")));
		admin.click();
	}
	
	public void clickOnUserName()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchSystemUser_userName']")));
		UserName.sendKeys("Admin");
	}
	
	public void clickOnUserRole() throws IOException 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='searchSystemUser[userType]']")));
		Select se = new Select(UserRole);
		se.selectByVisibleText("Admin");
	}
	
	public void clickOnEmployeeName() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[2]")));
		EmployeeName.click();
		EmployeeName.sendKeys("Joe Root");
	}
	
	public void clickOnStatus() throws InterruptedException
	{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='searchSystemUser[status]']")));
		Select se = new Select(Status);
		se.selectByVisibleText("Enabled");
	}
	
	public void clickOnCheckbox() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='chkSelectRow[]'])[18]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Checkbox);
		Checkbox.click();
	}
}
