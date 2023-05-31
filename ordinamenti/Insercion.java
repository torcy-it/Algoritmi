package algestudiante.p2 ;

import algestudiante.p2.Vector;

/** Este programa sirve para ordenar n elementos
	con un algoritmo de los "malos" (cuadrático)· 
	Es la INSERCIÓN DIRECTA
 */
public class Insercion extends Vector
{
	
	public Insercion(int nElementos) {
		super(nElementos);
	}

	/**
	 * Ordenación por inserción directa
	 */
	@Override
	public void ordenar() {
		  

	    for (int i = 1; i < super.elements.length; i++) {
		      int key = super.elements[i];
		      int j = i - 1;
	
		      // Compare key with each element on the left of it until an element smaller than
		      // it is found.
		      while (j >= 0 && key < super.elements[j]) {
			        super.elements[j + 1] = super.elements[j];
			        j--;
		      }

	      // Place key at after the element just smaller than it.
	      super.elements[j + 1] = key;
	    }
	} 

	@Override
	public String getNombre() {
		return "Inserción directa";
	} 
} 
