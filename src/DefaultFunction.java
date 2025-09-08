import java.lang.*;

interface A1{
	public abstract void a();
}

interface B1{
	public abstract void a();
}

public class DefaultFunction implements A1,B1{
	
	public static void main(String ar[]){
		
		DefaultFunction ob = new DefaultFunction();
		ob.a();
	}
	@Override
	public  void a(){
		System.out.println("Common implementation");
	}
	
}