package algestudiante.p6;

import java.util.ArrayList;

import algestudiante.p4.Defensa;

public class RevientaClavesTiempo {

	 
	public static void main(String[] args) {

		String fich= "C:\\Users\\ASUS\\OneDrive\\Desktop\\workspaceAlgo\\alg_TorcicolloAdolfoUO299007\\src\\main\\java\\algestudiante\\p6\\herenciaEnvenenadaMD5.txt";
		
		RevientaClaves rc= new RevientaClaves(fich, false);
		
		rc.getTodasClavesTiempo();		

		
	} // main
}
