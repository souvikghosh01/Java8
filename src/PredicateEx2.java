import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
// Having a list of employees, print the details of those emps whis salary > 15000 n having girlfriend .
class Employee1{
	int empNo;
	String empName;
	int salary;
	int noOfGirlFiends;
	
	Employee1(int empNo, String empName, int salary , int noOfGirlFiends){
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
		this.noOfGirlFiends = noOfGirlFiends;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getNoOfGirlFiends() {
		return noOfGirlFiends;
	}

	public void setNoOfGirlFiends(int noOfGirlFiends) {
		this.noOfGirlFiends = noOfGirlFiends;
	}

	public String toString(){
		
		return (empName + " has " + noOfGirlFiends + " girlfriend(s) and gets a salary of " + salary);
	}
}
public class PredicateEx2 {

	public static void main(String[] args) {
		List<Employee1> emp = new ArrayList<Employee1>();	
		Predicate<Employee1> p = e->e.salary>1500 && e.noOfGirlFiends>0;
		emp.add(new Employee1(105, "Souvik", 15000, 1));
		emp.add(new Employee1(101, "Mvk1", 150, 0));
		emp.add(new Employee1(104, "Svk4", 162520, 6));
		emp.add(new Employee1(102, "Avk2", 1000, 1));
		emp.add(new Employee1(106, "Gvk6", 1500, 5));
		emp.add(new Employee1(103, "Svkk3", 20000000, 10));
		emp.forEach(temp->{
			if(p.test(temp))
				System.out.println(temp);
		});
		
		System.out.println("---------------");
		emp.stream().filter(p).forEach(System.out::println);
		
		System.out.println("---------------");
		List<String> filteredEmployeeName = new ArrayList<String>();
		filteredEmployeeName = emp.stream().filter(p)
					.map(Employee1::getEmpName)
					.map(String::new)
					.collect(Collectors.toList());
		
		filteredEmployeeName.forEach(System.out::println);
	}
}
