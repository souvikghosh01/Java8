import java.util.function.Consumer;
// WAP to generate a 6 digit OTP

public class ConsumerEx {

	public static void main(String[] args) {

		Consumer<String> con = s->System.out.println("Hi "  + s +" !" );
		con.accept("Souvik");
		
	}

}
