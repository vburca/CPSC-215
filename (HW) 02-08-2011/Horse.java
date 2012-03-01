public class Horse {

	private long height;
	private String color;
	
	Horse() {
		this(2, "brown");
	}

	Horse(long h, String c) {
		height = h;
		color = c;
	}
	
	public void run() {
		System.out.println("Horse is running!");
	}

	public void jumo() {
		System.out.println("Horse is jumping!");
	}

}
