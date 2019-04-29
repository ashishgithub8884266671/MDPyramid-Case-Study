import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalculateMaxSum {

	private static final String FILE_PATH = "./src/resources/inputFile3.txt";
	private int sum = 0;
	private int index = 0;
	private int lastElementInserted = 0;
	private String line;
	private static StringBuffer path = new StringBuffer();

	public static void main(String[] args) throws IOException {
		CalculateMaxSum calculateMaxSum = new CalculateMaxSum();
		BufferedReader bufferedReader = calculateMaxSum.readFile(FILE_PATH);
		int sum = calculateMaxSum.findMaxSum(bufferedReader);
		System.out.println("Max sum:" + sum);
		System.out.println("Path:"+path);
	}

	public int findMaxSum(BufferedReader bufferedReader) throws IOException {

		try {
			line = bufferedReader.readLine();

			while (line != null) {
				String inputLine[] = line.split(" ");
				if (inputLine.length == 1) {
					addFirstTime();
				} else {
					calculate(inputLine);
				}
				line = bufferedReader.readLine();
			}
		} finally {
			bufferedReader.close();
		}

		return sum;
	}

	private void calculate(String[] inputLine) {
		int left = Integer.parseInt(inputLine[index - 1]);
		int right = Integer.parseInt(inputLine[index]);

		if (lastElementInserted % 2 == 0) {
			calculateEven(left, right);
		} else {
			calculateOdd(left, right);
		}
	}

	private void calculateOdd(int left, int right) {
		if (left % 2 == 0 && left > right) {
			sumAndAdjust(left);
		} else if ((right % 2 == 0)) {
			sumAndAdjust(right);
			index = index + 1;
		} else if ((left % 2 == 0)) {
			sumAndAdjust(left);
		}
	}

	private void calculateEven(int left, int right) {
		if (right % 2 != 0 && left < right) {
			sumAndAdjust(right);
			index = index + 1;
		} else if (left % 2 != 0) {
			sumAndAdjust(left);
		} else if (right % 2 != 0) {
			sumAndAdjust(right);
			index = index + 1;
		}

	}

	private void sumAndAdjust(int element) {
		sum = sum + element;
		path.append(",").append(element);
		lastElementInserted = element;
	}

	private void addFirstTime() {
		sum = sum + Integer.parseInt(line);
		path.append(line);
		lastElementInserted = Integer.parseInt(line);
		index = 1;

	}

	public BufferedReader readFile(String filePath) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return bufferedReader;
	}
}
