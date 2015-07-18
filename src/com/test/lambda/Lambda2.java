package com.test.lambda;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.naming.PartialResultException;

class Employee{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class Lambda2 {

	public static int subString(String s) {
		return Integer.parseInt(s.substring(1));
	}
	
	public static void doSomeOperation(Person person){
		System.out.println(person.getName()+person.getAge());
	}
	
	public static void main(String[] args) {

		List<Person> persons = Arrays
				.asList(new Person("Max", 18), new Person("Peter", 23),
						new Person("Pamela", 23), new Person("David", 12));
		
		/*
		 * System.out.println(persons.stream().map(Person::getName).collect(
		 * Collectors.toList()));
		 * 
		 * System.out.println(persons.stream().collect(Collectors.groupingBy(Person
		 * ::getName)));
		 * 
		 * System.out.println(persons.stream().map(Person::getName).collect(
		 * Collectors.joining(",")));
		 */

		Map<Boolean, List<Person>> test = persons.stream().collect(
				Collectors.partitioningBy((Person s) -> s.getAge() > 1));
		
		Stream<List<Person>> listStream = Stream.of(test).flatMap(f -> f.values().stream());
		
//		System.out.println("shauank");
		listStream.forEach(e -> e.stream().mapToInt(Person::getAge).map(e1 -> { System.out.println(e1); return 1;}));
		
		Consumer<Person> consumer =  Lambda2::doSomeOperation;
		consumer.accept(new Person("Jilu", 33));
		consumer.accept(new Person("Shaunak", 21));

		// s -> () -> ;

		/*
		 * List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		 * 
		 * Supplier<Stream<String>> supplier = () -> myList.stream();
		 * 
		 * System.out.println(supplier.get().findFirst());
		 * 
		 * 
		 * System.out.println(myList.stream().filter(e -> e.startsWith("a"))
		 * .map(String::toUpperCase).mapToInt(Lambda2::subString) .reduce(0,
		 * (a,b) -> a+b));
		 */

		// forEach(System.out::println);

		/*
		 * Stream.of(myList);
		 * 
		 * IntStream.rangeClosed(1, 4).forEach(System.out::println);
		 */
	}
}
