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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HRISPendingStaff extends Utilities {

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

	// formDetail
	@FindBy(xpath = "//select[@name='Recruitment_Type']")
	public WebElement formDetail_Tujuan;
	@FindBy(xpath = "//input[@placeholder='NIK']")
	public WebElement fieldNIK;
	@FindBy(xpath = "//i[@class='fa fa-search']")
	public WebElement searchNIK;
	@FindBy(xpath = "//select[@name='Position_Request']")
	public WebElement formDetail_Posisi;
	@FindBy(xpath = "//input[@name='Total_Request']")
	public WebElement formDetail_JmlhOrang;
	@FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
	public WebElement formDetail_MKerja;
	@FindBy(xpath = "//select[@name='Work_Location']")
	public WebElement formDetail_LokKerja;
	@FindBy(xpath = "//div[@class='filter-option-inner-inner']")
	public WebElement formDetail_OtherPilih;
	@FindBy(xpath = "//input[@aria-label='Search']")
	public WebElement inputPilih;
	@FindBy(xpath = "//input[@name='Work_Location_Other']")
	public WebElement formDetail_OtherField;
	@FindBy(xpath = "//textarea[@name='Job_Desc']")
	public WebElement formDetail_jobDesc;

	// formKualifikasi
	@FindBy(xpath = "//select[@name='field']")
	public WebElement formKualifikasi;
	@FindBy(xpath = "//select[@name='jk']")
	public WebElement formKualifikasi_JK;
	@FindBy(xpath = "//input[@name='umur_start']")
	public WebElement formKualifikasi_UStart;
	@FindBy(xpath = "//input[@name='umur_end']")
	public WebElement formKualifikasi_UEnd;
	@FindBy(xpath = "//select[@name='pendidikan']")
	public WebElement formKualifikasi_Pend;
	@FindBy(xpath = "//select[@name='status_perkawinan']")
	public WebElement formKualifikasi_SPerka;
	@FindBy(xpath = "//textarea[@name='other']")
	public WebElement formKualifikasi_KLainnya;

	// formKondisi
	@FindBy(xpath = "//label[@for='rbEmployeeType0']")
	public WebElement rBtn_Tetap;
	@FindBy(xpath = "//label[@for='rbEmployeeType1']")
	public WebElement rBtn_PKWT;
	@FindBy(xpath = "//input[@name='Month_1']")
	public WebElement PKWTMonth;
	@FindBy(xpath = "//input[@name='Year_1']")
	public WebElement PKWTYear;
	@FindBy(xpath = "//label[@for='rbEmployeeType2']")
	public WebElement rBtn_Magang;
	@FindBy(xpath = "//input[@name='Month_2']")
	public WebElement MagangMonth;
	@FindBy(xpath = "//input[@name='Year_2']")
	public WebElement MagangYear;
	@FindBy(xpath = "//label[@for='rbEmployeeType3']")
	public WebElement rBtn_MagangHarian;
	@FindBy(xpath = "//input[@name='Month_3']")
	public WebElement MagangHarianMonth;
	@FindBy(xpath = "//input[@name='Year_3']")
	public WebElement MagangHarianYear;
	@FindBy(xpath = "//label[@for='rbEmployeeType4']")
	public WebElement rBtn_Mitra;
	@FindBy(xpath = "//input[@name='Month_4']")
	public WebElement Mitra_Month;
	@FindBy(xpath = "//input[@name='Year_4']")
	public WebElement MitraYear;

	@FindBy(xpath = "//input[@name='Probation_Period']")
	public WebElement probation;
	@FindBy(xpath = "//select[@name='Level']")
	public WebElement golongan;
	@FindBy(xpath = "//input[@name='Salary']")
	public WebElement gaji;
	@FindBy(xpath = "//input[@id='cbInsurance0']")
	public WebElement asBPJS;
	@FindBy(xpath = "//input[@id='cbInsurance1']")
	public WebElement asSwasta;
	@FindBy(xpath = "//input[@id='cbInsurance2']")
	public WebElement asKecelakaan;
	@FindBy(xpath = "//input[@id='cbInsurance3']")
	public WebElement asPensiun;
	@FindBy(xpath = "//input[@name='Positional_Allowance']")
	public WebElement tunjanganJab;
	@FindBy(xpath = "//input[@name='Transportation_Allowance']")
	public WebElement tunjanganTransp;
	@FindBy(xpath = "//input[@name='Communication_Allowance']")
	public WebElement tunjanganKom;
	@FindBy(xpath = "//textarea[@id='Note_Request']")
	public WebElement note;
	@FindBy(xpath = "//button[normalize-space()='Kirim']")
	public WebElement btnKirim;

	// eror
	@FindBy(xpath = "//span[normalize-space()='The tujuan field is required.']")
	public WebElement erTujuan;
	@FindBy(xpath = "//span[normalize-space()='The penggantian field is required.']")
	public WebElement erNik;
	@FindBy(xpath = "//span[normalize-space()='The posisi field is required.']")
	public WebElement erPosisi;
	@FindBy(xpath = "//span[normalize-space()='The jumlah orang field is required.']")
	public WebElement erJumlahOrang;
	@FindBy(xpath = "//span[normalize-space()='The mulai kerja field is required.']")
	public WebElement erMulaiKerja;
	@FindBy(xpath = "//span[normalize-space()='The lokasi kerja field is required.']")
	public WebElement erLokasiKerja;
	@FindBy(xpath = "//span[normalize-space()='The deskripsi pekerjaan field is required.']")
	public WebElement erDesk;
	@FindBy(xpath = "//span[normalize-space()='The Jenis Kelamin field is required.']")
	public WebElement erJK;
	@FindBy(xpath = "//span[normalize-space()='The umur start field is required.']")
	public WebElement erUmurStart;
	@FindBy(xpath = "//span[normalize-space()='The umur end field is required.']")
	public WebElement erUmurEnd;
	@FindBy(xpath = "//span[normalize-space()='The Pendidikan field is required.']")
	public WebElement erPend;
	@FindBy(xpath = "//span[normalize-space()='The Status Perkawinan field is required.']")
	public WebElement erPerkawinan;
	@FindBy(xpath = "//span[normalize-space()='The Kualifikasi lainnya field is required.']")
	public WebElement erKualifikasiLain;
	@FindBy(xpath = "//span[normalize-space()='The bulan field is required.']")
	public WebElement erPKWTBulan;
	@FindBy(xpath = "//span[normalize-space()='The tahun field is required.']")
	public WebElement erPKWTTahun;
	@FindBy(xpath = "//span[normalize-space()='The bulan field is required.']")
	public WebElement erMagBulan;
	@FindBy(xpath = "//span[normalize-space()='The tahun field is required.']")
	public WebElement erMagTahun;
	@FindBy(xpath = "//span[normalize-space()='The bulan field is required.']")
	public WebElement erMagHarBulan;
	@FindBy(xpath = "//span[normalize-space()='The tahun field is required.']")
	public WebElement erMagHarTahun;
	@FindBy(xpath = "//span[normalize-space()='The bulan field is required.']")
	public WebElement erMitraBulan;
	@FindBy(xpath = "//span[normalize-space()='The tahun field is required.']")
	public WebElement erMitraTahun;
	@FindBy(xpath = "//span[normalize-space()='The golongan/jabatan field is required.']")
	public WebElement erGolongan;

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

	
	
	public HRISPendingStaff(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	public void getPending() {
		sleep(500);
		System.out.println(pageRequestStaff.getText());
		String expected = "Request Staff";
		String actual = pageRequestStaff.getText();
		Assert.assertEquals(actual, expected);
	}

	public void searchData(String search) {
		fieldSearch.clear();
		fieldSearch.sendKeys(search);
		fieldSearch.sendKeys(Keys.ENTER);
		String strName = new String(getName());
		String strUnit = new String(getUnit());
		String strForm = new String(getForm());
		String strTujuan = new String(getTujuan());
		String strJumlah = new String(getJumlah());
		String strLokasi = new String(getLokasi());

		if (search.equalsIgnoreCase("EX - ADHITYA BAYU W")) {
			Assert.assertTrue(strName.matches(".*" + search + ".*"));
		} else if (search.equalsIgnoreCase("Supervisor")) {
			Assert.assertTrue(strUnit.matches(".*" + search + ".*"));
		} else if (search.equalsIgnoreCase("006/PM/HRD/VII/2022")) {
			Assert.assertTrue(strForm.matches(".*" + search + ".*"));
		} else if (search.equalsIgnoreCase("Penggantian")) {
			Assert.assertTrue(strTujuan.matches(".*" + search + ".*"));
		} else if (search.equalsIgnoreCase("50")) {
			Assert.assertTrue(strJumlah.matches(".*" + search + ".*"));
		} else if (search.equalsIgnoreCase("Juara Coding Tebet")) {
			Assert.assertTrue(strLokasi.matches(".*" + search + ".*"));
		}

	}

	public void searchDataPending(String search) {
		fieldSearch.clear();
		fieldSearch.sendKeys(search);
		fieldSearch.sendKeys(Keys.ENTER);
		String strName = new String(getName());
		String strUnit = new String(getUnit());
		String strForm = new String(getForm());
		String strTujuan = new String(getTujuan());
		String strJumlah = new String(getJumlah());
		String strLokasi = new String(getLokasi());

		if (search.equalsIgnoreCase("EX - ADHITYA BAYU W")) {
			Assert.assertTrue(strName.matches(".*" + search + ".*"));
		} else if (search.equalsIgnoreCase("Supervisor")) {
			Assert.assertTrue(strUnit.matches(".*" + search + ".*"));
		} else if (search.equalsIgnoreCase("006/PM/HRD/VII/2022")) {
			Assert.assertTrue(strForm.matches(".*" + search + ".*"));
		} else if (search.equalsIgnoreCase("Penggantian")) {
			Assert.assertTrue(strTujuan.matches(".*" + search + ".*"));
		} else if (search.equalsIgnoreCase("50")) {
			Assert.assertTrue(strJumlah.matches(".*" + search + ".*"));
		} else if (search.equalsIgnoreCase("Juara Coding Tebet")) {
			Assert.assertTrue(strLokasi.matches(".*" + search + ".*"));
		}

	}

	public void showData() {
		se = new Select(dataShow);
		se.selectByValue("50");

	}

	public void tujuan(String input) {
		sleep(500);
		Select tujuan = new Select(formDetail_Tujuan);
		tujuan.selectByValue(input);

	}

	public void posisi(String input) {
		sleep(500);
		Select posisi = new Select(formDetail_Posisi);
		posisi.selectByValue(input);

	}

	public void lokasi(String input) {
		sleep(500);
		Select lokasi = new Select(formDetail_LokKerja);
		lokasi.selectByValue(input);

	}

	public void pilihOther(String input) {
		sleep(500);
		formDetail_OtherPilih.click();
		inputPilih.sendKeys(input);
		inputPilih.sendKeys(Keys.ENTER);

	}

	public void tambahKualifikasi(String input) {
		sleep(1000);
		Select tambah = new Select(formKualifikasi);
		tambah.selectByValue(input);

	}

	public void jk(String input) {
		sleep(500);
		Select tambah = new Select(formKualifikasi_JK);
		tambah.selectByValue(input);

	}

	public void pendidikan(String input) {
		sleep(500);
		Select tambah = new Select(formKualifikasi_Pend);
		tambah.selectByValue(input);

	}

	public void statusPerkawinan(String input) {
		sleep(500);
		Select tambah = new Select(formKualifikasi_SPerka);
		tambah.selectByValue(input);

	}

	public void golongan(String input) {
		sleep(500);
		Select tambah = new Select(golongan);
		tambah.selectByValue(input);
	}

	public void getShowData() {
		sleep(500);
		System.out.println(showData.getText());
		String expected = "50";
		String actual = showData.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getPermintaanBaru() {
		sleep(500);
		System.out.println(permintaanBaru.getText());
		String expected = "Permintaan baru";
		String actual = permintaanBaru.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorNik() {
		sleep(500);
		System.out.println(erNik.getText());
		String expected = "The penggantian field is required.";
		String actual = erNik.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorPosisi() {
		sleep(500);
		System.out.println(erPosisi.getText());
		String expected = "The posisi field is required.";
		String actual = erPosisi.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorJumlahOrang() {
		sleep(500);
		System.out.println(erJumlahOrang.getText());
		String expected = "The jumlah orang field is required.";
		String actual = erJumlahOrang.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorMulaiKerja() {
		sleep(500);
		System.out.println(erMulaiKerja.getText());
		String expected = "The mulai kerja field is required.";
		String actual = erNik.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorTujuan() {
		sleep(500);
		System.out.println(erTujuan.getText());
		String expected = "The tujuan field is required.";
		String actual = erTujuan.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorLokasiKerja() {
		sleep(500);
		System.out.println(erLokasiKerja.getText());
		String expected = "The lokasi kerja field is required.";
		String actual = erLokasiKerja.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorDeskripsiPekerjaan() {
		sleep(500);
		System.out.println(erDesk.getText());
		String expected = "The deskripsi pekerjaan field is required.";
		String actual = erDesk.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorJenisKelamin() {
		sleep(500);
		System.out.println(erJK.getText());
		String expected = "The Jenis Kelamin field is required.";
		String actual = erJK.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorUmurStart() {
		sleep(500);
		System.out.println(erUmurStart.getText());
		String expected = "The umur start field is required.";
		String actual = erUmurStart.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorBatasUmur() {
		sleep(500);
		System.out.println(erUmurEnd.getText());
		String expected = "The umur end field is required.";
		String actual = erUmurEnd.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorPendidikan() {
		sleep(500);
		System.out.println(erPend.getText());
		String expected = "The Pendidikan field is required.";
		String actual = erPend.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorStatusPerkawinan() {
		sleep(500);
		System.out.println(erPerkawinan.getText());
		String expected = "The Status Perkawinan field is required.";
		String actual = erPerkawinan.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorKualifikasiLainnya() {
		sleep(500);
		System.out.println(erKualifikasiLain.getText());
		String expected = "The Kualifikasi lainnya field is required.";
		String actual = erKualifikasiLain.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorPKWTBulan() {
		sleep(500);
		System.out.println(erPKWTBulan.getText());
		String expected = "The bulan field is required.";
		String actual = erPKWTBulan.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorPKWTTahun() {
		sleep(500);
		System.out.println(erPKWTTahun.getText());
		String expected = "The tahun field is required.";
		String actual = erPKWTTahun.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorMagangBulan() {
		sleep(500);
		System.out.println(erMagBulan.getText());
		String expected = "The bulan field is required.";
		String actual = erMagBulan.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorMagangTahun() {
		sleep(500);
		System.out.println(erMagTahun.getText());
		String expected = "The tahun field is required.";
		String actual = erMagTahun.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorMagangHarianBulan() {
		sleep(500);
		System.out.println(erMagHarBulan.getText());
		String expected = "The bulan field is required.";
		String actual = erMagHarBulan.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorMagangHarianTahun() {
		sleep(500);
		System.out.println(erMagHarTahun.getText());
		String expected = "The tahun field is required.";
		String actual = erMitraTahun.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorMitraBulan() {
		sleep(500);
		System.out.println(erMitraBulan.getText());
		String expected = "The bulan field is required.";
		String actual = erMitraBulan.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorMitraTahun() {
		sleep(500);
		System.out.println(erMitraTahun.getText());
		String expected = "The tahun field is required.";
		String actual = erMitraTahun.getText();
		Assert.assertEquals(actual, expected);
	}

	public void getErorGolongan() {
		sleep(500);
		System.out.println(erGolongan.getText());
		String expected = "The golongan/jabatan field is required.";
		String actual = erGolongan.getText();
		Assert.assertEquals(actual, expected);
	}

	public void setDate(String dateUser) {

		String month = getDate.getText().substring(0, 4);
		String year = getDate.getText().substring(5, 9);

		// INPUT
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
		return driver.findElement(By.xpath("//tbody/tr[1]/td[5]")).getText();

	}

	public String getJumlah() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[6]")).getText();

	}

	public String getLokasi() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[7]")).getText();

	}

	public boolean cekNik() {
		driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
		btnEye.click();
		boolean check = false;
		try {
			String value = fieldNIK.getAttribute("value");
			if (value == "!!..%$^!") {
				check = false;
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			return check = true;
		}
	}

	public boolean cekPKWT() {
		driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
		sleep(500);
		btnEye.click();
		boolean check = false;
		try {
			String value = PKWTMonth.getAttribute("value");
			if (value == "13") {
				check = false;
			} else if (value == "134") {
				check = false;
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			return check = true;
		}
	}

	public boolean cekMagang() {
		driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
		btnEye.click();
		boolean check = false;
		try {
			String value = MagangMonth.getAttribute("value");
			if (value == "13") {
				check = false;
			} else if (value == "134") {
				check = false;
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			return check = true;
		}
	}

	public boolean cekMagangHarian() {
		driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
		btnEye.click();
		boolean check = false;
		try {
			String value = MagangHarianMonth.getAttribute("value");
			if (value == "13") {
				check = false;
			} else if (value == "134") {
				check = false;
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			return check = true;
		}
	}

	public boolean cekMitra() {
		driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
		btnEye.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
		boolean check = false;
		try {
			String value = Mitra_Month.getAttribute("value");
			if (value == "13") {
				check = false;
			} else if (value == "134") {
				check = false;
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			return check = true;
		}
	}

}
