
package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Feature",glue={"StepDefinations","hooks"}, monochrome=true,
plugin = {"html:target/cucumber.html"}, tags="@tag1123")
public class TestRunner extends AbstractTestNGCucumberTests {
    
}
