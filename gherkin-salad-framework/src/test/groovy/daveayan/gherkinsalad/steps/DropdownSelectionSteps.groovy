package daveayan.gherkinsalad.steps;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.When;

public class DropdownSelectionSteps extends BaseStep {
	@Given("^(?:User|user|I|You|you) selected option text ([^\\.]*) in drop down ([^\\.]*)")
	@When("^(?:User|user|I|You|you) selects option text ([^\\.]*) in drop down ([^\\.]*)")
	select_option(option, element_name) throws InterruptedException {
		select(option, on_page_element_with_key(element_name));
	}
	@Given("^(?:User|user|I|You|you) selected radio button text ([^\\.]*) in drop down ([^\\.]*) on ([^\\.]*)")
	@When("^(?:User|user|I|You|you) selects radio button text ([^\\.]*) in drop down ([^\\.]*) on ([^\\.]*)")
	select_option(option, element_name, component_name) {
		select(option, on_page_element_with_key(component_name, element_name));
	}
}