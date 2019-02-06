package com.charan.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		List<String> c1 = new ArrayList<String>();
		c1.add("Charan");
		c1.add("Charan");
		c1.add("Charan");
		List<String> c2 = Collections.unmodifiableList(c1);
		System.out.println(c1);
		System.out.println(c2);
		c1.remove(0);
		System.out.println(c1);
		System.out.println(c2);
		
	}
}
