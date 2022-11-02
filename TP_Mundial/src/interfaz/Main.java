package interfaz;

import java.util.LinkedList;

import logica.Admin;
import logica.Grupo;

class Main {

	public static void main(String[] args) {
		
		LinkedList<Grupo> listaGrupos = new LinkedList<Grupo>();
		listaGrupos.add(new Grupo(1,"A"));
		listaGrupos.add(new Grupo(2,"B"));
		listaGrupos.add(new Grupo(3,"C"));
		listaGrupos.add(new Grupo(4,"D"));
		listaGrupos.add(new Grupo(5,"E"));
		listaGrupos.add(new Grupo(6,"F"));
		listaGrupos.add(new Grupo(7,"G"));
		listaGrupos.add(new Grupo(8,"H"));
		
		for(Grupo grupo : listaGrupos) {
			System.out.println(grupo);
		}
		
		for(Grupo grupo : listaGrupos) {
			Admin.cargarResultados(grupo);
			grupo.calcularPuestos();
			System.out.println(grupo);
		}

	}

}
