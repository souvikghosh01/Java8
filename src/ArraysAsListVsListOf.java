import java.util.Arrays;
import java.util.List;


public class ArraysAsListVsListOf {

	public static void main(String[] args) {

		String[] str = {"Apple", "Orange"};
		List<String> strList = Arrays.asList(str);
		strList.set(2, "Grape"); // Valid, the list and the array are both changed.
		// strList.add("grape"); // Throws UnsupportedOperationException
		System.out.println(strList);
		
		//List<String> list = List.of("apple", "banana"); from jav 1.9
		// list.set(0, "orange"); // Throws UnsupportedOperationException
		// list.add("grape"); // Throws UnsupportedOperationException
		// List<String> listWithNull = List.of("a", null); // Throws NullPointerException
		
	}

}
