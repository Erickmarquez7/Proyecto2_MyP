package myp.proyecto2.model;

import java.util.Iterator;
import java.util.LinkedList;
/**
 * Clase para Recerta que
 * implementan registro pues es un objeto "agregable" a la base de datos
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */


public class Receta implements Registro<Receta,CampoBuscador>{

    private String nombre;
    private LinkedList<Ingrediente> ingredientes;
    private LinkedList<String> instrucciones;
    private int tiempo;
    private int dificultad;
    private Receta registro;


    public Receta(String nombre, LinkedList<Ingrediente> ingredientes, 
    LinkedList<String> instrucciones, int tiempo, int dificultad){
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
        this.tiempo = tiempo;
        this.dificultad = dificultad;
    }

    public Receta(String nombre){
        this.nombre=nombre;
    }

    /*

    public Receta(String nombre, LinkedList<Ingrediente> ingredientes, 
    String instrucciones, int tiempo, int dificultad){
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.instrucciones = cambiaInstruccion(instrucciones);
        this.tiempo = tiempo;
        this.dificultad = dificultad;
    }

    public Receta(String nombre, String ingredientes, 
    LinkedList<String> instrucciones, int tiempo, int dificultad){
        this.nombre = nombre;
        this.ingredientes = cambiaIngrediente(ingredientes);
        this.instrucciones = instrucciones;
        this.tiempo = tiempo;
        this.dificultad = dificultad;
    }

    public Receta(String nombre, String ingredientes, 
    String instrucciones, int tiempo, int dificultad){
        this.nombre = nombre;
        this.ingredientes = cambiaIngrediente(ingredientes);
        this.instrucciones = cambiaInstruccion(instrucciones);
        this.tiempo = tiempo;
        this.dificultad = dificultad;
    }
    */
    //public Receta(String receta){
	//deserializa(receta);
    //}

    public LinkedList<Ingrediente> cambiaIngrediente(String ings){
        LinkedList<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
        if(ings == null)
            throw new ExcepcionRegistroInvalido();

        ings = ings.trim();
        String[] ingrediente = ings.split(",");
        for(String s : ingrediente)
            ingredientes.add(new Ingrediente(s));
        return ingredientes;
    }

    public LinkedList<String> cambiaInstruccion(String ins){
        LinkedList<String> instrucciones = new LinkedList<>();
        if(ins == null)
            throw new ExcepcionRegistroInvalido();

        ins = ins.trim();
        String[] instruccion = ins.split("\n");
        for(String s : instruccion)
            instrucciones.add(s);
        return instrucciones;
    }

    public String getNombre(){
        return nombre;
    }

    public LinkedList<Ingrediente> getIngredientes(){
        return ingredientes;
    }

    public LinkedList<String> getInstrucciones(){
        return instrucciones;
    }

    public int getTiempo(){
        return tiempo;
    }

    public int getDificultad(){
        return dificultad;
    }

    
    /**
     * Regresa el registro serializado en una línea de texto.
     * @return la serialización del registro en una línea de texto.
     */
    @Override
    public String serializa() {
        return String.format("%s/%s/%s/%d/%d",nombre,serializaIngredientes(),
        serializaInstrucciones(),tiempo, dificultad);
    }


    /**
    * Metodo auxiliar para serializar las instrucciones
    * @return  las intrucciones serializadas
    */
    public String serializaIngredientes(){
        String s = "";
        for(Ingrediente i : ingredientes)
            s += String.format("%s,",i.serializa());
        return s;
    }


    /**
    * Metodo auxiliar para serializar las instrucciones
    * @return  las intrucciones serializadas
     */
    public String serializaInstrucciones(){
        String s = "";
        for(String i : instrucciones)
            s += String.format("%s,",i);
        return s;
    }


    /**
     * Deserializa una línea de texto en las propiedades del registro.
     * @param registro la línea a deserializar.
     * @throws ExcepcionLineaInvalida si la línea recibida es nula, vacía o no
     *         es una serialización válida de un registro.
     */
    @Override
    public void deserializa(String registro) {
        if(registro == null)
            throw new ExcepcionRegistroInvalido("El registro es nulo");

        registro = registro.trim();
        String[] params = registro.split("/");

	System.out.println("Cheto" + params.length);
	for(int i = 0; i < params.length; i++) System.out.println(params[i]);
        if(params.length != 5)
            throw new ExcepcionRegistroInvalido("Número de parámetros no válido.");

        try{
            nombre = params[0];
            if(params[1] != null)
                deserializaIngredientes(params[1]);
            else
                ingredientes = new LinkedList<>();
            deserializaInstrucciones(params[2]);
            tiempo = Integer.parseInt(params[3]);
            dificultad  = Integer.parseInt(params[4]);
        }catch (NumberFormatException nfe){
            throw new ExcepcionRegistroInvalido("Registro no válido");
        }
    }


    /**
    * Metodo auxiliar para deserializar los ingredientes
    *@param ings los ingredientes a deserializar
     */
    public void deserializaIngredientes(String ings){
        ingredientes = new LinkedList<Ingrediente>();
        ings = ings.trim();
        String[] ingr = ings.split(",");
	System.out.println(ingr.length);
        for(String e : ingr){
	    Ingrediente aux = new Ingrediente(null,null,0.0,0);
	    aux.deserializa(e);
            ingredientes.add(aux);
	System.out.println(e);}
    }


    /**
    * Metodo auziliar para deserializar las intrucciones
    * @param ins las instrucciones a deserializar
     */
    public void deserializaInstrucciones(String ins){
        instrucciones = new LinkedList<String>();
        ins = ins.trim();
        String[] inst = ins.split(",");
        for(String e : inst)
            instrucciones.add(e);
    }


    /**
    * Actualiza los valores del registro con los del registro recibido.
     * @param registro el registro con el cual actualizar los valores.
     * @throws ClassCastException si el registro no es de la instancia correcta.
     */
    @Override
    public void actualiza(Receta registro) {
        this.registro = registro;
        if(!(registro instanceof Receta))
            throw new ExcepcionRegistroInvalido();
        
        Receta receta = (Receta)registro;
        this.nombre = receta.nombre;
        this.ingredientes = receta.ingredientes;
        this.instrucciones = receta.instrucciones;
        this.dificultad = receta.dificultad;
        this.tiempo = receta.tiempo;
    }

    
    public String mostrarComida() {
        return toString();
    }

    
    public Receta buscarReceta(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }


    
    public void agregaReceta(Receta comida) {
        // TODO Auto-generated method stub
        
    }

    public String getTiempoString(){
        int horas = tiempo/60;
        String plural = horas == 1 ? "hr" : "hrs";
        if(horas > 0)
            return String.format("%d %s %d min\n", horas, plural, tiempo%60);
        else
            return String.format("%d min\n", tiempo);
    }

    @Override
    public String toString(){
        String s = "\n<<< " + nombre + " >>>\n";

        s += "\tIngredientes:";
        for(Ingrediente i : ingredientes)
            s+="\n\t\t> " + i.toString();

        s += "\n\tPreparación:";
        for(String q : instrucciones)
            s += "\n\t\t> " + q;

        if(dificultad > 5)
            dificultad = 5;
        else if(dificultad < 0)
            dificultad = 0;
        s += "\n\tDificultad: ";
        for(int i = 0; i < dificultad; i++)
            s+= "*";

        s +="\n\tTiempo estimado de preparación: ";
        int horas = tiempo/60;
        String plural = horas == 1 ? "hr" : "hrs";
        if(horas > 0)
            s += String.format("%d %s %d min\n", horas, plural, tiempo%60);
        else
            s += String.format("%d min\n", tiempo);

        return s;
    }


    /**
     * Nos dice si el registro caza el valor dado en el campo especificado.
     * @param campo el campo que hay que cazar.
     * @param valor el valor con el que debe cazar el campo del registro.
     */
    @Override
    public boolean caza(CampoBuscador campo, Object valor) {
        if(campo == null)
            throw new IllegalArgumentException();

        switch(campo){
            case NOMBRE:
                if(valor instanceof String){
                    String nombre = (String)valor;
                    return getNombre().contains(nombre) && !nombre.equals("");
                }break;
            case INGREDIENTES:
                if(valor instanceof String){
                    return cazaIngredientes((String)valor);
                }break;
            case INSTRUCCIONES: // Este buscador no se va a aplicar
                if(valor instanceof String){
                    String ins = (String)valor;
                    return !ins.equals("") && getInstrucciones().contains(ins);
                }break;
            case TIEMPO:
                if(valor instanceof Integer){
                    int tiempo = (int)valor;
                    return tiempo >= 0 && (getTiempo() <= tiempo);
                }break;
            case DIFICULTAD:
                if(valor instanceof Integer){
                    int dificultad = (int)valor;
                    return (dificultad >= 0 && dificultad < 6) && (getDificultad() <= dificultad);
                }break;
        }
        return false;
    }

    private boolean cazaIngredientes(String ingrediente){
        String[] ings = ingrediente.trim().split(",");
        Iterator<Ingrediente> it = getIngredientes().iterator();
        while(it.hasNext()){
            Ingrediente ing = it.next();
            for(int i = 0; i < ings.length; i++)
                if(ing.getNombre().contains(ings[i]))
                    return true;
        }
        return false;
    }
}
