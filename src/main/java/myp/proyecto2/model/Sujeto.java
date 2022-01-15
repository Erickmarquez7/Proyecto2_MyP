package myp.proyecto2.model;
/**
 * Clase para los sujetos 
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public interface Sujeto {
    /**
    * Actualiza las recetas de los sujetos
    * @param receta la nueva receta
     */
    public void notificar();

    public void agrega(Chef chef);

    public void elimina(Chef chef);

}
