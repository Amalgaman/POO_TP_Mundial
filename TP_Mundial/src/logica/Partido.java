package logica;

import java.util.LinkedList;

public class Partido {

	private int id_partido;
	private String equipo1;
	private String equipo2;
	private String ganador;
	private int goles1;
	private int goles2;
	private String nombre;
	private static int autoincrement=1;
	
	public Partido(String equipo1, String equipo2,String nombre) {
		super();
		this.id_partido = Partido.autoincrement;
		Partido.autoincrement++;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.goles1 = 0;
		this.goles2 = 0;
		this.nombre = nombre;
		this.ganador = " ";
	}

	public int getId_partido() {
		return id_partido;
	}

	public void setId_partido(int id_partido) {
		this.id_partido = id_partido;
	}

	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}

	public int getGoles1() {
		return goles1;
	}

	public void setGoles1(int goles1) {
		this.goles1 = goles1;
	}

	public int getGoles2() {
		return goles2;
	}

	public void setGoles2(int goles2) {
		this.goles2 = goles2;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "\n"+nombre+" : "+goles1+" - "+goles2;
	}
	
	public LinkedList<Equipo> calcularResultadoGrupo(LinkedList<Equipo> equipos){
		
		boolean equipo1=false,equipo2=false;
		int i=0;
		
		while(!equipo1 && !equipo2 || i > equipos.size()) {
			if(equipos.get(i).getNombre() == this.equipo1) {
				equipo1 = true;
				equipos.get(i).setGoles(equipos.get(i).getGoles() + this.goles1);
				if (this.goles1 > this.goles2) {
					equipos.get(i).setPartidosGanados(equipos.get(i).getPartidosGanados()+1);
				}
			}else if(equipos.get(i).getNombre() == this.equipo2) {
				equipo2 = true;
				equipos.get(i).setGoles(equipos.get(i).getGoles() + this.goles2);
				if (this.goles1 < this.goles2) {
					equipos.get(i).setPartidosGanados(equipos.get(i).getPartidosGanados()+1);
				}
			}
			i++;
		}
			
		return equipos;
	}
	
	public Equipo calcularResultadoTorneo(LinkedList<Equipo> equipos){
		
		boolean encontrado1=false,encontrado2=false;
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		int i=0;

		
		while(!encontrado1 || !encontrado2 && i < equipos.size()) {
			
			if(equipos.get(i).getNombre().equals(this.equipo1) ) {
				encontrado1 = true;
				equipos.get(i).setGoles(equipos.get(i).getGoles() + this.goles1);
				equipo1 = equipos.get(i);
				
			}else if(equipos.get(i).getNombre().equals(this.equipo2)) {
				encontrado2 = true;
				equipos.get(i).setGoles(equipos.get(i).getGoles() + this.goles2);
				equipo2 = equipos.get(i);
			}
			
			i++;
		}
		    if (this.goles1 > this.goles2) {
				equipo1.setPartidosGanados(equipo1.getPartidosGanados()+1);
				this.ganador=this.equipo1;
				return equipo1;
				
			} else if (this.goles1 < this.goles2) {
				
				equipo2.setPartidosGanados(equipo2.getPartidosGanados()+1);
				this.ganador=this.equipo2;
				return equipo2;
			}else {
				if ((int)(Math.random()*1) == 0) {
					this.ganador=this.equipo1;
					return equipo1;
				}else {
					this.ganador=this.equipo2;
					return equipo2;
				}
			}
			
	}
	
	
}
