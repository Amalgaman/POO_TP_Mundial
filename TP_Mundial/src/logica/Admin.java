package logica;

import java.util.LinkedList;

public class Admin {

	public static boolean cargarResultados(Grupo grupo) {
		
		for (Partido partido : grupo.getPartidos()) {
			partido.setGoles1((int)(Math.random()*4));
			partido.setGoles2((int)(Math.random()*4));
			
			partido.calcularResultado(grupo.getEquipos());
		}
		return true;
	}
	
	public static boolean cargarResultados(Torneo torneo) {
		
		return true;
	}
}
