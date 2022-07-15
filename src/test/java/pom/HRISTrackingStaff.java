package pom;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HRISTrackingStaff extends Utilities {

	protected WebDriver driver;
	private JavascriptExecutor je;
	private WebDriverWait wait;
	Alert alert;
	Select se;

	
	@FindBy(xpath = "//a[@href='javascript:;']//span[contains(text(),'Request Staff')]")
	public WebElement menuRqS;
	@FindBy(xpath = "//a[normalize-space()='Pending']")
	public WebElement subMenuPending;
	@FindBy(xpath = "//a[normalize-space()='Tracking']")
	public WebElement subMenuTracking;
	@FindBy(xpath = "//input[@placeholder='Enter value here']")
	public WebElement fieldSearch;
	@FindBy(xpath = "//input[@id='fField']")
	public WebElement startDateFilter;
	@FindBy(xpath = "//input[@id='tField']")
	public WebElement toDateFilter;
	@FindBy(xpath = "//i[@class='fa fa-filter']")
	public WebElement btnFilter;
	@FindBy(xpath = "//select[@name='dataTable_length']")
	public WebElement dataShow;
	@FindBy(xpath = "//a[normalize-space()='1']")
	public WebElement valueDataShow;
	@FindBy(xpath = "//a[@class='btn btn-primary mb-2']")
	public WebElement btnInputData;
	@FindBy(xpath = "//tbody[1]/tr[1]/td[1]")
	public WebElement btnPlus;
	@FindBy(xpath = "//span[@class='dtr-data']//i[@class='fa fa-eye']")
	public WebElement btnEye;
	
	//UNTUK DATE
	@FindBy(xpath = "//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")
	public WebElement prevBtn;
	@FindBy(xpath = "//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")
	public WebElement nextBtn;
	@FindBy(xpath = "//th[normalize-space()='July 2022']")
	public WebElement getDate;
	
	@FindBy(xpath = "//a[normalize-space()='Permintaan baru']")
	public WebElement permintaanBaru;
	@FindBy(xpath = "//div[@class='alert alert-success fade show']")
	public WebElement successMessage;
	@FindBy(xpath = "//td[normalize-space()='50']")
	public WebElement showData;
	
	@FindBy(xpath = "//h1[@class='page-header']")
	public WebElement pageRequestStaff;
	
	
	

	public HRISTrackingStaff(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Select se = new Select(driver.findElement(By.name("dataTable_length")));
		// Select show = new Select(driver.findElement(By.xpath(null)));

	}
	
	public void filterDataTracking(String filter) {
		fieldSearch.clear();
		fieldSearch.sendKeys(filter);
		fieldSearch.sendKeys(Keys.ENTER);
		String strTanggal = new String(getTglPengajuan());
		
		if (filter.equalsIgnoreCase("11 Mei 2022")) {
			Assert.assertTrue(strTanggal.matches(".*" + filter + ".*"));
		}else if (filter.equalsIgnoreCase("08 Juli 2022")) {
			Assert.assertTrue(strTanggal.matches(".*" + filter + ".*"));
		}else if (filter.equalsIgnoreCase(" ")) {
			Assert.assertTrue(false);
		}
		
	
	}
	

	public void searchDataTracking(String search) {
		fieldSearch.clear();
		fieldSearch.sendKeys(search);
		fieldSearch.sendKeys(Keys.ENTER);
		String strName = new String(getName());
		String strUnit = new String(getUnit());
		String strForm = new String(getForm());
		String strTujuan = new String(getTujuan());
		String strJumlah = new String(getJumlah());
		String strLokasi = new String(getLokasi());
		
		if (search.equalsIgnoreCase("ADHITYA BAYU W")) {
			Assert.assertTrue(false);
		}
		else if (search.equalsIgnoreCase("Supervisor")) {
			Assert.assertTrue(false);
		}
		else if (search.equalsIgnoreCase("006/PM/HRD/VII/2022")) {
			Assert.assertTrue(strForm.matches(".*" + search + ".*"));
		}
		else if (search.equalsIgnoreCase("Penggantian")) {
			Assert.assertTrue(strTujuan.matches(".*" + search + ".*"));
		}
		else if (search.equalsIgnoreCase("Karyawan baru")) {
			Assert.assertTrue(strTujuan.matches(".*" + search + ".*"));
		}
		else if (search.equalsIgnoreCase("50")) {
			Assert.assertTrue(strJumlah.matches(".*" + search + ".*"));
		}
		else if (search.equalsIgnoreCase("Juara Coding Tebet")) {
			Assert.assertTrue(strLokasi.matches(".*" + search + ".*"));
		}

	}
	

	public void showData() {
		se = new Select(dataShow);
		se.selectByValue("50");
//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='1']"))).perform();

	}


	public void getTracking() {
		sleep(500);
		System.out.println(pageRequestStaff.getText());
		String expected = "Request Staff";
		String actual = pageRequestStaff.getText();
		Assert.assertEquals(actual, expected);
	}	
	
	public void getShowData() {
		sleep(500);
		String actual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='50']"))).getText();
		System.out.println(showData.getText());
		String expected = "50";
//		String actual = showData.getText();
		Assert.assertEquals(actual, expected);
	}
	
	public void getPermintaanBaru() {
		sleep(500);
		System.out.println(permintaanBaru.getText());
		String expected = "Permintaan baru";
		String actual = permintaanBaru.getText();
		Assert.assertEquals(actual, expected);
	}	
	
	public void setDate(String dateUser) {
		
		String month = getDate.getText().substring(0,4);
		String year = getDate.getText().substring(5, 9);
		
		//INPUT
		String tanggal = dateUser.substring(8, 10);
		String bulan = dateUser.substring(5, 7);
		String tahun = dateUser.substring(0, 4);

		int currentMonth;
		int currentYear = Integer.valueOf(year);
		
		switch (month) {
		case "January":
			currentMonth = 1;
			break;
		case "February":
			currentMonth = 2;
			break;
		case "March":
			currentMonth = 3;
			break;
		case "April":
			currentMonth = 4;
			break;
		case "May":
			currentMonth = 5;
			break;
		case "June":
			currentMonth = 6;
			break;
		case "July":
			currentMonth = 7;
			break;
		case "August":
			currentMonth = 8;
			break;
		case "September":
			currentMonth = 9;
			break;
		case "October":
			currentMonth = 10;
			break;
		case "November":
			currentMonth = 11;
			break;
		case "December":
			currentMonth = 12;
			break;
		default: currentMonth = 0;
		}
		
		int targetMonth = Integer.valueOf(bulan);
		int targetYear = Integer.valueOf(tahun);
		
		int stepYear = Math.abs(((currentYear-targetYear)*12));
		int stepMonth = Math.abs(currentMonth-targetMonth);
		
		int step;
		if(currentMonth < targetMonth) {
			step = Math.abs(stepYear-stepMonth);
		}
		else{
			step = Math.abs(stepYear+stepMonth);
		}
		if (currentYear < targetYear) {
			for (int z = 0; z < step; z++) {
				nextBtn.click();
			}
		} else if (currentYear > targetYear) {
			for (int y = 0; y < step; y++) {
				prevBtn.click();
			}
		}
		if(stepYear == 0) {
			if (currentMonth < targetMonth) {
				for (int z = 0; z < step; z++) {
					nextBtn.click();
				}
			} else if (currentMonth > targetMonth) {
				for (int y = 0; y < step; y++) {
					prevBtn.click();
				}
			}
		}
		
		int tanggalAngka = Integer.valueOf(tanggal);
		sleep(2000);
		
		driver.findElement(By.xpath("(//td[normalize-space()='" + tanggalAngka + "'])[1]")).click();
	}								  
	
	public String getAlertMsg() {
		try {
			alert = driver.switchTo().alert();
			System.out.println(alert.getText() + " Alert is Displayed");
			String msg = alert.getText();
			sleep(1000);
			alert.accept();
			return msg;
		} catch (NoAlertPresentException e) {
			System.err.println(e);
			return "Alert is Not Displayed";
		}
	}
	
	public String getName() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[2]")).getText();
				
	}
	
	public String getUnit() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[3]")).getText();
		
	}
	
	public String getForm() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[4]")).getText();
		
	}
	
	public String getTujuan() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[5]")).getText();
		
	}
	
	public String getJumlah() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[6]")).getText();
		
	}
	
	public String getLokasi() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[7]")).getText();
		
	}
	
	public String getTglPengajuan() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[8]")).getText();
		
	}
	

}
