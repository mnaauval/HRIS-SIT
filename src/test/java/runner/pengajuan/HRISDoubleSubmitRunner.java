package runner.pengajuan;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = "src/test/resources/features/003-MODUL PENGAJUAN CUTI/HRISDoubleSubmit.feature", glue = "definitions.data")
public class HRISDoubleSubmitRunner extends AbstractTestNGCucumberTests {

}
