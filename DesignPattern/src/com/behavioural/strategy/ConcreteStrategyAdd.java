package com.behavioural.strategy;

// Concrete strategies implement the algorithm while following
//the base strategy interface. The interface makes them
//interchangeable in the context.
public class ConcreteStrategyAdd implements Strategy {
	public int execute(int a, int b) {
		return a + b;
	}
}