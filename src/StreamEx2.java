import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person{
	
	String name;
	String emailAddress;
	int age;
	boolean isValidated;
	List<String> phoneNumbers = new ArrayList<String>();
	
	public Person(String name, String emailAddress, int age,
			boolean isValidated, List<String> phoneNumbers) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.age = age;
		this.isValidated = isValidated;
		this.phoneNumbers = phoneNumbers;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", emailAddress=" + emailAddress
				+ ", age=" + age + ", isValidated=" + isValidated
				+ ", phoneNumbers=" + phoneNumbers + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isValidated() {
		return isValidated;
	}
	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}
	
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
class InternetAddress{
	public String emailAddress;

	public InternetAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "InternetAddress [emailAddress=" + emailAddress + "]";
	}
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}	
}
public class StreamEx2 {

	public static void main(String[] args) {

	ArrayList<Person> people  = new ArrayList<>();
	people.add(new Person("Souvik-1", "abc-1@xyz", 22, true, Arrays.asList("8981363398-1","9830020473-1")));
	people.add(new Person("Souvik-2", "abc-2@xyz", 32, false,Arrays.asList("8981363398-2","9830020473-2")));
	people.add(new Person("Souvik-3", "abc-3@xyz", 42, true, Arrays.asList("8981363398-3","9830020473-3")));
	people.add(new Person("Souvik-4", "abc-4@xyz", 52, false,Arrays.asList("8981363398-4","9830020473-4")));
	
	// Example of Map() 
	//list out all the people's emailAddress to another list 
	ArrayList<String> address  = new ArrayList<String>();
	address =(ArrayList<String>) people.stream().map(Person::getEmailAddress) // using method ref, we can use lambda also
											//  .map(String::new) <- eta dileo hoye aar na dileo hoye bcoz we are converting String to String
												.collect(Collectors.toList());
	address.forEach(System.out::println);
	
	// list out all those person's emailAddress whose age is <50 and is a valid user to another list of InternetAddress type
	// Taking another array List of type InternetAddress and using method reference in line 97 & 98
	
	ArrayList<InternetAddress> internetAddress  = new ArrayList<InternetAddress>();
	internetAddress = (ArrayList<InternetAddress>) people.stream()
											       .filter(person -> person.getAge() <50)
											       .filter(Person::isValidated) // can also be written as .filter(person -> person.isValidated())
												   .map(person -> person.getEmailAddress())// Stream of strings
												   .map(InternetAddress::new)	//.map(emailAddress -> new InternetAddress(emailAddress))
												   .collect(Collectors.toList());
	internetAddress.forEach(temp -> System.out.println(temp));
	
	//Type -2 using lambda expression in line 105
	System.out.println("Type - 2");
	internetAddress.clear();
	internetAddress = (ArrayList<InternetAddress>) people.stream()
											       .filter(person -> person.getAge() <50 && person.isValidated())
												   .map(person -> new InternetAddress(person.getEmailAddress()))
												   .collect(Collectors.toList());
	internetAddress.forEach(temp -> System.out.println(temp));
		
	// Example of flatMap()
	// list out all the people's phoneNumber to another list. Since phoneNum is a list inside people list 
	// so if we use map here the out put will be also list of list
	
	List<List<String>> phoneNumbers = people.stream()
											.map(Person::getPhoneNumbers)
											.collect(Collectors.toList());
	System.out.println("Printing phone numbers using map");
	phoneNumbers.forEach(System.out::println);
	
	// Using Flat map for this to flatten the input stream
	
	List<String> flatPhoneNumbers = people.stream()
										  .flatMap(person -> person.getPhoneNumbers().stream())
										  .collect(Collectors.toList());
	System.out.println("Printing phone numbers using flat map");
	flatPhoneNumbers.forEach(System.out::println);
	
	}
}
