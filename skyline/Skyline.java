package algestudiante.p32;

import java.util.*;

public class Skyline {
	private Map<Integer, Integer> heightInPosition = new HashMap<Integer, Integer>(); //key = position; value = height; that is, it stores the height in a particular position of the skyline
	private int leftSide; //left side of the skyline (first point of the skyline)
	private int rightSide; //right side of the skyline (last poaint of the skyline)
	//private List<Integer> listEndPoint = new ArrayList<Integer>();
	
	public Skyline ( ) {}
	/**
	 * Creates a new skyline from scratch
	 * @param building the only building used to create the skyline
	 */
	public Skyline(Building building) {

		
		if( building.left < 0 || building.right < 0 || building.height <= 0 || building.right == building.left){

			System.out.println( "Argument of building not valid must be \n building.left < 0 || building.right < 0 || building.height < 0 || building.right == building.left ");

		}else{

			leftSide = building.left;
			rightSide = building.right;
			
			for( int i = leftSide ; i < rightSide ; i++ ) {
				//System.out.println(i + " " + building.height );
				heightInPosition.put(i, building.height);	
			}
			
			heightInPosition.put(rightSide, 0);
				
		}
		

			
	}
	
	/**
	 * Creates a new skyline joining together other 2 previous skylines
	 * @param s1 one of the skylines
	 * @param s2 the other of the skylines
	 */
	public Skyline(Skyline s1, Skyline s2) {
		
		if( s1 == null) setSkyline( s2);
		else if ( s2 == null) setSkyline( s1 );
		else{
			
			if( s1.rightSide > s2.rightSide) rightSide = s1.rightSide;
			else rightSide = s2.rightSide;
			
			if(s1.leftSide < s2.leftSide ) leftSide = s1.leftSide;
			else leftSide = s2.leftSide;
			

			for( int i = leftSide ; i <= rightSide ; i++ ) {
				
				int s1Height = s1.getHeightInPosition(i);
				
				int s2Height = s2.getHeightInPosition(i);
				
				
				if(s1Height > s2Height)
					heightInPosition.put(i, s1Height);
				else 
					heightInPosition.put(i, s2Height);
			}
			
			heightInPosition.put(rightSide, 0);
			
			
		}
		
		

	}
	
	public void setSkyline ( Skyline skyline ) {
		
		
			rightSide = skyline.rightSide;
		
			leftSide = skyline.leftSide;
		
		
		for( int i = leftSide ; i < rightSide ; i++ )
			heightInPosition.put(i, skyline.heightInPosition.get(i));
		
	}
	
	/**
	 * Gets the height in a specific position
	 * @param position the position in the skyline
	 * @return the height in the skyline
	 */
	public int getHeightInPosition(int position) {
		if (this.heightInPosition.containsKey(position))
			return this.heightInPosition.get(position);
		
		return 0;
	}
	
	/**
	 * Returns the first position of the skyline
	 * @return the first position of the skyline
	 */
	public int getLeftSide() {
		return this.leftSide;
	}
	
	/**
	 * Returns the last position of the skyline
	 * @return the last position of the skyline
	 */
	public int getRightSide() {
		return this.rightSide;
	}
	
	/**
	 * Prints the skyline, that is, the height in each of the positions of the skyline
	 */
	public void printHeights() {

		System.out.println("PrintHeights");
		for (Map.Entry<Integer, Integer> entry : heightInPosition.entrySet()) {
			if( entry.getValue() !=-1 )
	        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	    }
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

	}
	
}
