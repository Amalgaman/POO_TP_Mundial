package logica;

import java.util.LinkedList;

public class Torneo {

	private int id_torneo;
	private LinkedList<Partido> octavos;
	private LinkedList<Partido> cuartos;
	private LinkedList<Partido> semifinales;
	private LinkedList<Partido> finales;
	private LinkedList<Equipo> equipos;
	
	public Torneo(int id_torneo, LinkedList<Equipo> equipos) {
		super();
		this.id_torneo = id_torneo;
		this.equipos = equipos;
		this.octavos = this.cargarOctavos();
		
	}

	public int getId_torneo() {
		return id_torneo;
	}

	public void setId_torneo(int id_torneo) {
		this.id_torneo = id_torneo;
	}

	public LinkedList<Partido> getPartidos() {
		return octavos;
	}

	public void setPartidos(LinkedList<Partido> partidos) {
		this.octavos = partidos;
	}

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}
	public boolean establecerEquipos(LinkedList<Grupo> grupos){
		
		int aux = 0;
		
		for(Grupo grupo : grupos) {
			this.equipos.add(aux ,grupo.getPuesto1());
			this.equipos.add(aux+8 ,grupo.getPuesto2());
			aux++;
		}
		return true;
	}
	public boolean cargarOctavos(){
		
		for () {
			
		}
		
		
		return true;
	}
	
}
