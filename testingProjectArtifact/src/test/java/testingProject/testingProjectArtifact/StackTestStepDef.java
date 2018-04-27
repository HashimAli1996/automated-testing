package testingProject.testingProjectArtifact;

import java.util.Stack;
import cucumber.api.java.en.*;

import static junit.framework.Assert.*;
public class StackTestStepDef {
	
	Stack<Information> myStack;
	
	int preSize;
	Information info1 = new Information("hasdhfghf", 13, 3);
	
	@Given("^a stack$")
	public void give_a_stack() {
		myStack = new Stack<Information>();
	}
	
	@When("^I push to the stack$")
	public void Push_to_stack() {
		preSize = myStack.size();
		myStack.push(info1);
	}
	
	@Then("^the stack has one more object$")
	public void checkStackSyz() {
		assertEquals(preSize+1, myStack.size());
	}
	
	@Given("^a stack with atleast one object$")
	public void give_a_stack_with_atleast_an_object() {
		myStack = new Stack<Information>();
		myStack.push(info1);
	}
	

}
