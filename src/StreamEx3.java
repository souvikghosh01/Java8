import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamEx3 {

	public static void main(String[] args) {

		// Distinct
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);numbers.add(2);numbers.add(3);numbers.add(4);numbers.add(1);
		numbers = numbers.stream().distinct().collect(Collectors.toList());
		numbers.forEach(System.out::println);
		
		// Reduce
		// reduce can take an initializing variable know as Identity if we give the identity then it will return that type 
		//if we do not provide any identity then the return  optional type
		// 1. without identity
		Optional<Integer> sum = numbers.stream().reduce((a,b)->{
			System.out.println("a:" + a + " b:" + b);
			return a+b ;
			});
		if(sum.isPresent())
			System.out.println("Sum1 is: " +sum.get());
		
		// 2. with identity
		//numbers = 1 2 3 4
		Integer sum1 = numbers.stream().reduce(0, (a,b)->{
			System.out.println("a:" + a + " b:" + b);
			return a+b ;
			});
		System.out.println("Sum2 is: " +sum1);
		
		//3. With Collectors.summingInt()
		Integer sum3 = numbers.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println("Sum3 is: " +sum3);
		
		//Remove duplicate values from a Map
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Souvik");
		map.put(2, "Ghosh");
		map.put(3, "Souvik");

		Set<String> unique = new HashSet<String>();
		
		for(Map.Entry<Integer, String> entry: map.entrySet()){
			System.out.println(entry.getValue());
		}
		
		
		Map<Integer, String> collect = map.entrySet()
										  .stream()
										  .filter(entry -> unique.add(entry.getValue()))
							   			  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		
		for(Map.Entry<Integer, String> entry: collect.entrySet()){
			System.out.println(entry.getValue());
		}
		
		//groupBy
		List<Integer> numbers2 = new ArrayList<Integer>();
		numbers2.add(1);numbers2.add(2);numbers2.add(3);numbers2.add(4);numbers2.add(1);numbers2.add(4);
		
		//Frequency
		Map<Integer, Long> frequency = numbers2.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
		System.out.println(frequency);
		
		// We can also use Function.identity() instead of num-> num if we want to have a self reference as the key
				
		//Sum of a group 1 dubar ache taai 1+1, 2,3 ekbar ache 4 dubar ache 4+4
		Map<Integer, Integer> frequencySum = numbers2.stream()
											.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(Integer::intValue)));
		System.out.println(frequencySum);
		
		
		//String frequency
		String str = "geeksforgeeks";
		str.chars().forEach(System.out::print); // ascii chars
		System.out.println("\ncharacters printing");
		str.chars().mapToObj(ch-> (char)ch).forEach(System.out::print);
		
		Map<String, Long> stringFreq = Stream.of(str.split("")).collect(Collectors.groupingBy(temp -> temp, Collectors.counting()));
		System.out.println(stringFreq);
		Map<Character, Long> charFreq = str.chars().mapToObj(ch-> (char)ch).collect(
										Collectors.groupingBy(temp -> temp, Collectors.counting()));
		System.out.println(charFreq);
	}

}
