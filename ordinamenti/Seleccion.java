package algestudiante.p2;

import algestudiante.p2.Vector;

/** Este programa sirve para ordenar n elementos
	con un algoritmo de los "malos" (cuadrático)·
	es la SELECCION
 */
public class Seleccion extends Vector
{
	public Seleccion(int nElementos) {
		super(nElementos);
	}
	

	/**
	 * Ordenación por selección
	 */
	@Override
	public void ordenar() {

	    for (int i = 0; i < super.elements.length - 1; i++) {
		      int minIndex = i;
	
		      for (int j = i + 1; j < super.elements.length; j++) {
	
			        // To sort in descending order, change > to < in this line.
			        // Select the minimum element in each loop.
			        if (super.elements[j] < super.elements[minIndex]) {
			        	minIndex = j;
			        }
		      }
		      	
		      // put min at the correct position
		      int temp = super.elements[i];
		      super.elements[i] = super.elements[minIndex];
		      super.elements[minIndex] = temp;
	    }
	}  

	@Override
	public String getNombre() {		
		return "Selección";
	}  
} 
