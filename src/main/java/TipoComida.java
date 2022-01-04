import java.util.Iterator;
import java.util.LinkedList;

public abstract class TipoComida{

    private LinkedList<Receta> recetas;

    
    public LinkedList<Receta> getRecetas(){
        return recetas;
    }

    public void agregaReceta(Receta receta){
        recetas.add(receta);
    }

    public void mostrarRecetas(){
        Iterator<Receta> it = recetas.iterator();
        while(it.hasNext())
            System.out.println(it.next().mostrarReceta());
    }


    public abstract Receta busca(String nombre);

    public abstract Receta busca(Ingrediente[] nombre);

    public abstract Receta busca(int tiempo);

}