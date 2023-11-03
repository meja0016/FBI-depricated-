package com.javacodegeeks.examples.jaxws;

import java.util.HashMap;
import java.util.Map;

public class PersonUtil {
	private static Map<Integer, Person> map;
	
	static {
		map = new HashMap<>();
		map.put(1, new Person(1, "A"));
		map.put(2, new Person(2, "B"));
		map.put(3, new Person(3, "C"));
		map.put(4, new Person(4, "D"));
		map.put(5, new Person(5, "E"));
	}

	private PersonUtil() {
	}

	public static Person getPerson(Integer id) {
		return map.get(id);
	}
}
