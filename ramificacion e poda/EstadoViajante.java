package algestudiante.p7;

import java.util.ArrayList;
import java.util.Arrays;

import algestudiante.p7.Estado;
import algestudiante.p7.RamificaYPoda;

/**
 * Estado Viajante
 * Hereda de la clase Estado
 */


public class EstadoViajante extends Estado 
{
	// Datos comunes a todos los estados, por eso los declaramos "static"
	private static int n;				// Tamano del problema, num de ciudades
	private static int[][] caminos;		// matriz de caminos

	// Estado
	private int[] solParcial;				// secuencia de ciudades
	private boolean[] visitadas;	// ciudadas ya visitadas

	/**
	 * Constructor para crear el estado inicial,
	 * Establecemos los datos y condiciones iniciales del problema
	 */
	public EstadoViajante(int [][] caminos) {
		super();
		
		// Condiciones iniciales
		n= caminos.length;		// n�mero de agentes y tareas
		// matriz de costes
		
		this.caminos = caminos;
		/*
		caminos[0][0]=58;caminos[0][1]=67;caminos[0][2]=58;caminos[0][3]=65;
		caminos[1][0]=60;caminos[1][1]=68;caminos[1][2]=65;caminos[1][3]=55;
		caminos[2][0]=62;caminos[2][1]=70;caminos[2][2]=67;caminos[2][3]=56;
		caminos[3][0]=56;caminos[3][1]=68;caminos[3][2]=60;caminos[3][3]=54; 
*/
		/**/if (RamificaYPoda.TRAZA)
			imprimirCostes();

		// Inicializa variables de cada estado
		solParcial = new int[n];
		for (int i=0;i<solParcial.length;i++)
			solParcial[i] = -1;//sin asignaciones inicialmente
		
		visitadas=new boolean[solParcial.length];
		
		//aggiungere del codice per lo stato iniziale
		//aggiungere lo 0 
		
		solParcial[profundidad] = 0;
		visitadas[0] = true;
		profundidad++;
	}
	private int ran(int min , int max ) {
		return ((int) (Math.random()*max)+min);
	}
	
	public EstadoViajante(int n) {
		super();
		
		// Condiciones iniciales
			// n�mero de agentes y tareas
		// matriz de costes
		
		
		int [][] caminos =   new int [n][n];
    	
    	for (int i = 0; i < n; i++) {
    	    for (int j = 0; j < n; j++) {
    	        if (i == j) {
    	        	caminos[i][j] = 0;
    	        } else {
    	        	caminos[i][j] = ran(10,99);
    	        }
    	    }
    	}
		this.caminos = caminos;
		/*
		caminos[0][0]=58;caminos[0][1]=67;caminos[0][2]=58;caminos[0][3]=65;
		caminos[1][0]=60;caminos[1][1]=68;caminos[1][2]=65;caminos[1][3]=55;
		caminos[2][0]=62;caminos[2][1]=70;caminos[2][2]=67;caminos[2][3]=56;
		caminos[3][0]=56;caminos[3][1]=68;caminos[3][2]=60;caminos[3][3]=54; 
*/
		/**/if (RamificaYPoda.TRAZA)
			imprimirCostes();

		// Inicializa variables de cada estado
		solParcial = new int[n];
		for (int i=0;i<solParcial.length;i++)
			solParcial[i] = -1;//sin asignaciones inicialmente
		
		visitadas=new boolean[solParcial.length];
		
		//aggiungere del codice per lo stato iniziale
		//aggiungere lo 0 
		solParcial[profundidad] = 0;
		visitadas[0] = true;
		profundidad++;
		//calcularValorHeuristico();
	}

	/**
	 * Constructor para crear un estado a partir del padre
	 */
	public EstadoViajante(EstadoViajante padre,int j) {
		super();
		// copiamos toda la informaci�n del padre		
		solParcial= Arrays.copyOf(padre.solParcial,n);
		visitadas= Arrays.copyOf(padre.visitadas,n);
		profundidad= padre.profundidad;
		idPadre= padre.getId();
		
		// modificamos lo correspondiente a este hijo
		solParcial[profundidad] =j;		// profundidad se corresponde con el primer agente sin asignar
		visitadas[j]= true;	// marcamos la tarea como asignada
		profundidad++;
		calcularValorHeuristico();
		
		// UNIFICA LOS DOS �LTIMOS NIVELES DEL �RBOL DE ESTADOS
		if (profundidad==n-1)
		{
			int tareaPorAsignar= -1;
			// Busca �ltima tarea por asignar
			for (int k= 0; k<n; k++)
				if (!visitadas[k])
					tareaPorAsignar= k;
			
			solParcial[profundidad] =tareaPorAsignar;		// profundidad se corresponde con el primer agente sin asignar
			visitadas[tareaPorAsignar]= true;	// marcamos la tarea como asignada
			profundidad++;							
			calcularValorHeuristico();
		}

	}

	/**
	 * Calcula el valor del heuristico y lo guarda
	 */
	@Override
	public void calcularValorHeuristico() {
		valorHeuristico = 0;
		
		int []  minVal  = new int [caminos.length];

			
					
		
		for (int i =0 ; i < minVal.length ; i++ )
			minVal[i] = Integer.MAX_VALUE;
		
		for( int i = 0 ; i < caminos.length; i++ ) 
			for ( int j = 0 ; j < caminos.length; j++ ) 
				if( minVal[i] >= caminos[i][j] && i != j) {
					minVal[i] = caminos[i][j];
					//System.out.print(minVal[i]+" ");
				}
		

		
		for( int i = 0 ; i < caminos.length; i++ ) 
			for ( int j = 0 ; j < caminos.length; j++ ) 
					caminos[i][j] -= minVal[i];
		
		for (int i =0 ; i < minVal.length ; i++ ) {
			valorHeuristico += minVal[i];
			minVal[i] = Integer.MAX_VALUE;
		}
		
			
		for( int i = 0 ; i < caminos.length; i++ ) 
			for ( int j = 0 ; j < caminos.length; j++ )
					if( minVal[i] >= caminos[j][i] && i != j)
					minVal[i] = caminos[j][i];
		
		for (int i =0 ; i < minVal.length ; i++ ) 
			valorHeuristico += minVal[i];
		
		super.valorHeuristico = valorHeuristico;
		
		
//		// Suma los costes de los agentes con tarea
//		for (int i= 0; i<profundidad; i++)
//			valorHeuristico+= caminos[i][solParcial[i]];
//		
//		// Suma los m�nimos de lo que resta de columna por cada tarea no asignada
//		for (int j = 0; j<n; j++)
//			if (!visitadas[j])
//				valorHeuristico+= minimoColumna(profundidad,j);
		
	}

	/**
	 * Calcula el valor minimo por columnas
	 * @param profundidad	para saber cuantas tareas est�n ya asignadas
	 * @param j				para saber que tarea se asigna en este paso
	 * @return				valor m�nimo por columnas
	 */
	private int minimoColumna(int profundidad, int j) {
		int minValorColumna=Integer.MAX_VALUE;
		for (int i= profundidad; i<n; i++)
			// calculamos el m�nimo de columnas
			if (caminos[i][j] < minValorColumna)
				minValorColumna= caminos[i][j];
		return minValorColumna;
	}

	@Override
	public ArrayList<Estado> expandir() {
		ArrayList<Estado> listaHijos= new ArrayList<Estado>();

		// Recorre todas las tareas
		for (int j=0; j<n; j++)
			if (!visitadas[j])  // Crea hijo solo para tareas NO asignadas
			{
				Estado estadoHijo= new EstadoViajante(this,j); 
				listaHijos.add(estadoHijo);
				
				if (RamificaYPoda.TRAZA)  // imprimimos estado hijo generado
				{
					System.out.println("Nivel: "+profundidad+" - Hijo: "+j);
					System.out.println(estadoHijo);
				}
			}

		return listaHijos;
	}

	@Override
	public boolean solucion() {
		if (profundidad==n)
			return true;
		else
			return false;
	}
	
	@Override
	public int valorInicialPoda() 
	/* Inicialmente el valor de poda va a ser la menor de la 
   suma de ambas diagonales */
	{
		int diagonal1= 0;
		for (int i=0;i<n;i++)
			diagonal1 += caminos[i][i];
		int diagonal2= 0;
		for (int i=0;i<n;i++)
			diagonal2 += caminos[i][caminos.length-1-i];

		/**/if (RamificaYPoda.TRAZA)	// muestra el valor inicial
		{
			System.out.println("Valor inicial de poda");
			System.out.println("Diagonal 1: "+diagonal1);
			System.out.println("Diagonal 2: "+diagonal2);
			System.out.println("Valor cota de poda: "+(diagonal1<=diagonal2?diagonal1:diagonal2)+"\n");
		}
		
		if (diagonal1<=diagonal2) 
			return diagonal1;
		else 
			return diagonal2;
	}

	/**
	 * Imprime la matriz de costes
	 */
	public void imprimirCostes()
	{
		System.out.println("N�mero de agentes / tareas = "+n);
		System.out.println("Matriz de costes");
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
				System.out.printf("%5d", caminos[i][j]);
			System.out.println();
		}
		System.out.println();

	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer("===============\n");
		for (int i=0; i<solParcial.length; i++) 
		{
			if (solParcial[i] != -1)
				sb.append(solParcial[i]+"->");
			
		}
		sb.append("\n");
		sb.append("Valor heuristico = " + valorHeuristico + "\n");
		sb.append("===============\n");
		return sb.toString();
	}

	public int[] getSolucion() {
		return solParcial;
	}

}
