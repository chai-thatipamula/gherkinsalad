package daveayan.gherkinsalad.steps;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.When;

public class DataEntrySteps extends BaseStep {
	@Given("^(?:User|user|I|You|you) entered text ([^\\.]*) in text box ([^\\.]*)")
	@When("^(?:User|user|I|You|you) enters text ([^\\.]*) in text box ([^\\.]*)")
	defenter_text_in_text_box(text, element_name) throws InterruptedException {
		enter(text, on_page_element_with_key(element_name));
	}
	@Given("^(?:User|user|I|You|you) entered text ([^\\.]*) in text box ([^\\.]*) on ([^\\.]*)")
	@When("^(?:User|user|I|You|you) enters text ([^\\.]*) in text box ([^\\.]*) on ([^\\.]*)")
	defenter_text_in_text_box(text, element_name, component_name) throws InterruptedException {
		enter(text, on_page_element_with_key(component_name, element_name));
	}
	@Given("^(?:User|user|I|You|you) entered data ([^\\.]*) in text box ([^\\.]*)")
	@When("^(?:User|user|I|You|you) enters data ([^\\.]*) in text box ([^\\.]*)")
	defenter_data_in_text_box(symbolic_text, element_name) throws InterruptedException {
		enter(data_element_with_key(symbolic_text), on_page_element_with_key(element_name));
	}
	@Given("^(?:User|user|I|You|you) entered data ([^\\.]*) in text box ([^\\.]*) on ([^\\.]*)")
	@When("^(?:User|user|I|You|you) enters data ([^\\.]*) in text box ([^\\.]*) on ([^\\.]*)")
	defenter_data_in_text_box(symbolic_text, element_name, component_name) throws InterruptedException {
		enter(data_element_with_key(symbolic_text), on_page_element_with_key(component_name, element_name));
	}
}