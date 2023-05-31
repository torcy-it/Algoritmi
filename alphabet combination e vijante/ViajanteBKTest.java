package algestudiante.p6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ViajanteBKTest {

	@Test
	public void testGrafo04() {
		int[][] grafoCaminos=  {{0, 10, 20, 14 },
								{11, 0, 19, 12 },
								{13, 18, 0, 20 },
								{12, 14, 11, 0 }};
		int origen= 0;
		int[] solucion= {0, 1, 3, 2, 0};
		int distanciaOptima= 46;
		
		ViajanteBK viajante= new ViajanteBK(grafoCaminos);
		viajante.calcularCiclo(origen);
		
		assertEquals(viajante.getMejorDistancia(), distanciaOptima);
		assertArrayEquals(viajante.getMejorSolucion(), solucion);
 
	}

}
