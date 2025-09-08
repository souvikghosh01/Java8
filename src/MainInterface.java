@FunctionalInterface
public interface MainInterface {

	// abstract method
	public int add(int a, int b);
	
	//default methods
	default void printIt(){
		System.out.println("Default method");
	}
	
	//static method
	public static int multiply(int a , int b){
		return a*b;
	}

	//static main method
	public static void main(String[] args) {
		MainInterface i = (a,b)->a+b;
		System.out.println(i.add(5,6));		//11 
		i.printIt();						// Default method
		
		System.out.println(MainInterface.multiply(4,5)); 		//20
		
	}

}
