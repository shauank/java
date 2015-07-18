package com.test.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

import java.util.stream.Stream;

import com.test.admin.Employee.SEX;

public class AdminActivity {

	public static List<Employee> getRawEmployee() {
		List<Employee> employees = new ArrayList<Employee>();
		int i = 20;
		while (i < 80) {
			employees.add(new Employee("Name-" + i, i,
					(i % 2 == 0) ? SEX.FEMALE : SEX.MALE));
			i++;
		}
		return employees;
	}

	public static void main(String[] args) {
		Stream<Employee> empStream = getRawEmployee().stream();
		
		Predicate<Employee> predicate = (Employee employee) -> (employee.getAge() > 20 && employee.getGender() == SEX.MALE);
		
		Function<Employee, String> mapper = Employee::getName; 
		
		
		empStream.filter((Employee employee) -> employee.getAge() > 20).forEach(e -> System.out.println(mapper.apply(e)));
		
		Collections.sort(getRawEmployee(), (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));
		
		Collections.sort(getRawEmployee(), Employee::compareByName);
		
		String[] stringArray = { "Barbara", "James", "Mary", "John",
			    "Patricia", "Robert", "Michael", "Linda" };
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		
		getRawEmployee().sort(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName));
			
		
		/*Consumer<Employee> ce = Employee::printPersion;
		
		System.out.println();*/
		

	}

}
