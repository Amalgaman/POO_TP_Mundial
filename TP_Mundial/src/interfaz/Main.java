package interfaz;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.LinkedList;

import javax.swing.*;

import logica.*;

class Main {

	public static void main(String[] args) {
		
		boolean tCargado=false;
		String []opciones1={"Jugar Mundial","Ver Resultados","Salir"};
		int op1;
		//metemos imagenes
		Icon iconoPor = new ImageIcon(Main.class.getResource("../img/portada.jpg"));
		Icon iconoSim = new ImageIcon(Main.class.getResource("../img/simulacion.png"));
		
		//instancio los grupos y el torneo
		LinkedList<Grupo> listaGrupos = new LinkedList<Grupo>();
		cargarGrupos(listaGrupos);
		Torneo torneo = new Torneo(1);
		
		
		do {
			op1 = JOptionPane.showOptionDialog(null, "Bienvenido, selecciona una opcion", null, 0, 0, iconoPor, opciones1, opciones1);
			
			switch(op1) {
			case 0:
				Admin.completarResultados(listaGrupos,torneo);
				tCargado=true;
				JOptionPane.showMessageDialog(null,"Simulacion de partidos completada!", "Simulando...", JOptionPane.PLAIN_MESSAGE, iconoSim);
				break;
			case 1:
				if(tCargado) {
				    menuResultado(listaGrupos,torneo);	
				}else {
					JOptionPane.showMessageDialog(null, "Aun no se ha jugado el mundial...");
					op1 = 0;
				}
				break;
			default:
				
				break;
			}
			
		}while(op1<2);
			
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
	
	public static void  menuResultado(LinkedList<Grupo> listaGrupos,Torneo torneo) {
		int op1,aux=0;
		String []opciones1={"Grupos","Torneo","Equipos","Salir"};
		String []opcionesGrupo= new String[listaGrupos.size()];
		String opGrupo,opEquipo;
		String []opcionesEquipo= new String[32];
		Icon iconoPor = new ImageIcon(Main.class.getResource("../img/copita.jpg"));
		
		//completo opcionesGrupo y opcionesEquipo
		for (Grupo grupo : listaGrupos) {
			
			opcionesGrupo[listaGrupos.indexOf(grupo)]=grupo.getNombre();
			
			for(Equipo equipo : grupo.getEquipos()) {
				opcionesEquipo[aux]=equipo.getNombre();
				aux++;
			}
		}
		
		
		do {
		op1 = JOptionPane.showOptionDialog(null, "Que resultados queres ver?", null, 0, 0, iconoPor, opciones1, opciones1);
		
		switch(op1) {
		
		case 0:
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
		case 1:
			
			JOptionPane.showMessageDialog(null, torneo);
			
			break;
			
		case 2:
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
		}while(op1<3);
	}
}

