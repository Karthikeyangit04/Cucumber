package com.jon.step;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Addcustomer {

	WebDriver driver;

	@Given("launch the browser")
	public void launch_the_browser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\KarthiKeyan\\eclipse-workspace\\project\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/telecom/");
		driver.findElement(By.xpath("//*[text()='Add Customer']")).click();
		driver.findElement(By.xpath("//*[text()='Done']")).click();
	}

	@When("enter the customer details")
	public void enter_the_customer_details(io.cucumber.datatable.DataTable dataTable) {
		List<String> datas = dataTable.asList(String.class);

		driver.findElement(By.id("fname")).sendKeys(datas.get(0));
		driver.findElement(By.id("lname")).sendKeys(datas.get(1));
		driver.findElement(By.id("email")).sendKeys(datas.get(2));
		driver.findElement(By.xpath("(//*[@id='message'])[2]")).sendKeys(datas.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(datas.get(4));
		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}
	
	@When("enter the customer details")
	public void enter_the_customer_details1(io.cucumber.datatable.DataTable dataTable) {

		Map<String, String> datas = dataTable.asMap(String.class, String.class);

		driver.findElement(By.id("fname")).sendKeys(datas.get("fname"));
		driver.findElement(By.id("lname")).sendKeys(datas.get("lname"));
		driver.findElement(By.id("email")).sendKeys(datas.get("email"));
		driver.findElement(By.xpath("(//*[@id='message'])[2]")).sendKeys(datas.get("address"));
		driver.findElement(By.id("telephoneno")).sendKeys(datas.get("phone"));
		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}


	@When("enter the customer detail")
	public void enter_the_customer_detail(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> dataList = dataTable.asLists(String.class);

		driver.findElement(By.id("fname")).sendKeys(dataList.get(0).get(0));
		driver.findElement(By.id("lname")).sendKeys(dataList.get(1).get(0));
		driver.findElement(By.id("email")).sendKeys(dataList.get(3).get(2));
		driver.findElement(By.xpath("(//*[@id='message'])[2]")).sendKeys(dataList.get(0).get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(dataList.get(3).get(4));
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
	@When("enter the customer details{int}")
	public void enter_the_customer_details(Integer int1, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> datas = dataTable.asMaps(String.class, String.class);

		driver.findElement(By.id("fname")).sendKeys(datas.get(1).get("fname"));
		driver.findElement(By.id("lname")).sendKeys(datas.get(2).get("lname"));
		driver.findElement(By.id("email")).sendKeys(datas.get(3).get("lname"));
		driver.findElement(By.xpath("(//*[@id='message'])[2]")).sendKeys(datas.get(4).get("address"));
		driver.findElement(By.id("telephoneno")).sendKeys(datas.get(5).get("phone"));
		driver.findElement(By.xpath("//*[@type='submit']")).click();


	}
	@When("click the customer details {string},{string},{string},{string},{string}")
	public void click_the_customer_details(String A, String B, String C, String D, String E) {
		driver.findElement(By.id("fname")).sendKeys(A);
		driver.findElement(By.id("lname")).sendKeys(B);
		driver.findElement(By.id("email")).sendKeys(C);
		driver.findElement(By.xpath("(//*[@id='message'])[2]")).sendKeys(D);
		driver.findElement(By.id("telephoneno")).sendKeys(E);
		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}	

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		Assert.assertTrue((driver.findElement(By.xpath("//*[text()='Customer ID']")).isDisplayed()));

	}

}