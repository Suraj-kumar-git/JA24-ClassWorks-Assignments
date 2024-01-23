package java8.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		Stream stream = Stream.of(10,20,30,40,50);
//		long count = stream.count();
//		System.out.println(count);
		
		Comparator<Integer> comparator = (i1,i2)->{return i1.toString().compareTo(i2.toString());};
		Optional<Integer> optional = stream.max(comparator);
		if(optional.isPresent()) {
			System.out.println(optional.get());
		}else {
			System.out.println(optional.orElse(0));
		}
		
		String names[] = {"satish","ravindra kumar","ford", "adam gilchrist","Suraj"};
		Stream<String> stream2 = Arrays.stream(names);
		stream.map((str)->{System.out.println(str); return ((String) str).length();}).forEach((len)->{System.out.println(len);});
		
		List<String> list = Arrays.asList(names);
		Stream<String> stream3 = list.stream();
		
		stream3.map((str)->{return str.length();})
		.filter((len)->{return len>7;})
//		.forEach(System.out::println);
		.toList();
		
		System.out.println(list);
		
		
	}

}
