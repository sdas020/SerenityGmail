package ui.steps;

import java.awt.AWTException;
import java.io.IOException;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import ui.page.GmailAttachmentFeatureFlow;

public class GmailAttachmentFlowSteps extends PageObject {
	
	
	Scenario scenario;
	
	@Before
	public void before(Scenario s) {
		this.scenario=s;
	}
	
	@Steps
	GmailAttachmentFeatureFlow gmailObj;
	
	@Given("User navigating to gmail signIn page")
	public void user_navigating_to_gmail_sign_in_page() {
		
	    gmailObj.login();
	}

	@When("^User login with (.*) and (.*)$")
	public void user_login(String email , String password) throws IOException {
		
	    
	  
	    gmailObj.loginToGmail(email, password);
	}
	
	@When("^User signIn with (.*) and invalid (.*)$")
	public void user_login_inValidPassword(String email , String password) throws IOException {
		
	    
	  
	    gmailObj.loginToGmailInvalidPAssword(email, password);
	    
	    
	}
	
	@When("^User signIn with invalid (.*)$")
	public void user_login_inValidEmail(String email) throws IOException {
		
	    
	  
	    gmailObj.loginToGmailInvalidMail(email);
	    
	    
	}
	
	@Then("^User validates (.*)$")
	public void user_validate_ErrorMessage(String errorMessage) throws InterruptedException {
		
		Thread.sleep(2000);
		
		containsText(errorMessage);
		
		
		
	}
	
	@Then("^User is validating the alert error message (.*)$")
	public void user_validateAlert_ErrorMessage(String errorMessage) throws InterruptedException {
		
		Thread.sleep(2000);
		
		gmailObj.validateAlertErrorMessage(errorMessage);
		
		
	}

	@Then("User validate the gmail page")
	public void user_validate_the_gmail_page() throws InterruptedException {
		
		gmailObj.gmailPageValidation();
		
		
	}

	@And("^user upload attachment in compose with (.*) , (.*) , (.*)$")
	public void user_upload(String receipentMailId, String mailSubject,String mailBody) throws InterruptedException, AWTException {
		
		gmailObj.gmailAttachmentCompose(receipentMailId, mailSubject, mailBody);;
		
	}
	
	@And("^user compose mail without document (.*) , (.*) , (.*)$")
	public void user_upload_without_Doc(String receipentMailId, String mailSubject,String mailBody) throws InterruptedException, AWTException {
		
		gmailObj.gmailComposeWithoutAtachment(receipentMailId, mailSubject, mailBody);;
		
	}
	
	
	@Then("User send the mail to recipient")
	public void user_SendMail() throws InterruptedException, AWTException {
		
		
		gmailObj.sendEmail();
		
	}
	
	@Then("User is validating the inbox for invalid email address as recipient")
	public void user_validate_inbox_emailAddress() throws InterruptedException {
		
		gmailObj.validateInboxInvalidReceipentMail();
		
		
	}
}
