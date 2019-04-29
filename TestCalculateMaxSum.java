import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.danske.it.main.CalculateMaxSum;

public class TestCalculateMaxSum {

	BufferedReader bufferedReader = null;
	CalculateMaxSum calculateMaxSum = null;

	@Before
	public void init() {
		calculateMaxSum = new CalculateMaxSum();
	}

	@Test
	public void test1() throws IOException {

		String filePath = "./src/resources/testInput1.txt";
		bufferedReader = calculateMaxSum.readFile(filePath);
		int sum = calculateMaxSum.findMaxSum(bufferedReader);
		assertEquals(16, sum);
	}

	@Test
	public void test2() throws IOException {
		String filePath = "./src/resources/testInput2.txt";
		bufferedReader = calculateMaxSum.readFile(filePath);
		int sum = calculateMaxSum.findMaxSum(bufferedReader);
		assertEquals(8186, sum);
	}

	@Test
	public void test3() throws IOException {
		String filePath = "./src/resources/testInput3.txt";
		bufferedReader = calculateMaxSum.readFile(filePath);
		int sum = calculateMaxSum.findMaxSum(bufferedReader);
		assertEquals(27, sum);
	}

}
