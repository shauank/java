package com.test.admin;

import java.util.Spliterator;

public class SplitItrEx {
	
	public static void main(String[] args) {
		Spliterator<Employee> splitItr = AdminActivity.getRawEmployee().spliterator();
		System.out.println("Size of Ori ...."+splitItr.estimateSize());
		Spliterator<Employee> spliter = splitItr.trySplit();
		System.out.println("Size of after split ...."+spliter.estimateSize());
		
	}

}
