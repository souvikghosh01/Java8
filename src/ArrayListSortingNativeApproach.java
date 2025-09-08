import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyEmployee{
	int empNo;
	String empName;
	
	MyEmployee(int empNo, String empName){
		this.empNo = empNo;
		this.empName = empName;
	}
	
	public String toString(){
		
		return (empNo + "->" + empName);
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

class MyComparator implements Comparator<MyEmployee>{

	@Override
	public int compare(MyEmployee e1, MyEmployee e2) {

		return (e1.empNo<e2.empNo)?-1:(e1.empNo>e2.empNo)?+1:0;
	}
	
}
public class ArrayListSortingNativeApproach {
	public static void main(String[] args) {
		ArrayList<MyEmployee> l = new ArrayList<MyEmployee>();
		l.add(new MyEmployee(105, "Svk5"));
		l.add(new MyEmployee(101, "Mvk1"));
		l.add(new MyEmployee(104, "Svk4"));
		l.add(new MyEmployee(102, "Avk2"));
		l.add(new MyEmployee(106, "Gvk6"));
		l.add(new MyEmployee(102, "Svkk3"));
		
		Collections.sort(l, new MyComparator());
		l.forEach(System.out::println);
	}

}
