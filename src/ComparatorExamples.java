import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
	int empNo;
	String empName;
	int marks; 
	
	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	Employee(int empNo, String empName, int marks){
		this.empNo = empNo;
		this.empName = empName;
		this.marks = marks;
	}
	
	public String toString(){
		
		return (empNo + "->" + empName + "->" + marks);
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
}
public class ComparatorExamples {
	public static void main(String[] args) {
		ArrayList<Employee> l = new ArrayList<Employee>();
		l.add(new Employee(107, "Svk5", 70));
		l.add(new Employee(102, "Svkk3", 50));
		l.add(new Employee(105, "Svk4", 60));
		l.add(new Employee(104, "Avk2", 90));
		l.add(new Employee(105, "Gvk6", 76));
		l.add(new Employee(102, "Svkk3", 38));
		l.add(new Employee(101, "Avkk3",29));
		
		l.forEach(System.out::println);
		
		System.out.println("--------------------Sorting by empNo-----------------------------");
		/** Internally the Comparator Interface is called which implements the Compare function.*/
		//Collections.sort(l, (e1,e2)->(e1.empNo<e2.empNo)?-1:(e1.empNo>e2.empNo)?+1:0);
		Collections.sort(l, (e1,e2)-> e1.empNo - e2.empNo);
		l.forEach(System.out::println);
		
		System.out.println("-Sorting by length of names,jodi samelength then alphabetically---");
		/** Internally the Comparator Interface is called which implements the Compare function.*/
		Comparator<Employee> empName = (e1,e2)->{
			int len1 = e1.empName.length();
			int len2 = e2.empName.length();
			return (len1<len2)?-1:(len1>len2)?+1:e1.empName.compareTo(e2.empName);
		};
		Collections.sort(l, empName);
		
		l.forEach(temp -> System.out.println(temp));
		
		System.out.println("Streams sorting ex");
		l.stream().sorted((e1,e2)->(e1.empNo<e2.empNo)?-1:(e1.empNo>e2.empNo)?+1:0).forEach(System.out::println);
		
		System.out.println("----------------------Sorting by empName----------------------------");
	
		//This is internally using Comparable interface implementing the compareTo method.
		Collections.sort(l, (e1,e2)->e1.empName.compareTo(e2.empName));
		
		l.forEach(temp -> System.out.println(temp));
		
		System.out.println("----------------------Sorting by chaining comparator function "
				+ "dec order of Emp no then asc or name and dec order of marks" + "	----------------------------");
		
		Comparator<Employee> comp = Comparator.comparing(Employee::getEmpNo, Collections.reverseOrder()).
												thenComparing(Employee::getEmpName)
												.thenComparing(Employee::getMarks, Collections.reverseOrder());
		Collections.sort(l, comp);
		l.forEach(temp -> System.out.println(temp));
		
		// Native approach 
		System.out.println("----------------------Sorting by native approach for channing"
				+ "dec order of Emp no then asc or name and dec order of marks" + "	----------------------------");
		Comparator<Employee> comp1 = (a,b)->{
			int empNo = Integer.compare(b.getEmpNo(), a.getEmpNo());
			if(empNo != 0)
				return empNo;
			int empNameComp = a.getEmpName().compareTo(b.getEmpName());
			if(empNameComp != 0)
				return empNameComp;
			
			return Integer.compare(b.getMarks(), a.getMarks());
		};
		
		Collections.sort(l, comp1);
		l.forEach(temp -> System.out.println(temp));
		
	}

}
