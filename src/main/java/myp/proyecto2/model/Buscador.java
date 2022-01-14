package myp.proyecto2.model;

import java.util.LinkedList;
import java.util.Iterator;
/**
 * Clase abstracta para buscar por diferentes opciones
 * aqui se implementa strategy
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public abstract class Buscador{
    //guarda las coincidencias 
    protected LinkedList<Receta> resultado;

    /**
     * Busca em una base de datos las recetas
     * @param cadena el valor a buscar
     * @param recetario la base de datos donde buscar
     * @return las coincidencia encontradas
     */
    public abstract LinkedList<Receta> busca(String cadena, Recetario recetario);


    /**
    * Devuelve el resultado de la busqueda
    * @return el resultado de la busqueda
     */
    public String mostrarBusqueda(){
        Iterator<Receta> it = resultado.iterator();
        String s = "";
        while(it.hasNext())
            s += it.next().toString() + "\n";
        return s;
    }
}