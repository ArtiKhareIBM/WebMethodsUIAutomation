package com.webMethodsFlowUI.testsuites.GitLabVersionControl;

import com.webMethodsUI.flow.VersionControlPageObject.VersionControl;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.PackageConnector.PackageConnectorPage;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;




public class GitLabVersionControlTestCase extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    VersionControl versionControl;
    WebElement element;
    CommonActions commonActions;
    PackageConnectorPage packageConnectorPage;
    String srcCtrl ="srcCtrl_gitlab_Arti";
    String username ="ArtiKhareGitlab";
    String gitlabsrcCtrl = "GitLab";
    String gitlab_hostname = "gitlab.com";
    String gitlab_pat = "glpat-xA3EQv459wTbQLYFxySF";


    @Test(priority = 1, groups = " gitlab source control", description = "ensure login worked fine",  testName="login test case")
    public void loginTest() throws Exception
    {
        getApplicationUrl(ObjectReader.reader.getURL());
        loginPage = new LoginPage(driver);
        homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
    }
    
 
    
	
	  @Test(priority = 2, groups = " gitlab source control", description = "clicking User profile",  testName="clicking User profile")
	  public void addGitLabVersionControl() throws Exception 
	  {
	  
	  versionControl = new VersionControl(driver);
	  versionControl.addVersionControl();	 
	  
	  }
	 
	  @Test(priority = 3, groups = " gitlab source control", description = "Entering GitLab Source Control Details",  testName="Entering GitLab Source Control")
	  public void enterGitLabSourceControl() throws Exception 
	  {
	  
	  versionControl = new VersionControl(driver);
	  versionControl.enterSourceControl(srcCtrl);
	  versionControl.enterUsername(username);
	  packageConnectorPage = new PackageConnectorPage(driver);
	  packageConnectorPage.ClickOnDropdown("GitHub");
      packageConnectorPage.ClickOnDropdown("GitLab");
      versionControl.enterHostName(gitlab_hostname);
      versionControl.enterPAT(gitlab_pat);
      versionControl.clickValidateAndAdd();
	  }
	  
	  @Test(priority = 4, groups = " gitlab source control", description = "verifying SourceControl is Created",  testName="verifying SourceControl is Created")
	  public void verifySourceControlIsCreated() throws Exception
	  {
		  packageConnectorPage.VerifyElementVisible(srcCtrl);
	  }
	  
	  @Test(priority = 5, groups = " gitlab source control", description = "deleting source control",  testName="deleting source control")
	  public void deleteSourceControl() throws Exception
	  {
		  versionControl.deleteSourceControlFromVersionControl(srcCtrl);
		  
	  }
	  
	  
	 
	
	
   
}
