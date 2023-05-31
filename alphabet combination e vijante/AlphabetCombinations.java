package algestudiante.p6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

//public class AlphabetCombinations {
//    public static void main(String[] args) {
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//        List<String> combinations = new ArrayList<>();
//
//        for (int i = 1; i <= alphabet.length(); i++) {
//            generateCombinations(alphabet, i, 0, new StringBuilder(), combinations);
//        }
//        System.out.println(combinations);
//    }
//
//    private static void generateCombinations(String alphabet, int length, int index, StringBuilder current, List<String> combinations) {
//        if (current.length() == length) {
//            combinations.add(current.toString());
//            return;
//        }
//
//        for (int i = index; i < alphabet.length(); i++) {
//            current.append(alphabet.charAt(i));
//            generateCombinations(alphabet, length, i + 1, current, combinations);
//            current.deleteCharAt(current.length() - 1);
//        }
//    }
//}
//public class AlphabetCombinations {
//    public static void main(String[] args) {
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//
//        for (int i = 3; i <= 21 && i <= alphabet.length(); i++) {
//            generateCombinations(alphabet, i, 0, new StringBuilder());
//        }
//    }
//
//    private static void generateCombinations(String alphabet, int length, int index, StringBuilder current) {
//        if (current.length() == length) {
//            System.out.println(current.toString());
//            return;
//        }
//
//        for (int i = index; i < alphabet.length(); i++) {
//            if (current.length() >= 2 || i < 3) { // Controlla che le prime tre lettere siano presenti
//                current.append(alphabet.charAt(i));
//                generateCombinations(alphabet, length, i + 1, current);
//                current.deleteCharAt(current.length() - 1);
//            }
//        }
//    }
//}


//public class AlphabetCombinations {
//    public static void main(String[] args) {
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//        int minLen = 3;
//        
//        for (int len = minLen; len <= alphabet.length(); len++) {
//            generateCombinations(alphabet, len, 0, new StringBuilder());
//        }
//    }
//
//    private static void generateCombinations(String alphabet, int length, int index, StringBuilder current) {
//        if (current.length() == length) {
//            System.out.println(current.toString());
//            return;
//        }
//
//        for (int i = index; i < alphabet.length(); i++) {
//            current.append(alphabet.charAt(i));
//            generateCombinations(alphabet, length, i + 1, current);
//            current.deleteCharAt(current.length() - 1);
//        }
//    }
//}


//public class AlphabetCombinations {
//    
//    public static void main(String[] args) {
//        char startLetter = 'a'; // lettera di inizio
//        int minLength = 3; // lunghezza minima della stringa
//        
//        ArrayList<String> combinations = generateCombinations(startLetter, minLength);
//        
//        // stampa tutte le combinazioni
//        for (String combination : combinations) {
//            System.out.println(combination);
//        }
//    }
//    
//    public static ArrayList<String> generateCombinations(char startLetter, int minLength) {
//        ArrayList<String> combinations = new ArrayList<String>();
//        generateCombinationsHelper("", startLetter, minLength, combinations);
//        return combinations;
//    }
//    
//    private static void generateCombinationsHelper(String current, char startLetter, int minLength, ArrayList<String> combinations) {
//        if (current.length() >= minLength) {
//            combinations.add(current);
//        } else {
//            for (char c = startLetter; c <= 'z'; c++) {
//                generateCombinationsHelper(current + c, startLetter, minLength, combinations);
//            }
//        }
//    }
//    
//}

import java.util.Scanner;

public class AlphabetCombinations {

    private static final int MIN_LETTERS = 3;
    private static ArrayList<String> listOfMd5 = new ArrayList<String>();
    private static ArrayList<String> claves = new ArrayList<String>();
    private static boolean flag = false; 
    
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
        
    	String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    	revientaClavesFromFile("C:\\Users\\ASUS\\OneDrive\\Desktop\\workspaceAlgo\\alg_TorcicolloAdolfoUO299007\\src\\main\\java\\algestudiante\\p6\\herenciaEnvenenadaMD5.txt" );
    	
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
    	
    	input.close();
    }/*
    if (currentLength == 0) {
        
    	if ( EjemploMD5.getMD5(currentCombination).equals(listOfMd5.get(0))) { 
    		this.claves.add(currentCombination);
    		//System.out.println("DAJE ROMA ");
    	}
        return;
    }
    for (int i = 0; i < alphabet.length; i++) {
        generateCombinations(alphabet, currentCombination + alphabet[i], currentLength - 1);
    }*/

    private static void generateAllCombinations(String[] alphabet, String currentCombination, int currentLength, String md5) {
        
    	
    	if( currentLength == 0 ) {
    		
    		//System.out.println (md5 + "  "+ currentCombination  );
 
    	
	    	if ( EjemploMD5.getMD5(currentCombination).equals(md5) ) {
	           
	        		claves.add(currentCombination);
	        		System.out.println("DAJE ROMA " );
	        		
	        		flag = true;
	        	
	    	}
	    	
            return;
        }
    	
        for (int i = 0; i < alphabet.length; i++) {
            generateAllCombinations(alphabet, currentCombination + alphabet[i], currentLength - 1, md5);
        }
    }


	private static void revientaClavesFromFile ( String fileName ){
		
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                listOfMd5.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}

/*
public class AlphabetCombinations {
    
    public static void main(String[] args) {
        char startLetter = 'a'; // lettera di inizio
        int maxLength = 26; // lunghezza massima della stringa
        
        for (int i = 3; i <= maxLength; i++) {
        	
            ArrayList<String> combinations = generateCombinations(startLetter, i);
            
            // stampa tutte le combinazioni
            System.out.println("Combinazioni di lunghezza " + i + ":");
            for (String combination : combinations) {
            	
                System.out.println(combination);
            }
            
            System.out.println();
        }
    }
    
    public static ArrayList<String> generateCombinations(char startLetter, int length) {
        ArrayList<String> combinations = new ArrayList<String>();
        generateCombinationsHelper("", startLetter, length, combinations);
        return combinations;
    }
    
    private static void generateCombinationsHelper(String current, char startLetter, int length, ArrayList<String> combinations) {
        if (current.length() >= length) {
            combinations.add(current);
        } else {
            for (char c = startLetter; c <= 'z'; c++) {
                generateCombinationsHelper(current + c, startLetter, length, combinations);
            }
        }
    }
    
}

*/

//public class AlphabetCombinations {
//    public static void main(String[] args) {
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//
//        for (int i = 1; i <= alphabet.length(); i++) {
//            generateCombinations(alphabet, i, 0, new StringBuilder());
//        }
//    }
//
//    private static void generateCombinations(String alphabet, int length, int index, StringBuilder current) {
//        if (current.length() == length) {
//            System.out.println(current.toString());
//            return;
//        }
//
//        for (int i = index; i < alphabet.length(); i++) {
//            current.append(alphabet.charAt(i));
//            generateCombinations(alphabet, length, i + 1, current);
//            current.deleteCharAt(current.length() - 1);
//        }
//    }
//}