
public class InitializingFinalVariable {

	public final int a;
	
	
	public InitializingFinalVariable(){
		a=10;
	}
	
	public static void main(String[] args) {
		InitializingFinalVariable obj = new InitializingFinalVariable();
		System.out.println(obj.a);		
	}

}
