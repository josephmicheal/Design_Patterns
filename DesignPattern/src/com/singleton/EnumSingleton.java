package com.singleton;

public class EnumSingleton {
	public static void main(String args[]) {
		Singleton singleton = Singleton.INSTANCE;
		singleton.doSomething();
	}
}

enum Singleton {
	INSTANCE;

	public void doSomething() {
		System.out.println("Processed");
	}

}