package pomPackage;

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

public class PIMmodule {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//b[contains(text(),'PIM')]")
	private WebElement PIM;
	
	@FindBy(xpath="//input[@class='ac_loading']")
	private WebElement EmployeeName;
	
	@FindBy(xpath="//input[@id='empsearch_id']")
	private WebElement Id;
	
	@FindBy(xpath="//select[@id='empsearch_employee_status']")
	private WebElement EmploymentStatus;
	
	@FindBy(xpath="//select[@id='empsearch_termination']")
	private WebElement Include;
	
	@FindBy(xpath="//input[@id='empsearch_supervisor_name']")
	private WebElement SupervisorName;
	
	@FindBy(xpath="//select[@id='empsearch_job_title']")
	private WebElement JobTitle;
	
	@FindBy(xpath="//select[@id='empsearch_sub_unit']")
	private WebElement SubUnit;
	
	@FindBy(xpath="//input[@id='searchBtn']")
	private WebElement SearchButton;
	
	public PIMmodule(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void clickOnPIM() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'PIM')]")));
		PIM.click();
	}
	
	public void validateEmployeeName() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='ac_loading']")));
		EmployeeName.sendKeys("Kiya");
	}
	
	public void validateId() 
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='empsearch_id']")));
		Id.sendKeys("0239");
	}
	
	public void validateEmploymentStatus() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='empsearch_employee_status']")));
		Select se = new Select(EmploymentStatus);
		se.selectByValue("1");
	}
	
	public void validateInclude() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='empsearch_termination']")));
		Select se = new Select(Include);
		se.selectByValue("2");
	}
	
	public void validateSupervisorName() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='empsearch_supervisor_name']")));
		SupervisorName.sendKeys("Gunji Manohar");
	}
	
	public void validateJobTitle() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='empsearch_job_title']")));
		Select se = new Select(JobTitle);
		se.selectByValue("24");
	}
	
	public void validateSubUnit() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='empsearch_sub_unit']")));
		Select se = new Select(JobTitle);
		se.selectByValue("13");
	}
	
	public void validateSearchButton() throws InterruptedException 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchBtn']")));
		SearchButton.click();
		Thread.sleep(4000);
	}
}