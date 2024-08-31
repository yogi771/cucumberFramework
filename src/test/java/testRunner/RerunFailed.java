package testRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "@target/rerun.txt",
		glue="stepDefinitations",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html: test-output","html:target/rerun-cucumber-reports.html"}
		)
		

public class RerunFailed {

}
