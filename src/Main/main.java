package Main;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

//Parent/Child Super calls
class Derp{
	private int test;
	public Derp(){
		System.out.println(test);
	}
	
}


class Herp extends Derp{
	public Herp(){
		super();
		System.out.println("Child Class");
	}
	
}

//Calling another constructor
class A{
	public A(){
		this(5);
	}
	public A(int a){
		System.out.println(a);
	}
}

//Remember when you have method the parent and child must both be static or non-static
//Classes that implements overriding
class One{
	private String name;
	public One(){
		this.name = "\tParent";
	}
	
	public void getName(){
		System.out.println(name);
		
	}
}

class Two extends One{
	private String name;
	public Two(){
		super();
		this.name = "\tChild";
	}
	
	public void getName(){
		System.out.println(name);
	}
}

//Static version of the previous classes, using hiding
class OneS{
	private static String name;
	public OneS(){
		this.name = "\tParent";
	}
	
	public static void getName(){
		System.out.println(name);
		
	}
}

class TwoS extends OneS{
	private static String name;
	public TwoS(){
		super();
		this.name = "\tChild";
	}
	
	public static void getName(){
		System.out.println(name);
	}
}
//Abstract class
abstract class Abstraction{
	public final int y = 5;
	public abstract void abstractMethod();
	public void nonAbstractMethod(){
		System.out.println("Not Abstract");
	}
}

//Interface Example
interface Interfacing{
	final int a = 5;
	void HelloWorld();
	void HelloWorld(String a);
}

public class main extends Abstraction implements Interfacing{
	//Extended abstract method
	public void abstractMethod(){
		
	}
	//Overloaded abstract method
	public int abstractMethod(int a){
		return 1;
	}
	
	//try catch with Exceptions
	public static void tryCatch() throws Exception{
		int[] a = new int[5];
		try{
			System.out.println(a[6]);
		}catch(Exception ArrayOutOfBound){
			System.out.println("Out of Bound!");
			throw new Exception();
		}finally{
			System.out.println("Finally block");
		}
		System.out.println("Out of try catch!");

	}
	
	//Interface methods that had to be implemented
	public void HelloWorld(){
	}
	public void HelloWorld(String a){
	}

	public static void main(String[] args) {
		/*try{
			tryCatch();
			System.out.println("Main try block");
		}catch(Exception Excepion){
			System.out.println("Did I print the last part? ;)");
		}*/
		ternaryTest();
		switchTest();
		forEachTest();
		stringBuilderTest();
		System.out.println(overloaded(2));
		System.out.println(overloaded(2.0));
		varArgs(1, 2, 3, 4, 5);
		new A();
		System.out.println("Overriding:");
		One one = new Two();
		one.getName();          //Since it is overriden it will go to the child
		Two two = (Two) one;	//Switch back works since it is a instance of Two
		two.getName();			//Goes to child
		System.out.println("Hiding:");
		OneS oneS = new TwoS();
		oneS.getName();         //This should print the parent due to hiding
		TwoS twoS = (TwoS) oneS;//Switch back works since it is a instance of Two
		twoS.getName();			//Goes to child
		OneS derp = new OneS();
		looping();
		instanceVariables();
		PolyMaster.feed(new ParentPoly());
		PolyMaster.feed(new ChildPolyA());
		PolyMaster.feed(new ChildPolyB());
		Variables.IntegerPrint();
		//Loops.Looping();			Infinite loop
		//DoubleCatch.CatchExample();
		whileLoop.whileLooping();
	}
	
	
	//Ternary Example
	public static void ternaryTest(){
		int i = 2;
		System.out.println((i > 2)? 7 : 8);
	}
	
	public static void switchTest(){
		int a = 7;
		switch(a){	
		default:
			System.out.println("Default");
			break;
		case(5):
			System.out.println("5");
			break;
		case(6):
			System.out.println("6");
			break;
		}
	}
	
	public static void forEachTest(){
		int List[] = new int[5];
		for(int i:List){
			System.out.print(i);
		}
			System.out.println();
	}
	
	public static void stringBuilderTest(){
		StringBuilder foo = new StringBuilder("Hello!");
		String bar = "Hello!";
		System.out.println(foo.equals(bar));
		System.out.println(bar.length());
	}
	
	public static int overloaded(int a){
		return a;
	}
	
	public static double overloaded(double a){
		return a;
	}
	
	public static void varArgs(int...num){
		for(int i:num)
			System.out.printf("%d ", i);
		System.out.println();
	}
	
	public static void looping(){
		int i;
		for(i = 0; i < 2; i++){
			System.out.println(i);
		}
		int y = 2;
		int x = y++ + ++y;
		System.out.println(x);
			
			
	}
	
	static int instanceInt;
	static double instanceDouble;
	static String instanceString;
	static boolean instanceBool;
	
	public static void instanceVariables(){
		System.out.println(instanceInt);
		System.out.println(instanceDouble);
		System.out.println(instanceString);
		System.out.println(instanceBool);
	}

}


//Polymorphism
class ParentPoly{
	private int i;
	private String name;
	public ParentPoly(){
		this.name = "ParentPoly";
		this.i = 1;
	}
	
	public String getName(){
		return this.name;
	}
}

class ChildPolyA extends ParentPoly{
	private String name;
	public ChildPolyA(){
		this.name="ChildPolyA";
	}
	public String getName(){
		return this.name;
	}
}

class ChildPolyB extends ParentPoly{
	private String name;
	public ChildPolyB(){
		this.name = "ChildPolyB";
	}
	public String getName(){
		return this.name;
	}
}

class PolyMaster{
	public static void feed(ParentPoly a){
		System.out.println(a.getName());
	}
}

class Variables{
	static ArrayList<Integer> foo = new ArrayList<Integer>();
	public static void IntegerPrint(){
		foo.add(1);
		foo.add(2);
		System.out.println(foo);
	}
}

class DoubleCatch{
	public static void CatchExample(){
		try{
			System.out.println("Try");
			throw new IllegalArgumentException();
		}catch(IllegalArgumentException e){
			System.out.println("Catch 1");
			throw new RuntimeException();
		}catch(RuntimeException e){
			System.out.println("Catch 2");
		}finally{
			System.out.println("Finally");
		}
	}
}

class Loops{
	public static void Looping(){
		for(int i = 0; i < 10; ){
			i = i++;
			System.out.println("Looped" + i);
		}
	}
}
//One of the example questions at the end of the book
class whileLoop{
	public static void whileLooping(){
		int x = 0;
		while(++x < 5){
			x +=1;
		}
		String message = x > 5? "Greater than" : "Less than";
		System.out.println(message+", "+x);
	}
}

