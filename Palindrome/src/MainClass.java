import java.util.Objects;

public class MainClass {

	public static void main(String[] args) {
		System.out.println(isPalindorme(new char[] { 'C', 'A', 'T' ,'A', 'C' }));
	}

	private static boolean isPalindorme(char[] cs) {
		if (Objects.isNull(cs) || cs.length == 0) {
			throw new IllegalArgumentException("DATA is empty");
		}
		int first = 0;
		int last = cs.length - 1;
		while (first <= last) {
			if (cs[first] != cs[last]) {
				return false;
			}
			first++;
			last--;
		}
		return true;
	}

}
