package logica;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Bookmaker {

	public static int comprobarApuesta(Grupo grupo, String op1, String op2, String favorito) {
		int puntos=0;
		
		if(op1.equals(grupo.getPuesto1().getNombre())) {
			puntos= puntos+2;
		}else if(op1.equals(grupo.getPuesto2().getNombre())){
			puntos= puntos+1;
		}
		if(op2.equals(grupo.getPuesto2().getNombre())){
			puntos= puntos+2;
		}else if(op2.equals(grupo.getPuesto1().getNombre())){
			puntos= puntos+1;
		}
		if (op1.equals(favorito) || op2.equals(favorito)) {
			puntos= puntos+3;
		}
		
		return puntos;
	}
	public static int comprobarApuesta(Partido partido, String op1, String favorito) {
		int puntos=0;
		
		if(partido.getGanador().equals(op1)) {
			puntos+=3;
		}
		if(partido.getGanador().equals(favorito)) {
			puntos+=3;
		}
		
		return puntos;
	}
	public static boolean entregarPremio(int puntuacion, LinkedList<Premio> premios) {
		
		int aux=0;
		boolean repetido=false;
		
		if(puntuacion == 108) {
			premios.add(new Premio(1, "nombre", "descripcion", "imagen"));
			puntuacion=puntuacion-3;
		}
			if(puntuacion == 0) {
			premios.add(new Premio(1, "nombre", "descripcion", "imagen"));
		} 
			while(puntuacion>=3) {
				
				//nos fijamos si esta repetido
				do {
				repetido=false;
				aux=(int)(Math.random()*37+1);
				for (Premio premio : premios) {
					if(aux==premio.getId()) {
						repetido=true;
					}
				}
				}while(repetido);
				
				//Genertamos el premio con el aux, aca todo hardcodeado
				switch(aux) {
				
				case 1:
					premios.add(new Premio(1, "World Cup Willie", "Mascota de la Copa Mundial de Inglaterra 1966. \n"
																+ "Fue la primera mascota de un mundial.", "premio-willie.jpg"));
					break;
				case 2:
					premios.add(new Premio(2, "Juanito", "Mascota de la Copa Mundial de Mexico 1970. \n"
														+ "Fue el primer mundial transmitido a color.", "premio-juanito.jpg"));
					break;
				case 3:
					premios.add(new Premio(3, "Tip y Tap", "Mascota de la Copa Mundial de Alemania Occidental 1974.\n"
							+ "En medio de un país dividido entre la Alemania Occidental y la Oriental, \n"
							+ "los hermanos Tip y Tap abrazados simbolizaban la unión entre ambas, en un \n"
							+ "claro pedido para que se terminaran aquellas diferencias.", "premio-tiptap.jpg"));
					break;
				case 4:
					premios.add(new Premio(4, "Gauchito Mundialito", "Mascota de la Copa Mundial de Argentina 1978.\n"
							+ "Era un chico de La Pampa, creado por el dibujante nacional Néstor Córdoba.", "premio-gauchito.jpg"));
					break;
				case 5:
					premios.add(new Premio(5, "Naranjito", "Mascota de la Copa Mundial de España 1982.\n"
							+ "Resistida al principio por haber sido extraña, su popularidad\n"
							+ "creció tanto sobre el final que hasta llegó a tener su propio\n"
							+ "show en la televisión.", "premio-naranjito.jpg"));
					break;
				case 6:
					premios.add(new Premio(6, "Pique", "Mascota de la Copa Mundial de Mexico 1986", "premio-pique.jpg"));
					break;
				case 7:
					premios.add(new Premio(7, "Ciao", "Mascota de la Copa Mundial de Italia 1990", "premio-ciao.jpg"));
					break;
				case 8:
					premios.add(new Premio(8, "Striker", "Mascota de la Copa Mundial de Estados Unidos 1994", "premio-striker.jpg"));
					break;
				case 9:
					premios.add(new Premio(9, "Footix", "Mascota de la Copa Mundial de Francia 1998", "premio-footix.jpg"));
					break;
				case 10:
					premios.add(new Premio(10, "Los Spheriks", "Mascota de la Copa Mundial de Corea del Sur y Japon 2002", "premio-spheriks.jpg"));
					break;
				case 11:
					premios.add(new Premio(11, "Goleo VI y Pille", "Mascota de la Copa Mundial de Alemania 2006", "premio-goleo.jpg"));
					break;
				case 12:
					premios.add(new Premio(12, "Zakumi", "Mascota de la Copa Mundial de Sudafrica 2010", "premio-zakumi.jpg"));
					break;
				case 13:
					premios.add(new Premio(13, "Fuleco", "Mascota de la Copa Mundial de Brasil 2014", "premio-fuleco.jpg"));
					break;
				case 14:
					premios.add(new Premio(14, "Zabivaka", "Mascota de la Copa Mundial de Rusia 2018", "premio-zabivaka.jpg"));
					break;
				case 15:
					premios.add(new Premio(15, "La Eeb", "Mascota de la Copa Mundial de Qatar 2022", "premio-laeeb.jpg"));
					break;
				case 16:
					premios.add(new Premio(16, "T-Model", "Pelota del Mundial de Uruguay 1930. Campeon: Uruguay", "premio-1930.jpg"));
					break;
				case 17:
					premios.add(new Premio(17, "Federale 102", "Pelota del Mundial de Italia 1934. Campeon: Italia", "premio-1934.jpg"));
					break;
				case 18:
					premios.add(new Premio(18, "Allen", "Pelota del Mundial de Francia 1938. Campeon: Italia", "premio-1938.jpg"));
					break;
				case 19:
					premios.add(new Premio(19, "Super Ball Duplo T", "Pelota del Mundial de Brasil 1950. Campeon: Uruguay", "premio-1950.jpg"));
					break;
				case 20:
					premios.add(new Premio(20, "Swiss World Champion", "Pelota del Mundial de Suiza 1954. Campeon: Alemania", "premio-1954.jpg"));
					break;
				case 21:
					premios.add(new Premio(21, "Top Star", "Pelota del Mundial de Suecia 1958. Campeon: Brasil", "premio-1958.jpg"));
					break;
				case 22:
					premios.add(new Premio(22, "Mr. Crack", "Pelota del Mundial de Chile 1962. Campeon: Brasil", "premio-1962.jpg"));
					break;
				case 23:
					premios.add(new Premio(23, "Slazenger Challenge", "Pelota del Mundial de Inglaterra 1966. Campeon: Inglaterra", "premio-1966.jpg"));
					break;
				case 24:
					premios.add(new Premio(24, "Telstar", "Pelota del Mundial de Mexico 1970. Campeon: Brasil", "premio-1970.jpg"));
					break;
				case 25:
					premios.add(new Premio(25, "Telstar Durlast", "Pelota del Mundial de Alemania 1974. Campeon: Alemania", "premio-1974.jpg"));
					break;
				case 26:
					premios.add(new Premio(26, "Tango Durlast", "Pelota del Mundial de Argentina 1978. Campeon: Argentina", "premio-1978.jpg"));
					break;
				case 27:
					premios.add(new Premio(27, "Tango España", "Pelota del Mundial de España 1982. Campeon: Italia", "premio-1982.jpg"));
					break;
				case 28:
					premios.add(new Premio(28, "Azteca", "Pelota del Mundial de Mexico 1986. Campeon: Argentina", "premio-1986.jpg"));
					break;
				case 29:
					premios.add(new Premio(29, "Etrusco Unico", "Pelota del Mundial de Italia 1990. Campeon: Alemania", "premio-1990.jpg"));
					break;
				case 30:
					premios.add(new Premio(30, "Questra", "Pelota del Mundial de Estados Unidos 1994. Campeon: Brasil", "premio-1994.jpg"));
					break;
				case 31:
					premios.add(new Premio(31, "Tricolore", "Pelota del Mundial de Estados Unidos 1998. Campeon: Francia", "premio-1998.jpg"));
					break;
				case 32:
					premios.add(new Premio(32, "Fevernova", "Pelota del Mundial de Corea del Sur y Japon 2002. Campeon: Brasil", "premio-2002.jpg"));
					break;
				case 33:
					premios.add(new Premio(33, "Teamgeist", "Pelota del Mundial de Alemania 2006. Campeon: Italia", "premio-2006.jpg"));
					break;
				case 34:
					premios.add(new Premio(34, "Jabulani", "Pelota del Mundial de Sudafrica 2010. Campeon: España", "premio-2010.jpg"));
					break;
				case 35:
					premios.add(new Premio(35, "Brazuca", "Pelota del Mundial de Brasil 2014. Campeon: Alemania", "premio-2014.jpg"));
					break;
				case 36:
					premios.add(new Premio(36, "Telstar 18", "Pelota del Mundial de Rusia 2018. Campeon: Francia", "premio-2018.jpg"));
					break;
				case 37:
					premios.add(new Premio(37, "Al Rihla", "Pelota del Mundial de Qatar 2022. Campeon:...", "premio-2022.jpg"));
					break;	

				}
				puntuacion=puntuacion-3;
			}
		
		return true;
	}
}
