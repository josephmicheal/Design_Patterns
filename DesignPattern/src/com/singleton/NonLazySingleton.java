package com.singleton;

import java.io.Serializable;

public class NonLazySingleton implements Serializable{
	private static volatile NonLazySingleton instance = new NonLazySingleton();

	public static NonLazySingleton Instance() {
		return instance;
	}

	private NonLazySingleton() {
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	protected Object readResolve() {
		return instance;
	}
}

// www.java67.com/2020/05/5-ways-to-implement-singleton-design.html#ixzz7GhsXeaxz