package logica;

public class Partido {

	private int id_partido;
	private int equipo1;
	private int equipo2;
	private int goles1;
	private int goles2;
	private static int autoincrement=1;
	
	public Partido(int equipo1, int equipo2) {
		super();
		this.id_partido = this.autoincrement;
		this.autoincrement++;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.goles1 = 0;
		this.goles2 = 0;
	}

	public int getId_partido() {
		return id_partido;
	}

	public void setId_partido(int id_partido) {
		this.id_partido = id_partido;
	}

	public int getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(int equipo1) {
		this.equipo1 = equipo1;
	}

	public int getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(int equipo2) {
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

	@Override
	public String toString() {
		return "\n Partido [id_partido=" + id_partido + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", goles1="
				+ goles1 + ", goles2=" + goles2 + "]";
	}
	
	
}
