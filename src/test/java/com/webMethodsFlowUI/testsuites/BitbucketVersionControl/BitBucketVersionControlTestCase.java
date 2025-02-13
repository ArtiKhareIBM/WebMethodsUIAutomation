package com.webMethodsFlowUI.testsuites.BitbucketVersionControl;

import com.webMethodsUI.flow.VersionControlPageObject.VersionControl;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.PackageConnector.PackageConnectorPage;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class BitBucketVersionControlTestCase extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	VersionControl versionControl;
	WebElement element;
	CommonActions commonActions;
	PackageConnectorPage packageConnectorPage;
	String srcCtrl = "srcCtrl_bitbucket_Arti";
	String username = "artikhare";
	String bitbucketsrcCtrl = "Bitbucket";
	String bitbucket_hostname = "bitbucket.org";
	String bitbucket_pat = "ATBBbGDhRrPXkFT7G2UVDCpT3Rpy32594F58";

	@Test(priority = 1, groups = " bitbucket source control", description = "ensure login worked fine", testName = "login test case")
	public void loginTest() throws Exception {
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}

	@Test(priority = 2, groups = " bitbucket source control", description = "clicking User profile", testName = "clicking User profile")
	public void addbitbucketVersionControl() throws Exception {

		versionControl = new VersionControl(driver);
		versionControl.addVersionControl();

	}

	@Test(priority = 3, groups = " bitbucket source control", description = "Entering bitbucket Source Control Details", testName = "Entering bitbucket Source Control")
	public void enterbitbucketSourceControl() throws Exception {

		versionControl = new VersionControl(driver);
		versionControl.enterSourceControl(srcCtrl);
		versionControl.enterUsername(username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("Bitbucket");
		versionControl.enterHostName(bitbucket_hostname);
		versionControl.enterPAT(bitbucket_pat);
		versionControl.clickValidateAndAdd();
	}

	@Test(priority = 4, groups = " bitbucket source control", description = "verifying SourceControl is Created", testName = "verifying SourceControl is Created")
	public void verifySourceControlIsCreated() throws Exception {
		packageConnectorPage.VerifyElementVisible(srcCtrl);
	}

	@Test(priority = 5, groups = " bitbucket source control", description = "deleting source control", testName = "deleting source control")
	public void deleteSourceControl() throws Exception {
		versionControl.deleteSourceControlFromVersionControl(srcCtrl);

	}

}
