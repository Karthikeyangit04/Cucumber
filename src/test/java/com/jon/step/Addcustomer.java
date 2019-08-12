package com.jon.step;

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

		Map<String, String> datas = dataTable.asMap(String.class, String.class);

		driver.findElement(By.id("fname")).sendKeys(datas.get("fname"));
		driver.findElement(By.id("lname")).sendKeys(datas.get("lname"));
		driver.findElement(By.id("email")).sendKeys(datas.get("email"));
		driver.findElement(By.xpath("(//*[@id='message'])[2]")).sendKeys(datas.get("address"));
		driver.findElement(By.id("telephoneno")).sendKeys(datas.get("phone"));
		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		Assert.assertTrue((driver.findElement(By.xpath("//*[text()='Customer ID']")).isDisplayed()));

	}

}