package algestudiante.p0;
import java.util.NoSuchElementException;
import java.util.Random;
import java.io.*;
import java.util.Scanner;


public class MatrizOperaciones {

    private int dimensionMatrix = 0;
    private int [][] myMatrix;
    
    //random matrix 
    public MatrizOperaciones  (int n , int min , int max ) {


        if( n > 0  && min <= max ){
            dimensionMatrix = n;
            myMatrix = new int[dimensionMatrix][dimensionMatrix];
            Random rand = new Random( );

            for ( int i = 0 ; i< dimensionMatrix; i++ ){
                for ( int j = 0 ; j< dimensionMatrix ; j++ ){
                    
                    //RANGE  min = 7 max = 10 --> rand( 3 ) 
                    //so the random num can be in the range 0 to 2 
                    //if we add the min the range become 7 to 10 
                    myMatrix[i][j] = rand.nextInt(max-min) + min;
                }
            }
        }else{
            
            System.out.println("The matrix must have a n > 0 and the min value minimum than tha max value!!!");
            System.out.println("Setted a default matrix with n = 0");
            myMatrix = new int[dimensionMatrix][dimensionMatrix];
        }
    }

        
    public int getTam ( ){

        // return myMatrix.length;

        return dimensionMatrix;
    }

    public void escribir( ){
        
        if( dimensionMatrix == 0 ) { 
            System.out.println("Empty matrix");
            return;
        }


        System.out.println("Printing the matrix with dimension of " + dimensionMatrix);
        
        for ( int i = 0 ; i< dimensionMatrix; i ++){
            for ( int j = 0; j <dimensionMatrix; j++){
                System.out.printf("%d   ",myMatrix[i][j] );
            }
            System.out.println();
        }
    }


    //file matrix
    public MatrizOperaciones ( String fileName ){

        try( Scanner input = new Scanner(new File (fileName))) {

            
            if( input.hasNext() ) {
                dimensionMatrix = input.nextInt();
            }

            if( dimensionMatrix <= 0 ){

                System.out.println("The matrix must have a n > 0 and the min value minimum than tha max value!!!");
                System.out.println("Setted a default matrix with n = 0");
                myMatrix = new int[dimensionMatrix][];

                
            }else{

                int i = 0 , j = 0 ;
                myMatrix = new int [dimensionMatrix][dimensionMatrix];
        
                while (input.hasNext()) {

                    myMatrix[i][j] = input.nextInt();
                    j++;
    
                    if( j == dimensionMatrix  ){
                        i++;
                        j = 0;
                    }
            
                }

            }


        }catch (IOException | NoSuchElementException | IllegalStateException e){
            
            myMatrix = new int[dimensionMatrix][];
            System.out.println("File not Found --> error message " + e.getMessage() +"\n" );
            e.printStackTrace();

        }
        
        
    }
    
    public int sumarDiagonal1 ( ) {
    	
    	int sum = 0 ; 
    	
    	for( int i = 0 ; i < dimensionMatrix ; i++ ) {
    		for ( int j = 0 ; j < dimensionMatrix ; j++ ) {
    			
    			if( i == j ) sum += myMatrix[i] [j];
    		}
    	}
    	
    	return sum;
    }
    
    public int sumarDiagonal2 ( ) {
    	int sum = 0; 
    	
    	for (int i = 0 ; i < dimensionMatrix ; i++ ) {
    		sum += myMatrix [i][i];
    	}
    	
    	return sum;
    }
    
    
    public void recorrerCamino ( int i , int j ) {
    	
    	int myValue = 0 ;
    	
    	while ( myMatrix[i][j] != -1 ) {
    		
    		myValue = myMatrix[i][j];
    		
    		switch ( myValue ) {
    		
    			case 1 : 
    				myMatrix[i][j] = -1;
    				i -= 1;
    			break;
    			
    			case 2 : 
    				myMatrix[i][j] = -1;
    				j += 1;
    			break;
    			
    			case 3 : 
    				myMatrix[i][j] = -1;
    				i += 1;
    			break;
    			
    			case 4 : 
    				myMatrix[i][j] = -1;
    				j -= 1;
    			break;
    		}
    		
    		if( j < 0 || j >= dimensionMatrix || i < 0 || i >= dimensionMatrix ) {
    			
    			return;
    		}
    		
    	}
    	
    }
    
}
