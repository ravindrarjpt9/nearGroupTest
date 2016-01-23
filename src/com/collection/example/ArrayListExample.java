package com.collection.example;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		
		List<String> genList = new ArrayList<String>();//Genric 
		
		List nonGenList = new ArrayList();// Non Genric 
		
		nonGenList.add("abc");
		nonGenList.add(1234);
	}
	
}
