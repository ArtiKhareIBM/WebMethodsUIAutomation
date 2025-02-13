package com.webMethodsUI.flow.VersionControlPageObject;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.Settingpage.Oauthclientregistrationhomepage;
import com.webMethodsUI.flow.testbase.CommonActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VersionControl extends CommonActions {

	private WebDriver driver;
	private Logger log = LogManager.getLogger(Oauthclientregistrationhomepage.class);
	WaitHelper waitHelper;

	public VersionControl(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("version control page created");
	}

	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	@FindBy(xpath = "//i[@class='delite-icon dlt-icon-profile']")
	@CacheLookup
	WebElement UserProfile;

	@FindBy(xpath = "//span[@data-eventmap='metadata-AccountDetailsDropdown-{\"settings\"}']")
	@CacheLookup
	WebElement Settings;

	@FindBy(xpath = "//span[normalize-space()='Version control']")
	@CacheLookup
	WebElement Version_control;

	@FindBy(xpath = "//button[@type='button']")
	@CacheLookup
	WebElement AddButton;

	@FindBy(xpath = "//input[@id='display-name']")
	@CacheLookup
	WebElement SourceControl;

	@FindBy(xpath = "//input[@id='user-name']")
	@CacheLookup
	WebElement Username;

	@FindBy(xpath = "//div[@class='select2-common__value-container select2-common__value-container--has-value css-1hwfws3']")
	@CacheLookup
	WebElement Dropdown;

	@FindBy(xpath = "//input[@id='host_name']")
	@CacheLookup
	WebElement HostName;

	@FindBy(xpath = "//input[@id='new-token']")
	@CacheLookup
	WebElement PersonalAccessToken;

	@FindBy(xpath = "//button[normalize-space()='Validate']")
	@CacheLookup
	WebElement ValidateToken;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	@CacheLookup
	WebElement AddVersionControl;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement NotificationMessage;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	@CacheLookup
	WebElement ConfirmDeleteButton;

	@FindBy(xpath = "//div[@class='alert-container']")
	@CacheLookup
	WebElement ConfirmDeleteAlert;

	public void addVersionControl() throws Exception {

		click(UserProfile, driver, "click on User profile..");
		click(Settings, driver, "click on settings..");
		click(Version_control, driver, "click on Version Control tab..");
		click(AddButton, driver, "click on Add Button..");

	}

	public void enterSourceControl(String srcGithubCtrl) throws Exception {

		logExtentReport("Entering Github source control");
		log.info("Entering Github source control");
		enterValue(SourceControl, srcGithubCtrl, driver, "Enter the source control " + srcGithubCtrl);

	}

	public void enterUsername(String username) throws Exception {

		logExtentReport("Entering Username");
		log.info("Entering Username");
		enterValue(Username, username, driver, "Enter the User name " + username);

	}

	public void enterHostName(String hostname) throws Exception {

		logExtentReport("Entering HostName");
		log.info("Entering HostName");
		clearAndEnterText(HostName, hostname, driver, "Entering HostName");

	}

	public void enterPAT(String pat) throws Exception {

		logExtentReport("Entering Personal Access Token");
		log.info("Entering Personal Access Token");
		clearAndEnterText(PersonalAccessToken, pat, driver, "Entering Personal Access Token");

	}

	public void clickValidateAndAdd() throws Exception {

		logExtentReport("click Validate And Add...");
		log.info("click Validate And Add...");
		isElementEnabled(ValidateToken, driver, "click Validate And Add...");
		click(ValidateToken, driver, "click on Validate Button..");
		click(AddVersionControl, driver, "click on Add Version Control Button..");
		waitForElementVisible(NotificationMessage, driver, "checking success notification message for add success");

	}

	public void deleteSourceControlFromVersionControl(String srcCtrl) throws Exception {

		logExtentReport("Delete Source Control...");
		log.info("Deleting Source Control...");
		WebElement element = findElement("//span[normalize-space()='" + srcCtrl
				+ "']/ancestor::div[@class='git-account-row row']//a[contains(@title, 'Delete')]", driver);
		click(element, driver, "Removing the added source control :");
		click(ConfirmDeleteButton, driver, "clicking confirm delete button..");
		waitForElementVisible(ConfirmDeleteAlert, driver, "Confirming Source Control delete.. ");
		log.info(" Source Control Deleted...");

	}

	/*
	 * public void validateElementNotVisible(String srcCtrl) throws Exception {
	 * String element = "//span[normalize-space(),'srcCtrl')]";
	 * waitForElementNotVisible(element, driver,
	 * "wait for page load, source control should not be visible");
	 * 
	 * }
	 */

}
