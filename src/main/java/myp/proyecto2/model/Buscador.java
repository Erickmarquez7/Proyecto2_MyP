package myp.proyecto2.model;

import java.util.LinkedList;

public interface Buscador{

    public LinkedList<Receta> busca(String cadena, LinkedList<Receta> base);

    public String mostrarBusqueda();
}