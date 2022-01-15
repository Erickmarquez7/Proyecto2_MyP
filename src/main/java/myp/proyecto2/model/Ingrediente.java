package myp.proyecto2.model;
/**
 * Clase para los ingredientes de las recetas
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public class Ingrediente {
    private String nombre;
    private Medida medida;
    private double cantidad;

    public Ingrediente(String nombre, Medida medida, double cantidad, int porciones){
        this.nombre = nombre;
        this.medida = medida;
        this.cantidad = cantidad;
    }

    public Ingrediente(String ingredienteSer){
        deserializa(ingredienteSer);
    }

    @Override
    public String toString(){
	return String.format("%s   %.1f  %s", nombre, cantidad, medida.toString());
    }


    /**
     * Regresa el registro serializado en una línea de texto.
     * @return la serialización del registro en una línea de texto.
     */
    public String serializa(){
        return String.format("%s-%s-%.3f", nombre, medida.valor(), cantidad);
    }


    /**
     * Deserializa una línea de texto en las propiedades del registro.
     * @param registro la línea a deserializar.
     * @throws ExcepcionLineaInvalida si la línea recibida es nula, vacía o no
     *         es una serialización válida de un registro.
     */
    public void deserializa(String registro){
        if(registro == null)
            throw new ExcepcionRegistroInvalido("El registro es nulo.");

        registro = registro.trim();
        String[] campos = registro.split("-");
	//System.out.println("Campos <- " + campos.length);
	//for(int i = 0; i < campos.length; i++)
	//System.out.println("Ingrediente deserializa" + campos[i]);
        if(campos.length != 3){
            throw new ExcepcionRegistroInvalido("Registro no válido.");
        }
        try{
            this.nombre = campos[0];
            this.medida = Medida.valueOf(campos[1]);
            this.cantidad = Double.parseDouble(campos[2]);
        }catch (NumberFormatException nfe){
            throw new ExcepcionRegistroInvalido("Registro no válido 2.");
        }
    }

    public String getNombre(){
	return nombre;
    }
}
