package algestudiante.p6;

import java.util.Arrays;

public class ViajanteMod {

    private int[][] grafoCaminos;
    private boolean[] visitados;
    private int[] solucionActual;
    private int[] mejorSolucion;
    private int mejorDistancia;
    private int distanciaActual;
    private int origen;
    private int[] mejorCaminoActual;
    private boolean flag =false;
    
    public ViajanteMod(int[][] grafoCaminos) {
        this.grafoCaminos = grafoCaminos;
        this.visitados = new boolean[grafoCaminos.length];
        this.solucionActual = new int[grafoCaminos.length];
        this.mejorSolucion = new int[grafoCaminos.length];
        this.mejorDistancia = Integer.MAX_VALUE;
    	this.mejorCaminoActual = new int[grafoCaminos.length];
        this.origen = 0;
    }
    
    /*
     * in teoria devo utilizzare le informazioni che sono int origine e int precede e int sigue 
     * il codice dovrebbe essere lo stesso , ma con piccole modifiche del tipo che se io scelgo un nodo origine 
     * devo sempre iniziare il viaggio per i nodi da quello 
     * 
     * inoltre gli int che sono 'precede e sigue sono delle variabili importanti perchè posso creare infinite combinazioni 
     * anzi devo creare tutte le possibili combinazioni del tipo che il nodo che viene chiamato precede non deve essere mai 
     * scelto dopo il secondo nodo 
     */
    
    public ViajanteMod (int n ) {
    	
    	this.grafoCaminos  =  new int [n][n];
    	
    	for (int i = 0; i < n; i++) {
    	    for (int j = 0; j < n; j++) {
    	        if (i == j) {
    	            grafoCaminos[i][j] = 0;
    	        } else {
    	            grafoCaminos[i][j] = ran(10,99);
    	        }
    	    }
    	}
    	
    	this.mejorCaminoActual = new int[grafoCaminos.length];
        this.visitados = new boolean[grafoCaminos.length];
        this.solucionActual = new int[grafoCaminos.length];
        this.mejorSolucion = new int[grafoCaminos.length];
        this.mejorDistancia = Integer.MAX_VALUE;
        this.origen = 0;
    }

	private int ran(int min , int max ) {
		return ((int) (Math.random()*max)+min);
	}
	
    public void calcularCiclo(int origen, int pre , int next ) {
        this.origen = origen;
        this.distanciaActual = 0;
        
        for (int i = 0; i < visitados.length; i++) {
            visitados[i] = false;
           
        }
        

        visitados[origen] = true;
        solucionActual[0] = origen;
        //calcularCicloRecursivo(1);
        calcularCicloRecursivo(1, pre, next,1);
        
        addOrigenNode ( );
    }

    private void addOrigenNode() {
    	
    	int n = mejorSolucion.length+1;
    
    	
		int[] arraycopy = new int [n];
		for( int i = 0 ; i < n; i++ ) {
			if(i != n-1)
				arraycopy[i] = mejorSolucion[i];
			else
				arraycopy[i] = origen;
		}

    	this.mejorSolucion = new int[arraycopy.length];

    	System.arraycopy(arraycopy, 0, mejorSolucion, 0, arraycopy.length);
    	
    	
	}
    



//	private void calcularCicloRecursivo(int nivel, int prevNode, int nextNode) {
//        if (nivel == grafoCaminos.length) {
//            int distancia = grafoCaminos[solucionActual[nivel - 1]][origen];
//            if (distancia != 0 && solucionActual[1] == prevNode && solucionActual[solucionActual.length-1] == nextNode) {
//                distanciaActual += distancia;
//                if (distanciaActual < mejorDistancia) {
//                    mejorDistancia = distanciaActual;
//                    System.arraycopy(solucionActual, 0, mejorSolucion, 0, solucionActual.length);
//                }
//                distanciaActual -= distancia;
//            }
//        } else {
//            for (int i = 0; i < visitados.length; i++) {
//                if (!visitados[i] && grafoCaminos[solucionActual[nivel - 1]][i] != 0) {
//                    if(nivel==1 && i!=prevNode) continue; // skip if the first node is not the prevNode
//                    if(nivel==grafoCaminos.length-1 && i!=nextNode) continue; // skip if the last node is not the nextNode
//                    
//                    visitados[i] = true;
//                    solucionActual[nivel] = i;
//                    distanciaActual += grafoCaminos[solucionActual[nivel - 1]][i];
//                    calcularCicloRecursivo(nivel + 1, prevNode, nextNode);
//                    distanciaActual -= grafoCaminos[solucionActual[nivel - 1]][i];
//                    visitados[i] = false;
//                }
//            }
//        }
//    }
    private void calcularCicloRecursivo(int nivel, int prevNode, int nextNode, int currentNode) {
    	
        if (nivel == grafoCaminos.length) {
            int distancia = grafoCaminos[currentNode][origen];
            if (distancia != 0 && distanciaActual + distancia < mejorDistancia) {

            	mejorDistancia = distanciaActual + distancia;
                System.arraycopy(solucionActual, 0, mejorSolucion, 0, solucionActual.length);
                for( int i = 0 ; i < solucionActual.length; i++ ) {
                	System.out.print(solucionActual[i] + " ");
                }
                System.out.println();
                
            }
        } else {
            for (int i = 0; i < visitados.length; i++) {
                if (!visitados[i] && grafoCaminos[currentNode][i] != 0) {
                    visitados[i] = true;
                    int tempNode = solucionActual[nivel];
                    solucionActual[nivel] = i;
                    distanciaActual += grafoCaminos[currentNode][i] ;
                    calcularCicloRecursivo(nivel + 1, prevNode, nextNode, i);
                    distanciaActual -= grafoCaminos[currentNode][i];
                    solucionActual[nivel] = tempNode;
                    visitados[i] = false;
                }
            }
        }
    }




    public int getMejorDistancia() {
        return mejorDistancia;
    }

    public int[] getMejorSolucion() {
    	
        return mejorSolucion;
    }

	public void escribirSolucion(int[] solucion) {
		System.out.println();
		for( int i = 0 ; i < solucion.length; i++ )
			System.out.print(solucion[i]+ "  ");
		System.out.println();
		
	}
}



