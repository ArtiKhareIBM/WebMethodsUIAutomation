package com.webMethodsFlowUI.testsuites.GithubVersionControl;

import com.webMethodsUI.flow.VersionControlPageObject.VersionControl;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.PackageConnector.PackageConnectorPage;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;




public class GithubVersionControlTestCase extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    VersionControl versionControl;
    WebElement element;
    CommonActions commonActions;
    PackageConnectorPage packageConnectorPage;
    String srcCtrl ="srcGithubCtrl_Arti";
    String username ="ArtiKhareIBM";
    String githubsrcCtrl = "GitHub";
    String github_hostname = "github.com";
    String github_pat = "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";


    @Test(priority = 1, groups = " gitlab source control", description = "ensure login worked fine",  testName="login test case")
    public void loginTest() throws Exception
    {
        getApplicationUrl(ObjectReader.reader.getURL());
        loginPage = new LoginPage(driver);
        homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
    }
    
 
    
	
	  @Test(priority = 2, groups = " gitlab source control", description = "clicking User profile",  testName="clicking User profile")
	  public void addGithubVersionControl() throws Exception 
	  {
	  
	  versionControl = new VersionControl(driver);
	  versionControl.addVersionControl();	 
	  
	  }
	 
	  @Test(priority = 3, groups = " gitlab source control", description = "Entering Github Source Control Details",  testName="Entering Github Source Control")
	  public void enterGithubSourceControl() throws Exception 
	  {
	  
	  versionControl = new VersionControl(driver);
	  versionControl.enterSourceControl(srcCtrl);
	  versionControl.enterUsername(username);
	  packageConnectorPage = new PackageConnectorPage(driver);
	  packageConnectorPage.ClickOnDropdown("GitHub");
      packageConnectorPage.ClickOnDropdown("GitHub");
      versionControl.enterHostName(github_hostname);
      versionControl.enterPAT(github_pat);
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
