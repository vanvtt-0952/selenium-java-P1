package apt.configs;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public enum DriverType implements DriverSetup {

	FIREFOX {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			System.setProperty("webdriver.gecko.driver", "/home/vu.thi.tran.van/vanvtt-0952/Trainings/automation/Java-language/driver/geckodriver");
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capabilities);
			options.setHeadless(HEADLESS);
			return new FirefoxDriver(options);
		}
	},
	CHROME {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			System.setProperty("webdriver.chrome.driver", "/home/vu.thi.tran.van/vanvtt-0952/Trainings/automation/Java-language/driver/chromedriver");
			HashMap<String, Object> chromePreferences = new HashMap<>();
			chromePreferences.put("profile.password_manager_enabled", false);

			ChromeOptions options = new ChromeOptions();
			options.merge(capabilities);
			options.setHeadless(HEADLESS);
			options.addArguments("--no-default-browser-check");
			options.setExperimentalOption("prefs", chromePreferences);

			return new ChromeDriver(options);
		}
	};

	public final static boolean HEADLESS = Boolean.getBoolean("headless");

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
