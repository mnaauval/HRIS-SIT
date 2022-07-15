package runner.dashboard;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/002-MODUL DASHBOARD/HRISDashboard_MNG.feature", 
glue = "definitions.promotion")
public class HRISDashboardRunner extends AbstractTestNGCucumberTests {

}
