package myp.proyecto2.model;
/**
 * Clase para tener las recetas
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
import java.util.LinkedList;

public abstract class Recetario implements Sujeto{

	protected BaseDatosRecetas recetario;
	protected BaseDatosChefs chefs;

	public Recetario(String directorio){
		recetario = new BaseDatosRecetas();
		chefs = new BaseDatosChefs();
		recetario.carga(directorio);
		chefs.carga(directorio);
	}

	/**Agrega una receta al recetario del chef
	 * @param registro la receta a agregar
	 */
	public void agrega(Receta receta){
		recetario.agregaRegistro(receta);
		recetario.guarda();
		notificar();
	}

	@Override
    public void agrega(Chef chef){
		chefs.agregaRegistro(chef);
		chefs.guarda();
	}

	@Override
    public void elimina(Chef chef){
		chefs.eliminaRegistro(chef);
		chefs.guarda();
	}

	/**
    * Actualiza las recetas de los sujetos
    * @param receta la nueva receta
     */
	@Override
	public void notificar() {
	    for(Chef c : chefs.getRegistros())
			c.actualizar();
	}

	public LinkedList<Receta> getRecetas(){
		return recetario.getRegistros();
	}

	public BaseDatosRecetas getRecetario(){
		return recetario;
	}

	public BaseDatosChefs getChefs(){
		return chefs;
	}
}
