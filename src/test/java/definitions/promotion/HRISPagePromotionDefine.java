package definitions.promotion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.HomePage;
import pom.PromotionPage;
import pom.Utilities;
import pom.LoginPage;
import pom.PromotionHistoryPage;

public class HRISPagePromotionDefine {

	public WebDriver driver;
	public WebElement element;
	private LoginPage login;
	private PromotionPage prom;
	private PromotionHistoryPage promotionHis;
	private Utilities util;

	public JavascriptExecutor js = (JavascriptExecutor) driver;
	private FluentWait<WebDriver> wait;
//	WebDriverWait wait = new WebDriverWait(driver, 30 );

	@SuppressWarnings("deprecation")
	@Before
	public void init() {
		System.setProperty("url", "https://dev.ptdika.com/employee/panel/login/");
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		login = PageFactory.initElements(driver, LoginPage.class);
		prom = PageFactory.initElements(driver, PromotionPage.class);
		promotionHis = PageFactory.initElements(driver, PromotionHistoryPage.class);
	}

	@Given("User login sebagai Manager")
	public void loginMng() {
		login.setCredentials("EXD8120011", "admin12345");
		login.clickLogin();
	}

	@And("User masuk pada Homepage")
	public void at_Home() {
	}

	@When("User menekan teks promotion pada menu my Task")
	public void click_Mytask_Promotion() {
		prom.myTaskPromotion.click();
	}

	@When("User menekan teks promotion pada Navigation Menu")
	public void click_Navigation_Menu_Promotion() {
		prom.navPromotion.click();
	}

	@And("User menekan Promotion pada submenu Navigation")
	public void click_Promotion_subnav() {
		prom.subNavPromotion.click();
	}

	@Then("User berada pada Halaman Promotion")
	public void page_Promotion() {

	}

	@When("User berada pada subMenu promotion")
	public void goto_Promotion() {
		prom.navPromotion.click();
		prom.subNavPromotion.click();
	}

	@And("User add")
	public void click_Btn_Add() {
		prom.btnAdd.click();
	}

//	TUJUAN PROMOSI=======================================================================================================================================================
	@And("User memilih tujuan promosi perubahan jabatan")
	public void select_tujuan_promosi_jabatan() {
		prom.inPromJabatan.click();
	}

	@And("User memilih tujuan promosi perubahan salary")
	public void select_tujuan_promosi_salary() {
		prom.inPromSalary.click();
	}

	@And("User memilih tujuan promosi perubahan kontrak")
	public void select_tujuan_promosi_kontrak() {
		prom.inPromKontrak.click();
	}

	@And("^User memilih nik(.*)$")
	public void select_nik(String nik) {
		prom.inNik.click();
//		Select chooseNik = new Select(prom.inNik);
//		chooseNik.selectByVisibleText(nik);

		prom.chooseNIK(nik);
		System.out.println("NIK terisi " + nik);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1000)");
	}

	@And("^User mengisi gapok (.*), jabatan (.*), komunikasi (.*), transportasi (.*)$")
	public void input_New_Salary(String gapok, String jabatan, String komunikasi, String transportasi) {
		prom.sleep(1000);
		prom.inGaPok.clear();
		prom.inGaPok.sendKeys(gapok);
		prom.sleep(1000);
		prom.inTunJabatan.clear();
		prom.inTunJabatan.sendKeys(jabatan);
		prom.sleep(1000);
		prom.inTunKomunikasi.clear();
		prom.inTunKomunikasi.sendKeys(komunikasi);
		prom.sleep(1000);
		prom.inTunTransportasi.clear();
		prom.inTunTransportasi.sendKeys(transportasi);
	}

//	PROMOTION JABATAN====================================================================================================================================================
	@And("^User mengisi tglEf manual(.*)$")
	public void input_tglEf(String tglEf) {
		prom.sleep(1000);
		prom.manuTglEf(tglEf);
		System.out.println("Tanggal Effective " + tglEf);
	}

	@And("^User mengisi status (.*)$")
	public void input_Status(String status) {
		prom.sleep(800);
		prom.setStatus(status);
		System.out.println("Status " + status);
	}

	@And("^User mengisi unit (.*)$")
	public void input_Unit(String unit) {
		prom.sleep(800);
		prom.setUnit(unit);
		System.out.println("Unit " + unit);
	}

	@And("^User mengisi perubahan jabatan (.*)$")
	public void input_Perubahan_Jabatan(String jabatan) {
		prom.setPerubahanJbtn(jabatan);
		System.out.println("User promosi jabatan sebagai Rp " + jabatan);
	}

	@And("^User mengisi divisi (.*)$")
	public void input_Divisi(String divisi) {
		prom.sleep(1000);
		prom.setDivisi(divisi);
		System.out.println("User pada divisi " + divisi);
	}

	@And("^User mengisi level (.*)$")
	public void input_Level(String level) {
		prom.sleep(800);
		prom.setLevel(level);
		System.out.println("User pada level " + level);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,3000)");
	}

	@And("^User memilih tglEf (.*), status (.*), unit (.*), perubahan jabatan (.*), divisi (.*), level (.*)$")
	public void input_New_Jabatan(String tglEf, String status, String unit, String jabatan, String divisi,
			String level) {
//		prom.inEffDate.click();
//		prom.setDate(tglEf);
		prom.manuTglEf(tglEf);
		prom.setStatus(status);
		prom.setUnit(unit);
		prom.setPerubahanJbtn(jabatan);
		prom.setDivisi(divisi);
		prom.setLevel(level);
	}

	@And("^User memilih status (.*), unit (.*), perubahan jabatan (.*), divisi (.*), level (.*)$")
	public void input_New_Jabatan_noTglEf(String status, String unit, String jabatan, String divisi, String level) {
		prom.setStatus(status);
		prom.setUnit(unit);
		prom.setPerubahanJbtn(jabatan);
		prom.setDivisi(divisi);
		prom.setLevel(level);
	}

	@And("^User mengisi set tglEf (.*)$")
	public void input_set_tglEf(String tglEf) {
		prom.inEffDate.click();
		prom.setDate(tglEf);
//		prom.manuTglEf(tglEf);
	}

//	PROMOTION SALARY=====================================================================================================================================================
//	@And("^User mengisi gapok (.*)$")
	public void input_Gapok(String gapok) {
		prom.setGapok(gapok);
		System.out.println("User memasukkan gapok Rp " + gapok);
	}

	@And("^User mengisi jabatan (.*)$")
	public void input_Tunjangan_Jabatan(String jabatan) {
		prom.setTunjabatan(jabatan);
		System.out.println("User memasukkan tunjangan jabatan Rp " + jabatan);
	}

	@And("^User mengisi komunikasi (.*)$")
	public void input_Tunjangan_Komunikasi(String komunikasi) {
		prom.setTunKomunikasi(komunikasi);
		System.out.println("User memasukkan tunjangan komunikasi Rp " + komunikasi);
	}

	@And("^User mengisi transportasi (.*)$")
	public void input_Tunjangan_Transportasi(String transportasi) {
		prom.setTunTransportasi(transportasi);
		System.out.println("User memasukkan tunjangan transportasi Rp " + transportasi);
	}

//	PERPANJANG KONTRAK===================================================================================================================================================
	@And("^User memilih tanggal mulai kontrak (.*)$")
	public void input_Contract_tglMulai(String start) {
		prom.startCon.clear();
		prom.setMulai(start);
	}

	@And("^User memilih tanggal selesai kontrak (.*)$")
	public void input_Contract_tglSelesai(String end) {
		prom.endCOn.clear();
		prom.setSelesai(end);
	}

	@And("^User memilih masa (.*)$")
	public void input_Masa_Contract(String masa) {
		prom.setMasa(masa);
		prom.sleep(500);
	}

	@And("^User memilih tanggal mulai (.*), tanggal selesai (.*), masa (.*)$")
	public void input_New_Masa_Contract(String start, String end, String masa) {
		prom.startCon.click();
		prom.setDate(start);
//		prom.sleep(800);
		prom.endCOn.click();
		prom.setDate(end);
//		prom.sleep(500);
		prom.setMasa(masa);
		prom.sleep(800);
	}

//  PENILAIAN============================================================================================================================================================
	@And("^User mengisi penilaian (.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*)$")
	public void select_Value(String opt01, String opt02, String opt03, String opt04, String opt05, String opt06,
			String opt07, String opt08, String opt09, String opt10) {
		prom.sleep(150);
		prom.setAnswer01(opt01);
		prom.sleep(150);
		prom.setAnswer02(opt02);
		prom.sleep(150);
		prom.setAnswer03(opt03);
		prom.sleep(150);
		prom.setAnswer04(opt04);
		prom.sleep(150);
		prom.setAnswer05(opt05);
		prom.sleep(150);
		prom.setAnswer06(opt06);
		prom.sleep(150);
		prom.setAnswer07(opt07);
		prom.sleep(150);
		prom.setAnswer08(opt08);
		prom.sleep(150);
		prom.setAnswer09(opt09);
		prom.sleep(150);
		prom.setAnswer10(opt10);
		System.out.println("User memilih jawaban");
	}

	@And("^User mengisi aspek Kelebihan(.*)$")
	public void input_Kelebihan(String kelebihan) {
		prom.setAspek1(kelebihan);
		System.out.println("User memilih aspek kelebihan : " + kelebihan);
	}

	@And("^User mengisi aspek yang perlu ditingkat(.*)$")
	public void input_Perlu_diTingkatkan(String selfGrow) {
		prom.setAspek2(selfGrow);
		System.out.println("User memilih aspek yang perlu ditingkatkan : " + selfGrow);
	}

	@And("^User mengisi asuransi(.*)$")
	public void input_Asuransi(String asuransi) {
		prom.setAspek3(asuransi);
		System.out.println("User memilih asuransi : " + asuransi);
	}

	@And("^User memilih ulasan atasan(.*)$")
	public void select_Ulasan(String ulasanAtsn) {
		prom.chooseUlasan(ulasanAtsn);
		System.out.println("Ulasan Atasan terisi " + ulasanAtsn);
	}
	

//	JENIS VAKSIN=========================================================================================================================================================
	@And("^User mengisi jenis vaksin(.*)$")
	public void input_Jenis_Vaksin(String vaksin) {
		prom.chooseVaksin(vaksin);
	}

	@And("^User mengisi tanggal vaksin (.*)$")
	public void input_Tgl_Vaksin(String tgl) {
		prom.tglVaksin(tgl);

	}

	@And("^User mengisi note (.*)$")
	public void input_Note(String note) {
		prom.setNote(note);
	}

	@And("User klik tombol sent to uplier")
	public void click_Btn_SentToUplier() {
		prom.btnSend.click();
		prom.sleep(500);
	}

	@Then("Data tersimpan")
	public void data_Tersimpan() {
	}

	@And("Kembali ke halaman promotion")
	public void kembali() {
		prom.btnBack.click();
	}

//	PROMOTION HISTORY ===================================================================================================================================================
	@And("User menekan Promotion History pada submenu Navigation")
	public void click_Promotion_History_subnav() {
		prom.subNavPromHistory.click();
	}

//	
//	@Then("User berada pada Halaman Promotion History")
//	public void page_Promotion_History() {
//		
//	} 
	@And("^User memilih from date (.*)")
	public void choose_from(String start) {
		promotionHis.calStart.click();
		((JavascriptExecutor) driver).executeScript("document.getElementById('tgl').removeAttribute('readonly',0);"); // Enables
		WebElement fromDateBox = driver.findElement(By.id("tgl"));
		fromDateBox.clear();
		fromDateBox.sendKeys(start);
	}

	@And("^User memilih to date (.*)")
	public void choose_to(String to) {
		promotionHis.calEnd.click();
		((JavascriptExecutor) driver).executeScript("document.getElementById('tgl2').removeAttribute('readonly',0);"); // Enables
		WebElement fromDateBox = driver.findElement(By.id("tgl2"));
		fromDateBox.clear();
		fromDateBox.sendKeys(to);
		fromDateBox.click();
		promotionHis.filter.click();
	}

	@And("User menekan klik next")
	public void click_next() {
		prom.scrollToElem(promotionHis.next);
		promotionHis.next.click();
	}

	@And("User menekan klik prev")
	public void click_prev() {
		prom.scrollToElem(promotionHis.next);
		promotionHis.prev.click();
	}

	@Then("Data tampil")
	public void data_tampil() {
		System.out.println("Data tampil");
	}

//	PROMOTION HISTORY : SEARCH BY========================================================================================================================================
	@And("^User search by (.*)")
	public void search_by_in_Promotion_History(String search) {
		promotionHis.fiturSearch(search);
	}

	@And("^User memilih show of data (.*)")
	public void show_Of_Data(String show) {
		Select showdata = new Select(promotionHis.show);
		showdata.selectByVisibleText(show);
	}

	@And("User sort by Ascending ID Request")
	public void sortAsc_By_IDReq() {
		promotionHis.ascID.click();
	}

	@And("User sort by Descending ID Request")
	public void sortDesc_By_IDReq() {
		promotionHis.ascID.click();
		promotionHis.descID.click();
	}

	@And("User sort by Ascending Form")
	public void sortAsc_By_Form() {
		promotionHis.ascForm.click();
	}

	@And("User sort by Descending Form")
	public void sortDesc_By_Form() {
		promotionHis.ascForm.click();
		promotionHis.descForm.click();
	}

	@And("User sort by Ascending Nama Karyawan")
	public void sortAsc_By_Nama_Karyawan() {
		promotionHis.ascName.click();
	}

	@And("User sort by Descending Nama Karyawan")
	public void sortDesc_By_Nama_Karyawan() {
		promotionHis.ascName.click();
		promotionHis.descName.click();
	}

	@And("User sort by Ascending Tanggal Pengajuan")
	public void sortAsc_By_Tanggal_Pengajuan() {
		promotionHis.ascForm.click();
	}

	@And("User sort by Descending Tanggal Pengajuan")
	public void sortDesc_By_Tanggal_Pengajuan() {
		promotionHis.ascForm.click();
		promotionHis.descForm.click();
	}

	@And("User sort by Ascending Approve Status")
	public void sortAsc_By_Approve_Status() {
		promotionHis.ascStatus.click();
	}

	@And("User sort by Descending Approve Status")
	public void sortDesc_By_Approve_Status() {
		promotionHis.ascStatus.click();
		promotionHis.descStatus.click();
	}

	@And("User sort by Ascending Kategori")
	public void sortAsc_By_Kategori_Promosi() {
		promotionHis.ascKategori.click();
	}

	@And("User sort by Descending Kategori")
	public void sortDesc_By_Kategori_Promosi() {
		promotionHis.ascKategori.click();
		promotionHis.descKategori.click();
	}

	@And("User sort by Ascending Requested By")
	public void sortAsc_By_Requested_By() {
		promotionHis.ascReq.click();
	}

	@And("User sort by Descending Requested By")
	public void sortDesc_By_Requested_By() {
		promotionHis.ascReq.click();
		promotionHis.descReq.click();
	}

	@And("User menekan button see")
	public void click_Button_Eye() {
		promotionHis.btnSee.click();
	}

	@And("User menekan button kembali")
	public void click_Button_Kembali() {
		promotionHis.btnBack.click();
	}

	@And("^Validasi filter (.*) date (.*)$")
	public void filter_date_by(String from, String to) {

		String[] strFrom = from.split("-");
		int tglFrom = Integer.parseInt(strFrom[2]);
//		for (String string : strFrom) {
//			System.out.println(string);
//		}
//		System.out.println(tglFrom);
//
		String[] strTo = to.split("-");
		int tglTo = Integer.parseInt(strTo[2]);
//		for (String string : strTo) {
//			System.out.println(string);
//		}
//		System.out.println(tglTo);
//		
		int expected = 9;

		System.out.println(expected);
		boolean check = false;
		if (expected >= tglFrom && expected <= tglTo) {
			System.out.println("Data benar");
			check = true;
		}
		Assert.assertTrue(check);
	}

	@And("User menekan button reset")
	public void click_Button_Reset() {
		promotionHis.reset.click();
	}

	@And("Validasi button reset")
	public void validasi_button_reset() {
		((JavascriptExecutor) driver).executeScript("document.getElementById('tgl').removeAttribute('readonly',0);"); // Enables
		WebElement fromDateBox = driver.findElement(By.id("tgl"));
		String expected = "";
		String actual = fromDateBox.getText();
		Assert.assertEquals(actual, expected);
	}

//	ASSERTION============================================================================================================================================================
	@Then("Validasi search by ID Req")
	public void search_byIDReq() {
		String actual = promotionHis.getEmptyTableSearch();
		System.out.println(actual);
		String expected = "Harusnya Tampil data search By ID Request";
		Assert.assertEquals(actual, expected);
	}
	
	@Then("User berada pada Page Promotion")
	public void halaman_Promotion() {
		driver.get("https://dev.ptdika.com/employee/promotion/promotion/");
		String actual = prom.getEmptyTable();
		System.out.println(actual);
		String expected = "No data available in table";
		Assert.assertEquals(actual, expected);
	}

	@Then("User berada pada Halaman Promotion History")
	public void halaman_Promotion_History() {
		String actual = prom.getTable();
		System.out.println(actual);
		String expected = "1";
		Assert.assertEquals(actual, expected);
	}

	@And("^Validasi data promotion history by (.*)$")
	public void validasi_Data_Tampil_Promotion_History(String show) {
		boolean check = false;
		if (show.equals("10")) {
			if (!driver.findElements(By.xpath("(//td[normalize-space()='10'])[1]")).isEmpty()) {
				check = true;
				prom.scrollToElem(promotionHis.next);
				System.out.println("Tampil 10 data, true");
			}
		} else if (show.equals("25")) {
			if (!driver.findElements(By.xpath("(//td[normalize-space()='25'])[1]")).isEmpty()) {
				check = true;
				prom.scrollToElem(promotionHis.next);
				System.out.println("Tampil 25 data, true");
			}
		} else if (show.equals("50")) {
			if (!driver.findElements(By.xpath("(//td[normalize-space()='50'])[1]")).isEmpty()) {
				check = true;
				prom.scrollToElem(promotionHis.next);
				System.out.println("Tampil 50 data, true");
			}
		} else if (show.equals("100")) {
			if (!driver.findElements(By.xpath("(//td[normalize-space()='51'])[1]")).isEmpty()) {
				check = true;
				prom.scrollToElem(promotionHis.next);
				System.out.println("Tampil 100 data, true");
			}
		}
		Assert.assertTrue(check);
	}

	@Then("^Validasi search by (.*) contain (.*)")
	public void searchBy_Validation(String searchBy, String word) {
		String id = promotionHis.getIDReq();
		String form = promotionHis.getForm();
		String nama = promotionHis.getNama();
		String tgl = promotionHis.getTgl();
		String appr = promotionHis.getAppr();
		String kategori = promotionHis.getKategori();
		String req = promotionHis.getReq();
		String strID = new String(id);
		String strForm = new String(form);
		String strNama = new String(nama);
		String strTgl = new String(tgl);
		String strAppr = new String(appr);
		String strKategori = new String(kategori);
		String strReq = new String(req);

		System.out.println("Search By " + searchBy);
		System.out.println("Contains kata " + word);

		if (searchBy.equalsIgnoreCase("id request")) {
			System.out.println("id request true");
			Assert.assertTrue(strID.matches(".*" + word + ".*"));
		} else if (searchBy.equalsIgnoreCase("form")) {
			System.out.println("form true");
			Assert.assertTrue(strForm.matches(".*" + word + ".*"));
		} else if (searchBy.equalsIgnoreCase("nama karyawan")) {
			System.out.println("nama karyawan true");
			Assert.assertTrue(strNama.matches(".*" + word + ".*"));
		} else if (searchBy.equalsIgnoreCase("tgl pengajuan")) {
			System.out.println("tgl pengajuan true");
			Assert.assertTrue(strTgl.matches(".*" + word + ".*"));
		} else if (searchBy.equalsIgnoreCase("appr status")) {
			System.out.println("appr status");
			Assert.assertTrue(strAppr.matches(".*" + word + ".*"));
		} else if (searchBy.equalsIgnoreCase("kategori promosi")) {
			System.out.println("kategori promosi true");
			Assert.assertTrue(strKategori.matches(".*" + word + ".*"));
		} else if (searchBy.equalsIgnoreCase("requested by")) {
			System.out.println("requested by true");
			Assert.assertTrue(strReq.matches(".*" + word + ".*"));
		}
	}

	@And("Validasi data tersimpan")
	public void validasi_Data_Tersimpan() {
		System.out.println(prom.suksesMsg.getText());
		String actual = prom.suksesMsg.getText();
		actual = actual.replace("×", "").trim();
		System.out.println(actual);
		String expected = "Sukses! Data Berhasil Di Input. Silakan cek kembali!";
		Assert.assertEquals(actual, expected);
		prom.sleep(2000);
	}

	@And("Validasi sent to uplier")
	public void sent_to_uplier() {
		System.out.println("Validasi data akan diteruskan ke uplier");
		prom.getSentUplier();
	}
	
	@And("Validasi tgl > hari ini")
	public void validasi_lebih_dari_hari_ini() {
		System.out.println("Data > dari hari ini");
		prom.getVaksinOver();
	}

//	@And("Validasi field nik kosong")
//	public void field_Data_nik_kosong() {
//		System.out.println("Validasi data nik kosong");
//		prom.getErrorNIK();
//	}

	@And("Validasi field tglEf kosong")
	public void field_Data_TGlEf_kosong() {
		System.out.println("Validasi data tglEf kosong");
		prom.getErrorTglEf();
	}

	@And("Validasi field status kosong")
	public void field_Data_status_kosong() {
		System.out.println("Validasi data status kosong");
		prom.getErrorStatus();
	}

	@And("Validasi field unit kosong")
	public void field_Data_unit_kosong() {
		System.out.println("Validasi data unit kosong");
		prom.getErrorUnit();
	}

	@And("Validasi field jabatan kosong")
	public void field_Data_jabatan_kosong() {
		System.out.println("Validasi data jabatan kosong");
		prom.getErrorJabatan();
	}

	@And("Validasi field level kosong")
	public void field_Data_level_kosong() {
		System.out.println("Validasi data leve; kosong");
		prom.getErrorLevel();
	}

	@And("Validasi field divisi kosong")
	public void field_Data_divisi_kosong() {
		System.out.println("Validasi data divisi kosong");
		prom.getErrorDivisi();
	}

	@And("Validasi field vaksin kosong")
	public void field_Data_vaksin_kosong() {
		if (prom.VaksinNull() == true) {
			System.out.println("Please select an item in the list!");
		} else {
			System.out.println("vaksin terisi");
		}
	}

	@And("Validasi field note kosong")
	public void field_Data_Note_kosong() {
		if (prom.NoteNull() == true) {
			System.out.println("Please fil out this field!");
		} else {
			System.out.println("Note terisi");
		}
	}
	
	@And("Validasi field nik kosong")
	public void field_nik_kosong() {
		if (prom.NIKnull() == true) {
			System.out.println("Please select an item in the list!");
		} else {
			System.out.println("Nik terisi");
		}
	}

	@And("Validasi field start kosong")
	public void field_Data_start_kosong() {
		System.out.println("Validasi data start kontrak kosong");
		prom.getErrorStart();
	}

	@And("Validasi field end kosong")
	public void field_Data_end_kosong() {
		System.out.println("Validasi data end kontrak kosong");
		prom.getErrorEnd();
	}

	@And("Validasi field masa kosong")
	public void field_Data_Masa_Jabatan_kosong() {
		System.out.println("Validasi data masa kosong");
		prom.getErrorMasa();
	}

	@And("Validasi field masa jabatan < 0")
	public void field_Masa_jabatan_kurang_dari_0() {
		if (prom.masaMinus() == true) {
			System.out.println("Masa jabatan minus!");
		} else {
			System.out.println("Masa jabatan aman");
		}
	}

	@And("Validasi field gapok kosong")
	public void field_gapok_kosong() {
		System.out.println("Validasi gapok kosong");
		prom.getErrorGapok();
	}

	@And("Validasi field Tunjangan Jabatan kosong")
	public void field_tunJabatan_kosong() {
		System.out.println("Validasi tunJabatan kosong");
		prom.getErrorTunJabatan();
	}

	@And("Validasi field Tunjangan Komunikas kosong")
	public void field_tunKomunikasi_kosong() {
		System.out.println("Validasi tunKomunikasi kosong");
		prom.getErrorTunKomunikasi();
	}

	@And("Validasi field Tunjangan Transportasi kosong")
	public void field_tunTransport_kosong() {
		System.out.println("Validasi tunTransport kosong");
		prom.getErrorTunTransport();
	}

	@Then("Validasi tujuan promosi 2")
	public void verif_tujuan_promosi2() {
		boolean check = false;
		WebElement checkBox1 = driver.findElement(By.cssSelector("#cb_promotion_0"));
		WebElement checkBox2 = driver.findElement(By.cssSelector("#cb_promotion_1"));
		WebElement checkBox3 = driver.findElement(By.cssSelector("#cb_promotion_2"));

		if (checkBox1.isSelected() && checkBox2.isSelected()) {
			check = false;	//false untuk menandakan dia tidak boleh 2
			  
			System.out.println("Tidak boleh pilih 2 tujuan promosi");
		} else if (checkBox1.isSelected() && checkBox3.isSelected()) {
			check = false;
			System.out.println("Tidak boleh pilih 2 tujuan promosi");
		} else if (checkBox1.isSelected() && checkBox3.isSelected()) {
			check = false;
			System.out.println("Tidak boleh pilih 2 tujuan promosi");
		}
		Assert.assertTrue(check);
	}

	@Then("Validasi tujuan promosi 3")
	public void verif_tujuan_promosi3() {
		boolean check = false;
		WebElement checkBox1 = driver.findElement(By.cssSelector("#cb_promotion_0"));
		WebElement checkBox2 = driver.findElement(By.cssSelector("#cb_promotion_1"));
		WebElement checkBox3 = driver.findElement(By.cssSelector("#cb_promotion_2"));

		if (checkBox1.isSelected() && checkBox2.isSelected()&& checkBox3.isSelected()) {
			check = false;
			System.out.println("Tidak boleh pilih > 1 tujuan promosi");
		}
		Assert.assertTrue(check);
	}

// SORT KLIK SEKALI===============================================================================================================================================
	@And("Validasi ascending kolom IDReq")
	public void validasi_asc_kolom_id() {
		String actual = promotionHis.getIDReq();
		System.out.println(actual);
		String expected = "540";
		Assert.assertEquals(actual, expected);
	}

	@And("Validasi ascending kolom Form")
	public void validasi_asc_kolom_form() {
		String actual = promotionHis.getForm();
		System.out.println(actual);
		String expected = "FM-HRD-600-517-00";
		Assert.assertEquals(actual, expected);
	}

	@And("Validasi kolom nama")
	public void validasi_asc_kolom_nama() {
		String actual = promotionHis.getNama();
		System.out.println(actual);
		String expected = "EX - ADHITYA BAYU W";
		Assert.assertEquals(actual, expected);
	}

	@And("Validasi kolom Tgl Pengajuan")
	public void validasi_kolom_tgl() {
		String actual = promotionHis.getTgl();
		System.out.println(actual);
		String expected = "2022-07-14 08:36:34";
		Assert.assertEquals(actual, expected);
	}

	@And("Validasi kolom Appr")
	public void validasi_asc_kolom_appr() {
		String actual = promotionHis.getAppr();
		System.out.println(actual);
		String expected = "Send Data To Upliner (EX - CECEP R)";
		Assert.assertEquals(actual, expected);
	}

	@And("Validasi ascending kolom kategori")
	public void validasi_asc_kolom_kategori() {
		String actual = promotionHis.getKategori();
		System.out.println(actual);
		String expected = "promotion level";
		Assert.assertEquals(actual, expected);
	}

	@And("Validasi kolom Request")
	public void validasi_kolom_request() {
		String actual = promotionHis.getReq();
		System.out.println(actual);
		String expected = "EX - AHMAD ZAKI BIN TAMIMI";
		Assert.assertEquals(actual, expected);
	}

// SORT KLIK 2 SEKALI===============================================================================================================================================
	@And("Validasi descending kolom IDReq")
	public void validasi_desc_kolom_id() {
		String actual = promotionHis.getIDReq();
		System.out.println(actual);
		String expected = "287";
		Assert.assertEquals(actual, expected);
	}

	@And("Validasi descending kolom Form")
	public void validasi_desc_kolom_form() {
		String actual = promotionHis.getForm();
		System.out.println(actual);
		String expected = "FM-HRD-600-295-00";
		Assert.assertEquals(actual, expected);
	}

	@And("Validasi descending kolom Tgl Pengajuan")
	public void validasi_desc_kolom_tgl() {
		String actual = promotionHis.getTgl();
		System.out.println(actual);
		String expected = "2022-07-06 13:29:39";
		Assert.assertEquals(actual, expected);
	}

	@And("Validasi descending kolom kategori")
	public void validasi_desc_kolom_kategori() {
		String actual = promotionHis.getKategori();
		System.out.println(actual);
		String expected = "promotion level";
		Assert.assertEquals(actual, expected);
	}

//	=====================================================================================================================================================================
	@After
	public void close(Scenario scenario) {
		prom.sleep(3000);
		System.out.println(scenario.getStatus());
//		scenario.log(scenario.getName());
		if (scenario.isFailed() || scenario.getStatus().equals("UNDEFINED")||scenario.getStatus().equals("FAILED")) {
			System.out.println("screenshot isFailed");
			String file = "<img src='file://" + prom.screenshoot(driver)
					+ "'height=\"350\" width=\"792\"/>";
			Reporter.log(file);
		}
		driver.close();
	}
}
