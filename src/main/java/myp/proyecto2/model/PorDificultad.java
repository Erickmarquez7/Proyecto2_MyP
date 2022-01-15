package myp.proyecto2.model;

import java.util.LinkedList;

public class PorDificultad extends Buscador{

   /**
     * Busca em una base de datos las recetas
     * @param cadena el valor a buscar
     * @param recetario la base de datos donde buscar
     * @return las coincidencia encontradas
     */
	@Override
	public LinkedList<Receta> busca(String cadena, Recetario recetario) {
    int dificulatad;
    try{
      dificulatad = Integer.parseInt(cadena);
    }catch (NumberFormatException nfe){
      return null;
    }
		return recetario.getRecetario().buscaRegistros(CampoBuscador.DIFICULTAD, dificulatad);
	}
}