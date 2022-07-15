package runner.promotion;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
// src/test/resources/features/HRISPagePromotion.feature
// src/test/resources/features/HRISAddPromotion.feature  
// src/test/resources/features/HRISPagePromotionHistory_Search.feature -> Search
// src/test/resources/features/HRISPagePromotionHistory.feature
// src/test/resources/features/HRISAddPromotionSalary.feature
// src/test/resources/features/HRISAddPromotionJabatan.feature
// src/test/resources/features/HRISAddPromotionContract.feature



@CucumberOptions(tags = "", features = "src/test/resources/features/005-MODUL PROMOTION/HRISAddPromotionSalary.feature", 
glue = "definitions.promotion")
public class HRISPagePromotionSalary extends AbstractTestNGCucumberTests {

}
