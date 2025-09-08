import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;


public class StringSorting {
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");list.add("BA");list.add("AAA");list.add("CAA");list.add("X");list.add("WW");
		System.out.println("NORMAL LIST "+list);

		list = (ArrayList<String>) list.stream().sorted().collect(Collectors.toList());
		System.out.println("WITHOUT ANY PARAMETER. BY DEFAULT IT WILL IMPLEMENT compareTo() function  "+list);
		
		list = (ArrayList<String>) list.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());
		System.out.println("IMPLEMENTING compareTo for asc order  "+list);
		
		list = (ArrayList<String>) list.stream().sorted((a,b)->-a.compareTo(b)).collect(Collectors.toList());
		System.out.println("IMPLEMENTING compareTo for desc order  "+ list);
		Comparator<String> c = (a,b)->{
			int lenComparison = Integer.compare(a.length(), b.length());
			if(lenComparison != 0)
				return lenComparison;
			else
				return a.compareTo(b);
		};
		
		list = (ArrayList<String>) list.stream().sorted(c).collect(Collectors.toList());
		System.out.println("IMPLEMENTING compare function for asc order  "+list);
	}
}
