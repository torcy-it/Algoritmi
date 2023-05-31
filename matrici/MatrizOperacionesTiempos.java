package algestudiante.p0;


public class MatrizOperacionesTiempos {

	public static void main(String[] args) {

		long t1, t2;
		int limite = 10000000;

		System.out.println("n\tt");
		for (int n = 3; n < 100000; n *= 2) {
			// el tamaño del problema tiene que ir variando con n, por eso hay que construir matrices en funcion de n
			MatrizOperaciones matrizOperaciones = new MatrizOperaciones(n, 1, 5);
			t1 = System.currentTimeMillis();
			for (int repeticiones = 0; repeticiones < limite; repeticiones++)
				matrizOperaciones.sumarDiagonal1();
			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + +(t2 - t1));
		}
		System.out.println();
		System.out.println("n\tt");
		for (int n = 3; n < 100000; n *= 2) {
			MatrizOperaciones matrizOperaciones = new MatrizOperaciones(4, 1, 5);
			t1 = System.currentTimeMillis();
			for (int repeticiones = 0; repeticiones < limite; repeticiones++)
				matrizOperaciones.sumarDiagonal2();
			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + +(t2 - t1));
		}

	}
}