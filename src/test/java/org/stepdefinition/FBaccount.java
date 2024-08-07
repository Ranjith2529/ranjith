package org.stepdefinition;

import org.base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pojo.FBac;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FBaccount extends Baseclass{
	FBac a;
	@When("user to launch and maximise the window")
	public void user_to_launch_and_maximise_the_window() {
	    launchBrowser();
	    windowMaximize();
	}

	@When("User to Open the facebook url")
	public void user_to_Open_the_facebook_url() {
	   launchUrl("https://en-gb.facebook.com/");
	}

	@When("User to click the create account button")
	public void user_to_click_the_create_account_button() {
		a = new FBac();
		clickButton(a.getCreateac());
	  
	}

	@When("User to give firstname in firstname box")
	public void user_to_give_firstname_in_firstname_box() {
		a = new FBac();
		passText("ranjith",a.getFirstname());
	}

	@When("User to give the Secondname in secondname box")
	public void user_to_give_the_Secondname_in_secondname_box() {
		a = new FBac();
		passText("kumar",a.getLastname());
	}

	@When("User to give the gmail")
	public void user_to_give_the_gmail() {
		a = new FBac();
		passText("4545@gmail.com",a.getEmail());
	}

	@When("user to give the password")
	public void user_to_give_the_password() {
	   passText("12122312",a.getPass());
	}

	@Then("User to close the Browser")
	public void user_to_close_the_Browser() {
	    //closeEntireBrowser();
	}



}
