package algestudiante.p5;

public class IslandsPathsTiempo {
	
	public static void main(String[] args) {
		final int MAX_VALUE = 200_000;
		long limite = 10;

		System.out.println("n   \tTiempo");
		// BRUTE FORCE

		for (int n = 100; n < MAX_VALUE; n *= 2) {
			IslandsPath problem = new IslandsPath(n);
			long t1 = System.currentTimeMillis();
			for (int repeticiones = 1; repeticiones <= limite; repeticiones++) {

				problem.calculateMaximumWidths();
			}
			
			long t2 = System.currentTimeMillis();
			System.out.println(n + "\t" + (t2 - t1));
		}

		System.out.printf("\n\n");
		System.out.println("n   \tTiempo");
	}

}

