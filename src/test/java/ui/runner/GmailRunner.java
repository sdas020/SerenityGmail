package ui.runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources",glue={"ui.steps"},tags={"@gmail"},
plugin={"pretty","html:cucumberReport/cucumber-html-report","json:cucumberReport/cucumber-report.json"})

public class GmailRunner {

}
