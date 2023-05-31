package algestudiante.p5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IslandsPath {
	private final static int MAX_INF = Integer.MAX_VALUE;  //to represent the value of infinity
	private final static int MIN_INF = Integer.MIN_VALUE; //to represent the value of -infinity
	private int numIslands;	//number of islands (nodes) of the graph matrice iniziale dove c'è il peso 
	private int[][] W;	//matrix with the widths of the bridges
	//support arrays to calculate the widths (analogous to Floyd)
	private int[][] C; //COST MATRIX: stores the maximum width
	private int[][] P; //PATH MATRIX: stores the best path
	private ArrayList<String> paths; //to store the different solutions
	
	public IslandsPath (int n) {
		paths = new ArrayList<String> ();
		numIslands = n; 
		
		W = new int [n][n];
		C= new int [n][n];
		P = new int [n][n];
		
		for( int i = 0 ; i < numIslands; i++ ) {
			for ( int j = 0 ; j < numIslands; j++ ) {
				W[i][j] = ran( 2, 10 );
				
			}
		}
		for( int i = 0 ; i< numIslands ; i++ ) {
			for( int j = 0 ; j < numIslands; j++ ) {
				C[i][j] = W[i][j];
				P[i][j] = MIN_INF;
			}
		}
	}
	
	private int ran(int min , int max ) {
		return ((int) (Math.random()*max)+min);
	}
	/**
	 * Create the arrays of the graph and initialize them
	 * It also created the arrays to do the calculations
	 * @param file File with the data
	 */
	public IslandsPath(String file) {
		loadData(file); //load from the file the islands and bridges
		paths = new ArrayList<String>();
		
		

		//we create the support arrays
		C = new int[numIslands][numIslands];
		P = new int[numIslands][numIslands];
		
		for (int i = 0; i<numIslands; i++) {
			for (int j = 0; j<numIslands; j++) {
				C[i][j] = W[i][j];
				P[i][j] = MIN_INF;
			}
		}	
		
		//calculateMaximumWidths();
	}
	
	/**
	 * Reads the initial data from a text file and creates an object to deal with the problem
	 */
	private void loadData(String file) {
		BufferedReader reader = null;
		String line;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			
			//first line with the number of islands
			line = reader.readLine();
			numIslands = Integer.parseInt(line);
			
			//creates the array of widths for the number of islands
			W = new int[numIslands][numIslands];
			for (int i = 0; i<numIslands; i++)
				for (int j = 0; j<numIslands; j++)
					if (i != j)
						W[i][j]= MIN_INF;	//there is no bridge
					else
						W[i][j]= MAX_INF;	//there is no limit of width on the island itself

			//reads the rest of the lines with the bridges between the islands
			while (reader.ready()) {
				line = reader.readLine();
				String[] parts = line.split(" ");
				int i = Integer.parseInt(parts[0]);
				int j = Integer.parseInt(parts[2]);
				int width = Integer.parseInt(parts[3]);
				String edge = parts[1];
				if (edge.equals("--")) {
					W[i][j] = width;
					W[j][i] = width;
				}
				else if (edge.equals("->")) {
					W[i][j] = width;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Calculates the maximum width path between islands (nodes)
	 * (Analogous to Floyd, changing the conditions for the best way)
	 */
	public void calculateMaximumWidths() {
		int k , i , j;
		
        for (k = 0; k < numIslands; k++)         
            for (i = 0; i < numIslands; i++)
                for (j = 0; j < numIslands; j++) {
                	//System.out.print( C[i][k] +" "+ C[k][j] + " > " + C[i][j] +" = " + Math.min( C[i][k] ,  C[k][j] ) );
                    if ( Math.min( C[i][k] , C[k][j] ) > C[i][j] ) {
                    	 C[i][j] = Math.min( C[i][k] ,  C[k][j] ) ;
                    	 P[i][j] = k;
                    	 
                    	 //System.out.print(" AO?");
                    
                    } 
                    //System.out.println();
                }
                    
                   

         /*
        
        for (i = 0; i < numIslands; i++) {
            for (j = 0; j < numIslands; j++) {
            	System.out.print( C[i][j]+ " ");
       
            }
            System.out.println();
        } System.out.println();System.out.println();
        
        for (i = 0; i < numIslands; i++) {
            for (j = 0; j < numIslands; j++) {
            	System.out.print( P[i][j]+ " ");
       
            }
            System.out.println();
        }  
        
        System.out.println();
        System.out.println();
        for (i = 0; i < numIslands; i++) {
            for (j = 0; j < numIslands; j++) {
            	System.out.print( W[i][j]+ " ");
       
            }
            System.out.println();
        }
        System.out.println();System.out.println();
       */
	}	

	/****** Methods for printing final and intermediate data *************/
	/**
	 * Prints the widths matrix
	 */
	public String toString() {
		return printMatrix(W);
	}
	
	/**
	 * Converts the given array to n nodes in a printable string
	 * @param matrix
	 * @return 
	 */
	public String printMatrix(int[][] matrix) {
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numIslands; i++) {
			for (int j = 0; j < numIslands; j++)
				if (matrix[i][j] == MAX_INF) sb.append("* ");
				else if (matrix[i][j] == MIN_INF) sb.append("- ");
				else sb.append(matrix[i][j]+" ");
			sb.append("\n");
		}	
		return sb.toString();	
	}
	
	public void printCostsMatrix() {
		System.out.println(printMatrix(C));
	}
	
	public void printPathsMatrix() {
		System.out.println(printMatrix(P));
	}	
	
	/**
	 * Prints all paths found
	 */
	public void generatePaths() {
		
		String unCamino = "";
		
		for ( int i = 0 ; i <numIslands; i++ )
			for ( int j = 0 ; j <numIslands; j++ ) {
				if( i != j && C[i][j] != MIN_INF  ) {
					unCamino = i + getCamino( i, j)+ j;
					paths.add(unCamino);
				}
			}
		
	}
	
	public String getCamino( int i , int j ) {


		if( P[i][j] == MIN_INF  )
			return " -> ";
		else
			return getCamino(i, P[i][j]) + P[i][j] +  getCamino(P[i][j],  j);

			
	}
	/*
	public void tracePath( int i , int j ) {
		int c = P[i][j];
		
		if( c < 0 ) return ;
		else {
			tracePath(i,c);
			path.append(c+"->");
			tracePath(c,j);
		}

	}*/
	/*
	trayetoria ( int i , int j , strin camino)
	int c = p[i][j]
			if( c>= 0 )
			trayetoria(i,c,camino)
			camino,append(c+"----");
			trayetoria(c,j,camino);
	*/
	public ArrayList<String> getPaths() {
		return paths;
	}
	
	
	
}
