package algestudiante.p6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ViajanteModTest6 {

	@Test
	public void testGrafo04() {
		int[][] grafoCaminos=  {{0, 10, 20, 14 },
								{11, 0, 19, 12 },
								{13, 18, 0, 20 },
								{12, 14, 11, 0 }};
		int origen= 0;
		int precede= 2;
		int sigue= 1;
		int[] solucionEsperada= {0, 3, 2, 1, 0};
		int distanciaOptima= 54;

		
		ViajanteMod viajante= new ViajanteMod(grafoCaminos);
		viajante.calcularCiclo(origen, precede, sigue);
		
		int[] solucion= viajante.getMejorSolucion();
		
		viajante.escribirSolucion(solucion);

		assertEquals(viajante.getMejorDistancia(), distanciaOptima);
		assertArrayEquals(viajante.getMejorSolucion(), solucionEsperada);

	}

	@Test
	public void testGrafo07() {
		int[][] grafoCaminos=  {{0, 43, 78, 11, 86, 78, 45},
								{40, 0, 80, 81, 75, 15, 25},
								{83, 14, 0, 34, 64, 41, 71},
								{65, 44, 16, 0, 89, 86, 98},
								{35, 72, 23, 18, 0, 98, 47},
								{44, 40, 99, 70, 17, 0, 35},
								{45, 50, 13, 12, 15, 70, 0}};
		int origen= 0;
		int precede= 2;
		int sigue= 1;
		int distanciaOptima = 141;
		
		ViajanteMod viajante= new ViajanteMod(grafoCaminos);
		viajante.calcularCiclo(origen, precede, sigue);
		
		int[] solucion= viajante.getMejorSolucion();
		
		viajante.escribirSolucion(solucion);
		
		assertEquals(viajante.getMejorDistancia(), distanciaOptima);
//		assertArrayEquals(viajante.getMejorSolucion(), solucionEsperada);
	}
	
	@Test
	public void testGrafo10() {
		int[][] grafoCaminos=  {{0, 99, 72, 49, 39, 26, 51, 24, 76, 90},
								{18, 0, 33, 28, 44, 98, 80, 42, 47, 56},
								{98, 15, 0, 40, 29, 75, 64, 90, 26, 35},
								{52, 74, 80, 0, 87, 49, 37, 21, 42, 80},
								{71, 80, 74, 28, 0, 44, 40, 79, 36, 84},
								{15, 24, 66, 28, 70, 0, 89, 69, 70, 77},
								{90, 91, 41, 26, 68, 78, 0, 36, 79, 66},
								{84, 17, 81, 39, 91, 66, 83, 0, 95, 39},
								{13, 42, 30, 69, 23, 55, 10, 41, 0, 97},
								{18, 58, 55, 77, 94, 43, 63, 97, 27, 0}};
		int origen= 0;
		int precede= 2;
		int sigue= 1;
		int distanciaOptima = 278;
		
		ViajanteMod viajante= new ViajanteMod(grafoCaminos);
		viajante.calcularCiclo(origen, precede, sigue);
		
		int[] solucion= viajante.getMejorSolucion();
		
		viajante.escribirSolucion(solucion);
		
		
		
		assertEquals(viajante.getMejorDistancia(), distanciaOptima);
//		assertArrayEquals(viajante.getMejorSolucion(), solucionEsperada);
	}
}
