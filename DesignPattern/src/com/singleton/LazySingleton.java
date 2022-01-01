package com.singleton;

public class LazySingleton {
	private static LazySingleton instance = null;

	public static LazySingleton Instance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}

	private LazySingleton() {}
}

// www.java67.com/2020/05/5-ways-to-implement-singleton-design.html#ixzz7GhsFpjLV