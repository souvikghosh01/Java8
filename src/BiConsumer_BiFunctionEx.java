import java.util.function.*;


public class BiConsumer_BiFunctionEx {

	public static void main(String[] args) {
		BiConsumer<String,String > obj = (str1,str2) ->{
			System.out.println(str1.concat(str2).length());
			
		};

			obj.accept("Souvik", "Ghosh");
	
	
	BiFunction<String,String,Integer> obj1 = (str1,str2) ->{
		return str1.concat(str2).length();
		};

		System.out.println(obj1.apply("Souvik", "Ghosh"));
		
	}

}
