package com.interview.collection;

import java.util.ArrayList;
import java.util.List;


public class ListInsideList {

	public static void main(String[] args) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		List<Integer> l2 = new ArrayList<>();
		l2.add(3);
		//l2.add(2);
		List<Integer> l3 = new ArrayList<>();
		l3.add(4);
		l3.add(3);
		List<Integer> l4 = new ArrayList<>();
		l4.add(5);
		l4.add(4);
		List<Integer> l5 = new ArrayList<>();
		l5.add(6);
		l5.add(5);
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		list.add(l5);
		System.out.println(list);
		
		for(List<Integer> l : list)
		{
			for(Integer i : l)
			{
				
				System.out.println(i);
			}
		}
		
		
	}
}
