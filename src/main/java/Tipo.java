import java.util.LinkedList;
import java.util.Iterator;

public class Tipo extends Comida{

    private LinkedList<Comida> comidas;
    private String nombre;
    private String descripcion;

    public Tipo(String nombre, String descipcion){
        this.nombre = nombre;
        this.descripcion = descipcion;
    }

    public String getNombre(){
        return nombre;
    }

    public String descripcion(){
        return descripcion;
    }


    public String mostrarComida(){
        String res="";
        Iterator<Comida> it = comidas.iterator();
        while(it.hasNext()){
            Comida c = it.next();
            res += c.mostrarComida();    
        }
        return res;
    }


    public Comida buscarReceta(String nombre){
        return null;
        
    }


    public void agregaReceta(Comida comida){
        comidas.add(comida);
    }


}