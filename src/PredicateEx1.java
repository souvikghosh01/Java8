import java.util.function.Predicate;

// Having a string array, Print those elements whose length is more than 5. 

public class PredicateEx1 {

	public static void main(String[] args) {
		
		String[] StrArray= {"Ram", "Shyam", "Laxman", "Souvik", "Srijita"};
		
		Predicate<String> p = s->s.length()>5;
		
		for(String temp : StrArray){
			if(p.test(temp))
				System.out.println(temp);
		}
	}
}
