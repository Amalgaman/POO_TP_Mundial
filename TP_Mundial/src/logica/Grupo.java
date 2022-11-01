package logica;

import java.util.LinkedList;

public class Grupo {

	private int id_grupo;
	private String nombre;
	private int puesto1;
	private int puesto2;
	private LinkedList<Equipo> equipos;
	private LinkedList<Partido> partidos;
	
	public Grupo(int id_grupo, String nombre) {
		super();
		this.id_grupo = id_grupo;
		this.nombre = nombre;
		this.puesto1 = 0;
		this.puesto2 = 0;
		this.equipos = this.cargarEquipos();
		this.partidos = this.cargarPartidos();
	}

	public int getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuesto1() {
		return puesto1;
	}

	public void setPuesto1(int puesto1) {
		this.puesto1 = puesto1;
	}

	public int getPuesto2() {
		return puesto2;
	}

	public void setPuesto2(int puesto2) {
		this.puesto2 = puesto2;
	}

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public LinkedList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(LinkedList<Partido> partidos) {
		this.partidos = partidos;
	}
	
	
    @Override
	public String toString() {
		return "Grupo [id_grupo=" + id_grupo + ", nombre=" + nombre + ", puesto1=" + puesto1 + ", puesto2=" + puesto2
				+ ", equipos=" + equipos + ", partidos=" + partidos + "]";
	}

	public LinkedList<Equipo> cargarEquipos() {
		
		LinkedList<Equipo> equipos = new LinkedList<Equipo>();
		
		switch (this.id_grupo) {
		case 1:
			equipos.add(new Equipo(1, "Qatar", 1));
			equipos.add(new Equipo(2, "Ecuador", 1));
			equipos.add(new Equipo(3, "Senegal", 1));
			equipos.add(new Equipo(4, "Paises Bajos", 1));
			break;
		
		case 2:
			equipos.add(new Equipo(5, "Inglaterra", 2));
			equipos.add(new Equipo(6, "Iran", 2));
			equipos.add(new Equipo(7, "USA", 2));
			equipos.add(new Equipo(8, "Gales", 2));
			break;	
			
		}
		
		
		return equipos;
	}
    public LinkedList<Partido> cargarPartidos(){
    	
    	LinkedList<Partido> partidos = new LinkedList<Partido>();
    	
    	for (Equipo equipo1: this.equipos) {
			for (Equipo equipo2: this.equipos) {
				if(equipo1.getId_equipo() > equipo2.getId_equipo()) {
					partidos.add(new Partido(equipo1.getId_equipo(), equipo2.getId_equipo()));
				}
				
			}
		}
    	
    	return partidos;
    }
	
}
