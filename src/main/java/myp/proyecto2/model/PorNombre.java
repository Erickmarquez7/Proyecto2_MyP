package myp.proyecto2.model;

import java.util.LinkedList;
import java.util.Iterator;

public class PorNombre extends Buscador{

   /**
     * Busca em una base de datos las recetas
     * @param cadena el valor a buscar
     * @param recetario la base de datos donde buscar
     * @return las coincidencia encontradas
     */
	@Override
	public LinkedList<Receta> busca(String cadena, Recetario recetario) {
		return recetario.getRecetario().buscaRegistros(CampoBuscador.NOMBRE, cadena);
		/*
		LinkedList<Receta> recetas = new LinkedList<Receta>();

		Iterator<Receta> it = recetario.getRecetas().iterator();
		while(it.hasNext()){
			Receta receta = it.next();
			String nombre = receta.getNombre();
			if(cadena.equals(cadena))
			recetas.add(receta);
		}

		return recetas;
		*/
	}

}