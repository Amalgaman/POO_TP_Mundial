package interfaz;

import java.util.LinkedList;

import logica.*;

class Main {

	public static void main(String[] args) {
		
		LinkedList<Grupo> listaGrupos = new LinkedList<Grupo>();
		listaGrupos.add(new Grupo(1,"A"));
		listaGrupos.add(new Grupo(2,"B"));
		listaGrupos.add(new Grupo(3,"C"));
		listaGrupos.add(new Grupo(4,"D"));
		listaGrupos.add(new Grupo(5,"E"));
		listaGrupos.add(new Grupo(6,"F"));
		listaGrupos.add(new Grupo(7,"G"));
		listaGrupos.add(new Grupo(8,"H"));
		
		
		for(Grupo grupo : listaGrupos) {
			Admin.cargarResultados(grupo);
			grupo.calcularPuestos();
			System.out.println(grupo);
		}
		
		for(Grupo grupo : listaGrupos) {
			System.out.println(grupo.getNombre()+": "+grupo.getPuesto1().getNombre()+" - "+grupo.getPuesto2().getNombre());
		}
		
		Torneo torneo = new Torneo(1);

		torneo.establecerEquipos(listaGrupos);
		for (Equipo equipo : torneo.getEquipos()) {
			System.out.println(equipo.getNombre());
		}
		torneo.cargarOctavos();
		System.out.println("Octavos de Final:");
		for (Partido partido: torneo.getOctavos()) {
			System.out.println(partido);
		}
		
	
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
	}

}
