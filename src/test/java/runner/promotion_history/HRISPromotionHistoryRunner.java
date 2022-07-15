package runner.promotion_history;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/006-MODUL PROMOTION HISTORY/HRISPagePromotionHistory.feature", 
glue = "definitions.promotion")
public class HRISPromotionHistoryRunner extends AbstractTestNGCucumberTests {

}
