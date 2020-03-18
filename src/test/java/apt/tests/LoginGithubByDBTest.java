package apt.tests;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import apt.configs.DriverBase;
import apt.configs.database.DatabaseConfig;
import apt.page_object.LoginGithubPage;

public class LoginGithubByDBTest extends DriverBase {
	Statement st;

	@BeforeTest
	public void setup() {
		DatabaseConfig dbConfig = new DatabaseConfig();
		st = dbConfig.connectDatabase();
	}

	@Test
	public void applyAsDeveloper() throws Exception {
		// Create object of HomePage Class
		LoginGithubPage page = new LoginGithubPage();
		page.clickBtnSinginPage();

		// Check if page is opened
		Assert.assertTrue(page.isSinginFormOpened());
		List<String> account = loadData();
		page.setEmail(account.get(0).toString());
		page.setPassword(account.get(1).toString());
		page.clickBtnSingin();

		page.clickBtnAvatar();

		// Check
		Assert.assertTrue(page.checkAccount());

	}

	private List<String> loadData() {
		List<String> accounts = new ArrayList<String>();
		try {
			String query = "select * from account";
			// Get the contents of userinfo table from DB
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				accounts.add(res.getString("username").toString());
				accounts.add(res.getString("password").toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return accounts;
	}

}
