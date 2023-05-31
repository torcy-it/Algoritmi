// PROBLEMA 1: ASIGNACION n TRABAJADORES-n TAREAS
// RESUELTO POR RAMIFICA Y PODA

package algestudiante.p7;

import algestudiante.p7.RamificaYPoda;

/**
 * Clase principal para el problema de Asignaci�n de agentes - tareas
 * Herada de RamificaYPoda 
 */
class Asignacion extends RamificaYPoda 
{	

	public static void main(String[] args) 
	{
		System.out.println("Problema de Agentes - tareas /// Ramificaci�n y poda");
		
		// Creamos una instancia para resolver el problema
		Asignacion problemaAsigna = new Asignacion(); 

		// Ejecutamos el m�todo que va recorriendo el espacio de soluciones con ramifica y poda
		problemaAsigna.ramificaYPoda(problemaAsigna.getNodoRaiz()); 
		
		// Soluci�n final
		System.out.println("Solucion optima del problema $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(problemaAsigna.mejorSolucion);
		

		if (RamificaYPoda.TRAZA)
			problemaAsigna.mostrarTrazaSolucion(); 
	}


	/**
	 * Constructor crea el estaod inicial para iniciar el problema
	 */
	public Asignacion() 
	{
		super(false);	// no hay estados repetidos
		
		nodoRaiz = new EstadoAsigna(); //costes iniciales
	}

}

