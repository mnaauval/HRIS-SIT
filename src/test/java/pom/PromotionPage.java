package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PromotionPage extends Utilities {

	private WebDriver driver;
	private JavascriptExecutor je;

	Select vaksin, nik, ulasanAtsn;

//	public void scrollToElem(WebElement elm) {
////		je.executeScript("aguments[0].scrollIntoView(true);",elm);
//		
//	}
	public void scrollTOPixel(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,3000)");

	}

//	Promotion
	@FindBy(xpath = "//h4[normalize-space()='Promotion']")
	public WebElement myTaskPromotion;
	@FindBy(xpath = "//span[normalize-space()='Promotion']")
	public WebElement navPromotion;
	@FindBy(xpath = "//a[@href='https://dev.ptdika.com/employee/promotion/promotion/']")
	public WebElement subNavPromotion;
	@FindBy(xpath = "//a[normalize-space()='Promotion History']")
	public WebElement subNavPromHistory;
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	public WebElement identityProm;
//	Add pengajuan promotion staff
	@FindBy(xpath = "//div[@id='content']/div/a")
	public WebElement btnAdd;

	// Tujuan Promosi
	@FindBy(xpath = "//label[@for='cb_promotion_0']")
	public WebElement inPromJabatan;
	@FindBy(xpath = "//label[@for='cb_promotion_1']")
	public WebElement inPromSalary;
	@FindBy(xpath = "//label[@for='cb_promotion_2']")
	public WebElement inPromKontrak;

	// Form Identitas
	@FindBy(xpath = "//select[@id='nik']")
	public WebElement inNik;

	// Form Tambahan
	@FindBy(xpath = "//select[@id='Vaksin_Check']")
	public WebElement inVaksin;
	@FindBy(xpath = "//input[@id='Vaksin_Date']")
	public WebElement inTglVaksin;
	@FindBy(xpath = "//td[@class='today day']")
	public WebElement inVaksinToday;
	@FindBy(xpath = "//textarea[@id='Requested_Comment']")
	public WebElement inNote;

	// Submit form
	@FindBy(xpath = "//input[@value='Send To Upliner (EX - CECEP R)']")
	public WebElement btnSend;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	public WebElement btnBack;
	
//	Perubahan Jabatan
	@FindBy(xpath = "//input[@id='Effective_Date']")
	public WebElement inEffDate;
	@FindBy(xpath = "//span[@id='select2-Promotion_Employee_Type-container']")
	public WebElement inStatus;
	@FindBy(xpath = "//span[@id='select2-Promotion_Unit-container']")
	public WebElement inUnit;
	@FindBy(xpath = "//span[@id='select2-Promotion_Division-container']")
	public WebElement inDivisi;
	@FindBy(xpath = "//span[@id='select2-Promotion_Level-container']")
	public WebElement inLevel;
	@FindBy(xpath = "//span[@id='select2-Promotion_Position-container']")
	public WebElement inJabatan;
	@FindBy(xpath = "//input[@role='textbox']")
	public WebElement txtBox;

//	Perubahan salary
	@FindBy(xpath = "//input[@id='New_Promotion_Salary']")
	public WebElement inGaPok;
	@FindBy(xpath = "//input[@id='New_Promotion_Positional_Allowance']")
	public WebElement inTunJabatan;
	@FindBy(xpath = "//input[@id='New_Promotion_Communication_Allowance']")
	public WebElement inTunKomunikasi;
	@FindBy(xpath = "//input[@id='New_Promotion_Transportation_Allowance']")
	public WebElement inTunTransportasi;

//	PERPANJANG KONTRAK
	@FindBy(xpath = "//input[@id='Contract_Date1']")
	public WebElement startCon;
	@FindBy(xpath = "//input[@id='Contract_Date2']")
	public WebElement endCOn;
	@FindBy(xpath = "//div[@id='datepicker-autoClose1']//i[@class='fa fa-calendar']")
	// input[@id='Contract_Date2']
	public WebElement datePicker;
	@FindBy(xpath = "//input[@id='bulan_perpanjang']")
	public WebElement masaJbtn;

//	PENILAIAN
	@FindBy(xpath = "//textarea[@id='Aspect1']")
	public WebElement asKelebihan;
	@FindBy(xpath = "//textarea[@id='Aspect2']")
	public WebElement asTingkatkan;
	@FindBy(xpath = "//textarea[@id='Aspect3']")
	public WebElement asuransi;
	@FindBy(xpath = "//select[@id='Aspect4']")
	public WebElement ulasan;
	@FindBy(xpath = "//div[@class='alert alert-warning alert-dismissible fade show']")
	public WebElement suksesMsg;

//	Assertiom=========================================
	@FindBy(xpath = "//a[normalize-space()='Send Data To Upliner (EX - CECEP R)']")
	public WebElement sentTo;
	
	@FindBy(xpath = "//span[contains(text(),'NIK Harap Di Isi!')]")
	public WebElement errorNIK;
	@FindBy(xpath = "//span[contains(text(),'Tanggal Efektif Harap Di Isi!')]")
	public WebElement errorTglEf;
	@FindBy(xpath = "//span[contains(text(),'Status Harap Di Isi!')]")
	public WebElement errorStatus;
	@FindBy(xpath = "//span[contains(text(),'Divisi Harap Di Isi!')]")
	public WebElement errorDivisi;
	@FindBy(xpath = "//span[contains(text(),'Unit Harap Di Isi!')]")
	public WebElement errorUnit;
	@FindBy(xpath = "//span[contains(text(),'Level Harap Di Isi!')]")
	public WebElement errorLevel;
	@FindBy(xpath = "//span[contains(text(),'Jabatan Harap Di Isi!')]")
	public WebElement errorJabatan;

	@FindBy(xpath = "//span[contains(text(),'Tanggal Kontrak Mulai Harap Di Isi!')]")
	public WebElement errorStart;
	@FindBy(xpath = "//span[contains(text(),'Tanggal Kontrak Selesai Harap Di Isi!')]")
	public WebElement errorEnd;
	@FindBy(xpath = "//span[contains(text(),'Bulan Harap Di Isi!')]")
	public WebElement errorMasa;
	
	@FindBy(xpath = "//span[contains(text(),'Gaji Pokok Harap Di Isi!')]")
	public WebElement errorGapok;
	@FindBy(xpath = "//span[contains(text(),'Tunjangan Jabatan Harap Di Isi!')]")
	public WebElement errorTunJabatan;
	@FindBy(xpath = "//span[contains(text(),'Tunjangan Komunikasi Harap Di Isi!')]")
	public WebElement errorTunKomunikasi;
	@FindBy(xpath = "//span[contains(text(),'Tunjangan Transportasi Harap Di Isi!')]")
	public WebElement errorTunTransportasi;

	public PromotionPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
	}

	public void chooseNIK(String nik) {
		scrollToElem(inNik);
		Select niKaryawan = new Select(inNik);
//		niKaryawan.selectByValue(nik);
		niKaryawan.selectByVisibleText(nik);
//		this.nik = new Select(inNik);
//		this.nik.selectByVisibleText(nik);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,750)");
	}

//	PROMOSI SALARY=============================================================================================================================================
	public void setGapok(String Gapok) {
		inGaPok.click();
		inGaPok.sendKeys(Gapok);
		sleep(500);
	}

	public void setTunjabatan(String jbtn) {
		inTunJabatan.click();
		inTunJabatan.sendKeys(jbtn);
		sleep(500);
	}

	public void setTunKomunikasi(String kmnks) {
		inTunKomunikasi.click();
		inTunKomunikasi.sendKeys(kmnks);
		sleep(500);
	}

	public void setTunTransportasi(String transport) {
		inTunTransportasi.click();
		inTunTransportasi.sendKeys(transport);
		sleep(2000);
	}

//	public void addFormPerubahanSalary(String gapok, String jabatan, String komunikasi, String transportasi) {
//	inGaPok.click();
//	inGaPok.sendKeys(gapok);
//	inTunJabatan.click();
//	inTunJabatan.sendKeys(jabatan);
//	inTunKomunikasi.click();
//	inTunKomunikasi.sendKeys(komunikasi);
//	inTunTransportasi.click();
//	inTunTransportasi.sendKeys(transportasi);
//	sleep(1000);
//}
//  PROMOSI JABATAN============================================================================================================================================
	public void manuTglEf(String tglEffective) {
		inEffDate.click();
		inEffDate.sendKeys(tglEffective);
		inEffDate.sendKeys(Keys.ENTER);
//		sleep(1000);
	}
//	public void setTglEf(String tglEffective) {
//		inEffDate.click();
//		setDate(tglEffective);
//		inEffDate.sendKeys(Keys.ENTER);
//	}

	public void setStatus(String status) {
		inStatus.click();
		txtBox.sendKeys(status);
		txtBox.sendKeys(Keys.ENTER);
		sleep(800);
	}

	public void setUnit(String unit) {
		inUnit.click();
		txtBox.sendKeys(unit);
		txtBox.sendKeys(Keys.ENTER);
		sleep(800);
	}

	public void setPerubahanJbtn(String jabatan) {
		inJabatan.click();
		txtBox.sendKeys(jabatan);
		txtBox.sendKeys(Keys.ENTER);
		sleep(800);
	}

	public void setDivisi(String divisi) {
		inDivisi.click();
		txtBox.sendKeys(divisi);
		txtBox.sendKeys(Keys.ENTER);
		sleep(800);
	}

	public void setLevel(String level) {
		inLevel.click();
		txtBox.sendKeys(level);
		txtBox.sendKeys(Keys.ENTER);
		sleep(800);
	}

//	PERPANJANG KONTRAK=========================================================================================================================================
//	Date picker
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
		sleep(2000);
		driver.findElement(By.xpath("(//td[normalize-space()='" + tanggalAngka + "'])[1]")).click();
	}

	public void setMulai(String mulai) {
		startCon.clear();
		startCon.sendKeys(mulai);
		startCon.sendKeys(Keys.ENTER);
		sleep(800);
	}

	public void setSelesai(String selesai) {
		endCOn.clear();
		endCOn.sendKeys(selesai);
		endCOn.sendKeys(Keys.ENTER);
		sleep(800);
	}

	public void setMasa(String masaCon) {
		masaJbtn.clear();
		masaJbtn.sendKeys(masaCon);
		masaJbtn.sendKeys(Keys.ENTER);
		sleep(500);
	}

//	PENILAIAN==================================================================================================================================================
	// input opt 3-7 as value (1-5)
	public void setAnswer01(String opt) {
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[5]/form[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[" + opt
						+ "]/input[1]"))
				.click();
	}

	public void setAnswer02(String opt) {
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[5]/form[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[" + opt
						+ "]/input[1]"))
				.click();
	}

	public void setAnswer03(String opt) {
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[5]/form[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[4]/td[" + opt
						+ "]/input[1]"))
				.click();
	}

	public void setAnswer04(String opt) {
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[5]/form[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[5]/td[" + opt
						+ "]/input[1]"))
				.click();
	}

	public void setAnswer05(String opt) {
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[5]/form[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[6]/td[" + opt
						+ "]/input[1]"))
				.click();
	}

	public void setAnswer06(String opt) {
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[5]/form[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[7]/td[" + opt
						+ "]/input[1]"))
				.click();
	}

	public void setAnswer07(String opt) {
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[5]/form[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[8]/td[" + opt
						+ "]/input[1]"))
				.click();
	}

	public void setAnswer08(String opt) {
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[5]/form[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[9]/td[" + opt
						+ "]/input[1]"))
				.click();
	}

	public void setAnswer09(String opt) {
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[5]/form[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[10]/td["
						+ opt + "]/input[1]"))
				.click();
	}

	public void setAnswer10(String opt) {
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[5]/form[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[11]/td["
						+ opt + "]/input[1]"))
				.click();
	}

	public void setAspek1(String aspek1) {
//		asKelebihan.clear();
		asKelebihan.sendKeys(aspek1);
		sleep(500);
	}

	public void setAspek2(String aspek2) {
//		asKelebihan.clear();
		asTingkatkan.sendKeys(aspek2);
		sleep(500);
	}

	public void setAspek3(String aspek3) {
		asuransi.sendKeys(aspek3);
		sleep(500);
	}

	public void chooseUlasan(String ulasanAtsn) {
		scrollToElem(ulasan);
		ulasan.click();
		this.ulasanAtsn = new Select(ulasan);
		this.ulasanAtsn.selectByVisibleText(ulasanAtsn);
	}

//	VAKSIN=====================================================================================================================================================
	public void chooseVaksin(String vaksin) {
		scrollToElem(inVaksin);
		this.vaksin = new Select(inVaksin);
		this.vaksin.selectByVisibleText(vaksin);
	}

	public void tglVaksin(String tgl) {
		inTglVaksin.click();
		inTglVaksin.sendKeys(tgl);
		inTglVaksin.sendKeys(Keys.ENTER);
	}

	public void setNote(String note) {
		inNote.clear();
		inNote.sendKeys(note);
		sleep(1000);
	}

//	===========================================================================================================================================================
	public String getEmptyTable() {
		return driver.findElement(By.xpath("//td[@class='dataTables_empty']")).getText();
	}

	public String getTable() {
		return driver.findElement(By.xpath("(//td[normalize-space()='1'])[1]")).getText();
	}

	public void getErrorNIK() {
		scrollToElem(errorNIK);
		System.out.println(errorNIK.getText());
		String expected = "NIK Harap Di Isi!";
		String actual = errorNIK.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErrorTglEf() {
		sleep(300);
		scrollToElem(errorTglEf);
		System.out.println(errorTglEf.getText());
		String expected = "Tanggal Efektif Harap Di Isi!";
		String actual = errorTglEf.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErrorStatus() {
		sleep(300);
		scrollToElem(inEffDate);
		System.out.println(errorStatus.getText());
		String expected = "Status Harap Di Isi!";
		String actual = errorStatus.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErrorDivisi() {
		sleep(300);
		scrollToElem(inEffDate);
		System.out.println(errorDivisi.getText());
		String expected = "Divisi Harap Di Isi!";
		String actual = errorDivisi.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErrorLevel() {
		sleep(300);
		scrollToElem(inEffDate);
		System.out.println(errorLevel.getText());
		String expected = "Level Harap Di Isi!";
		String actual = errorLevel.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErrorJabatan() {
		sleep(300);
		scrollToElem(inEffDate);
		System.out.println(errorJabatan.getText());
		String expected = "Jabatan Harap Di Isi!";
		String actual = errorJabatan.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErrorUnit() {
		sleep(300);
		scrollToElem(errorUnit);
		System.out.println(errorUnit.getText());
		String expected = "Unit Harap Di Isi!";
		String actual = errorUnit.getText();
		Assert.assertEquals(actual, expected);
	}

	public boolean VaksinNull() {
		boolean check = false;
		try {
			String value = ((WebElement) vaksin).getAttribute("required");
			if (value != null) {
				check = true;
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			return check = false;
		}
	}
	
	public boolean masaMinus() {
		boolean check = false;
		try {
			String value = ((WebElement) masaJbtn).getAttribute("value");
			if (value != null) {
				check = true;
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			return check = false;
		}
	}

	public void getErrorStart() {
		sleep(300);
		scrollToElem(masaJbtn);
		System.out.println(errorStart.getText());
		String expected = "Tanggal Kontrak Mulai Harap Di Isi!";
		String actual = errorStart.getText();
		Assert.assertEquals(actual, expected);
	}
	
	public void getErrorEnd() {
		sleep(300);
		scrollToElem(masaJbtn);
		System.out.println(errorEnd.getText());
		String expected = "Tanggal Kontrak Selesai Harap Di Isi!";
		String actual = errorEnd.getText();
		Assert.assertEquals(actual, expected);
	}
	public void getErrorMasa() {
		sleep(300);
		scrollToElem(masaJbtn);
		System.out.println(errorMasa.getText());
		String expected = "Bulan Harap Di Isi!";
		String actual = errorMasa.getText();
		Assert.assertEquals(actual, expected);
	}
	public void getSentUplier() {
		sleep(300);
		scrollToElem(sentTo);
		System.out.println(sentTo.getText());
		String expected = "Send Data To Upliner (EX - CECEP R)";
		String actual = sentTo.getText();
		Assert.assertEquals(actual, expected);
	}

	public boolean NoteNull() {
		boolean check = false;
		try {
			String value = ((WebElement) inNote).getAttribute("required");
			if (value != null) {
				check = true;
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			return check = false;
		}
	}
	
	public boolean NIKnull() {
		boolean check = false;
		try {
			String value = ((WebElement) inNik).getAttribute("required");
			if (value != null) {
				check = true;
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			return check = false;
		}
	}
	
//	 PERUBAHAN SALARY===============================================================================================
	public void getErrorGapok() {
		sleep(200);
		scrollToElem(inGaPok);
		System.out.println(errorGapok.getText());
		String expected = "Gaji Pokok Harap Di Isi!";
		String actual = errorGapok.getText();
		Assert.assertEquals(actual, expected);
	}
	public void getErrorTunJabatan() {
		sleep(200);
		scrollToElem(inGaPok);
		System.out.println(errorTunJabatan.getText());
		String expected = "Tunjangan Jabatan Harap Di Isi!";
		String actual = errorTunJabatan.getText();
		Assert.assertEquals(actual, expected);
	}
	public void getErrorTunKomunikasi() {
		sleep(200);
		scrollToElem(inGaPok);
		System.out.println(errorTunKomunikasi.getText());
		String expected = "Tunjangan Komunikasi Harap Di Isi!";
		String actual = errorTunKomunikasi.getText();
		Assert.assertEquals(actual, expected);
	}
	public void getErrorTunTransport() {
		sleep(200);
		scrollToElem(inGaPok);
		System.out.println(errorTunTransportasi.getText());
		String expected = "Tunjangan Transportasi Harap Di Isi!";
		String actual = errorTunTransportasi.getText();
		Assert.assertEquals(actual, expected);
	}
	
	public void getVaksinOver() {
		sleep(200);
		System.out.println(inTglVaksin.getText());
		String expected = "2022-07-14";
		String actual = errorTunTransportasi.getText();
		Assert.assertEquals(actual, expected);
	}
	
	

}
