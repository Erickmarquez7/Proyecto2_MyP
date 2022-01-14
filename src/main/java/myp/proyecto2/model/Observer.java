package myp.proyecto2.model;
/**
 * interfaz para los observadores
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public interface Observer {

    public void agrega(Recetario receta);

    public void elimina(Recetario receta);

    public void notifica();
}