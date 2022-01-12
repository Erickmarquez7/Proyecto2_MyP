package myp.proyecto2.model;

import java.util.LinkedList;

public class Recetario implements Sujeto{

	private BaseDatosRecetas recetario;
	private BaseDatosChefs chefs;

	public Recetario(){
		recetario = new BaseDatosRecetas();
		recetario.carga();
	}

	public void agrega(Receta registro){
		recetario.agregaRegistro(registro);
		actualiza();
	}

	@Override
	public void actualiza() {
		
	}

}