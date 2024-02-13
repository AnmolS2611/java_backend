package basicConcepts;

import java.util.List;
import java.util.Arrays;

public class ParallelStreamExample 
{
	public static void main(String args[])
	{
		List<String> list = Arrays.asList("J","A","V","A","B","A","C","K");
		list.parallelStream().forEach(System.out::print); 
		// Above code returns a string without any specific order because streams are running parallel
		
		System.out.println();
		
		// How to get Number of Cores in the system using Java?
		System.out.println("Available cores: "+Runtime.getRuntime().availableProcessors());
		
		// How to get the stream and the thread and the core
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		numbers.parallelStream().filter(i -> {
			System.out.println("In filter method: "+i+", thread: "+Thread.currentThread().getName());
			return i%2==0;
		}).map(i -> {
			System.out.println("In map method: "+i+", thread: "+Thread.currentThread().getName());
			return i*i;
		}).forEachOrdered(x -> {
			System.out.println("In forEachOrdered method: "+x+", thread: "+Thread.currentThread().getName());
		});
	}
}