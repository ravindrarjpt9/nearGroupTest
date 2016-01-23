package com.interview.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterInStringmAP {

	public static void main(String[] args) {
		
		String s = "HelloHe";
		
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(char c:s.toCharArray())
		{
			if(map.containsKey(c))
			{
				map.put(c, map.get(c)+1);
			}
			else
			{
				map.put(c, 1);
			}
		}
		for(Map.Entry<Character, Integer> e:map.entrySet())
		{
			if(e.getValue() == 1)
			{
				System.out.println(e.getKey());
				break;
			}
		}
	}
}
