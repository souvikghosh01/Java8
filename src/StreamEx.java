import java.util.ArrayList;
import java.util.stream.Collectors;

/**Display all marks, 
 * display sorted marks in asc order, 
 * display sorted marks in desc order, 
 * display all the fail marks, 
 * add grace marks to all marks 
 * and filter out all the fail marks and 
 * display the count

*/
public class StreamEx {
		public static void main(String[] args) {
			ArrayList<Integer> marks = new ArrayList<Integer>();
			for(int i=0; i<10; i++){
				marks.add((int)(Math.random()*100));
			}
			
			//Integer[] array = marks.stream().toArray(size -> new Integer[size]);
			//Integer[] array1 = marks.stream().toArray(Integer[]::new);
			
			System.out.println("All marks = " + marks);
			marks = (ArrayList<Integer>) marks.stream().sorted().collect(Collectors.toList());
			System.out.println("All marks in asc sorted = " + marks);
			
			marks = (ArrayList<Integer>) marks.stream().sorted((a,b)->(a>b)?-1:(a<b?+1:0)).collect(Collectors.toList());
			System.out.println("All marks in desc sorted = " + marks);
		
			// Finding out max and min marks using streams
			System.out.println("Highest marks: " + marks.stream().max((a,b)->(a<b)?-1:(a>b?+1:0)).get());
			
			System.out.println("Lowest marks: " + marks.stream().min((a,b)->(a<b)?-1:(a>b?+1:0)).get());
			
			ArrayList<Integer> fail = (ArrayList<Integer>) marks.stream().filter(i->i<=30).collect(Collectors.toList());
			System.out.println("All fail marks = " + fail);
			
			fail = (ArrayList<Integer>) fail.stream().map(i->i+10).collect(Collectors.toList());
			System.out.println("Upgraded fail marks = " + fail);
			
			fail = (ArrayList<Integer>) fail.stream().filter(i->i<=30).collect(Collectors.toList());
			System.out.println("final fail marks = " + fail);
			
			int noOfFailMarks = (int) fail.stream().count();
			System.out.println(noOfFailMarks);
	}

}