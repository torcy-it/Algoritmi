package algestudiante.p6;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class RevientaClaves {

	private ArrayList<String> listOfMd5;
	private ArrayList<String> claves;
    private static boolean flag = false; 
    
    private ArrayList<String> tiempo;
	
	
	public RevientaClaves ( String string , boolean isMd5) {
		this.listOfMd5 = new ArrayList<String>();
		this.claves = new ArrayList<String>();
		this.tiempo = new ArrayList<String>();
		
		if( isMd5 ) revientaClavesFromString(string); //metodo per assegnare valori a md5
		else revientaClavesFromFile(string);// metodo per prelevare da file md5 e asseggnarle
	}
	
	private void revientaClavesFromFile ( String fileName ){
		
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        	
            String line;
            while ((line = br.readLine()) != null) 
                listOfMd5.add(line);
            
            
        }catch (IOException e) {
            e.printStackTrace();
        }
        
	}
	
	private void revientaClavesFromString(String md5) {
		
		this.listOfMd5.add(md5);
	}
	

	public ArrayList<String> getTodasClaves ( ) {
		
    	String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    	int indice = 0 ;
    	int length = 3; 
    	
    	while ( indice < listOfMd5.size() ){
    		
    		generateAllCombinations(alphabet, "", length, listOfMd5.get(indice));
    		//System.out.println( listOfMd5.size());
    		
    		if( !flag ) length++;
    		else {
    			flag = false ;
    			indice++; 
    			length = 3;
    		}
    		
    		//input.nextLine();
    	}
    	
    	return claves;
	}
	
	public ArrayList<String> getTodasClavesTiempo ( ) {
		
		//					a,    b,    c,   d,   e,   f,   g,   h,   i,   j,   k,   l,   m,  n,    o,   p,   q,   r,   s,   t,   u,  v,   w,   x,   y,   z.
    	String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    	int indice = 0 ;
    	int length = 3; 
//		long t1, t2;
//		System.out.println("n   \tTiempo");
		
		
    	while ( indice < listOfMd5.size() ){
    		
    		//t1 = System.currentTimeMillis();

    		generateAllCombinations(alphabet, "", length, listOfMd5.get(indice));
    		//System.out.println( listOfMd5.size());
    		
    		if( !flag ) length++;
    		else {
    			
//    			t2 = System.currentTimeMillis();
//    			System.out.println( (indice+1) + "\t" + (t2 - t1));
//    			
    			flag = false ;
    			indice++; 
    			length = 3;
    		}
    		
    		//input.nextLine();
    	}
    	
    	return claves;
	}
	
    private void generateAllCombinations(String[] alphabet, String currentCombination, int currentLength, String md5) {
        
    	
    	if( currentLength == 0 ) {
    		
    		//System.out.println (md5 + "  "+ currentCombination  );
 
    	
	    	if ( EjemploMD5.getMD5(currentCombination).equals(md5) ) {
	           
	        		claves.add(currentCombination);
	        		//System.out.println("DAJE ROMA " );
	        		
	        		flag = true;
	        	
	    	}
	    	
            return;
        }
    	
        for (int i = 0; i < alphabet.length; i++) {
            generateAllCombinations(alphabet, currentCombination + alphabet[i], currentLength - 1, md5);
        }
    }
    
    
	public String getClave( ) {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        generateCombinations(alphabet, "", 3);
        
        if( claves.isEmpty() ) return null;
        else return claves.get(0);
               
	}
	
    private void generateCombinations(String[] alphabet, String currentCombination, int currentLength) {
        if (currentLength == 0) {
            
        	if ( EjemploMD5.getMD5(currentCombination).equals(listOfMd5.get(0))) { 
        		this.claves.add(currentCombination);
        		System.out.println("DAJE ROMA ");
        	}
            return;
        }
        for (int i = 0; i < alphabet.length; i++) {
            generateCombinations(alphabet, currentCombination + alphabet[i], currentLength - 1);
        }
    }


	public ArrayList<String> getArrayMD5() {
		
		return listOfMd5;
	}
}
