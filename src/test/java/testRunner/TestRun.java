package testRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= ".//Features/SwitchWindows.feature",
		glue="stepDefinitations",
		dryRun=true,
		monochrome=true,
		plugin= {"pretty","html: test-output","json:target/cucumber.json","rerun:target/rerun.txt"}
		)

public class TestRun {	
	
}