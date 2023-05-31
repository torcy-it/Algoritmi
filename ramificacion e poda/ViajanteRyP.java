// PROBLEMA 1: Viajante de comercio
// RESUELTO POR RAMIFICA Y PODA

package algestudiante.p7;

import java.util.ArrayList;

import algestudiante.p7.RamificaYPoda;

/**
 * Clase principal para el problema de Viajante
 * Herada de RamificaYPoda
 */
class ViajanteRyP extends RamificaYPoda {

	public static void main(String[] args) {
		System.out.println("Problema de viajante de comercio /// Ramificacion y poda");

		int[][] caminos = { { 0, 10, 20, 14 }, { 11, 0, 19, 12 }, { 13, 18, 0, 20 }, { 12, 14, 11, 0 } };
		// cargaMatrizCamino("grafo04.txt)

		System.out.println("Estado inicial");

		EstadoViajante estadoInicial = new EstadoViajante(caminos);
		System.out.println(estadoInicial);

		ArrayList<Estado> hijos = estadoInicial.expandir();
		// for imprimir hijos

		// Creamos una instancia para resolver el problema
		ViajanteRyP problemaViajante = new ViajanteRyP(caminos);

		// Ejecutamos el m�todo que va recorriendo el espacio de soluciones con ramifica
		// y poda
		problemaViajante.ramificaYPoda(problemaViajante.getNodoRaiz());

		// Solucion final
		System.out.println("Solucion optima del problema $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(problemaViajante.mejorSolucion);

		if (RamificaYPoda.TRAZA)
			problemaViajante.mostrarTrazaSolucion();
	}
	
	

	/**
	 * Constructor crea el estaod inicial para iniciar el problema
	 */
	public ViajanteRyP(int[][] caminos) {
		super(false); // no hay estados repetidos

		nodoRaiz = new EstadoViajante(caminos); // costes iniciales
	}

}
