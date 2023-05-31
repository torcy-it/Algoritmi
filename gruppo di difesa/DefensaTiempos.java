package algestudiante.p4;

public class DefensaTiempos {

	public static void main(String[] args) {

		long t1, t2;
		int limite = 1000;
		System.out.println("n   \tTiempo");
		
		for (int n = 10; n <= 10_000_000; n *= 2) {
			
			Defensa defensa = new Defensa(n, Defensa.generarEnemigos(n), Defensa.generarGrupoDefensa(n));
			t1 = System.currentTimeMillis();
			for (int repeticiones = 1; repeticiones <= limite; repeticiones++) {
				defensa.asignar();
			}

			t2 = System.currentTimeMillis();
			System.out.println(n + "\t" + (t2 - t1));

		} // for

	} // main
}