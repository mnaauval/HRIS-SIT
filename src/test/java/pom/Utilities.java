package pom;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor je;
	private Alert alert;

	@FindBy(xpath = "//th[normalize-space()='July 2022']")
	public WebElement getDate;
	@FindBy(xpath = "//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")
	public WebElement prevBtn;
	@FindBy(xpath = "//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")
	public WebElement nextBtn;

	public Utilities(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		je = (JavascriptExecutor) driver;
	}

	public void sleep(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollToElem(WebElement elm) {
		je.executeScript("arguments[0].scrollIntoView(true);", elm);
	}

	public void zoomOut(Double scale) {
		String zoomJS = "document.body.style.zoom='" + scale + "'";
		je.executeScript(zoomJS);
	}

//	Date
	public void setDate(String dateUser) {

		String month = getDate.getText().substring(0, 4);
		String year = getDate.getText().substring(5, 9);

//		Input 
		String tahun = dateUser.substring(0, 4);
		String bulan = dateUser.substring(5, 7);
		String tanggal = dateUser.substring(8, 10);

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
		default:
			currentMonth = 0;
		}

		int targetMonth = Integer.valueOf(bulan);
		int targetYear = Integer.valueOf(tahun);

		int stepYear = Math.abs(((currentYear - targetYear) * 12));
		int stepMonth = Math.abs(currentMonth - targetMonth);

		int step;
		if (currentMonth < targetMonth) {
			step = Math.abs(stepYear - stepMonth);
		} else {
			step = Math.abs(stepYear + stepMonth);
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
		if (stepYear == 0) {
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
		sleep(5000);
		driver.findElement(By.xpath("(//td[normalize-space()='" + tanggalAngka + "'])[1]")).click();
	}

	public String screenshoot(WebDriver driver) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\EclipseWorkSpace\\TA_HRIS\\src\\test\\resources\\SS\\" + waktu + ".PNG";
		File screenshoot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshoot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return namaFile;
	}
	
	public String handleAlert() {
		String msg = "No allert";
		if (isAlertPresent()) {
			alert = driver.switchTo().alert();
			msg = alert.getText();
			System.out.println(alert.getText());
			sleep(1000);
			alert.accept();
		}
		return msg;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

}
