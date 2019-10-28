import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MainClass {

	public static boolean chainedArray(List<String> data) {
		if(Objects.isNull(data) || data.isEmpty()) {
			throw new IllegalArgumentException("Data is empty");
		}
		int size = data.size();
		if (size == 1)
			return true;
		Collections.sort(data);
		int first = 0;
		int last = 1;
		while (last < data.size()) {
			String firstWord = data.get(first);
			String lastWord = data.get(last);
			if (firstWord.charAt(firstWord.length() - 1) != lastWord.charAt(0)) {
				return false;
			}
			first++;
			last++;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(chainedArray(new ArrayList<>(Arrays.asList("ijk"))));
	}

}
