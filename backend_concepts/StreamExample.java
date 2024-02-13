// The below code shows the implementation of Streams in two ways:
// 1) Without Lambda expressions, b using anonymous class concept
// 2) Using Lambda expressions
// The code also shows implementations of Intermediate Operations and Terminal Operations.

package basicConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Function;

public class StreamExample 
{
	public static void main(String args[])
	{
		List<Integer> number = Arrays.asList(1,2,3,4,5);
		
		// Without Lambda Expressions - Using Anonymous Class
		
		System.out.println(number.stream().filter(new Predicate<Integer>() 
		{
			@Override
			public boolean test(Integer t) 
			{
				System.out.println("Inside test method with t = "+t);
				return t%2==0;
			}
			
		}).map(new Function<Integer, Integer>() // end of filter, start of map
				{
					@Override
					public Integer apply(Integer t) 
					{
						System.out.println("Inside apply method with t = "+t);
						return t*t;
					}
			
				}
		).collect(Collectors.toList()) //end of map
		);
		
		// With Lambda Expression - all above code can be written in one line using lambda expressions
		
		System.out.println(number.stream().filter(t -> t%2==0).map(t -> t*t).collect(Collectors.toList()));
		System.out.println("Inside main method");
		
		List<String> names = Arrays.asList("Java","Python","Golang","Node");
		Set<String> result = names.stream().filter(s -> s.startsWith("G"))
				.map(s -> s.toUpperCase()).collect(Collectors.toSet());
		System.out.println(result);
	}
}