package logica;

public class Equipo {

	private int id_equipo;
	private String nombre;
	private int goles;
	private int grupo;
	private int partidosGanados;
	
	public Equipo(int id_equipo, String nombre, int grupo) {
		super();
		this.id_equipo = id_equipo;
		this.nombre = nombre;
		this.goles = 0;
		this.grupo = grupo;
		this.partidosGanados = 0;
	}
	public int getId_equipo() {
		return id_equipo;
	}
	public void setId_equipo(int id_equipo) {
		this.id_equipo = id_equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getGoles() {
		return goles;
	}
	public void setGoles(int goles) {
		this.goles = goles;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	
	public int getPartidosGanados() {
		return partidosGanados;
	}
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	@Override
	public String toString() {
		return "\n Equipo [id_equipo=" + id_equipo + ", nombre=" + nombre + ", goles=" + goles + ", grupo=" + grupo + ", ganados="+partidosGanados+"]";
	}
	
	
}
