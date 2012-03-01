public class Equestrian extends Horse {

	private long weight;

	Equestrian() {
		weight = 10;
	}

	Equestrian(long h, String c, long w) {
		super(h, c);
		weight = w;
	}

	public void trot() {
		System.out.println("Equestrian is trotting!");
	}

	public boolean isTrained() {
		if (weight < 10)
			return true;
		else
			return false;
	}

}
