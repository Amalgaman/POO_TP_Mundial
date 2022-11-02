package logica;

import java.util.LinkedList;

public class Grupo {

	private int id_grupo;
	private String nombre;
	private Equipo puesto1;
	private Equipo puesto2;
	private LinkedList<Equipo> equipos;
	private LinkedList<Partido> partidos;
	
	public Grupo(int id_grupo, String nombre) {
		super();
		this.id_grupo = id_grupo;
		this.nombre = nombre;
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

	public Equipo getPuesto1() {
		return puesto1;
	}

	public void setPuesto1(Equipo puesto1) {
		this.puesto1 = puesto1;
	}

	public Equipo getPuesto2() {
		return puesto2;
	}

	public void setPuesto2(Equipo puesto2) {
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
		
		case 3:
			equipos.add(new Equipo(9, "Argentina", 3));
			equipos.add(new Equipo(10, "Arabia Saudita", 3));
			equipos.add(new Equipo(11, "Mexico", 3));
			equipos.add(new Equipo(12, "Polonia", 3));
			break;
		
		case 4:
			equipos.add(new Equipo(13, "Francia", 4));
			equipos.add(new Equipo(14, "Australia", 4));
			equipos.add(new Equipo(15, "Dinamarca", 4));
			equipos.add(new Equipo(16, "Turquia", 4));
			break;
		
		case 5:
			equipos.add(new Equipo(17, "España", 5));
			equipos.add(new Equipo(18, "Costa Rica", 5));
			equipos.add(new Equipo(19, "Alemania", 5));
			equipos.add(new Equipo(20, "Japon", 5));
			break;
		
		case 6:
			equipos.add(new Equipo(21, "Belgica", 6));
			equipos.add(new Equipo(22, "Canada", 6));
			equipos.add(new Equipo(23, "Marruecos", 6));
			equipos.add(new Equipo(24, "Croasia", 6));
			break;
		
		case 7:
			equipos.add(new Equipo(25, "Brasil", 7));
			equipos.add(new Equipo(26, "Serbia", 7));
			equipos.add(new Equipo(27, "Suiza", 7));
			equipos.add(new Equipo(28, "Camerun", 7));
			break;
		
		case 8:
			equipos.add(new Equipo(29, "Portugal", 8));
			equipos.add(new Equipo(30, "Ghana", 8));
			equipos.add(new Equipo(31, "Uruguay", 8));
			equipos.add(new Equipo(32, "Corea del Sur", 8));
			break;
		}
		
		return equipos;
	}
    public LinkedList<Partido> cargarPartidos(){
    	
    	LinkedList<Partido> partidos = new LinkedList<Partido>();
    	
    	for (Equipo equipo1: this.equipos) {
			for (Equipo equipo2: this.equipos) {
				if(equipo1.getId_equipo() > equipo2.getId_equipo()) {
					partidos.add(new Partido(equipo1.getId_equipo(), equipo2.getId_equipo(), equipo1.getNombre()+" contra "+equipo2.getNombre()));
				}
				
			}
		}
    	
    	return partidos;
    }
    public boolean calcularPuestos() {
    	int aux=-1;
    	
    	for (Equipo equipo : this.equipos) {
    	
    		if(equipo.getPartidosGanados() > aux) {
    			this.puesto1 = equipo;
    			aux = this.puesto1.getPartidosGanados();
    			
    		}else if(equipo.getPartidosGanados() == aux) {
    			
    			if(equipo.getGoles() > this.puesto1.getGoles()) {
    				this.puesto1 = equipo;
    			
    			}else if(equipo.getGoles() == this.puesto1.getGoles()) {
    				if(Math.random()*2 == 0) {
    					this.puesto1 = equipo;
    				}
    			}
    		}
    	}
    	
    	aux=-1;
    	for (Equipo equipo : this.equipos) {
        	
    		if(equipo.getId_equipo()!=this.puesto1.getId_equipo()) {
    		
    			if(equipo.getPartidosGanados() > aux) {
    			this.puesto2 = equipo;
    			aux = this.puesto2.getPartidosGanados();
    			
    		}else if(equipo.getPartidosGanados() == aux) {
    			
    			if(equipo.getGoles() > this.puesto2.getGoles()) {
    				this.puesto2 = equipo;
    			
    			}else if(equipo.getGoles() == this.puesto2.getGoles()) {
    				if(Math.random()*2 == 0) {
    					this.puesto2 = equipo;
    				}
    			}
    		}
    		}		
    	}
    	return true;
    }
	
}
