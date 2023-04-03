package apt.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonWait {
//	private static final Logger LOGGER = Logger.getLogger(CommonWait.class);
//
//	private static void sleep(int milisecond) {
//		try {
//			Thread.sleep(milisecond);
//		} catch (InterruptedException e) {
//			LOGGER.error(e.getMessage());
//		}
//	}
//
//	private static void implicitlyWait(WebDriver driver, TimeUnit typeTime, int time) {
//		driver.manage().timeouts().implicitlyWait(time, typeTime);
//	}
//
//	private static void fluentWait(WebDriver driver, Duration duration) {
//		Wait wait = new FluentWait(driver).withTimeout(duration).pollingEvery(duration).ignoring(Exception.class);
//	}
//
//	private static void waitVisibilityOfElementLocated(WebDriver driver, long timeout, By element) {
//		WebDriverWait wait = new WebDriverWait(driver,timeout);
//		WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//	}
}
