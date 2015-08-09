package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.apache.xmlrpc.client.XmlRpcClient;

import org.apache.xmlrpc.*;
import org.apache.ws.commons.serialize.DOMSerializer;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class TestLink_Update_Search_Google {
  
	public static String DEVKEY="fcb75a5d649ed079300b46195d2616ac";
	
	public static String URL = "http://localhost//testlink//lib//api//xmlrpc//v1//xmlrpc.php";
	
	public void reportResult(String testProject, String testPlan, String testCase, String Build, String Notes, String Result) throws TestLinkAPIException {
		
		TestLinkAPIClient api = new TestLinkAPIClient (DEVKEY, URL);
		
		api.reportTestCaseResult(testProject, testPlan, testCase, Build, Notes, Result);
		
	}
  @Test
  public void searchGoogle () throws TestLinkAPIException {
	  
	 
	  
	  System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
	  
	  WebDriver driver = new ChromeDriver();

	  TestLink_Update_Search_Google t = new TestLink_Update_Search_Google();
	  
	  String testProject="My first project";
	  String testPlan="My first test plan";
	  String testSuite="My first test suite";
	  String testCase="my first selenium test case";
	  String Build="MFP-9.5.5.180";
	  String Notes=null;
	  String Result=null;
	  
	  int i;
	  
	  try {
	  driver.get("http://www.google.com");
	  
	  WebElement searchText = driver.findElement(By.name("q"));
	  searchText.sendKeys("LearnSelenium");
	  
	  
	  WebElement searchButton = driver.findElement(By.name("btnG"));
	  searchButton.click();
	  
	  
	  
	  Result = TestLinkAPIResults.TEST_PASSED;
	  Notes = "Executed Successfully";
	  } catch (Exception e) {
		  Result = TestLinkAPIResults.TEST_FAILED;
		  Notes = "Executed Failed";
	  }
	  finally {
		  t.reportResult(testProject, testPlan, testCase, Build, Notes, Result);
		  driver.quit();
	  }
  }
}
