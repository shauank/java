package com.test.lambda;

interface Executable {
	int execute(int i);
}


interface StringExecutable {
	int execute(int i);
}

class Runner {
	public void run(Executable e) {
		System.out.println("Executing code.....");
		int value = e.execute(2);
		System.out.println("return value "+ value);
//		e.execute1(4);
	}
	
	public void run(StringExecutable e) {
		System.out.println("Executing in String executable code.....");
		int value = e.execute(1);
		System.out.println("return value "+ value);
//		e.execute1(4);
	}
}

public class LambdaHelloWorld {

	public static void main(String[] args) {
		Runner r = new Runner();
		int d = 99;
//		r.run(new Executable() {
//			
//			@Override
//			public void execute() {
//				System.out.println("in Execute methods");
//			}
//		});
		
		System.out.println("========================================");
		
		/*r.run((x) -> {
			System.out.println("in Execute methods" + x);
			return 8;
		});*/
		StringExecutable se = (a) -> {
			System.out.println("test");
			int ad = 10;
			return d;
		};
		
		r.run(se);
		
	}

}
