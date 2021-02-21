package ui.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class GmailAttachmentFeatureFlow extends PageObject {

	@FindBy(xpath = "//*[@id='identifierId']")
	WebElementFacade emailTextBox;

	@FindBy(xpath = "//*[@id='identifierNext']")
	WebElementFacade emailNextButton;

	@FindBy(xpath = "//*[@id='passwordNext']")
	WebElementFacade passwordNextButton;

	@FindBy(xpath = "//textarea[@name='to']")
	WebElementFacade receipentMailidelement;

	@FindBy(xpath = "//input[@name='subjectbox']")
	WebElementFacade mailSubjectElement;

	@FindBy(xpath = "//*[@class = 'Am Al editable LW-avf tS-tW']")
	WebElementFacade mailBodyelement;

	@FindBy(xpath = "//*[@class='a1 aaA aMZ']")
	WebElementFacade emailAttachmentButton;

	@FindBy(xpath = "//*[@id=':2d']/tbody//tr[1]")
	WebElementFacade inboxFirstmail;

	EnvironmentVariables obj = SystemEnvironmentVariables.createEnvironmentVariables();

	public void login() {

		getDriver().get(obj.getProperty("GmailURL1"));

		getDriver().manage().window().maximize();

	}

	public void loginToGmail(String email, String password) {

		emailTextBox.sendKeys(email);
		emailNextButton.click();

		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement wb = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
		wb.sendKeys(password);

		passwordNextButton.click();

		getDriver().findElement(By.xpath("//*[@id='gbwa']/div/a")).click();

	}

	public void loginToGmailInvalidPAssword(String email, String password) {

		emailTextBox.sendKeys(email);
		emailNextButton.click();

		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement wb = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
		wb.sendKeys(password);

		passwordNextButton.click();

	}

	public void loginToGmailInvalidMail(String email) {

		emailTextBox.sendKeys(email);
		emailNextButton.click();

	}

	public void gmailPageValidation() throws InterruptedException {

		Thread.sleep(2000);

		getDriver().navigate().to(obj.getProperty("GmailURL2"));

		WebDriverWait wait = new WebDriverWait(getDriver(), 15);

		WebElement wb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));

		Actions ac = new Actions(getDriver());

		ac.click(wb).build().perform();

		Thread.sleep(10000);

	}

	public void gmailAttachmentCompose(String receipentMailId, String mailSubject, String mailBody)
			throws InterruptedException, AWTException {

		Thread.sleep(3000);

		receipentMailidelement.sendKeys(receipentMailId);

		Serenity.setSessionVariable("receipentMailId").to(receipentMailId);
		Serenity.setSessionVariable("mailSubject").to(mailSubject);

		mailSubjectElement.sendKeys(mailSubject);

		mailBodyelement.sendKeys(mailBody);
		Thread.sleep(3000);

		StringSelection stringSelection = new StringSelection(obj.getProperty("FilePath"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(5000);

		emailAttachmentButton.click();
		Thread.sleep(5000);

		// native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

	}

	public void gmailComposeWithoutAtachment(String receipentMailId, String mailSubject, String mailBody)
			throws InterruptedException, AWTException {

		Thread.sleep(3000);

		Serenity.setSessionVariable("receipentMailId").to(receipentMailId);
		Serenity.setSessionVariable("mailSubject").to(mailSubject);

		receipentMailidelement.sendKeys(receipentMailId);
		mailSubjectElement.sendKeys(mailSubject);
		mailBodyelement.sendKeys(mailBody);

		Thread.sleep(3000);

	}

	public void sendEmail() throws InterruptedException {

		Actions ac = new Actions(getDriver());

		ac.click(getDriver().findElement(By.xpath("//*[text()='Send']"))).build().perform();

		Thread.sleep(5000);
	}

	public void validateAlertErrorMessage(String errorMessage) throws InterruptedException {

		Thread.sleep(2000);
		String ap = getDriver().findElement(By.xpath("//*[@role='alertdialog']//div[text()='" + errorMessage + "']"))
				.getText();
		Assert.assertEquals(ap, errorMessage);
	}

	public void validateInboxInvalidReceipentMail() throws InterruptedException {

		Thread.sleep(20000);

		getDriver().findElement(By.xpath("//*[@id=':2d']/tbody//tr[1]")).click();
		String str = Serenity.sessionVariableCalled("receipentMailId");
		waitForTextToAppear("Your message wasn't delivered to " + str
				+ " because the address couldn't be found or is unable to receive email.");

	}
}
