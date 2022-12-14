package interfaz;

import javax.swing.Icon;

import javax.swing.ImageIcon;
import java.util.LinkedList;

import javax.swing.*;

import logica.*;

class Main {

	public static void main(String[] args) {
		
		//opciones del menu
		String []opciones1={"Jugar Mundial","Ver Resultados","Salir"};
		int op1;
		//metemos imagenes
		Icon iconoPor = new ImageIcon(Main.class.getResource("../img/portada.jpg"));
		Icon iconoSim = new ImageIcon(Main.class.getResource("../img/simulacion.png"));
		
		//puntaje del usuario y premios
		LinkedList<Premio> premios= new LinkedList<Premio>();
		
		//instancio los grupos y el torneo
		LinkedList<Grupo> listaGrupos = new LinkedList<Grupo>();
		cargarGrupos(listaGrupos);
		Torneo torneo = new Torneo(1);
		
		
		do {
			op1 = JOptionPane.showOptionDialog(null, "Bienvenido al simulador del mundial Qatar 2022.\n"
													+ "La I.A. altamente compleja del programa predecira\n"
													+ "los resultados de los partidos con datos y esta-\n"
													+ "disticas oficiales en tiempo real. Adivina los\n"
													+ "resultados y participa por increibles premios\n"
													+ "(digitales)", "Simulador Mundial", 0, 0, iconoPor, opciones1, opciones1);
			
			switch(op1) {
			case 0:
				Admin.completarResultados(listaGrupos,torneo);
				menuApuesta(listaGrupos,torneo,premios);
				menuResultado(listaGrupos,torneo,premios);
				break;
			case 1:
                JOptionPane.showMessageDialog(null, "Equipo Favorito: Primero, elegi tu equipo favorito. Cada\n"
                									+ "vez que sale ganador de una instancia, ganas 3 puntos. \n \n"
                									+ "Fase de Grupos: Elegi quienes seran el primer y segundo\n"
            										+ "puesto de cada grupo, obtendras puntos de la siguiente manera:\n"
            										+ "-Si acertas el equipo y su posicion, ganas 2 puntos.\n"
            										+ "-Si acertas el equipo pero no su posicion, ganas 1 puntos.\n \n"
            										+ "Fase de Eliminatorias: Elegi el ganador de cada partido.\n"
            										+ "Ganas 3 puntos por cada acierto.\n \n"
            										+ "Al final se contaran los puntos totales y obtendras un\n"
            										+ "premio por cada 3 puntos. Son 37 premios en total y\n"
            										+ "hay un premio especial por tener la puntuacion maxi-\n"
            										+ "ma. Mucha suerte!", "Simulador Mundial: Reglas", op1, iconoSim);
				
				break;
			default:
				
				break;
			}
			
		}while(op1==1);
			
	}
	
	public static boolean cargarGrupos(LinkedList<Grupo> listaGrupos) {
		
		listaGrupos.add(new Grupo(1,"A"));
		listaGrupos.add(new Grupo(2,"B"));
		listaGrupos.add(new Grupo(3,"C"));
		listaGrupos.add(new Grupo(4,"D"));
		listaGrupos.add(new Grupo(5,"E"));
		listaGrupos.add(new Grupo(6,"F"));
		listaGrupos.add(new Grupo(7,"G"));
		listaGrupos.add(new Grupo(8,"H"));
		
		return true;
	}
	
	public static void  menuResultado(LinkedList<Grupo> listaGrupos,Torneo torneo, LinkedList<Premio> premios) {

		int op1,aux=0;
		String []opciones1={"Premios","Grupos","Torneo","Equipos","Salir"};
		String []opcionesGrupo= new String[listaGrupos.size()];
		String opGrupo,opEquipo,opPremio;
		String []opcionesEquipo= new String[32];
		String []opcionesPremios= new String[premios.size()];
		Icon iconoPor = new ImageIcon(Main.class.getResource("../img/copita.jpg"));
		
		//completo opcionesPremios
				for (Premio premio : premios) {
					opcionesPremios[premios.indexOf(premio)]=premio.getNombre();	
				}
		//completo opcionesGrupo y opcionesEquipo
		for (Grupo grupo : listaGrupos) {
			
			opcionesGrupo[listaGrupos.indexOf(grupo)]=grupo.getNombre();
			
			for(Equipo equipo : grupo.getEquipos()) {
				opcionesEquipo[aux]=equipo.getNombre();
				aux++;
			}
		}
		
		
		do {
		op1 = JOptionPane.showOptionDialog(null, "Gracias por jugar. \n"
												+ "Podes volver a ver tus premios y los resultados del torneo.", null, 0, 0, iconoPor, opciones1, opciones1);
		
		switch(op1) {
		
		case 0:
			do {
				opPremio = (String) JOptionPane.showInputDialog(
						null // para que se muestre centrado
						,"Selecciona un Premio" // Mensaje de la ventana
						,"Simulador Mundial: Premios" // Titulo de la ventana
						,JOptionPane.QUESTION_MESSAGE // Icono
						,null //null para icono defecto de la ventana
						,opcionesPremios // el objeto
						,opcionesPremios[0] // posicion del que va aparecer seleccionado
						);
				
				for(Premio premio : premios) {
					if(premio.getNombre().equals(opPremio)) {
						JOptionPane.showMessageDialog(null, premio, "Simulador Mundial: Premio", 0, new ImageIcon(Main.class.getResource("../img/"+premio.getImagen())));
					}
				}
				}while (JOptionPane.showConfirmDialog(null, "Ver otro Premio?") < 1);
			break;
		
		case 1:
			do {
			opGrupo = (String) JOptionPane.showInputDialog(
					null // para que se muestre centrado
					,"Selecciona un Grupo" // Mensaje de la ventana
					,"Lista de Datos" // Titulo de la ventana
					,JOptionPane.QUESTION_MESSAGE // Icono
					,null //null para icono defecto de la ventana
					,opcionesGrupo // el objeto
					,opcionesGrupo[0] // posicion del que va aparecer seleccionado
					);
			
			for(Grupo grupo : listaGrupos) {
				if(grupo.getNombre().equals(opGrupo)) {
					JOptionPane.showMessageDialog(null, "GRUPO "+grupo.getNombre()+": 1ro "+grupo.getPuesto1().getNombre()+"- 2do "+grupo.getPuesto2().getNombre()+
							                       "\n Partidos: "+
				                                   grupo.getPartidos().get(0)+
				                                   grupo.getPartidos().get(1)+
				                                   grupo.getPartidos().get(2)+
				                                   grupo.getPartidos().get(3)+
				                                   grupo.getPartidos().get(4)+
				                                   grupo.getPartidos().get(5));
				}
			}
			}while (JOptionPane.showConfirmDialog(null, "Ver otro Grupo?") < 1);
			
			break;
		case 2:
			
			JOptionPane.showMessageDialog(null, torneo);
			
			break;
			
		case 3:
			opEquipo = (String) JOptionPane.showInputDialog(
					null // para que se muestre centrado
					,"Selecciona un Equipo" // Mensaje de la ventana
					,"Lista de Datos" // Titulo de la ventana
					,JOptionPane.QUESTION_MESSAGE // Icono
					,null //null para icono defecto de la ventana
					,opcionesEquipo // el objeto
					,opcionesEquipo[0] // posicion del que va aparecer seleccionado
					);
			
			for (Grupo grupo : listaGrupos) {
				
				opcionesGrupo[listaGrupos.indexOf(grupo)]=grupo.getNombre();
				
				for(Equipo equipo : grupo.getEquipos()) {
					if (equipo.getNombre().equals(opEquipo)) {
						JOptionPane.showMessageDialog(null, equipo);
					}
				}
			}
			
			
			break;
			
		default:
			break;
		}
		}while(op1<4);
	}

	public static void menuApuesta(LinkedList<Grupo> listaGrupos,Torneo torneo, LinkedList<Premio> premios) {
		
		Icon iconoPor = new ImageIcon(Main.class.getResource("../img/portada.jpg"));
		int puntuacion=0,aux=0;
		String favorito,op1,op2;
		String[] opcionesGrupo= new String[4];
		String[] opcionesTorneo= new String[2];
		
		//Rellenamos la array con todos los equipos
		String [] opcionesEquipo= new String[32];
		for (Grupo grupo : listaGrupos) {
			
			for(Equipo equipo : grupo.getEquipos()) {
				opcionesEquipo[aux]=equipo.getNombre();
				aux++;
			}
		}
		//El usuario selecciona su equipo favorito
		favorito = (String) JOptionPane.showInputDialog(
				null // para que se muestre centrado
				,"Selecciona tu Equipo favorito.\n Cada vez que gane, obtendras 3 puntos extra." // Mensaje de la ventana
				,"Lista de Equipos" // Titulo de la ventana
				,JOptionPane.QUESTION_MESSAGE // Icono
				,null //null para icono defecto de la ventana
				,opcionesEquipo // el objeto
				,opcionesEquipo[0] // posicion del que va aparecer seleccionado
				);
		
		for (Grupo grupo : listaGrupos) {
			//Rellenamos la array de opciones de equipo
			aux=0;
			for(Equipo equipo : grupo.getEquipos()) {
					opcionesGrupo[aux]=equipo.getNombre();
					aux++;
			}
			
			do {
				op1 = (String) JOptionPane.showInputDialog(
						null // para que se muestre centrado
						,"Elegi quien saldra primero del Grupo "+grupo.getNombre() // Mensaje de la ventana
						,"Lista de Equipos" // Titulo de la ventana
						,JOptionPane.QUESTION_MESSAGE // Icono
						,null //null para icono defecto de la ventana
						,opcionesGrupo // el objeto
						,opcionesGrupo[0] // posicion del que va aparecer seleccionado
						);
				op2 = (String) JOptionPane.showInputDialog(
						null // para que se muestre centrado
						,"Elegi quien saldra segundo del Grupo "+grupo.getNombre() // Mensaje de la ventana
						,"Lista de Equipos" // Titulo de la ventana
						,JOptionPane.QUESTION_MESSAGE // Icono
						,null //null para icono defecto de la ventana
						,opcionesGrupo // el objeto
						,opcionesGrupo[0] // posicion del que va aparecer seleccionado
						);
			
			if(op1.equals(op2)) {
				JOptionPane.showMessageDialog(null, "No podes elegir el mismo equipo dos veces...");
			}
			}while(op1.equals(op2));
			
			puntuacion+=Bookmaker.comprobarApuesta(grupo, op1, op2, favorito);
			
			JOptionPane.showMessageDialog(null, "Los resultados fueron: \n \n"
					+ "GRUPO "+grupo.getNombre()+": 1ro "+grupo.getPuesto1().getNombre()+"- 2do "+grupo.getPuesto2().getNombre()+
                    " \nPartidos: "+
                    grupo.getPartidos().get(0)+
                    grupo.getPartidos().get(1)+
                    grupo.getPartidos().get(2)+
                    grupo.getPartidos().get(3)+
                    grupo.getPartidos().get(4)+
                    grupo.getPartidos().get(5)+" \n \n"
                    		+ "Tu puntacion actual es: "+puntuacion);
		}
		
		//Resultados del torneo
		for(Partido partido : torneo.getOctavos()) {
			opcionesTorneo[0]=partido.getEquipo1();
			opcionesTorneo[1]=partido.getEquipo2();
			
			op1 = (String) JOptionPane.showInputDialog(
					null // para que se muestre centrado
					,"Elegi quien ganara y pasara a cuartos de final" // Mensaje de la ventana
					,"Lista de Equipos" // Titulo de la ventana
					,JOptionPane.QUESTION_MESSAGE // Icono
					,null //null para icono defecto de la ventana
					,opcionesTorneo // el objeto
					,opcionesTorneo[0] // posicion del que va aparecer seleccionado
					);
			
			puntuacion+=Bookmaker.comprobarApuesta(partido, op1, favorito);
			if(partido.getGoles1()==partido.getGoles2()) {
				JOptionPane.showMessageDialog(null, "Los resultados del partido: \n"
						+ partido +" \n \n"
						+" \nGano "+partido.getGanador()+" por penales."
	                    + " \nTu puntacion actual es: "+puntuacion);
			}else {
				JOptionPane.showMessageDialog(null, "Los resultados del partido: \n"
						+ partido +" \n \n"
						+" \nGano "+partido.getGanador()
	                    + " \nTu puntacion actual es: "+puntuacion);
			}
			
		}
		for(Partido partido : torneo.getCuartos()) {
			opcionesTorneo[0]=partido.getEquipo1();
			opcionesTorneo[1]=partido.getEquipo2();
			
			op1 = (String) JOptionPane.showInputDialog(
					null // para que se muestre centrado
					,"Elegi quien ganara y pasara a semifinales" // Mensaje de la ventana
					,"Lista de Equipos" // Titulo de la ventana
					,JOptionPane.QUESTION_MESSAGE // Icono
					,null //null para icono defecto de la ventana
					,opcionesTorneo // el objeto
					,opcionesTorneo[0] // posicion del que va aparecer seleccionado
					);
			
			puntuacion+=Bookmaker.comprobarApuesta(partido, op1, favorito);
			if(partido.getGoles1()==partido.getGoles2()) {
				JOptionPane.showMessageDialog(null, "Los resultados del partido: \n"
						+ partido +" \n \n"
						+" \nGano "+partido.getGanador()+" por penales."
	                    + " \nTu puntacion actual es: "+puntuacion);
			}else {
				JOptionPane.showMessageDialog(null, "Los resultados del partido: \n"
						+ partido +" \n \n"
						+" \nGano "+partido.getGanador()
	                    + " \nTu puntacion actual es: "+puntuacion);
			}
			
		}
		for(Partido partido : torneo.getSemifinales()) {
			opcionesTorneo[0]=partido.getEquipo1();
			opcionesTorneo[1]=partido.getEquipo2();
			
			op1 = (String) JOptionPane.showInputDialog(
					null // para que se muestre centrado
					,"Elegi quien ganara y pasara a la final" // Mensaje de la ventana
					,"Lista de Equipos" // Titulo de la ventana
					,JOptionPane.QUESTION_MESSAGE // Icono
					,null //null para icono defecto de la ventana
					,opcionesTorneo // el objeto
					,opcionesTorneo[0] // posicion del que va aparecer seleccionado
					);
			
			puntuacion+=Bookmaker.comprobarApuesta(partido, op1, favorito);
			if(partido.getGoles1()==partido.getGoles2()) {
				JOptionPane.showMessageDialog(null, "Los resultados del partido: \n"
						+ partido +" \n \n"
						+" \nGano "+partido.getGanador()+" por penales."
	                    + " \nTu puntacion actual es: "+puntuacion);
			}else {
				JOptionPane.showMessageDialog(null, "Los resultados del partido: \n"
						+ partido +" \n \n"
						+" \nGano "+partido.getGanador()
	                    + " \nTu puntacion actual es: "+puntuacion);
			}
			
		}
		for(Partido partido : torneo.getFinales()) {
			opcionesTorneo[0]=partido.getEquipo1();
			opcionesTorneo[1]=partido.getEquipo2();
			
			op1 = (String) JOptionPane.showInputDialog(
					null // para que se muestre centrado
					,"Elegi quien ganara la final" // Mensaje de la ventana
					,"Lista de Equipos" // Titulo de la ventana
					,JOptionPane.QUESTION_MESSAGE // Icono
					,null //null para icono defecto de la ventana
					,opcionesTorneo // el objeto
					,opcionesTorneo[0] // posicion del que va aparecer seleccionado
					);
			
			puntuacion+=Bookmaker.comprobarApuesta(partido, op1, favorito);
			if(partido.getGoles1()==partido.getGoles2()) {
				JOptionPane.showMessageDialog(null, "Los resultados del partido: \n"
						+ partido +" \n \n"
						+" \nGano "+partido.getGanador()+" por penales."
	                    + " \nTu puntacion actual es: "+puntuacion);
			}else {
				JOptionPane.showMessageDialog(null, "Los resultados del partido: \n"
						+ partido +" \n \n"
						+" \nGano "+partido.getGanador()
	                    + " \nTu puntacion actual es: "+puntuacion);
			}
			
			if(puntuacion == 108) {
				Bookmaker.entregarPremio(puntuacion, premios);
				JOptionPane.showMessageDialog(null, "Tu puntacion final es: "+puntuacion
						+" \nFelicidades, obtuviste la puntuacion perfecta,\n"
						+ "conseguiste todos los premios ademas del secreto.");
			}else if(puntuacion == 0) {
				Bookmaker.entregarPremio(puntuacion, premios);
				JOptionPane.showMessageDialog(null, "Tu puntacion final es: "+puntuacion
						+" \nNo acertaste ni una sola, es casi tan pro-\n"
						+ "vable como acertar todas, te ganaste un pre-\n"
						+ "mio de consolacion.");
			}else {
				Bookmaker.entregarPremio(puntuacion, premios);
				JOptionPane.showMessageDialog(null, "Tu puntacion final es: "+puntuacion
						+" \nFelicidades, ganaste "+(int)(puntuacion/3)+" premios. \n"
								+ "Te toco...");
			}
			
			for(Premio premio : premios) {
				JOptionPane.showMessageDialog(null, premio, "Simulador Mundial: Premio", 0, new ImageIcon(Main.class.getResource("../img/"+premio.getImagen())));
			}
			
		}
		
	}
}

