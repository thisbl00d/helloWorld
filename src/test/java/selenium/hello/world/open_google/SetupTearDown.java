package selenium.hello.world.open_google;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.ConfigurationProperties;

public class SetupTearDown {
	private static Log log = LogFactory.getLog(SetupTearDown.class);
	
	@Before
	public static void setUp() {
		String chromeDriver = ConfigurationProperties.getPropertyValueByKey("IsChromeBrowserActive");
		if (chromeDriver.equals("true")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments(ConfigurationProperties.getPropertyValueByKey("chromeOptionsUseIncognito"));
			options.addArguments(ConfigurationProperties.getPropertyValueByKey("chromeOptionsDisableInfoBar"));
			options.addArguments(ConfigurationProperties.getPropertyValueByKey("chromeOptionsStartMaximized"));
			
			System.setProperty(ConfigurationProperties.getPropertyValueByKey("chromeDriverSystemProperty"),
			ConfigurationProperties.getPropertyValueByKey("chromeDriver"));
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			if (null == CommonStepData.baseInstanceDriver) {
				CommonStepData.baseInstanceDriver = new ChromeDriver(capabilities);
			}
		}
		if (CommonStepData.baseInstanceDriver != null) {
			CommonStepData.baseInstanceDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
	}

	
	@After
	public static void tearDown() throws Throwable{
			if (CommonStepData.baseInstanceDriver != null) {
				CommonStepData.baseInstanceDriver.manage().deleteAllCookies();
				CommonStepData.baseInstanceDriver.quit();
		}
		log.info("Successfully quit chromedriver instances.");
	}
}