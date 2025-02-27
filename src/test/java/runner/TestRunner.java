package test.java.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features",  // ✅ Correct feature file path
	    glue = "test/java/stepDefinitions",  
	    tags = "@leadedit or @lead",
	    plugin = {"pretty", "html:target/cucumber-reports.html"},
	    monochrome = true
	)

public class TestRunner {
}