package algestudiante.p2 ;

import algestudiante.p2.Vector;


public class Burbuja extends Vector
{
	public Burbuja(int nElementos) {
		super(nElementos);
	}

	/**
	 * Ordenación por el método de Burbuja
	 */
	@Override
	public void ordenar() {

	    
	    for (int i = 0; i < super.elements.length - 1; i++)
	        for (int j = 0; j < super.elements.length - i - 1 ; j++)
	            if (super.elements[j] > super.elements[j + 1]) {
	                // swap
	                int temp = super.elements[j];
	                super.elements[j] = super.elements[j + 1];
	                super.elements[j + 1] = temp;
	            }
	}  

	@Override
	public String getNombre() {
		return "Burbuja";
	}  
} 