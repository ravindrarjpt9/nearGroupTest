package com.interview.collection;

public class TwoMaxNumbers {

	public static void printTwoMaxNumber(int[] n)
	{
		int maxOne = 0;
		int maxTwo = 0;
		for(int i:n)
		{
			if(maxOne < i)
			{
				maxTwo = maxOne;
				maxOne = i;
			}else if(maxTwo < i)
			{
				maxTwo = i;
			}
			
		}
		System.out.println("1st :"+maxOne);
		System.out.println("2nd :"+maxTwo);
	}
	public static void main(String[] args) {
		printTwoMaxNumber(new int[]{1,34,12,53,11,5,3,23,434,5,9});
	}
}
