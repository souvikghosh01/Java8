import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee4{
	String name;
	int age;
	int id;
	double salary;
	double yoe;
	String dept;
	
	@Override
	public String toString() {
		return "Employee4 [name=" + name + ", id=" + id + "]";
	}
	
	
	public Employee4(String name, int id, int age,  double salary, double yoe,
			String dept) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.salary = salary;
		this.yoe = yoe;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getYoe() {
		return yoe;
	}
	public void setYoe(double yoe) {
		this.yoe = yoe;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}

public class GroupingBy {

	public static void main(String[] args) {
		
		Employee4 emp1 = new Employee4("Souvik", 001, 29, 1000, 6, "IT");
		Employee4 emp2 = new Employee4("Pratik", 002, 36, 1055, 8, "CSE");
		Employee4 emp3 = new Employee4("Srijita", 003, 28, 1022, 5, "IT");
		Employee4 emp4 = new Employee4("Angana", 004, 34, 1023, 2, "CSE");
		Employee4 emp5 = new Employee4("Gouri", 005, 72, 10320, 13, "IT");
		Employee4 emp6 = new Employee4("Pradip", 006, 70, 10030, 15, "CSE");
		
		List<Employee4> empList = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
		
		//Stream expression to 
		// To get employee name whose age is > 30
		
		System.out.println(empList.stream().filter(emp->emp.age> 30).collect(Collectors.toList()));
		
		// To group employee based on their dept
		System.out.println("hello");
		System.out.println(empList.stream().collect(Collectors.groupingBy(Employee4::getDept,Collectors.mapping(Employee4::getName, Collectors.toList()))));
		
		// to convert names to uppercase
		
		System.out.println(empList.stream().map(emp->emp.getName().toUpperCase()).collect(Collectors.toList()));
		
		// To get the highest salary among all emp
		System.out.println(empList.stream().max(Comparator.comparingDouble(Employee4::getSalary)));
		System.out.println(empList.stream().max((e1,e2)->Double.compare(e1.getSalary(),  e2.getSalary())));
		
		// to get emp with yoe > 7
		
		System.out.println(empList.stream().filter(emp->emp.getYoe()> 7).collect(Collectors.toList()));
		
		// to count employee in each dept
		
		System.out.println(empList.stream().collect(Collectors.groupingBy(Employee4::getDept, Collectors.counting())));
		
		// IMPORTANT: To get the highest salary among all emp in each dept
		System.out.println(empList.stream().collect(Collectors.groupingBy(Employee4::getDept, Collectors.maxBy((e1,e2)->Double.compare(e1.getSalary(),  e2.getSalary())))));
		//Operer tate toh optional of employee pabi jodi bole toh give me the names only then eta korte parish
		Map<String, Optional<Employee4>> collect = empList.stream().collect(Collectors.groupingBy(Employee4::getDept, Collectors.maxBy((e1,e2)->Double.compare(((Employee4) e1).getSalary(),  ((Employee4) e2).getSalary()))));
		Map<String, String> collect2 = collect.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry-> entry.getValue().map(Employee4::getName).orElse("No employee found")));
		// Or shortcut hoche
		Map<String, String> highestPaidEmployeeByDept = empList.stream()
			    .collect(Collectors.groupingBy(Employee4::getDept,
			        Collectors.collectingAndThen(
			            Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())),
			            optionalEmployee -> optionalEmployee.map(Employee4::getName).orElse(null)
			        )
			    ));
		
		//AvG salary per dpet 
		System.out.println(empList.stream().collect(Collectors.groupingBy(Employee4::getDept, Collectors.averagingDouble(Employee4::getSalary))));
		
		
		//Group by seniority range If the yoe is 1-2 yrs=> junior
		// 2-7=> Mid 
		// >= 8 > senior
		
		
		System.out.println(empList.stream().collect(Collectors.groupingBy(emp -> {
			if (emp.getYoe()<=2)
				return "junior";
			else if(emp.getYoe()>2 && emp.getYoe()<=7)
				return "mid";
			else
				return "senior";
		},Collectors.mapping(Employee4::getName, Collectors.toList())
		)));
	}

}
