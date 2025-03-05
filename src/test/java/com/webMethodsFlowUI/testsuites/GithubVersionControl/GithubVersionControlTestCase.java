package com.webMethodsFlowUI.testsuites.GithubVersionControl;

import com.webMethodsUI.flow.VersionControlPageObject.VersionControl;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.PackageConnector.PackageConnectorPage;

import githubAPIs.GithubAPI;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class GithubVersionControlTestCase extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	VersionControl versionControl;
	WebElement element;
	CommonActions commonActions;
	PackageConnectorPage packageConnectorPage;
	String srcCtrl = "srcGithubCtrl_Arti";
	String username = "ArtiKhareIBM";
	String githubsrcCtrl = "GitHub";
	String github_hostname = "github.com";
	String github_pat = "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";
	String invalid_github_pat = "34298ud9r4j3ygBIcktiqjpa2kUayz";
	String projectName = "GithubAutomation";
	String dynamicRepoName = projectName + "Project";
	String description = "Github Automation Project";
	String homepage = "https://github.com";
	boolean isPrivate = true;
	String isDynamic = "true";

	@Test(priority = 1, groups = " github source control", description = "ensure login worked fine", testName = "login test case")
	public void loginTest() throws Exception {
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}

	@Test(priority = 2, groups = " github source control", description = "create Github SourceControl Account", testName = "create Github SourceControl Account")

	public void createGithubSourceControlAccount() throws Exception {

		versionControl = new VersionControl(driver);
		versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		versionControl.clickAddButtonOnVersionControlPage();
		versionControl.enterSourceControl(srcCtrl);
		versionControl.enterUsername(username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("GitHub");
		versionControl.enterHostName(github_hostname);
		versionControl.enterPAT(github_pat);
		versionControl.clickValidate();
		versionControl.clickAdd();
		packageConnectorPage.VerifyElementVisible(srcCtrl);
		Thread.sleep(2000);
	}

	@Test(priority = 3, groups = " github source control", description = "update Github SourceControl Account with valid token", testName = "update Github SourceControl Account with valid token")
	public void update_GithubSourceControl_Account_with_ValidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
		versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		packageConnectorPage.VerifyElementVisible(srcCtrl);
		versionControl.editSourceControlFromVersionControl(srcCtrl);
		versionControl.enterPAT(github_pat);
		versionControl.clickValidate();
		versionControl.clickUpdate();
		Thread.sleep(2000);

	}

	@Test(priority = 4, groups = " github source control", description = "update github SourceControl Account with invalid token", testName = "update github SourceControl Account with invalid token")
	public void update_GitLabSourceControl_Account_with_InValidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
		versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		packageConnectorPage.VerifyElementVisible(srcCtrl);
		versionControl.editSourceControlFromVersionControl(srcCtrl);
		versionControl.enterPAT(invalid_github_pat);
		versionControl.clickValidate();
		versionControl.verifyAlertMsgforIncorrectDetails();
		versionControl.clickCancel();
		Thread.sleep(2000);

	}

	@Test(priority = 5, groups = " github source control", description = "delete github SourceControl", testName = "delete github SourceControl")
	public void delete_GitHubSourceControl_Account() throws Exception {
		versionControl.deleteSourceControlFromVersionControl(srcCtrl);
		Thread.sleep(2000);
	}

	@Test(priority = 6, groups = " github source control", description = "create Github SourceControl Account with incorrect type", testName = "create Github SourceControl Account with incorrect type")
	public void create_GithubSourceControl_Account_with_IncorrectType() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
		versionControl.clickAddButtonOnVersionControlPage();
		versionControl.enterSourceControl(srcCtrl);
		versionControl.enterUsername(username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("GitLab");
		versionControl.enterHostName(github_hostname);
		versionControl.enterPAT(invalid_github_pat);
		versionControl.clickValidate();
		versionControl.verifyAlertMsgforIncorrectDetails();
		Thread.sleep(2000);
		versionControl.clickCancel();
		Thread.sleep(2000);

	}

	@Test(priority = 7, groups = " github source control", description = "create Github SourceControl Account with invalid token", testName = "create Github SourceControl Account with invalid token")
	public void create_GithubSourceControl_Account_with_InvalidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
		versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		versionControl.clickAddButtonOnVersionControlPage();
		versionControl.enterSourceControl(srcCtrl);
		versionControl.enterUsername(username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("GitLab");
		versionControl.enterHostName(github_hostname);
		versionControl.enterPAT(invalid_github_pat);
		versionControl.clickValidate();
		versionControl.verifyAlertMsgforIncorrectDetails();
		versionControl.clickCancel();
		Thread.sleep(2000);

	}

	/*
	 * public void createGitRepo() throws Exception {
	 * System.out.println("~~~~~~~createGitRepo~~~~~~~~~"); String dynamicRepoName =
	 * repoName + "Project"; GithubAPI.gitRepoName.put(repoName, dynamicRepoName);
	 * GithubAPI githubAPI = new GithubAPI();
	 * githubAPI.createGitRepo(dynamicRepoName, description, homepage, isPrivate);
	 * //githubAPI.deleteGitRepo(dynamicRepoName); }
	 */

	/*
	 * @Test(priority = 6, groups = " github source control", description =
	 * "create Project with Github Repo", testName =
	 * "create Project with Github Repo")
	 * 
	 * public void createProjectWithSourceControl() throws Exception {
	 * 
	 * versionControl = new VersionControl(driver); versionControl.clickProjects();
	 * versionControl.clickAddProject();
	 * versionControl.enterProjectName(projectName);
	 * versionControl.clickAddBUttonOnCreateProjectPopUp();
	 * versionControl.enterSourceControl(srcCtrl);
	 * versionControl.enterUsername(username); packageConnectorPage = new
	 * PackageConnectorPage(driver); packageConnectorPage.ClickOnDropdown("GitHub");
	 * packageConnectorPage.ClickOnDropdown("GitHub");
	 * versionControl.enterHostName(github_hostname);
	 * versionControl.enterPAT(github_pat); versionControl.clickValidate();
	 * versionControl.clickAdd(); GithubAPI.gitRepoName.put(projectName,
	 * dynamicRepoName); GithubAPI githubAPI = new GithubAPI();
	 * githubAPI.createGitRepo(dynamicRepoName, description, homepage, isPrivate);
	 * versionControl.clickCreateProjectButton(); //
	 * versionControl.deleteSourceControlFromVersionControl(srcCtrl);
	 * Thread.sleep(3000); }
	 */

}
