package generics;

import java.util.*;

public class GenericsPractice {

	//	Write a generic method that can take an array of any type and print every other element of the array.
	private static<T> void printEveryOtherElement(T[] array)
	{
		for(int i = 0; i<array.length; i+=2)
		{
			System.out.println(array[i]);
		}
	}
	public static void main(String[] args) 
	{
		//Testing printEveryOtherElement
		Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String[] letters = {"a", "b", "c", "d", "e", "f", "h", "i"};
		printEveryOtherElement(numbers);
		printEveryOtherElement(letters);
	}
	
}
