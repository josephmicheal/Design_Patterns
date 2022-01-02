package com.creational.singleton;

import java.io.Serializable;

public class EnumSingleton {
	public static void main(String args[]) {
		Singleton singleton = Singleton.INSTANCE;
		singleton.doSomething();
	}
}

enum Singleton implements Serializable{
	INSTANCE;

	public void doSomething() {
		System.out.println("Processed");
	}

	private Object readResolve(){
	      return INSTANCE;
	}
}