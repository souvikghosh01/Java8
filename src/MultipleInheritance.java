/*interface A{
	default void m1(){
		System.out.println("A");
	}
}
interface B{
	default void m1(){
		System.out.println("B");
	}
}
public class MultipleInheritance  implements A,B{
	
	public void m1(){
		System.out.println("Our own method");	
	}
		
		
	public static void main(String[] args){
		MultipleInheritance obj = new MultipleInheritance();
		obj.m1();
		}
	

}
*/
/*
interface A{
	default void m1(){
		System.out.println(" interface A");
	}
}
interface B{
	default void m1(){
		System.out.println(" interface B");
	}
}
public class MultipleInheritance  implements A,B{
	
	public void m1(){
		A.super.m1();
	}
		
		
	public static void main(String[] args){
		MultipleInheritance obj = new MultipleInheritance();
		obj.m1();
		}
}

*/

class A{
	public void m1(){
		System.out.println(" Class A");
	}
}
interface B{
	default void m1(){
		System.out.println("Interface B");
	}
}
public class MultipleInheritance  extends A implements B{
	public void test(){
		B.super.m1();
	}
	public static void main(String[] args) {
		MultipleInheritance obj = new MultipleInheritance();
		obj.test();
	}
}

