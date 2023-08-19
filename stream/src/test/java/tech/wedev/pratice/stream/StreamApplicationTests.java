package tech.wedev.pratice.stream;

import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StreamApplicationTests {

	@Test
	public void test0() {
		var random = new Random();
		var list = IntStream.range(0, 1_00).filter(x -> x < 5).map(x -> random.nextInt(1_00)).boxed().collect(Collectors.toList());
		var result = list.parallelStream().max(Comparator.comparingInt(x -> x)).orElse(0);
		var result1 = list.parallelStream().reduce(0, Math::max);
		System.out.println(result);
	}

	@Test
	public void test1(){
		var random = new Random();
		var list = IntStream.range(0, 1_00).filter(x -> x < 5).map(x -> random.nextInt(1_00)).boxed().collect(Collectors.toList());
		var result = list.parallelStream().max(Comparator.comparingInt(x -> x)).orElse(0);
		list.stream().filter(a -> a < 17).collect(Collectors.toList());
		var result1 = list.parallelStream().reduce(0, Math::max);
		System.out.println(result);
	}

	@Test
	public void test2(){
		Optional<Integer> x = Optional.empty();
		var y = x.map(a -> a * a);
		System.out.println(y);
	}

	@Test
	public void test3(){
		var result = Stream.of("123", "55555").map(String::length).reduce(0, Integer::sum);
		System.out.println(result);
	}

	@Test
	public void test4(){
		new Random(1)
			.ints(5, 20)
			.distinct()
			.limit(7)
			.sorted()
			.forEach(System.out::println);
	}

}
