package algestudiante.p6;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RevientaClavesTest {

	@Test
	public void primeraClave() {
		String md5= "a58e0423869da99d6ca169de8a000cc7";
		
		RevientaClaves rc= new RevientaClaves(md5,true);
		String clave= rc.getClave();
		
		assertEquals(EjemploMD5.getMD5(clave),md5);
	}
	
	@Test
	public void todasClaves() {
		String fich= "C:\\Users\\ASUS\\OneDrive\\Desktop\\workspaceAlgo\\alg_TorcicolloAdolfoUO299007\\src\\main\\java\\algestudiante\\p6\\herenciaEnvenenadaMD5.txt";
		
		RevientaClaves rc= new RevientaClaves(fich, false);
		ArrayList<String> claves= rc.getTodasClaves();		
		ArrayList<String> arrayMD5= rc.getArrayMD5();
		
		assertTrue(compruebaTodasClaves(claves,arrayMD5));
		
	}

	private boolean compruebaTodasClaves(ArrayList<String> claves, ArrayList<String> arrayMD5) {
		for (int i= 0; i<claves.size(); i++)
			if (EjemploMD5.getMD5(claves.get(i))!=arrayMD5.get(i))
				return false;
		return true;
	}
	

}
