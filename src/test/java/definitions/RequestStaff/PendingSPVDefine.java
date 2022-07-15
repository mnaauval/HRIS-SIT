package definitions.RequestStaff;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.HRISPendingStaff;
import pom.HRISTrackingStaff;
import pom.LoginPage;

public class PendingSPVDefine { 

	// DIVINISI
	private WebDriver driver;
	private HRISPendingStaff req;
	private LoginPage login;
	private HRISTrackingStaff track;

	@SuppressWarnings("deprecation")
	@Before
	public void init() {
		System.setProperty("url", "https://dev.ptdika.com/employee/panel/login/");
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		req = PageFactory.initElements(driver, HRISPendingStaff.class);
		track = PageFactory.initElements(driver, HRISTrackingStaff.class);
		login = PageFactory.initElements(driver, LoginPage.class);

	}

	@Given("User berhasil login sebagai SPV")
	public void Login_SPV() {
		System.out.println("login SPV");
		login.setCredentials("EXD8200015", "admin12345");
		login.clickLogin();
	}

	@Given("User berhasil login sebagai MNGR")
	public void Login_MNGR() {
		System.out.println("login Manager");
		login.setCredentials("EXD8120011", "admin12345");
		login.clickLogin();
	}

	@When("User memilih Request Staff")
	public void Menu_Request_Staff() {
		System.out.println("request staff");
		req.menuRqS.click();
	}

	@And("User memilih sub menu Pending")
	public void sub_menu_penidng() {
		System.out.println("sub menu pending");
		req.subMenuPending.click();
	}

	@And("User memilih sub menu Tracking")
	public void sub_menu_tracking() {
		System.out.println("sub menu tracking");
		req.subMenuTracking.click();

	}

	// ========== FILTER DATE ==========
	@And("^User cek filter data input tanggal from (.*)$")
	public void cekFilterDate(String date1) {
		req.startDateFilter.click();
		((JavascriptExecutor) driver).executeScript("document.getElementById('fField').removeAttribute('readonly',0);");
		WebElement fromDateBox = driver.findElement(By.id("fField"));
		fromDateBox.clear();
		fromDateBox.sendKeys(date1);
	}

	@And("^User input tanggal to (.*)$")
	public void cekFilterDateTo(String date2) {
		req.toDateFilter.click();
		((JavascriptExecutor) driver).executeScript("document.getElementById('tField').removeAttribute('readonly',0);");
		WebElement toDateBox = driver.findElement(By.id("tField"));
		toDateBox.clear();
		toDateBox.sendKeys(date2);
		req.btnFilter.click();
		req.sleep(5000);
	}

	// ============ SEARCH =============
	@And("^User melakukan search data berdasarkan search (.*)$")
	public void search_data_positif_test(String search) {
		req.sleep(1000);
		System.out.println("cek search");
		System.out.println(search);
		req.searchData(search);
		req.sleep(1000);
	}

	@And("^User menjalankan search berdasarkan data di sub menu pending (.*)$")
	public void search_data_SPV(String search) {
		req.sleep(1000);
		System.out.println("cek search");
		req.searchData(search);
		req.sleep(3000);
	}

	@Then("Data tampil")
	public void Data_Tampil() {
		System.out.println("Data Tampil");
	}

	@Then("Data tidak berhasil tampil")
	public void Data_Tidak_Berhasil_Tampil() {
		System.out.println("Data tidak berhasil tampil");
	}

	@And("User melakukan show data")
	public void showData() {
		System.out.println("show data");
		req.sleep(2000);
		req.showData();
		req.sleep(1000);
	}

	@When("User menekan button plus dan eye")
	public void cekDetailData() {
		driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
		// req.btnPlus.click();
		req.btnEye.click();
	}

	@When("User menekan button input data")
	public void button_input() {
		System.out.println("menekan button input data");
		req.btnInputData.click();
	}

	// ========== FORM DETAIL ==========
	@And("^User input posisi, jumlah orang (.*), mulai kerja, lokasi kerja, kota kerja, input detail lokasi (.*), deskripsi pekerjaan (.*)$")
	public void tujuanTidakDipilih(String jumlahOrang, String detailLokasi, String desk) {
		req.tujuan("");
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail Penggantian");
	}

	// KARYAWAN BARU
	@And("^User input tujuan, posisi, jumlah orang (.*), mulai kerja, lokasi kerja, kota kerja, input detail lokasi (.*), deskripsi pekerjaan (.*)$")
	public void input_form_detail_KaryawanBaru(String jumlahOrang, String detailLokasi, String desk) {
		req.tujuan("Karyawan baru");
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail Karyawan Baru");
	}

	// PENGGANTIAN & NIK
	@And("^User input tujuan, NIK (.*), posisi, jumlah orang (.*), mulai kerja, lokasi kerja, kota kerja, input detail lokasi (.*), deskripsi pekerjaan (.*)$")
	public void Nikterdaftar(String nik, String jumlahOrang, String detailLokasi, String desk) {
		// awalnya penggantian karna cek nik valid
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.sleep(500);
		req.searchNIK.click();
		req.sleep(500);
		String actual = req.getAlertMsg();
		System.out.println(actual);
		String expected = "Karyawan ini sudah pernah diganti. Mohon ajukan karyawan yang lain.";
		Assert.assertEquals(actual, expected);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail NIK");
	}

	@And("^User input tujuan, spesial karakter dan kosong NIK (.*), posisi, jumlah orang (.*), mulai kerja, lokasi kerja, kota kerja, input detail lokasi (.*), deskripsi pekerjaan (.*)$")
	public void NIKInvalid_spesialKarakter_dan_kosong(String nik, String jumlahOrang, String detailLokasi,
			String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.sleep(500);
		req.searchNIK.click();
		req.sleep(500);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail NIK");
	}

	// POSISI
	@And("^User melakukan input tujuan, NIK (.*), select posisi dilakukan, jumlah orang (.*), mulai kerja, lokasi kerja, kota kerja, input detail lokasi (.*), deskripsi pekerjaan (.*)$")
	public void selectPosisiDilakukan(String nik, String jumlahOrang, String detailLokasi, String desk) {
		req.tujuan("Penggantian");
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail NIK");
	}

	@And("^User melakukan input tujuan, NIK (.*), select posisi tidak dilakukan, jumlah orang (.*), mulai kerja, lokasi kerja, kota kerja, input detail lokasi (.*), deskripsi pekerjaan (.*)$")
	public void selectPosisiTidakDilakukan(String nik, String jumlahOrang, String detailLokasi, String desk) {
		req.tujuan("Penggantian");
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
//		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail NIK");
	}

	// JUMLAH ORANG
	@And("^User input tujuan, NIK (.*), posisi, input jumlah orang dengan angka 0 (.*), mulai kerja, lokasi kerja, kota kerja, input detail lokasi (.*), deskripsi pekerjaan (.*)$")
	public void input_form_Detail_jumlahOrang_0(String nik, String jumlahOrang, String detailLokasi, String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		String actual = req.getAlertMsg();
		System.out.println(actual);
		String expected = "The jumlah orang field is required.";
		Assert.assertEquals(actual, expected);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail Jumlah Orang");
	}

	@And("^User input tujuan, NIK (.*), posisi, melakukan input jumlah orang (.*), mulai kerja, lokasi kerja, kota kerja, input detail lokasi (.*), deskripsi pekerjaan (.*)$")
	public void input_form_Detail_jumlahOrang_huruf_spesialKarakter_kosong(String nik, String jumlahOrang,
			String detailLokasi, String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail Jumlah Orang");
	}

	// MULAI KERJA
	@And("^User input tujuan, NIK (.*), posisi, jumlah orang (.*), input mulai kerja dengan date picker, lokasi kerja, kota kerja, input detail lokasi (.*), deskripsi pekerjaan (.*)$")
	public void input_form_Detail_MulaiKerja_DatePicker(String nik, String jumlahOrang, String detailLokasi,
			String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.click();
		req.setDate("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail Muali Kerja");
	}

	@And("^User input tujuan, NIK (.*), posisi, jumlah orang (.*), input mulai kerja manual, lokasi kerja, kota kerja, input detail lokasi (.*), deskripsi pekerjaan (.*)$")
	public void input_form_Detail_MulaiKerja_Manual(String nik, String jumlahOrang, String detailLokasi, String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.click();
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail Muali Kerja");
	}

	@And("^User input tujuan, NIK (.*), posisi, jumlah orang (.*), input huruf difield mulai kerja, lokasi kerja, kota kerja, input detail lokasi (.*), deskripsi pekerjaan (.*)$")
	public void input_form_Detail_MulaiKerja_Huruf(String nik, String jumlahOrang, String detailLokasi, String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.click();
		req.formDetail_MKerja.sendKeys("abcdefg");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail Muali Kerja");
	}

	// LOKASI KERJA
	@And("^User input tujuan, NIK (.*), posisi, jumlah orang (.*), mulai kerja, lokasi kerja DIKA, deskripsi pekerjaan (.*)$")
	public void input_form_Detail_LokasiKerja_Dika(String nik, String jumlahOrang, String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.click();
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("DIKA 1 lt 2");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail Lokasi Kerja");
	}

	@And("^User input tujuan, NIK (.*), posisi, jumlah orang (.*), mulai kerja, lokasi kerja tidak dipilih, deskripsi pekerjaan (.*)$")
	public void input_form_Detail_LokasiKerja_tidakdilakukan(String nik, String jumlahOrang, String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.click();
		req.formDetail_MKerja.sendKeys("2022-08-18");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail Lokasi Kerja");
	}

	@And("^User input tujuan, NIK (.*), posisi, jumlah orang (.*), mulai kerja, lokasi kerja, deskripsi pekerjaan (.*)$")
	public void kotaLokasiKerjaTidakDipilih(String nik, String jumlahOrang, String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.click();
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail Muali Kerja");
	}

	@And("^User input tujuan, NIK (.*), posisi, jumlah orang (.*), mulai kerja, lokasi kerja, kota kerja, field detail lokasi tidak dilakukan pengisian (.*), deskripsi pekerjaan (.*)$")
	public void detailLokasiKerja_Kosong(String nik, String jumlahOrang, String detailLokasi, String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail detail lokasi kerja");
	}

	@And("^User input tujuan, NIK (.*), posisi, jumlah orang (.*), mulai kerja, lokasi kerja, kota kerja, melakukan input detail lokasi dengan huruf angka dan spesial karakter (.*), deskripsi pekerjaan (.*)$")
	public void detailLokasiKerja_HurufAngkaSpk(String nik, String jumlahOrang, String detailLokasi, String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail detail lokasi kerja");
	}

	// DESKRIPSI PEKERJAAN
	@And("^User input tujuan, NIK (.*), posisi, jumlah orang (.*), mulai kerja, lokasi kerja, kota kerja, detail lokasi (.*), melakukan input deskripsi pekerjaan dengan huruf angka dan spesial karakter (.*)$")
	public void deskripsiPekerjaan_HurufAngkaSpk(String nik, String jumlahOrang, String detailLokasi, String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail detail lokasi kerja");
	}

	@And("^User input tujuan, NIK (.*), posisi, jumlah orang (.*), mulai kerja, lokasi kerja, kota kerja, detail lokasi (.*), tidak melakukan input deskripsi pekerjaan (.*)$")
	public void deskripsiPekerjaan_Kosong(String nik, String jumlahOrang, String detailLokasi, String desk) {
		req.tujuan("Penggantian");
		req.fieldNIK.sendKeys(nik);
		req.posisi("Accounting");
		req.formDetail_JmlhOrang.sendKeys(jumlahOrang);
		req.formDetail_MKerja.sendKeys("2022-08-18");
		req.lokasi("Other");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		req.pilihOther("Bandung");
		req.formDetail_OtherField.sendKeys(detailLokasi);
		req.formDetail_jobDesc.sendKeys(desk);
		System.out.println("Form Detail deskripsi pekerjaan");
	}

	// =============== ===============
	// FORM KUALIFIKASI
	@And("^User melakukan tambah field kualifikasi jenis kelamin, umur awal (.*), batas umur (.*), pendidikan, status perkawinan, kualifikasi lainnya (.*)$")
	public void input_form_kualifikasi(String umur1, String umur2, String kl) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.tambahKualifikasi("jk");
		req.tambahKualifikasi("umur");
		req.tambahKualifikasi("pendidikan");
		req.tambahKualifikasi("status_perkawinan");
		req.tambahKualifikasi("other");
		req.jk("2");
		req.formKualifikasi_UStart.sendKeys(umur1);
		req.formKualifikasi_UEnd.sendKeys(umur2);
		req.pendidikan("7");
		req.statusPerkawinan("4");
		req.formKualifikasi_KLainnya.sendKeys(kl);
		System.out.println("Form Kualifikasi Valid");
	}

	// JENIS KELAMIN
	@And("^User melakukan tambah field kualifikasi jenis kelamin dan tidak melakukan select data, umur awal (.*), batas umur (.*), pendidikan, status perkawinan, kualifikasi lainnya (.*)$")
	public void selectJKTidakDilakukan(String umur1, String umur2, String kl) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.tambahKualifikasi("jk");
		req.tambahKualifikasi("umur");
		req.tambahKualifikasi("pendidikan");
		req.tambahKualifikasi("status_perkawinan");
		req.tambahKualifikasi("other");
		req.formKualifikasi_UStart.sendKeys(umur1);
		req.formKualifikasi_UEnd.sendKeys(umur2);
		req.pendidikan("7");
		req.statusPerkawinan("4");
		req.formKualifikasi_KLainnya.sendKeys(kl);
		System.out.println("Form Kualifikasi Select Jenis Kelamin Tidak Dilakukan");
	}

	// UMUR
	@And("^User melakukan tambah field kualifikasi jenis kelamin, input umur kosong, spesial karakter dan huruf (.*)(.*), pendidikan, status perkawinan, kualifikasi lainnya (.*)$")
	public void inputUmurInvalid(String umur1, String umur2, String kl) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.tambahKualifikasi("jk");
		req.tambahKualifikasi("umur");
		req.tambahKualifikasi("pendidikan");
		req.tambahKualifikasi("status_perkawinan");
		req.tambahKualifikasi("other");
		req.jk("2");
		req.formKualifikasi_UStart.sendKeys(umur1);
		req.formKualifikasi_UEnd.sendKeys(umur2);
		req.pendidikan("7");
		req.statusPerkawinan("4");
		req.formKualifikasi_KLainnya.sendKeys(kl);
		System.out.println("Form Kualifikasi Umur Tidak Dilakukan");
	}

	@And("^User melakukan tambah field kualifikasi jenis kelamin, umur awal (.*) lebih besar dibanding batas umur (.*), pendidikan, status perkawinan, kualifikasi lainnya (.*)$")
	public void inputBatasUmurLebihKecil(String umur1, String umur2, String kl) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.tambahKualifikasi("jk");
		req.tambahKualifikasi("umur");
		req.tambahKualifikasi("pendidikan");
		req.tambahKualifikasi("status_perkawinan");
		req.tambahKualifikasi("other");
		req.jk("2");
		req.formKualifikasi_UStart.sendKeys(umur1);
		req.formKualifikasi_UEnd.sendKeys(umur2);
		String actual = req.getAlertMsg();
		System.out.println(actual);
		String expected = "Umur awal tidak boleh lebih besar dari batas umur.";
		Assert.assertEquals(actual, expected);
		req.pendidikan("7");
		req.statusPerkawinan("4");
		req.formKualifikasi_KLainnya.sendKeys(kl);
		System.out.println("Form Kualifikasi Umur awal > Batas Umur");
	}

	// PENDIDIKAN
	@And("^User melakukan tambah field kualifikasi jenis kelamin, umur awal (.*), batas umur (.*), select pendidikan tidak dilakukan, status perkawinan, kualifikasi lainnya (.*)$")
	public void selectPendidikanTidakDilakukan(String umur1, String umur2, String kl) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.tambahKualifikasi("jk");
		req.tambahKualifikasi("umur");
		req.tambahKualifikasi("pendidikan");
		req.tambahKualifikasi("status_perkawinan");
		req.tambahKualifikasi("other");
		req.jk("2");
		req.formKualifikasi_UStart.sendKeys(umur1);
		req.formKualifikasi_UEnd.sendKeys(umur2);
		req.statusPerkawinan("4");
		req.formKualifikasi_KLainnya.sendKeys(kl);
		System.out.println("Form Kualifikasi Pendidikan");
	}

	// STATUS PERKAWINAN
	@And("^User melakukan tambah field kualifikasi jenis kelamin, umur awal (.*), batas umur (.*), pendidikan, select status perkawinan tidak dilakukan, kualifikasi lainnya (.*)$")
	public void selectStatusPerkawinanTidakDilakukan(String umur1, String umur2, String kl) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.tambahKualifikasi("jk");
		req.tambahKualifikasi("umur");
		req.tambahKualifikasi("pendidikan");
		req.tambahKualifikasi("status_perkawinan");
		req.tambahKualifikasi("other");
		req.jk("2");
		req.formKualifikasi_UStart.sendKeys(umur1);
		req.formKualifikasi_UEnd.sendKeys(umur2);
		req.pendidikan("7");
		req.formKualifikasi_KLainnya.sendKeys(kl);
		System.out.println("Form Kualifikasi Status Perkawinan");
	}

	// KUALIFIKASI LAINNYA
	@And("^User melakukan tambah field kualifikasi jenis kelamin, umur awal (.*), batas umur (.*), pendidikan, status perkawinan, tidak melakukan input kualifikasi lainnya (.*)$")
	public void inputKualifikasiLainnyaKosong(String umur1, String umur2, String kl) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.tambahKualifikasi("jk");
		req.tambahKualifikasi("umur");
		req.tambahKualifikasi("pendidikan");
		req.tambahKualifikasi("status_perkawinan");
		req.tambahKualifikasi("other");
		req.jk("2");
		req.formKualifikasi_UStart.sendKeys(umur1);
		req.formKualifikasi_UEnd.sendKeys(umur2);
		req.pendidikan("7");
		req.statusPerkawinan("4");
		req.formKualifikasi_KLainnya.sendKeys(kl);
		System.out.println("Form Kualifikasi Lainnya");
	}

	@And("^User melakukan tambah field kualifikasi jenis kelamin, umur awal (.*), batas umur (.*), pendidikan, status perkawinan, melakukan input kualifikasi lainnya dengan huruf angka dan spesial karakter (.*)$")
	public void inputkualifikasiLainnyaValid(String umur1, String umur2, String kl) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.tambahKualifikasi("jk");
		req.tambahKualifikasi("umur");
		req.tambahKualifikasi("pendidikan");
		req.tambahKualifikasi("status_perkawinan");
		req.tambahKualifikasi("other");
		req.jk("2");
		req.formKualifikasi_UStart.sendKeys(umur1);
		req.formKualifikasi_UEnd.sendKeys(umur2);
		req.pendidikan("7");
		req.statusPerkawinan("4");
		req.formKualifikasi_KLainnya.sendKeys(kl);
		System.out.println("Form Kualifikasi Lainnya");
	}

	@And("^User melengkapi field kualifikasi jenis kelamin, umur awal (.*), batas umur (.*), pendidikan, status perkawinan, kualifikasi lainnya (.*)$")
	public void input_form_kualifikasi_invalidData(String umur1, String umur2, String kl) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.tambahKualifikasi("jk");
		req.tambahKualifikasi("umur");
		req.tambahKualifikasi("pendidikan");
		req.tambahKualifikasi("status_perkawinan");
		req.tambahKualifikasi("other");
		req.jk("2");
		req.formKualifikasi_UStart.sendKeys(umur1);
		req.formKualifikasi_UEnd.sendKeys(umur2);
		req.pendidikan("7");
		req.statusPerkawinan("4");
		req.formKualifikasi_KLainnya.sendKeys(kl);
		System.out.println("Form Kualifikasi Invalid");
	}

	// ================================
	// FORM STATUS KARYAWAN
	@And("^User melengkapi status karyawan, bulan (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void input_form_status(String bln, String thn, String masa, String gaji, String tj, String transport,
			String tk, String note) {
		System.out.println("Form Status Karyawan Valid");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_PKWT.click();
		req.PKWTMonth.sendKeys(bln);
		req.PKWTYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// KARYAWAN PERMANEN
	@And("^User melengkapi status karyawan, memilih status karyawan permanen, masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void memilihStatusKaryawanPermanen(String masa, String gaji, String tj, String transport, String tk,
			String note) {
		System.out.println("Form Status Karyawan Permanen");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// KARYAWAN PKWT
	@And("^User melengkapi status karyawan, memilih status karyawan PKWT, bulan (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void memilihStatusKaryawanPKWT(String bln, String thn, String masa, String gaji, String tj, String transport,
			String tk, String note) {
		System.out.println("Form Status Karyawan PKWT");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_PKWT.click();
		req.PKWTMonth.sendKeys(bln);
		req.PKWTYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, memilih status karyawan PKWT, check bulan bulan (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanPKWTCheckBulan(String bln, String thn, String masa, String gaji, String tj, String transport,
			String tk, String note) {
		System.out.println("Form Status Karyawan PKWT");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_PKWT.click();
		req.PKWTMonth.sendKeys(bln);
		req.PKWTYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, memilih status karyawan PKWT, input bulan > 12, bulan > 2 digit angka (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void StatusKaryawanPKWTinputBulan(String bln, String thn, String masa, String gaji, String tj,
			String transport, String tk, String note) {
		System.out.println("Form Status Karyawan PKWT");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_PKWT.click();
		req.PKWTMonth.sendKeys(bln);
		req.PKWTYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, memilih status karyawan PKWT, input bulan dengan huruf spesial karakter dan kosong (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanPKWTBulanInvalid(String bln, String thn, String masa, String gaji, String tj, String transport,
			String tk, String note) {
		System.out.println("Form Status Karyawan PKWT");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_PKWT.click();
		req.PKWTMonth.sendKeys(bln);
		req.PKWTYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, memilih status karyawan PKWT, bulan (.*), input tahun dengan huruf spesial karakter dan kosong (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanPKWTCheckTahunInvalid(String bln, String thn, String masa, String gaji, String tj,
			String transport, String tk, String note) {
		System.out.println("Form Status Karyawan PKWT");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_PKWT.click();
		req.PKWTMonth.sendKeys(bln);
		req.PKWTYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// MAGANG
	@And("^User melengkapi status karyawan, pilih karyawan Magang, bulan (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanMagang(String bln, String thn, String masa, String gaji, String tj, String transport, String tk,
			String note) {
		System.out.println("Form Status Karyawan Magang");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Magang.click();
		req.MagangMonth.sendKeys(bln);
		req.MagangYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, pilih karyawan Magang, input bulan > 12, bulan > 2 digit angka (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void StatusKaryawanMaganginputBulan(String bln, String thn, String masa, String gaji, String tj,
			String transport, String tk, String note) {
		System.out.println("Form Status Karyawan Magang");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Magang.click();
		req.MagangMonth.sendKeys(bln);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, pilih karyawan Magang, input bulan dengan huruf spesial karakter dan kosong (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanMagangBulanInvalid(String bln, String thn, String masa, String gaji, String tj,
			String transport, String tk, String note) {
		System.out.println("Form Status Karyawan Magang");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Magang.click();
		req.MagangMonth.sendKeys(bln);
		req.MagangYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, pilih karyawan Magang, bulan (.*), input tahun dengan huruf spesial karakter dan kosong (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanMagangCheckTahunInvalid(String bln, String thn, String masa, String gaji, String tj,
			String transport, String tk, String note) {
		System.out.println("Form Status Karyawan Magang");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Magang.click();
		req.MagangMonth.sendKeys(bln);
		req.MagangYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// MAGANG HARIAN
	@And("^User melengkapi status karyawan, memilih status karyawan Magang Harian, bulan (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanMagangHarian(String bln, String thn, String masa, String gaji, String tj, String transport,
			String tk, String note) {
		System.out.println("Form Status Karyawan Magang Harian");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_MagangHarian.click();
		req.MagangHarianMonth.sendKeys(bln);
		req.MagangHarianYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, memilih status karyawan Magang Harian, input bulan > 12, bulan > 2 digit angka (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanMagangHarianinputBulan(String bln, String thn, String masa, String gaji, String tj,
			String transport, String tk, String note) {
		System.out.println("Form Status Karyawan Magang Harian");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_MagangHarian.click();
		req.MagangHarianMonth.sendKeys(bln);
		req.MagangHarianYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, memilih status karyawan Magang Harian, input bulan dengan huruf spesial karakter dan kosong (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanMagangHarianBulanInvalid(String bln, String thn, String masa, String gaji, String tj,
			String transport, String tk, String note) {
		System.out.println("Form Status Karyawan Magang Harian");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_MagangHarian.click();
		req.MagangHarianMonth.sendKeys(bln);
		req.MagangHarianYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, memilih status karyawan Magang Harian, bulan (.*), input tahun dengan huruf spesial karakter dan kosong (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanMagangHarianCekTahunInvalid(String bln, String thn, String masa, String gaji, String tj,
			String transport, String tk, String note) {
		System.out.println("Form Status Karyawan Magang Harian");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_MagangHarian.click();
		req.MagangHarianMonth.sendKeys(bln);
		req.MagangHarianYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// MITRA
	@And("^User melengkapi status karyawan, pilih karyawan Mitra, bulan (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanMitra(String bln, String thn, String masa, String gaji, String tj, String transport, String tk,
			String note) {
		System.out.println("Form Status Mitra");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Mitra.click();
		req.Mitra_Month.sendKeys(bln);
		req.MitraYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, pilih karyawan Mitra, input bulan > 12, bulan > 2 digit angka (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanMitrainputBulan(String bln, String thn, String masa, String gaji, String tj, String transport,
			String tk, String note) {
		System.out.println("Form Status Mitra");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Mitra.click();
		req.Mitra_Month.sendKeys(bln);
		req.MitraYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, pilih karyawan Mitra, input bulan dengan huruf spesial karakter dan kosong (.*), tahun (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanMitraBulanInvalid(String bln, String thn, String masa, String gaji, String tj, String transport,
			String tk, String note) {
		System.out.println("Form Status Mitra");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Mitra.click();
		req.Mitra_Month.sendKeys(bln);
		req.MitraYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, pilih karyawan Mitra, bulan (.*), input tahun dengan huruf spesial karakter dan kosong (.*), masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void KaryawanMitraCekTahunInvalid(String bln, String thn, String masa, String gaji, String tj,
			String transport, String tk, String note) {
		System.out.println("Form Status Karyawan Magang");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Mitra.click();
		req.Mitra_Month.sendKeys(bln);
		req.MitraYear.sendKeys(thn);
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// MASA PERCOBAAN
	@And("^User melengkapi status karyawan masa percobaan dengan angka (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void cekMasaPercobaan(String masa, String gaji, String tj, String transport, String tk, String note) {
		System.out.println("Form Status Masa Percobaan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melakukan input status karyawan, masa percobaan input bulan lebih dari 12, bulan lebih dari 2 digit angka (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void cekMasaPercobaanInputBulan(String masa, String gaji, String tj, String transport, String tk,
			String note) {
		System.out.println("Form Status Karyawan Masa Percobaan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// GOLONGAN/JABATAN
	@And("^User melengkapi status karyawan, masa percobaan (.*), select golongan jabatan dilakukan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void cekGolonganJabatanValid(String masa, String gaji, String tj, String transport, String tk, String note) {
		System.out.println("Form Status Karyawan Golongan Jabatan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, masa percobaan (.*), select golongan jabatan tidak dilakukan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void cekGolonganJabatanInvalid(String masa, String gaji, String tj, String transport, String tk,
			String note) {
		System.out.println("Form Status Karyawan Golongan Jabatan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// FIELD GAJI

	@And("^User melengkapi status karyawan, masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void cekGajiValid(String masa, String gaji, String tj, String transport, String tk, String note) {
		System.out.println("Form Status Karyawan Gaji");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// ASURANSI
	@And("^User melengkapi status karyawan, masa percobaan (.*), golongan, gaji (.*), checkbox asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void checkboxAsuransi(String masa, String gaji, String tj, String transport, String tk, String note) {
		System.out.println("Form Status Karyawan Asuransi");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, masa percobaan (.*), golongan, gaji (.*), tidak melakukan pilih checkbox asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void checkboxAsuransiTidakDipilih(String masa, String gaji, String tj, String transport, String tk,
			String note) {
		System.out.println("Form Status Karyawan Asuransi");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// TUNJANGAN JABATAN
	@And("^User melengkapi status karyawan, masa percobaan (.*), golongan, gaji (.*), asuransi, input field tunjangan jabatan dengan data valid (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void tunjanganJabatanValid(String masa, String gaji, String tj, String transport, String tk, String note) {
		System.out.println("Form Status Tunjangan Jabatan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	@And("^User melengkapi status karyawan, masa percobaan (.*), golongan, gaji (.*), asuransi, invalid data tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void tunjanganJabatanInvalid(String masa, String gaji, String tj, String transport, String tk, String note) {
		System.out.println("Form Status Karyawan Tunjangan Jabatan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// TUNJANGAN TRANSPORTASI
	@And("^User melengkapi status karyawan, masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), data valid tunjangan transportasi (.*), tunjangan komunikasi (.*), note (.*)$")
	public void tunjanganTransportasiValid(String masa, String gaji, String tj, String transport, String tk,
			String note) {
		System.out.println("Form Status Karyawan Tunjangan Transportasi");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

//	@And("^User melengkapi status karyawan, masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), input tunjangan transportasi dengan invalid data (.*), tunjangan komunikasi (.*), note (.*)$")
//	public void tunjanganTransportasiInvalid(String masa, String gaji, String tj, String transport, String tk,
//			String note) {
//		System.out.println("Form Status Karyawan Tunjangan Transportasi");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(350,500)");
//		req.rBtn_Tetap.click();
//		req.probation.sendKeys(masa);
//		req.golongan("Manager");
//		req.gaji.sendKeys(gaji);
//		req.asBPJS.click();
//		req.asSwasta.click();
//		req.asKecelakaan.click();
//		req.asPensiun.click();
//		js.executeScript("window.scrollBy(500,1000)");
//		req.tunjanganJab.sendKeys(tj);
//		req.tunjanganTransp.sendKeys(transport);
//		req.tunjanganKom.sendKeys(tk);
//		req.note.sendKeys(note);
//	}

	// TUNJANGAN KOMUNIKASI
	@And("^User melengkapi status karyawan, masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), input tunjangan komunikasi dengan data valid (.*), note (.*)$")
	public void tunjanganKomunikasiValid(String masa, String gaji, String tj, String transport, String tk,
			String note) {
		System.out.println("Form Status Tunjangan Komunikasi");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// NOTE
	@And("^User melengkapi status karyawan, masa percobaan (.*), golongan, gaji (.*), asuransi, tunjangan jabatan (.*), tunjangan transportasi (.*), tunjangan komunikasi (.*), input note dengan data valid (.*)$")
	public void noteDataValid(String masa, String gaji, String tj, String transport, String tk, String note) {
		System.out.println("Form Status Note");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		req.golongan("Manager");
		req.gaji.sendKeys(gaji);
		req.asBPJS.click();
		req.asSwasta.click();
		req.asKecelakaan.click();
		req.asPensiun.click();
		js.executeScript("window.scrollBy(500,1000)");
		req.tunjanganJab.sendKeys(tj);
		req.tunjanganTransp.sendKeys(transport);
		req.tunjanganKom.sendKeys(tk);
		req.note.sendKeys(note);
	}

	// =====================
	@And("User klik tombol kirim")
	public void user_klik_tombol_kirim() {
		System.out.println("user klik tombol kirim");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		req.btnKirim.click();
	}

	@Then("Data tersimpan")
	public void data_tersimpan() {
		System.out.println("Data tersimpan");
		System.out.println(req.successMessage.getText());
		String actual = req.successMessage.getText();
		actual = actual.replace("×", "").trim();
		System.out.println(actual);
		String expected = "Data berhasil disimpan";
		Assert.assertEquals(actual, expected);
	}

	@Then("Data tidak dapat tersimpan dan muncul eror dihalaman input data")
	public void input_data_kosong() {
		System.out.println("Data tidak tersimpan");
	}

	@And("User melakukan validasi data semua field kosong")
	public void validasiData() {
		System.out.println("Validasi data kosong");
		req.getErorTujuan();
	}

	// =============== VALIDATE DATA ===============
	@Then("Validasi loging sub menu pending")
	public void logingPending() {
		System.out.println("Validasi loging sub menu pending");
		req.getPending();
	}

	@Then("User validasi show data sesuai")
	public void validasiShowData() {
		System.out.println("Validasi show data sesuai");
		req.getShowData();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4000)");
		req.sleep(500);
	}

	@And("User validasi data select tujuan")
	public void tujuanTidakDipilih() {
		System.out.println("Validasi tujuan");
		req.getErorTujuan();
	}

	@And("User validasi data select posisi")
	public void posisiTidakDipilih() {
		System.out.println("Validasi posisi");
		req.getErorPosisi();
	}

	@And("User validasi data NIK")
	public void validasiData_Nik() {
		req.cekNik();
		System.out.println("Validasi Nik Spesial Karakter");
	}

	@And("User validasi data NIK kosong")
	public void validasiData_NikKosong() {
		req.getErorNik();
		System.out.println("Validasi Nik kosong");

	}

	@And("User validasi data jumlah orang")
	public void validasiData_JumlahOrang() {
		System.out.println("Validasi jumlah orang");
		req.getErorJumlahOrang();
	}

	@And("User validasi data lokasi kerja")
	public void validasiData_lokasiKerja() {
		System.out.println("Validasi lokasi kerja");
		req.getErorLokasiKerja();
	}

	@And("User validasi data deskripsi pekerjaan")
	public void validasiData_deskripsiPekerjaan() {
		System.out.println("Validasi deskripsi pekerjaan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		req.getErorDeskripsiPekerjaan();
	}

	@And("User validasi data select jenis kelamin")
	public void validasiData_selectJenisKelamin() {
		System.out.println("Validasi data select jenis kelamin");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.getErorJenisKelamin();
	}

	@And("User validasi data input umur")
	public void validasiData_inputUmurTidakDilakukan() {
		System.out.println("Validasi data input umur");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.getErorUmurStart();
		req.getErorBatasUmur();
	}

	@And("User validasi data select pendidikan")
	public void validasiData_selectPendidikan() {
		System.out.println("Validasi data select pendidikan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.getErorPendidikan();
	}

	@And("User validasi data select status perkawinan")
	public void validasiData_selectStatusPerkawinan() {
		System.out.println("Validasi data select status perkawinan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200,350)");
		req.getErorStatusPerkawinan();
	}

	@And("User validasi data input kualifikasi lainnya")
	public void validasiData_inputKualifikasiLainnya() {
		System.out.println("Validasi data input kualifikasi lainnya");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.getErorKualifikasiLainnya();
	}

	// ==================================
	// CEK FIELD BULAN
	@And("User validasi bulan PKWT")
	public void validasi_bulanPKWT() {
		Assert.assertTrue(req.cekPKWT());
		System.out.println("Validasi PKWT");
	}

	@And("User validasi bulan magang")
	public void validasi_bulanMagang() {
		Assert.assertTrue(req.cekMagang());
		System.out.println("Validasi magang");
	}

	@And("User validasi bulan magang harian")
	public void validasi_bulanMagangHarian() {
		Assert.assertTrue(req.cekMagangHarian());
		System.out.println("Validasi magang harian");
	}

	@And("User validasi bulan mitra")
	public void validasi_bulanMitra() {
		Assert.assertTrue(req.cekMitra());	
		System.out.println("Validasi mitra");
	}

	@And("User validasi data input bulan PKWT")
	public void validasiData_inputPKWTBulan() {
		System.out.println("Validasi data input PKWT");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,700)");
		req.getErorPKWTBulan();
	}

	@And("User validasi data input tahun PKWT")
	public void validasiData_inputPKWTTahun() {
		System.out.println("Validasi data input PKWT");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,700)");
		req.getErorPKWTTahun();
	}

	@And("User validasi data input bulan Magang")
	public void validasiData_inputMagangBulan() {
		System.out.println("Validasi data input bulan Magang");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		req.getErorMagangBulan();
	}

	@And("User validasi data input tahun Magang")
	public void validasiData_inputMagangTahun() {
		System.out.println("Validasi data input tahun Magang");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		req.getErorMagangTahun();
	}

	@And("User validasi data input bulan Magang Harian")
	public void validasiData_inputMagangHarianCekBulan() {
		System.out.println("Validasi data input bulan Magang Harian");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		req.getErorMagangHarianBulan();
	}

	@And("User validasi data input tahun Magang Harian")
	public void validasiData_inputMagangHarianCekTahun() {
		System.out.println("Validasi data input tahun Magang Harian");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		req.getErorMagangHarianTahun();
	}

	@And("User validasi data input bulan Mitra")
	public void validasiData_inputMitraCekBulan() {
		System.out.println("Validasi data input bulan Mitra");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		req.getErorMitraBulan();
	}

	@And("User validasi data input tahun Mitra")
	public void validasiData_inputMitraCekTahun() {
		System.out.println("Validasi data input tahun Mitra");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		req.getErorMitraTahun();
	}

	@Then("User validasi data input non mandatory")
	public void validasiData_nonMandatory() {
		System.out.println("validasi masa percobaan invalid");
		req.sleep(1000);
		System.out.println(req.successMessage.getText());
		String actual = req.successMessage.getText();
		if (req.successMessage.isDisplayed()) {
			Assert.assertTrue(false);
		}
	}

	@Then("^User validasi field masa percobaan (.*)$")
	public void validasiData_masaPercobaan(String masa) {
		System.out.println("Form Status Karyawan Masa Percobaan");
		req.rBtn_Tetap.click();
		req.probation.sendKeys(masa);
		String expected = "";
		String actual = req.probation.getText();
		Assert.assertEquals(actual, expected);
	}

	@And("User validasi data input Golongan")
	public void validasiData_inputGolongan() {
		System.out.println("Validasi data input Golongan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		req.getErorGolongan();
	}

	@And("^User validasi field gaji (.*)$")
	public void validasiData_fieldGaji(String gaji) {
		System.out.println("Form Status Karyawan Gaji");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.gaji.sendKeys(gaji);
		String expected = "";
		String actual = req.gaji.getText();
		Assert.assertEquals(actual, expected);
	}

	@And("^User validasi field tunjangan jabatan (.*)$")
	public void validasiData_jabatan(String jabatan) {
		System.out.println("Form Status Karyawan tunjangan jabatan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.tunjanganJab.sendKeys(jabatan);
		String expected = "";
		String actual = req.tunjanganJab.getText();
		Assert.assertEquals(actual, expected);
	}

	@And("^User validasi field tunjangan transportasi (.*)$")
	public void validasiData_transportasi(String transportasi) {
		System.out.println("Form Status Karyawan tunjangan transportasi");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.tunjanganTransp.sendKeys(transportasi);
		String expected = "";
		String actual = req.tunjanganTransp.getText();
		Assert.assertEquals(actual, expected);
	}

	@And("^User validasi field tunjangan komunikasi (.*)$")
	public void validasiData_komunikasi(String komunikasi) {
		System.out.println("Form Status Karyawan tunjangan komunikasi");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.tunjanganKom.sendKeys(komunikasi);
		String expected = "";
		String actual = req.tunjanganKom.getText();
		Assert.assertEquals(actual, expected);
	}

	@And("^User validasi field note (.*)$")
	public void validasiData_note(String note) {
		System.out.println("field note");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,500)");
		req.note.sendKeys(note);
		String expected = "";
		String actual = req.note.getText();
		Assert.assertEquals(actual, expected);
	}

	@Then("User validasi detail data permintaan baru")
	public void validasiDetailData() {
		System.out.println("Validasi detail data permintaan baru");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)");
		req.getPermintaanBaru();
	}

	@And("User validasi data semua field kosong")
	public void validasiDataFieldKosong() {
		System.out.println("Validasi data kosong");
		req.getErorNik();
	}

	// =============== MODUL TRACKING ===============
	@And("^User menjalankan search data berdasarkan search (.*)$")
	public void cekSearchGagal(String search) {
		track.sleep(7000);
		track.searchDataTracking(search);
		track.sleep(10000);
	}

	@And("User melakukan show data pada sub menu tracking")
	public void showDataTracking() {
		System.out.println("show data");
		req.sleep(2000);
		req.showData();
		req.sleep(1000);
	}

	@And("^User melakukan cek filter data input tanggal from sub menu tracking (.*)$")
	public void cekFilterFrom(String date1) {
		track.startDateFilter.click();
		((JavascriptExecutor) driver).executeScript("document.getElementById('fField').removeAttribute('readonly',0);");

		WebElement fromDateBox = driver.findElement(By.id("fField"));
		fromDateBox.clear();
		fromDateBox.sendKeys(date1);
	}

	@And("^User melakukan input tanggal to sub menu tracking (.*)$")
	public void cekFilterTo(String date2) {
		track.toDateFilter.click();
		((JavascriptExecutor) driver).executeScript("document.getElementById('tField').removeAttribute('readonly',0);");
		WebElement toDateBox = driver.findElement(By.id("tField"));

		toDateBox.clear();
		toDateBox.sendKeys(date2);
		track.btnFilter.click();
		track.sleep(5000);
	}

	@And("^Validasi filter (.*) date (.*)$")
	public void filter_date_by(String from, String to) {

		String[] strFrom = from.split("-");
		int tglFrom = Integer.parseInt(strFrom[0]);

		String[] strTo = to.split("-");
		int tglTo = Integer.parseInt(strTo[0]);

		int expected = 13;

		System.out.println(expected);
		boolean check = false;
		if (expected >= tglFrom && expected <= tglTo) {
			System.out.println("Data benar");
			check = true;
		}
		Assert.assertTrue(check);
	}

	@And("^User validasi fitur filter (.*) date (.*)$")
	public void cekFilterDate(String from, String to) {

		String[] strFrom = from.split("-");
		int tglFrom = Integer.parseInt(strFrom[0]);

		String[] strTo = to.split("-");
		int tglTo = Integer.parseInt(strTo[0]);

		int expected = 8;

		System.out.println(expected);
		boolean check = false;
		if (expected >= tglFrom && expected <= tglTo) {
			System.out.println("Data benar");
			check = true;
		}
		Assert.assertTrue(check);
	}

	@Then("Validasi loging sub menu tracking")
	public void logingTracking() {
		System.out.println("Validasi loging sub menu tracking");
		track.getTracking();
	}

	// =============== AFTER ===============
	@After
	public void close(Scenario scenario) {
		req.sleep(2000);
		System.out.println(scenario.getStatus());

		if (scenario.isFailed() || scenario.getStatus().equals("FAILED") || scenario.getStatus().equals("UNDEFINED")) {
			System.out.println("take screenshot");
			String file = "<img src='file://" + req.screenshoot(driver) + "'height=\"350\" width=\"792\"/>";
			Reporter.log(file);
			driver.close();
		}
		driver.close();

	}

}
