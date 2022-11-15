import java.util.LinkedList;


import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Libros libro = new Libros(1,"12 reglas para vivir");
		Libros libro2 = new Libros(2,"Clean code");
		Libros libro3 = new Libros(3,"Gaturro");
		
		LinkedList<Libros> libreria = new LinkedList<Libros>();
		//imprimir(libreria);
		
		libreria.add(libro);
		libreria.add(0,libro2);
		libreria.add(libro3);
		int cont=0;
		int flag=1000000000;
		for (int i = 0; i < flag; i++) {
			
			String nombrenuevo = JOptionPane.showInputDialog("Ingrese nombre de libro");
			if(nombrenuevo==null || nombrenuevo.equals("0") || nombrenuevo.equals("")) {
				i=1000000000;
			}
			libreria.add(new Libros(cont++,nombrenuevo));
			
			
			
		}
		
		
		LinkedList<String> autores = new LinkedList<String>();

		LinkedList<String> autoresA = new LinkedList<String>();
		
	//	imprimir(libreria);
		
		for (Libros libros : libreria) {
					
					if(libros.getNombre().startsWith("A")) {
						autoresA.add(libros.getNombre());
					}
		}
		
		imprimirAutores(autoresA);

		
		
		String []aux2= new String[libreria.size()];
		
		
			for (Libros libros : libreria) {
				
				aux2[libreria.indexOf(libros)]=libros.getNombre();
			}
				
				
		
		
		String opcion = (String) JOptionPane.showInputDialog(
				null // para que se muestre centrado
				,"Seleccione de Datos" // Mensaje de la ventana
				,"Lista de Datos" // Titulo de la ventana
				,JOptionPane.QUESTION_MESSAGE // Icono
				,null //null para icono defecto de la ventana
				,aux2 // el objeto
				,aux2[0] // posicion del que va aparecer seleccionado
				);
		
		JOptionPane.showMessageDialog(null, opcion);
		
		String aux =  "Clean code";
		
		if(autores.contains(aux)){
			System.out.println("La lista contiene " + aux );
		}else{
			System.out.println("No contiene el elemnto buscado");
		}
		
		
		
		System.out.println("La liberia tiene: "+libreria.size()+ " libros");
	
		//Borrar(libreria,"Clean code");
		
		
		CambiarElemento(libreria,libro3,1);
		
		imprimirLibros(libreria);
		
		System.out.println("La liberia tiene: "+libreria.size()+ " libros");
		
	
	/*
	        List<String> list = Arrays.asList("RED","BLUE","BLACK","GREEN","BROWN");
	 
	        // Java 7 y anteriores:
	 
	        // crea una lista vacía
	        List<String> filteredList = new ArrayList<>();
	 
	        // iterar a través de la lista
	        for (String entry: list)
	        {
	            // filtrar valores que comienzan con `B`
	            if (entry.startsWith("B")) {
	                filteredList.add(entry);
	            }
	        }
	 
	        System.out.println(filteredList);
	 */
	}
	
	public static void imprimirLibros(LinkedList<Libros> lista) {
			
			if(lista.isEmpty()) {
				System.out.println("La lista se encuentra vacía");
			}else {
		    for (Libros elemento : lista)
		        System.out.print(elemento.getNombre() + " - ");
		    System.out.println();
			}
	}
	
	public static void imprimirAutores(LinkedList<String> lista) {
		
		if(lista.isEmpty()) {
			System.out.println("La lista se encuentra vacía");
		}else {
	    for (String elemento : lista)
	        System.out.print(elemento + " - ");
	    System.out.println();
		}
}
	
	public static /*Libros*/ void BuscarxNombre(LinkedList<Libros> lista,String nombre) {
		
		if(lista.isEmpty()) {
			System.out.println("La lista se encuentra vacía");
		}else {
	    for (Libros elemento : lista)
	        if(elemento.getNombre().equals(nombre)) {
	        	System.out.println(elemento);
	        	System.out.println(lista.indexOf(elemento));
	        	//return elemento;
	        }
		}
		//return null;
	}
	
	public static void Borrar(LinkedList<Libros> lista,String nombre) {
		if(lista.isEmpty()) {
			System.out.println("La lista se encuentra vacía");
		}else {
	    for (Libros elemento : lista)
	        if(elemento.getNombre().equals(nombre)) {
	        	System.out.println("removio el elemento: "+elemento.getNombre());        	
	        	lista.remove(lista.indexOf(elemento));
	        }
		}
	}
	
	public static void CambiarElemento(LinkedList<Libros> lista,Libros Libro,int indice) {
		
		if(lista.isEmpty()) {
			System.out.println("La lista se encuentra vacía");
		}else {
			lista.set(indice, Libro);
	        }
		}
}
