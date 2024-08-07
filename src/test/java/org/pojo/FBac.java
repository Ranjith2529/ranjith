package org.pojo;

import org.base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBac extends Baseclass {
	
	public FBac() {
		PageFactory.initElements(dd, this);
	}
	@FindBy(xpath="//a[text()='Create new account']")
	private WebElement createac;
	
	@FindBy(xpath="(//input[@data-type='text'])[1]")
	private WebElement firstname;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="reg_email__")
	private WebElement email;

	@FindBy(name="reg_passwd__")
	private WebElement pass;

	public WebElement getCreateac() {
		return createac;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPass() {
		return pass;
	}
	

}
