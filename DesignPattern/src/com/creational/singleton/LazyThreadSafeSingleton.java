package com.creational.singleton;

public class LazyThreadSafeSingleton {
	private static LazyThreadSafeSingleton instance = null;
	private static Object lockObj = new Object();

	public static LazyThreadSafeSingleton Instance() {
		if (instance == null) {
			synchronized(lockObj) {
				if (instance == null) {
					instance = new LazyThreadSafeSingleton();
				}
			}
		}
		return instance;
	}

	private LazyThreadSafeSingleton() {
	}
}

// www.java67.com/2020/05/5-ways-to-implement-singleton-design.html#ixzz7GhzIbWUU