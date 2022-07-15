package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PromotionHistoryPage extends Utilities {

	protected WebDriver driver;

	public PromotionHistoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
	}

//	Identity PromotionHistory
	@FindBy(xpath = "//input[@type='search']") // selectorHub
	public WebElement search;	
	@FindBy(xpath = "//a[normalize-space()='Next']")
	public WebElement next;
	@FindBy(xpath = "//a[normalize-space()='Previous']")
	public WebElement prev;
	@FindBy(xpath = "//select[@name='table_length']")
	public WebElement show;
	@FindBy(xpath = "//button[@id='btn-reset']")
	public WebElement reset;
	@FindBy(xpath = "//button[@id='btn-filter']")
	public WebElement filter;
	@FindBy(xpath = "//input[@id='tgl']")
//	By field inputan
	public WebElement startDate;
	@FindBy(xpath = "//input[@id='tgl2']")
	public WebElement endDate;
//	By button calender
	@FindBy(xpath = "//div[@id='datepicker-autoClose']//i[@class='fa fa-calendar']")
	public WebElement calStart;
	@FindBy(xpath = "//div[@id='datepicker-autoClose2']//i[@class='fa fa-calendar']")
	public WebElement calEnd;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	public WebElement btnBack;
	@FindBy(xpath = "//i[@class='fa fa-eye']")
	public WebElement btnSee;
	
	
//	Sort by From ID
	@FindBy(xpath = "//th[@aria-label='ID Request: activate to sort column ascending']")
	public WebElement ascID;
	@FindBy(xpath = "//th[@aria-label='ID Request: activate to sort column descending']")
	public WebElement descID;
	@FindBy(xpath = "//th[@aria-label='Form: activate to sort column ascending']")
	public WebElement ascForm;
	@FindBy(xpath = "//th[@aria-label='Form: activate to sort column descending']")
	public WebElement descForm;
//	error
	@FindBy(xpath = "//th[@aria-label='Nama Karyawan: activate to sort column ascending']")
	public WebElement ascName;
	@FindBy(xpath = "//th[@aria-label='Nama Karyawan: activate to sort column descending']")
	public WebElement descName;
	
	
	@FindBy(xpath = "//th[@aria-label='Tgl Pengajuan: activate to sort column ascending']")
	public WebElement ascTgl;
	@FindBy(xpath = "//th[@aria-label='Tgl Pengajuan: activate to sort column descending']")
	public WebElement descTgl;
	@FindBy(xpath = "//th[@aria-label='Appr Status: activate to sort column ascending']")
	public WebElement ascStatus;
	@FindBy(xpath = "//th[@aria-label='Appr Status: activate to sort column descending']")
	public WebElement descStatus;
	@FindBy(xpath = "//th[@aria-label='Kategori Promosi: activate to sort column ascending']")
	public WebElement ascKategori;
	@FindBy(xpath = "//th[@aria-label='Kategori Promosi: activate to sort column descending']")
	public WebElement descKategori;
	@FindBy(xpath = "//th[@aria-label='Requested By: activate to sort column ascending']")
	public WebElement ascReq;
	@FindBy(xpath = "//th[@aria-label='Requested By: activate to sort column descending']")
	public WebElement descReq;
	
	public void fiturSearch(String searchBy) {
		search.clear();
		search.sendKeys(searchBy);
		search.sendKeys(Keys.ENTER);
		sleep(3000);
	}

//	ASSERTION============================================================================================================================================================
	public String getIDReq() { 
		System.out.println(driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[2]")).getText());
		return driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[2]")).getText();
	}
	public String getForm() {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[3]")).getText());
		return driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[3]")).getText();
	}
	public String getNama() {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[4]")).getText());
		return driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[4]")).getText();
	}
	public String getTgl() {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[5]")).getText());
		return driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[5]")).getText();
	}
	public String getAppr() {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[6]")).getText());
		return driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[6]")).getText();
	}
	public String getKategori() {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[7]")).getText());
		return driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[7]")).getText();
	}
	public String getReq() {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[8]")).getText());
		return driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[8]")).getText();
	}
	public String getEmptyTableSearch() {
		return driver.findElement(By.xpath("//td[@class='dataTables_empty']")).getText();
	}
//	=====================================================================================================================================================================
	
}
