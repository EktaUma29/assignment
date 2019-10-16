package com.yash.assignment.two;

import java.io.Serializable;

public class SingletonThreadSafe implements Serializable {

	private static final long serialVersionUID = 1L;
	private static SingletonThreadSafe instance = null;
	private String name;

	public SingletonThreadSafe(String name) {
		this.name = name;
	}

	public SingletonThreadSafe() {
	}

	public static SingletonThreadSafe getInstance() {
		synchronized (SingletonThreadSafe.class) {
			if (instance == null)
				instance = new SingletonThreadSafe("AddValue");

			return instance;
		}
	}

	private Object readResolve() {
		return instance;
	}

}
