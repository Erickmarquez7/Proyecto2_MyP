package myp.proyecto2.model;

public interface Observer {

    public void agrega(Receta receta);

    public void elimina(Receta receta);

    public void notifica();
}