package testingProject.testingProjectArtifact;

import java.util.Stack;

public class StackTest {
	
	public static void main(String[] args) {
		
		Stack<Information> myStack = new Stack<Information>();
		
		Information info1 = new Information("Hashim", 22, 3);
		Information info2 = new Information("abdi", 24, 3);
		Information info3 = new Information("nothasdhim", 22, 3);
		
		
		myStack.push(info1);
		myStack.push(info2);
		myStack.push(info3);
		
		
	    //myStack.pop();
	
		for(Information InfoObj : myStack) {
			System.out.println(InfoObj.toString());
		}
	}
	
	

}
