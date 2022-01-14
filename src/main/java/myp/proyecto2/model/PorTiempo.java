package myp.proyecto2.model;

import java.util.LinkedList;

public class PorTiempo extends Buscador{

   /**
     * Busca em una base de datos las recetas
     * @param cadena el valor a buscar
     * @param recetario la base de datos donde buscar
     * @return las coincidencia encontradas
     */
	@Override
	public LinkedList<Receta> busca(String cadena, Recetario recetario) {
		return recetario.getRecetario().buscaRegistros(CampoBuscador.NOMBRE, cadena);
	}

}