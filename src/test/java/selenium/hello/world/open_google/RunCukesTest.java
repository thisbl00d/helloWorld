package selenium.hello.world.open_google;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = { "classpath:features/" }
,snippets = SnippetType.UNDERSCORE
,tags = {"@runMe"}
//,glue = {"cat/ui/automation/stepdefinitions" } 
,plugin = { "pretty", "html:target/cucumberreports/html/", "json:target/cucumberreports/json/" }
)
public class RunCukesTest {
	//This class will remain blank
  @BeforeClass
    public static void setupProperties() {
        System.setProperty("classname", "RunCukesTest");
    }
}