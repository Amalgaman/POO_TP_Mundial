package logica;

import java.util.LinkedList;

public class Torneo {

	private int id_torneo;
	private LinkedList<Partido> octavos;
	private LinkedList<Partido> cuartos;
	private LinkedList<Partido> semifinales;
	private LinkedList<Partido> finales;
	private LinkedList<Equipo> equipos;
	private Equipo idGanador;
	
	public Torneo(int id_torneo) {
		super();
		this.id_torneo = id_torneo;
		this.octavos = new LinkedList<Partido>();
		this.cuartos = new LinkedList<Partido>();
		this.semifinales = new LinkedList<Partido>();
		this.finales = new LinkedList<Partido>();
		this.equipos = new LinkedList<Equipo>();
		
	}

	public int getId_torneo() {
		return id_torneo;
	}

	public void setId_torneo(int id_torneo) {
		this.id_torneo = id_torneo;
	}

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	public LinkedList<Partido> getOctavos() {
		return octavos;
	}

	public void setOctavos(LinkedList<Partido> octavos) {
		this.octavos = octavos;
	}

	public LinkedList<Partido> getCuartos() {
		return cuartos;
	}

	public void setCuartos(LinkedList<Partido> cuartos) {
		this.cuartos = cuartos;
	}

	public LinkedList<Partido> getSemifinales() {
		return semifinales;
	}

	public void setSemifinales(LinkedList<Partido> semifinales) {
		this.semifinales = semifinales;
	}

	public LinkedList<Partido> getFinales() {
		return finales;
	}

	public void setFinales(LinkedList<Partido> finales) {
		this.finales = finales;
	}

	public boolean establecerEquipos(LinkedList<Grupo> grupos){
		
		int aux = 0;
		
		for(Grupo grupo : grupos) {
			this.equipos.add(aux ,grupo.getPuesto1());
			this.equipos.add(grupo.getPuesto2());
			aux++;
		}
		return true;
	}
	public boolean cargarOctavos(){
		Equipo equipo1 = new Equipo(); 
		Equipo equipo2 = new Equipo();
		Equipo equipo3 = new Equipo(); 
		Equipo equipo4 = new Equipo();
		
		for (int i=0 ; i < 7 ; i+=2) {
			equipo1 = this.equipos.get(i);
			equipo2 = this.equipos.get(i+9);
			equipo3 = this.equipos.get(i+1);
			equipo4 = this.equipos.get(i+8);
			
			this.octavos.add(new Partido(equipo1.getNombre(), equipo2.getNombre(), equipo1.getNombre()+" contra "+equipo2.getNombre()));
			this.octavos.add(new Partido(equipo3.getNombre(), equipo4.getNombre(), equipo3.getNombre()+" contra "+equipo4.getNombre()));
		}
		
		
		return true;
	}
	public boolean cargarCuartos(LinkedList<Equipo> equipos) {
		
		Equipo equipo1 = new Equipo(); 
		Equipo equipo2 = new Equipo();
		
		for(int i=0 ; i < 8 ; i+=2) {
			equipo1 = equipos.get(i);
			equipo2 = equipos.get(i+1);
			
			this.cuartos.add(new Partido(equipo1.getNombre(), equipo2.getNombre(), equipo1.getNombre()+" contra "+equipo2.getNombre()));
		}
		return true;
	}
	
	public boolean cargarSemifinal(LinkedList<Equipo> equipos) {
		
		Equipo equipo1 = new Equipo(); 
		Equipo equipo2 = new Equipo();
		
		for(int i=0 ; i < 4 ; i+=2) {
			equipo1 = equipos.get(i);
			equipo2 = equipos.get(i+1);
			
			this.semifinales.add(new Partido(equipo1.getNombre(), equipo2.getNombre(), equipo1.getNombre()+" contra "+equipo2.getNombre()));
		}
		return true;
	}
	
	public boolean cargarFinal(LinkedList<Equipo> equipos) {
		
		Equipo equipo1 = equipos.get(0); 
		Equipo equipo2 = equipos.get(1);
		//Equipo equipo3 = equipos.get(2);
		//Equipo equipo4 = equipos.get(3);
		
		this.finales.add(new Partido(equipo1.getNombre(), equipo2.getNombre(), equipo1.getNombre()+" contra "+equipo2.getNombre()));
		//this.finales.add(new Partido(equipo3.getId_equipo(), equipo4.getId_equipo(), equipo3.getNombre()+" contra "+equipo4.getNombre()));
		
		return true;
	}

	@Override
	public String toString() {
		String octavos="Octavos: \n",cuartos="Cuartos: \n",semifinales="Semifinal: \n",finales="Final: \n";
		
		for (Partido partido : this.octavos) {
		octavos = octavos+partido+"\n";	
		}
		for (Partido partido : this.cuartos) {
			cuartos = cuartos+partido+"\n";	
			}
		for (Partido partido : this.semifinales) {
			semifinales = semifinales+partido+"\n";	
			}
		for (Partido partido : this.finales) {
			finales = finales+partido+"\n";	
			}
		
		return octavos+cuartos+semifinales+finales;
	}
	
}
