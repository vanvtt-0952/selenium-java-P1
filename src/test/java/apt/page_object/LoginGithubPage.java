package apt.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import apt.configs.DriverBase;

public class LoginGithubPage {

	private String urlPage = "https://github.com/";

	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	private WebElement btnSinginPage;

	@FindBy(how = How.CLASS_NAME, using = "auth-form-header")
	private WebElement titleForm;

	@FindBy(id = "login_field")
	private WebElement txtEmail;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(how = How.NAME, using = "commit")
	private WebElement btnSingin;

	@FindBy(how = How.XPATH, using = "//*[@class='avatar avatar-small circle']")
	private WebElement btnAvatar;

	@FindBy(how = How.CLASS_NAME, using = "user-profile-link")
	private WebElement labelAccount;

	private WebDriver driver;

	public LoginGithubPage() throws Exception {
		this.driver = DriverBase.getDriver();
		driver.get(urlPage); // Initialise Elements
		driver.manage().window().maximize(); // full screen
		PageFactory.initElements(driver, this);
	}

	public void clickBtnSinginPage() {
		btnSinginPage.click();
	}

	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickBtnSingin() {
		btnSingin.click();
	}

	public void clickBtnAvatar() {
		btnAvatar.click();
	}

	public boolean isSinginFormOpened() {
		return titleForm.getText().toString().contains("Sign in to GitHub");
	}

	public boolean checkAccount() {
		return labelAccount.getText().toString().contains("vanvtt-soft");
	}

}
