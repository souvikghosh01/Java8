import java.lang.reflect.InvocationTargetException;

class BCD{
	public void a(){
		System.out.println("Inside A");
	}

}
public class InnerClass{

	public static void main(String[] args){
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("Child Thread");
			}
		};
		Thread t = new Thread(r);
		t.start();
		System.out.println("Main Thread");
		
		
		//---------------------------------
		BCD obj = new BCD(){
			int x= 5;
			public void print(){
				System.out.println(x);
			}
		};
		obj.a();
		try {
			obj.getClass().getMethod("print", null).invoke(obj, null);
		} catch (IllegalAccessException| IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
	}
}
