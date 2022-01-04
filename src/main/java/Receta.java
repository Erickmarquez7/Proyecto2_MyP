import java.util.Iterator;
import java.util.LinkedList;

public class Receta{
    private String nombre;
    private LinkedList<Ingrediente> ingredientes;
    private String receta;
    private int tiempo;
    private String dificultad;

    public Receta(String nombre, LinkedList<Ingrediente> ingredientes, 
                int tiempo, String dificultad){
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.tiempo = tiempo;
        this.dificultad = dificultad;
    }


    public void agregaReceta(String receta){
        this.receta = receta;
    }


    public String getNombre(){
        return nombre;
    }


    public LinkedList<Ingrediente> listaIngredientes(){
        return ingredientes;
    }


    public Iterator<Ingrediente> getIterator(){
        return ingredientes.iterator();
    }


    public String getIngredientes(){
        String res = "";
        Iterator<Ingrediente> it = getIterator();
        while(it.hasNext()){
            res+= it.next().getNombre();
        }
        return res;
    }


    public int getTiempo(){
        return tiempo;
    }


    public String getDificultad(){
        return dificultad;
    }


    public String mostrarReceta(){
        return receta;
    }
    
}