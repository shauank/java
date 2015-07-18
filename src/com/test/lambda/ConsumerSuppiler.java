package com.test.lambda;

import java.security.acl.LastOwnerException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator.OfInt;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

class User {
	private String name;

	public User(String name) {
		super();
		this.name = name;
	}
}

interface DefaultTest{
	default public String helloTestDefault(){
		return "Hey...tested default method";
	}
}

interface DefaultTest1{
	default public String helloTestDefault(){
		return "Hey...tested default method of DefaultTest1";
	}
}

public class ConsumerSuppiler implements DefaultTest, DefaultTest1{
	
	
	@Override
	public String helloTestDefault() {
		return DefaultTest1.super.helloTestDefault();
	}

	public static void main(String[] args) throws InterruptedException {

		List<Integer> lstInt = Arrays.asList(1,4,65,76,7,8,8,8);
		List<String> lstString = Arrays.asList("1","4","10","76","7","8","8","8");
//		Collector.of
//		Collector.of()
		
		
		ToIntFunction<Integer> intFunction = (e) -> { return e; };
		
		System.out.println(lstInt.stream().collect(summarizingInt((Integer e) -> {return e;})).getMax());
		System.out.println(lstString.stream().collect(joining(",")));
		
		
		lstString.stream().filter(e -> e.length() > 1).findAny();
		/*Optional<Integer> optional = null;
		
		optional.isPresent();
		optional.orElse(13);
		Optional.of(-1).orElse(13);*/
		
		
		String s = null;
		String str = Optional.ofNullable(s).orElse("Hello Null");
		System.out.println(str);
		/*Consumer<Integer> consumer = System.out::println;
		lstString.forEach(consumer::accept);
		
		System.out.println(new ConsumerSuppiler().helloTestDefault());*/
		
	}

}
