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
		page.clickBtnSinginPage();

		// Check if page is opened
		Assert.assertTrue(page.isSinginFormOpened());

		page.setEmail("Vanvtt");
		page.setPassword("van.vu93");
		page.clickBtnSingin();

		page.clickBtnAvatar();

		// Check
		Assert.assertTrue(page.checkAccount());

	}
}
