package com.webMethodsUI.flow.helper.browserConfigurations.config;

import com.webMethodsUI.flow.helper.browserConfigurations.BrowserType;

public interface ConfigReader {

	public int getImplicitWait();

	public int getExplicitWait();

	public int getPageLoadTime();

	public BrowserType getBrowserType();
	
	public BrowserType getBrowserTypeFireFox();

	public String getURL();
	
	public String getprojectName();

	public String getUserName();

	public String getPassword();
	public String getDevUserName();

	public String getDevPassword();
	
	public String getTargetUserName();

	public String getTargetPassword();
	
	public String getAdmin2UserName();

	public String getAdmin2Password();
	
	public String getISURL();

	public String getISUserName();

	public String getISPassword();
	
	public String targetSubdomain();

	public String GetdeployURL();

	public String GetdeployUserName();

	public String GetdeployPassword();

}
