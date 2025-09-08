import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FrequencyOfStringUsingStream {

	public static void main(String[] args) {
		
		String input = "bookkeeper";
		
		// 1. Print frequencies of characters in a string
		
		Map<String, Long> map = Stream.of(input.toLowerCase().split(""))
									  .collect(Collectors.groupingBy(ch->ch, Collectors.counting()));
		System.out.println(map);
		//If we want Map<Character, Long> 
		Map<Character, Long> mapCharacterVsLong = Stream.of(input.toLowerCase().split(""))
														.map(ch->ch.charAt(0))
														.collect(Collectors.groupingBy
																(Function.identity(), Collectors.counting()));
		 
		System.out.println(mapCharacterVsLong);
		

		// 2. Print frequencies of characters in a string in the order of their occurrence.
		// HashMap doesn’t preserve the order in which key is added. To preserve the order we need to use LinkedHashMap
		
	   LinkedHashMap<String, Long> linkedHashMap = Stream.of(input.toLowerCase().split(""))
			   											 .collect(Collectors.groupingBy(ch->ch, 
			   													 						LinkedHashMap::new, 
			   													 							Collectors.counting()));
	   System.out.println(linkedHashMap);
		
	   //3. Print characters frequency in alphabetic order. 
	   TreeMap<Character, Long> treeHashMap = Stream.of(input.toLowerCase().split(""))
																.map(ch->ch.charAt(0))
																.collect(Collectors.groupingBy
																		(Function.identity(), TreeMap::new ,Collectors.counting()));
	   
	   System.out.println("Sorted by key" + treeHashMap);
	    
	   
	 //Suppose we have a existing hashMap then Sort it by key. LinkedHashMap last ae karon jate oi sorted order ta preserved 
	 //thake karon  notun ashmap ae jokhon store korbe tokhon sorted order ta jate ghete na jaye taai LinkedHashMap
	   Map<String, Long> sorted = map.entrySet().stream()
			   						 .sorted(Map.Entry.comparingByKey()) // this will return the sorted stream
			   						 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
													LinkedHashMap::new));
	   System.out.println("Sorted by key" + sorted);
	   
	   
	   // 4. Print characters frequency in the order of most frequent one to least frequent one.Sort by value. 
	   // Tar maneh just like 1 frequency ta ke map ae store kore final map ta ke sort korte lagbe as per value	   
	   // frequency to already bar kore diyechi map ae, ebar map ta ke sort korte lagbe 
	   
		 sorted = map.entrySet()
					 .stream()
					 .sorted(Map.Entry.comparingByValue()) // this will return the sorted stream
					 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
							 													LinkedHashMap::new));
		 System.out.println("Sorted by value" + sorted);
		 
	   // 5. Desc order of value
	   
		 sorted = map.entrySet()
					 .stream()
					 .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // this will return the desc sorted stream
					 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
							 													LinkedHashMap::new));
		 System.out.println("Sorted by desc value" + sorted);
		 // The most repeated character
		 String max = map.entrySet()
		 .stream()
		 .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		 .map(entrySet-> entrySet.getKey())
		 .findFirst()
		 .orElse(null);
		 System.out.println(max);
	}

}
