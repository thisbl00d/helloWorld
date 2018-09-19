package selenium.hello.world.open_google;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class opengoogleStep {

	public static WebDriver baseDriver;
	private CommonStepData stepData;
	private Log log = LogFactory.getLog(opengoogleStep.class);

	public opengoogleStep(CommonStepData inputStepData) {
		if (null == inputStepData) {
			this.stepData = new CommonStepData();
		} else {
			this.stepData = inputStepData;
		}
		baseDriver = CommonStepData.baseInstanceDriver;
	}

	@Given("^I have the url for google search$")
	public void i_have_the_url_for_google_search() throws Throwable {
		stepData.url = "https://www.google.com/";
		log.info("assigned google URL");
	}

	@When("^I navigate to google dot com$")
	public void i_navigate_to_google_dot_com() throws Throwable {
		baseDriver.get(stepData.url);
		log.info("navigated chromedriver to google.com");
	}

	@Then("^I see a text box and enter a search keyword$")
	public void i_see_a_text_box_and_enter_a_search_keyword() throws Throwable {
		WebElement tBoxSearch = baseDriver.findElement(By.id("lst-ib"));
		assertTrue("Unable to find the search textbox.", tBoxSearch.isDisplayed());
		assertTrue("search textbox not enabled.", tBoxSearch.isEnabled());
		tBoxSearch.sendKeys("selenium");
		tBoxSearch.submit();
		log.info("successfully performed search for selenium keyword");
	}

}
