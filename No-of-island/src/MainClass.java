import java.util.Objects;

public class MainClass {

	
	public static int getNoOfIsland(int [][] land) {
		if(Objects.isNull(land)) {
			throw new IllegalArgumentException("Land cannot be null");
		}
		if(land.length == 0) {
			throw new IllegalArgumentException("Land cannot be empty");
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(getNoOfIsland(null));
	}

}
