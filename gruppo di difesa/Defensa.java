package algestudiante.p4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Defensa 
{										///alg_TorcicolloAdolfoUO299007/src/main/java/algestudiante/p4/
	public static final String PATH = "src\\main\\java\\algestudiante\\p4\\";
	
	// Datos de entrada
	private int n;						// N�mero de ciudades invadidas (coincide con el n�mero de equipos)
	private int[] enemigos;				// N�mero de efectivos enemigos en cada ciudad (ei)
	private int[] grupoDefensaRapida;	// Efectivos de defensa en cada equipo (di)
	
	// trabajo
	private boolean[] asignados;		// Equipos de defensa ya asignados
	
	// soluci�n
	private int[] asignacion;			// Asignaci�n de defensa a ciudades (�ndice del equipo de defensa r�pida)
	private int numVictorias;			// N�mero de victorias conseguidas con la asignaci�n
	
	/**
	 * Constructor que recibe los arrays para empezar a trabajar
	 * @param n	n�mero de ciudades invadidas
	 * @param enemigos	efectivos enemigos en cada ciudad 
	 * @param grupoDefensaRapida	efectivos en cada grupo de defensa r�pida
	 */
	public Defensa(int n, int[] enemigos, int[] grupoDefensaRapida)
	{
		this.n= n;	// Ciudades invadidas
		
		this.enemigos= new int[n];
		this.grupoDefensaRapida= new int[n];
		asignados= new boolean[n];
		
		for (int i= 0; i<n; i++)
		{
			this.enemigos[i]= enemigos[i]; 
			this.grupoDefensaRapida[i]= grupoDefensaRapida[i]; 
			this.asignados[i]= false;
		}
		numVictorias= 0;
		
	}
	
	/**
	 * Recibe los nombres de los ficheros para cargarlos y trabajar con ellos
	 * @param nomFichEnemigos	efectivos enemigos en cada ciudad
	 * @param nomFichDefensa	efectivos en cada grupo de defensa r�pida
	 */
	public Defensa(String nomFichEnemigos, String nomFichDefensa) {
		enemigos= cargarArrayEnteros(PATH + nomFichEnemigos);
		grupoDefensaRapida= cargarArrayEnteros(PATH + nomFichDefensa);
		n= enemigos.length;
		asignados= new boolean[n];
		
		for (int i= 0; i<n; i++)
		{
			this.asignados[i]= false;
		}
		numVictorias= 0;
	}
	
	/**
	 * Carga desde fichero un array de enteros
	 * @param file nombre del fichero
	 * @return array de enteros cargado
	 */
	public static int[] cargarArrayEnteros(String file) {
		List<Integer> input = new ArrayList<Integer>();
		
		try (Stream<String> lines = Files.lines(Paths.get(file))) {
			for (String line : lines.collect(Collectors.toList())) {    //lines.toList()) {
				String[] info = line.split("\t");
				input.add(Integer.parseInt(info[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return input.stream()
                .mapToInt(Integer::intValue)
                .toArray();
	}
	
	
	/**
	 * Soluci�n:
	 *  
	 * @return 	array con los equipos de defensa asignados a cada ciudad
	 */
	public int[] asignar()
	{
		
		asignacion = new int [n];
		
		int min = 2147483647; 
		int pos = 0;
		boolean findIt = false;
		int count = 0;
		
		
		for( int i = 0 ; i < enemigos.length; i++ ) {
			
			
			for ( int j = 0; j< grupoDefensaRapida.length; j++) {
				
				if( enemigos[i] <= grupoDefensaRapida[j] && !asignados[j]) {
					
					int sott = grupoDefensaRapida[j] - enemigos[i];
					
					if( min >= sott ) {
						
						//System.out.println(" "+ min + " " + (grupoDefensaRapida[j] - enemigos[i]) + " "+ sott );
						
						//System.out.println( grupoDefensaRapida[j] + " -- "+  enemigos[i] + "    "+asignados[j] +" "+ min);
						
						if ( findIt ) {asignados[pos] = false; count++;}
						
						findIt = true;
						
						pos = j;
						min = sott;
						
						asignados[pos] = true;
					
						asignacion[i] = pos;
						
					}
					
					if ( min == 0 ) {
						j = 0;
						break;
					}
					
					
				}
	
			}
			
			
			
			if ( !findIt  )
			{
				min = 2147483647;
				findIt = false;

				for ( int j = 0 ; j < grupoDefensaRapida.length ; j++ ) {
					
					//System.out.println( grupoDefensaRapida[j] + " "+asignados[j] +" "+ min);
				
					if ( !asignados[j] && min >= grupoDefensaRapida[j]) {
						
						//System.out.println("ao?");
						
						
						if ( findIt ) asignados[pos] = false;
						
						findIt = true;
						
						min = grupoDefensaRapida[j];
						
						pos = j;
						
						asignados[pos] = true;
						
						asignacion[i] = pos;
					}
				}
			}
			
			
			//System.out.println();
			//System.out.println();
			min = 2147483647;
			findIt = false;
		}
			//System.out.println(asignacion[i]);
		
		
		
		
		// TODO: Soluci�n voraz para este problema partiendo de los datos que ya tenemos
		// se pueden crear los m�todos privados que se consideren necesarios
		
		return asignacion;
	}
	
	
	/**
	 * Muestra en consola, los �ndices de las ciudades invadidas, los efectivos enemigos y 
	 * los efectivos de defensa asignados y 
	 * el resultado final en funci�n de esta asignaci�n: Victoria / Derrota
	 */
	public void mostrarPlanDefensaVertical()
	{
		
		System.out.println("N� ciudad invadida");
		System.out.println("\tEfectivos enemigos:");
		System.out.println("\t\tEfectivos de defensa");
		System.out.println("\t\t\tIndice equipo defensa");
		System.out.println("\t\t\t\tResultado batalla:");
		for (int i= 0; i<n; i++)
		{
			System.out.print(i+"\t");
			System.out.print(enemigos[i]+"\t");
			System.out.print(grupoDefensaRapida[i]+"\t");
			System.out.print(asignacion[i]+"\t");
			if(grupoDefensaRapida[asignacion[i]]>=enemigos[i] ) {
				System.out.print("Vict. +"); numVictorias++;
			}else {
				System.out.print("Derr. �");
			}
			//System.out.print((grupoDefensaRapida[asignacion[i]]>=enemigos[i]?"Vict. +":"Derr. �")+"\t");
			System.out.println();
		}
		System.out.println("Total victorias: "+ numVictorias+ " / "+n);
		
		
		
		
	}

	/**
	 * Genera array aleatorio con los enemigos
	 * @param n n�mero de ciudades que se quieren representar
	 * @return array con los efectivos enemigos por ciudad
	 */
	public static int[] generarEnemigos(int n)
	{
		Random r= new Random ();
		int[] enemigos= new int[n];
		
		for (int i= 0; i<n; i++)
		{
			enemigos[i]= r.nextInt(1000);
		}
		
		return enemigos;
	}
	
	/**
	 * Genera array aleatorio con los equipos de defensa
	 * @param n N�mero de equipos de defensa
	 * @return array con los efectivos de defensa por cada equipo
	 */
	public static int[] generarGrupoDefensa(int n)
	{
		Random r= new Random ();
		int[] grupoDefensaRapida= new int[n];
		
		for (int i= 0; i<n; i++)
		{
			grupoDefensaRapida[i]= r.nextInt(1000);
		}
		
		return grupoDefensaRapida;		
	}
	
	/**
	 *  Devuelve asignaci�n grupos de defensa (soluci�n)
	 * @return
	 */
	public int[] getAsignacion() {
		return asignacion;
	}
	
	/**
	 * Devuelve el n�mero de victorias conseguidas
	 * @return Asignaci�n de defensa a ciudades (�ndice del equipo de defensa r�pida)
	 */
	public int getNumVictorias() {
		return numVictorias;
	}
	
	/* Prueba el algoritmo de asignaci�n */
	public static void main(String[] args)
	{
		int n= 10;
//		int[] enemigos= generarEnemigos(n);	
//		int[] enemigos= {260,906,316,702,476,418,321,420,352,249};
//		int[] enemigos= {906,702,476,420,418,352,321,316,260,249};
//		int[] enemigos= {249,260,316,321,352,418,420,476,702,906};
		int[] enemigos= {8,3,6};
//		int[] grupoDefensaRapida= generarGrupoDefensa(n);	
//		int[] grupoDefensaRapida= {356,831,846,69,221,234,507,150,349,530};
		int[] grupoDefensaRapida= {2,10,3};
//		int[] enemigos= {10,8,2,1,3};
//		int[] grupoDefensaRapida= generarGrupoDefensa(n);	
//		int[] grupoDefensaRapida= {8,10,5,1,0};
		
		Defensa pais= new Defensa(enemigos.length, enemigos, grupoDefensaRapida);
		//Defensa pais= new Defensa("enemigos10.txt","defensa10.txt");
		pais.asignar();
		
		pais.mostrarPlanDefensaVertical();
	}

}
