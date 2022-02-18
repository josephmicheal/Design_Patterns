package com.behavioural.strategy;

//The client code picks a concrete strategy and passes it to
//the context. The client should be aware of the differences
//between strategies in order to make the right choice.
public class ExampleApplication {
	public static void main(String args[]) {
     //Create context object.
	 Context context = new Context();

     //Read first number.
     //Read last number.
     //Read the desired action from user input.
	 int action = 1;

     if (action == 1) {
         context.setStrategy(new ConcreteStrategyAdd());
     }

     if (action == 2) {
         context.setStrategy(new ConcreteStrategySubtract());
     }

     if (action == 3) {
         context.setStrategy(new ConcreteStrategyMultiply());
     }

    int result = context.executeStrategy(1, 23);

 }
}