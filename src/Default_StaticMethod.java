@FunctionalInterface
interface interf{
	
	public int add(int a, int b);
	default void printIt(){
		System.out.println("Default method");
	}
	public static int multiply(int a , int b){
		return a*b;
	}
}
public class Default_StaticMethod {
	
	public static void main(String[] args) {
		interf i = (a,b)->a+b;
		System.out.println(i.add(5,6));		//11 
		i.printIt();						// Default method
		
		System.out.println(interf.multiply(4,5)); 		//20
		
	}

}
