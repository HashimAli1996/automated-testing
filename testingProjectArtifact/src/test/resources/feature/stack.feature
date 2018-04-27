Feature: Stack Actions

Scenario: Push to Stack
Given a stack
When I push to the stack
Then the stack has one more object

Scenario: Pop from Stack
Given a stack with atleast one object
When I pop from stack
Then the stack has one less object

Scenario: Print Elements In The Stack
Given a stack with atleast one object