package algestudiante.p32;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class SkylineProblem {
	
	Skyline skyline = null;
	List<Building> listBuildings = new ArrayList<Building>();
	List<KeyPoint> listKeyPoints = new ArrayList<KeyPoint>();
	
	/**
	 * Creates a solution from a text file
	 * @param fileName the name of the file to be processed with the input data
	 */
	public SkylineProblem(String fileName) {
		
		int left = 0 ; 
		int right = 0 ;
		int height = 0;

		
		try( Scanner input = new Scanner(new File (fileName))) {
			
			int j = 0 ; 
            while (input.hasNext()) {
            	
            	if( j == 0 ) {
            		left = input.nextInt();
            		j++;
            		
            	}else if ( j == 1 ) {
            		right = input.nextInt();
            		j++;
 
            	}
            	
            	
            	if ( j == 2) {
            		height = input.nextInt();
            		
            		listBuildings.add(new Building(left, right , height));
          
            		j = 0 ;
            	}	
   
            	
            	

            }
            
		}catch (IOException | NoSuchElementException | IllegalStateException e){
            
            
            System.out.println("File not Found --> error message " + e.getMessage() +"\n" );
            e.printStackTrace();

        }
		
	}
	
	/**
	 * Creates a random solution with a given number of buildings
	 * @param nBuildings the number of desired buildings in the skyline
	 */
	@SuppressWarnings("unused")
	public SkylineProblem(int nBuildings) {
		int positions = 2*nBuildings; //the number of positions in the skyline is proportional to the number of buildings
		for (int i = 0; i < nBuildings; i++) {
			int left = new Random().nextInt(positions-5); //should leave some positions to place the building
			int right = left + 1 + new Random().nextInt(5); //should be a little bigger than left to get a valid position
			int height = new Random().nextInt(90) + 10; //between 10 and 99 meters
			//do something with the new randomly created building
		}
	}
	
	/**
	 * Prints the buildings' information given to the problem
	 */
	public void printBuildings() {
		for ( Building building : listBuildings) {
			System.out.println(building + " ");
		}
	}
	
	/**
	 * Solves the problem using brute force (without thinking too much)
	 * Complexity is going to be polynomial
	 */
	public void solveBruteForce() {
		boolean flag = false ;

		for ( Building building : listBuildings) {
			
			
			if( !flag ) {skyline = new Skyline( building ); flag = true;}
			else skyline = new Skyline ( skyline , new Skyline( building ));
			
		}
	}
	
	/**
	 * Solves the problem using divide and conquer (thinking a little bit)
	 * Complexity and times are going to be much better
	 */
	public void solveDivideAndConquer() {
		
		Collections.sort( listBuildings );
		
		//skyline = buildSkyline( listBuildings);
		
		skyline = buildSkyline(listBuildings, 0, listBuildings.size() - 1, 0);
	
	}
	
	private Skyline buildSkyline(List<Building> buildings, int start, int end, int level) {
	    if (end == start) {
	        return new Skyline(buildings.get(start));
	    }
	    if (/*level >= 1000 || */end < start) {
	        return null;
	    }
	    int mid = start + (end - start) / 2;
	    Skyline left = buildSkyline(buildings, start, mid, level + 1);
	    Skyline right = buildSkyline(buildings, mid + 1, end, level + 1);
	    return new Skyline(left, right);
	}

	/*
	private Skyline buildSkyline(List<Building> buildings) {
		
	    if (buildings.size() == 1) {
	        return new Skyline(buildings.get(0));
	    }
	    
	    int mid = buildings.size() / 2;
	    List<Building> leftBuildings = buildings.subList(0, mid);
	    List<Building> rightBuildings = buildings.subList(mid, buildings.size());
	    Skyline leftSkyline = buildSkyline(leftBuildings);
	    Skyline rightSkyline = buildSkyline(rightBuildings);
	    return new Skyline(leftSkyline, rightSkyline);
	}*/
	
	/**
	 * Prints the final solution (the key points for the generated skyline)
	 */
	public void printSolution() {

		List<KeyPoint> solution = getSolution();
		
		for( KeyPoint keypoint : solution ) {
			System.out.println(keypoint.x + " "+ keypoint.y);
		}
		
		System.out.println();
		System.out.println();
	}
	
	/**
	 * Returns the solution for the problem
	 * @return the list of key points for the generated skyline
	 */
	public List<KeyPoint> getSolution() {
		List<KeyPoint> solution = new ArrayList<KeyPoint>();
		
		int lastHeight = -1 ; 
		
		for( int i = skyline.getLeftSide() ; i < skyline.getRightSide() ; i++) {
			//System.out.println(skyline.getHeightInPosition(i));
			
			if(lastHeight != skyline.getHeightInPosition(i)) {
				
				lastHeight = skyline.getHeightInPosition(i);
				solution.add( new KeyPoint(i,lastHeight));
			}
			
			
		}
		
		solution.add( new KeyPoint(skyline.getRightSide(),0));
		
		return solution;
	}
	

}
