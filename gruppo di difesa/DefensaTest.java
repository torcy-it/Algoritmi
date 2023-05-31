package algestudiante.p4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DefensaTest {

	@Test
	public void asignacion03valores() {
		int[] enemigos= {8,3,6};
		int[] grupoDefensaRapida= {2, 10, 3};
		int[] asignaEsperada= {1, 2, 0};
		
		Defensa pais= new Defensa(enemigos.length, enemigos, grupoDefensaRapida);
		int[] asignaActual= pais.asignar();
		pais.mostrarPlanDefensaVertical();
		
		assertEquals(pais.getNumVictorias(),2);
		assertArrayEquals(asignaActual, asignaEsperada);
	}

	@Test
	public void asignacion03desdeFich() {
		int[] asignaEsperada= {1, 2, 0};
		
		Defensa pais= new Defensa("enemigos03.txt","defensa03.txt");
		int[] asignaActual= pais.asignar();
		pais.mostrarPlanDefensaVertical();
		
		assertEquals(pais.getNumVictorias(),2);
		assertArrayEquals(asignaActual, asignaEsperada);
	}

	@Test
	public void asignacion10desdeFich() {
		int[] asignaEsperada= Defensa.cargarArrayEnteros(Defensa.PATH + "esperada10.txt");
		
		Defensa pais= new Defensa("enemigos10.txt","defensa10.txt");
		int[] asignaActual= pais.asignar();
		pais.mostrarPlanDefensaVertical();
		
		assertEquals(pais.getNumVictorias(),6);
		assertArrayEquals(asignaActual, asignaEsperada);
	}
	
	@Test
	public void asignacion10creciente() {
		int[] asignaEsperada= Defensa.cargarArrayEnteros(Defensa.PATH + "esperada10creciente.txt");
		
		Defensa pais= new Defensa("enemigos10creciente.txt","defensa10.txt");
		int[] asignaActual= pais.asignar();
		pais.mostrarPlanDefensaVertical();
		
		assertEquals(pais.getNumVictorias(),6);
		assertArrayEquals(asignaActual, asignaEsperada);
	}

	@Test
	public void asignacion10decreciente() {
		int[] asignaEsperada= Defensa.cargarArrayEnteros(Defensa.PATH + "esperada10decreciente.txt");
		
		Defensa pais= new Defensa("enemigos10decreciente.txt","defensa10.txt");
		int[] asignaActual= pais.asignar();
		pais.mostrarPlanDefensaVertical();
		
		assertEquals(pais.getNumVictorias(),6);
		assertArrayEquals(asignaActual, asignaEsperada);
	}

}
