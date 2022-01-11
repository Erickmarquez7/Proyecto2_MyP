import java.util.Iterator;
import java.util.LinkedList;

public class Receta implements Registro{

    private String nombre;
    private LinkedList<Ingrediente> ingredientes;
    private LinkedList<String> instrucciones;
    private int tiempo;
    private int dificultad;


    public Receta(String nombre, LinkedList<Ingrediente> ingredientes, 
    LinkedList<String> instrucciones, int tiempo, int dificultad){
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
        this.tiempo = tiempo;
        this.dificultad = dificultad;
    }

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

    @Override
    public String serializa() {
        return String.format("%s/%s/%s/%d/%d",nombre,serializaIngredientes(),
        serializaInstrucciones(), dificultad, tiempo);
    }

    public String serializaIngredientes(){
        String s = "";
        for(Ingrediente i : ingredientes)
            s += String.format("%s,",i.serializa());
        return s;
    }

    public String serializaInstrucciones(){
        String s = "";
        for(String i : instrucciones)
            s += String.format("%s,",i);
        return s;
    }

    @Override
    public void deserializa(String registro) {
        if(registro == null)
            throw new ExcepcionRegistroInvalido("El registro es nulo");

        registro = registro.trim();
        String[] params = registro.split("/");

        if(params.length != 5)
            throw new ExcepcionRegistroInvalido("Número de parámetros no válido.");

        try{
            nombre = params[0];
            deserializaIngredientes(params[1]);
            deserializaInstrucciones(params[2]);
            dificultad  = Integer.parseInt(params[3]);
            tiempo = Integer.parseInt(params[4]);
        }catch (NumberFormatException nfe){
            throw new ExcepcionRegistroInvalido("Registro no válido");
        }
    }

    public void deserializaIngredientes(String ings){
        ingredientes = new LinkedList<Ingrediente>();
        ings = ings.trim();
        String[] ingr = ings.split(",");
        for(String e : ingr)
            ingredientes.add(new Ingrediente(e));
    }

    public void deserializaInstrucciones(String ins){
        instrucciones = new LinkedList<String>();
        ins = ins.trim();
        String[] inst = ins.split(",");
        for(String e : inst)
            instrucciones.add(e);
    }


    @Override
    public void actualiza(Registro registro) {
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
}