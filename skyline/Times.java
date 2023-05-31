package algestudiante.p32;

public class Times {

	public static void main(String[] args) {
		final int MAX_VALUE = 200_000;
		long limite = 1000000000;

		System.out.println("n   \tTiempo");
		// BRUTE FORCE

		for (int n = 10; n < MAX_VALUE; n *= 2) {
			SkylineProblem problem = new SkylineProblem(n);
			long t1 = System.currentTimeMillis();
			for (int repeticiones = 1; repeticiones <= limite; repeticiones++) {

				problem.solveBruteForce();
			}
			long t2 = System.currentTimeMillis();
			System.out.println(n + "\t" + (t2 - t1));
		}

		System.out.printf("\n\n");
		System.out.println("n   \tTiempo");

		// DIVIDE AND CONQUER

		for (int n = 10; n < MAX_VALUE; n *= 2) {
			SkylineProblem problem = new SkylineProblem(n);
			long t1 = System.currentTimeMillis();
			for (int repeticiones = 1; repeticiones <= limite; repeticiones++) {

				problem.solveDivideAndConquer();
			}

			long t2 = System.currentTimeMillis();
			System.out.println(n + "\t" + (t2 - t1));
		}
	}

}
