package myp.proyecto2.model;

import java.util.LinkedList;

public abstract class Recetario implements Sujeto{

	private BaseDatosRecetas recetario;
	private BaseDatosChefs chefs;

	public Recetario(String directorio){
		recetario = new BaseDatosRecetas();
		chefs = new BaseDatosChefs();
		recetario.carga(directorio);
		chefs.carga(directorio);
	}

	public void agrega(Receta registro){
		recetario.agregaRegistro(registro);
		actualiza(registro);
	}

	@Override
	public void actualiza(Receta receta) {
	    for(Chef c : chefs.getRegistros())
		c.notifica();
	}
}
