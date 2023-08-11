package tech.wedev.pratice.intern;

import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InternApplicationTests {

	@Test
	public void test0() {
		var random = new Random();
		var list = IntStream.range(0, 1_00).filter(x -> x < 5).map(x -> random.nextInt(1_00)).boxed().collect(Collectors.toList());
		var result = list.parallelStream().max(Comparator.comparingInt(x -> x)).orElse(0);
		var result1 = list.parallelStream().reduce(0, Math::max);
		System.out.println(result);
	}

}
