package StepDefinations;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature",glue={"StepDefinations"}, monochrome=true,
plugin = {"pretty", "html:target/cucumber-report", "json:target/cucumber.json"}, tags = "@taggooglesearch"
		)
public class TestRunner {

}
