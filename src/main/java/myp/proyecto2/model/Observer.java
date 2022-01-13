package myp.proyecto2.model;

public interface Observer {

    public void agrega(Recetario receta);

    public void elimina(Recetario receta);

    public void notifica();
}