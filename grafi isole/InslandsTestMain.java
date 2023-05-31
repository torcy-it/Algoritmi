package algestudiante.p5;


import java.util.ArrayList;

public class InslandsTestMain {

	public static void main ( String [] args ) {
		
		IslandsPath problem = new IslandsPath("C:\\Users\\ASUS\\OneDrive\\Desktop\\workspaceAlgo\\alg_TorcicolloAdolfoUO299007/src/main/java/algestudiante/p5/islas01.txt");
		executeFromFile(problem);
		ArrayList<String> paths = problem.getPaths();
		
	}
	
	
	private static void executeFromFile(IslandsPath problem) {
		System.out.println("Widths");
		System.out.println(problem);
		problem.calculateMaximumWidths();
		System.out.println("Costs matrix");
		problem.printCostsMatrix();
		System.out.println("Paths matrix");
		problem.printPathsMatrix();
		System.out.println("The islands that each road crosses");
		problem.generatePaths();
	}
}
