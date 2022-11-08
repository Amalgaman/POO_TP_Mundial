package logica;

import java.util.LinkedList;

public class Admin {

	public static boolean cargarResultados(Grupo grupo) {
		
		for (Partido partido : grupo.getPartidos()) {
			partido.setGoles1((int)(Math.random()*4));
			partido.setGoles2((int)(Math.random()*4));
			
			partido.calcularResultadoGrupo(grupo.getEquipos());
		}
		return true;
	}
	
	public static boolean cargarResultados(Torneo torneo) {
		
		LinkedList<Equipo> ganadores = new LinkedList<Equipo>();
		
		for (Partido partido : torneo.getOctavos()) {
			partido.setGoles1((int)(Math.random()*4));
			partido.setGoles2((int)(Math.random()*4));
			
			ganadores.add(partido.calcularResultadoTorneo(torneo.getEquipos()));
		}
		
		torneo.cargarCuartos(ganadores);
		
		for (int i=0 ; i < ganadores.size() ; i++) {
			ganadores.remove(0);
		}
		
		for (Partido partido : torneo.getCuartos()) {
			partido.setGoles1((int)(Math.random()*4));
			partido.setGoles2((int)(Math.random()*4));
			
			ganadores.add(partido.calcularResultadoTorneo(torneo.getEquipos()));
		}
		
		torneo.cargarSemifinal(ganadores);
		
		for (int i=0 ; i < ganadores.size() ; i++) {
			ganadores.remove(0);
		}
		
		for (Partido partido : torneo.getSemifinales()) {
			partido.setGoles1((int)(Math.random()*4));
			partido.setGoles2((int)(Math.random()*4));
			
			ganadores.add(partido.calcularResultadoTorneo(torneo.getEquipos()));
		}
		
		torneo.cargarFinal(ganadores);
		
		for (Partido partido : torneo.getFinales()) {
			partido.setGoles1((int)(Math.random()*4));
			partido.setGoles2((int)(Math.random()*4));
			
			ganadores.add(partido.calcularResultadoTorneo(torneo.getEquipos()));
		}
		
		return true;
	}
}
