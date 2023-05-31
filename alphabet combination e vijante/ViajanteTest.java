package algestudiante.p6;

import java.util.Arrays;

public class ViajanteTest {

	public static void main(String[] args) {
		
			int[][] grafoCaminos=  {{0, 10, 20, 14 },
									{11, 0, 19, 12 },
									{13, 18, 0, 20 },
									{12, 14, 11, 0 }};
			int origen= 0;
			int[] solucion= {0, 1, 3, 2, 0};
			int distanciaOptima= 46;

			ViajanteBK viajante= new ViajanteBK(grafoCaminos);
			viajante.calcularCiclo(origen);
			
			System.out.println("Distanza minima " + viajante.getMejorDistancia() + "  " + " vettore Distanze " +Arrays.toString(viajante.getMejorSolucion()));
			
			
//			TSPBacktracking backtracking = new TSPBacktracking(grafoCaminos);
//			
//			System.out.println("Distanza minima " + backtracking.solve() + "  " + " vettore Distanze " +Arrays.toString(backtracking.getBestPath()));
//			
			
	}
	
//	public static void main(String[] args) {
//		
//		int[][] grafoCaminos=  {{0, 10, 20, 14 },
//								{11, 0, 19, 12 },
//								{13, 18, 0, 20 },
//								{12, 14, 11, 0 }};
//		int origen= 0;
//		int[] solucion= {0, 1, 3, 2, 0};
//		int distanciaOptima= 46;
//		
//		ViajanteBK viajante= new ViajanteBK(grafoCaminos);
//		viajante.calcularCiclo(origen);
//		
//		System.out.println("Distanza minima " + viajante.getMejorDistancia() + "  " + " vettore Distanze " +Arrays.toString(viajante.getMejorSolucion()));
//		
//
//		
//		assertEquals(viajante.getMejorDistancia(), distanciaOptima);
//		assertArrayEquals(viajante.getMejorSolucion(), solucion);
//}

}
