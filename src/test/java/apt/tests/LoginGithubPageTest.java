package apt.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import apt.configs.DriverBase;
import apt.page_object.LoginGithubPage;

public class LoginGithubPageTest extends DriverBase {

	@Test
	public void applyAsDeveloper() throws Exception {
		// Create object of HomePage Class
		LoginGithubPage page = new LoginGithubPage();
		sleepOfThread(3000);
		page.clickBtnSinginPage();

		sleepOfThread(3000);
		// Check if page is opened
		Assert.assertTrue(page.isSinginFormOpened());

		page.setEmail("vanvtt-soft");
		page.setPassword("van.vu93");
		page.clickBtnSingin();

		sleepOfThread(3000);
		page.clickBtnAvatar();

		sleepOfThread(3000);
		// Check
		Assert.assertTrue(page.checkAccount());

	}
}
