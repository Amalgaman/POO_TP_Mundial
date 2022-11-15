package logica;

import java.util.LinkedList;

public class Admin {

	public static boolean completarResultados(LinkedList<Grupo> listaGrupos, Torneo torneo){
		
		//El Admin carga los resultados de los partidos de grupos
				for(Grupo grupo : listaGrupos) {
					Admin.cargarResultados(grupo);
					grupo.calcularPuestos();
					System.out.println(grupo);
				}
				
				for(Grupo grupo : listaGrupos) {
					System.out.println(grupo.getNombre()+": "+grupo.getPuesto1().getNombre()+" - "+grupo.getPuesto2().getNombre());
				}
				
				//Se carga el Torneo (con los ganadores de los grupos)

				torneo.establecerEquipos(listaGrupos);
				for (Equipo equipo : torneo.getEquipos()) {
					System.out.println(equipo.getNombre());
				}
				torneo.cargarOctavos();
				System.out.println("Octavos de Final:");
				for (Partido partido: torneo.getOctavos()) {
					System.out.println(partido);
				}
				
			
				//El Admin carga los resultados del torneo 
					Admin.cargarResultados(torneo);
					System.out.println("Cuartos de Final: ");
					for (Partido partido: torneo.getCuartos()) {
						System.out.println(partido);
					}
					
					System.out.println("Semifinales: ");
					for (Partido partido: torneo.getSemifinales()) {
						System.out.println(partido);
					}
				
					System.out.println("Final: ");
					for (Partido partido: torneo.getFinales()) {
						System.out.println(partido);
					}
				
		return true;			
	}
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
