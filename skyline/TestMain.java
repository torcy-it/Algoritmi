package algestudiante.p32;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestMain {
    
    public static void main ( String args[]){

    	
        File testFile = new File("");
        String currentPath = testFile.getAbsolutePath();
        System.out.println("current path is: " + currentPath);
    	
    	
    	SkylineProblem sk = new SkylineProblem("C:\\Users\\ASUS\\OneDrive\\Desktop\\workspaceAlgo\\alg_TorcicolloAdolfoUO299007\\\\src\\\\main\\\\java\\\\algestudiante\\\\p32\\\\city3.txt");
    	sk.solveBruteForce();
    	
    	sk.printSolution();
    	
    	sk.solveDivideAndConquer();
    	
    	sk.printSolution();


    }
    
	public static Skyline skyLineFile(String fileName) {
		
		Skyline skyline1 = null;
		int left = 0 ; 
		int right = 0 ;
		int height = 0;
		boolean flag = false;
		
		try( Scanner input = new Scanner(new File (fileName))) {
			
			int j = 0 ; 
            while (input.hasNext()) {
            	
            	if( j == 0 ) {
            		left = input.nextInt();
            		//System.out.println("Left " +left);
            		
            	}else if ( j == 1 ) {
            		right = input.nextInt();
            		//System.out.println("Right " +right);
            	}
            	
            	
            	if ( j == 2 && !flag) {
            		height = input.nextInt();
            		//System.out.println("Height " + height);
            		
            		System.out.println("!flag x1 =  " + left + " x2 = " + right +" y = "+ height);
            		skyline1 = new Skyline(new Building(left, right , height));
            		
            		flag = true;
            		j = -1 ;
            		
            	}else if( j == 2 && flag ) {
            		height = input.nextInt();
            		//System.out.println("Height " +height);
            		System.out.println("flag x1 =  " + left + " x2 = " + right +" y = "+ height);
            		skyline1 = new Skyline(skyline1 , new Skyline ( new Building ( left, right , height ) ));
            		//flag = false;
            		j = -1 ;
            				
            	}
            	
            	j++;

            	
            	
        
            }
            
		}catch (IOException | NoSuchElementException | IllegalStateException e){
            
            
            System.out.println("File not Found --> error message " + e.getMessage() +"\n" );
            e.printStackTrace();

        }
		
		return skyline1;
	}

}
