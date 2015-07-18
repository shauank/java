package com.test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Lambda1 {

	public static boolean isGreaterThan3(int number) {
		return number > 3;
	}

	public static void sumValues(List<Integer> numbers,
			Predicate<Integer> selector) {
		System.out.println(numbers.stream().filter(selector)
				.reduce(10, Math::addExact));
	}
	
	public static int doubleIt(int number){
		try{
			Thread.sleep(100);
		}catch(Exception e){
			
		}
		System.out.println("In function");
		return number * 2;
		
	}

	public static void main(String[] args) {
		/*List<Integer> values = Arrays.asList(1, 2, 4, 3, 6, 2, 9, 7, 6);*/
		List<Integer> values = Arrays.asList(1, 2, 6, 7, 8, 8);
		
		System.out.println(values.parallelStream().mapToInt(Lambda1::doubleIt).sum());

		/*sumValues(values, e -> true);
		sumValues(values, e -> e > 7);
		sumValues(values, e -> e >= 9);
		sumValues(values, e -> e % 2 == 0);*/

		/*
		 * Predicate<Integer> isGT3 = num -> num > 3; Function<Integer,
		 * Predicate<Integer>> isGT = pivot -> number -> number > pivot;
		 * 
		 * IntStream .range(0, 4) .parallel() .forEach( nbr ->
		 * System.out.println(values.stream()
		 * .filter(isGT.apply(4)).findAny()));
		 */

	}
}
