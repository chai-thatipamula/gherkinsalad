package daveayan.gherkinsalad.components.html;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import daveayan.gherkinsalad.components.NullBrowserElement;
import daveayan.gherkinsalad.components.TextEnterable;
import daveayan.gherkinsalad.report.Report;

public class TextField extends BaseBrowserElement implements TextEnterable {
	
	public static TextField find(By locator) {
		TextField tb = new TextField();
		tb.found(locator);
		return tb;
	}
	
	public String getText() {
		if(isNotDisplayed()) {
			throw new AssertionError("Element '" + this + "' is not displayed. Cannot getText on this element");
		}
		WebElement element = fetch_element();
		if(element instanceof NullBrowserElement) {
			throw new AssertionError("Element '" + this + "' is not displayed. Cannot getText on this element");
		}
		return element.getAttribute("value");
	}
	
	public boolean isEnabled() {
		WebElement element = fetch_element();
		return element.isEnabled();
	}

	public void enter_text_if_enabled(String text) {
		WebElement element = fetch_element();
		if(this.isEnabled()) {
			wait_between_steps();
			element.clear();
			element.sendKeys(text);
			Report.action("Entered text '" + text + "' in " + this);
		}
	}

	public void append_text_if_enabled(String text) {
		WebElement element = fetch_element();
		if(this.isEnabled()) {
			wait_between_steps();
			String current_text = element.getAttribute("value");
			element.clear();
			element.sendKeys(text + current_text);
			Report.action("Appended text '" + text + "' in " + this);
		}
	}

	public void click_if_enabled() {
		WebElement element = fetch_element();
		if(this.isEnabled()) {
			element.click();
		}
	}
	
	public void click_if_exists() {
		click_if_enabled();
	}

	public void click_if_exists_and_enabled() {
		// TODO Auto-generated method stub
		
	}
}