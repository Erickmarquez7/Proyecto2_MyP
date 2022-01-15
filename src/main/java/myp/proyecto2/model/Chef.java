package myp.proyecto2.model;
/**
 * Clase para cheefs que son observadore y están al tanto de 
 * implementan registro pues es un objeto "agregable" a la base de datos
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public class Chef implements Registro<Chef,CampoChef>, Observer{

    private String nombre;
    private String ubicacion;
    private int numero;

    public Chef(String nombre, String ubicacion, int numero){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.numero = numero;
    }

    public String getNombre(){
        return nombre;
    }

    public String getUbicacion(){
        return ubicacion;
    }

    public int getNumero(){
        return numero;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    /**
     * Regresa el registro serializado en una línea de texto.
     * @return la serialización del registro en una línea de texto.
     */
    @Override
    public String serializa() {
        return String.format("%s/%s/%d\n", nombre, ubicacion, numero);
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
            throw new ExcepcionRegistroInvalido();

        registro = registro.trim();
        String[] params = registro.split("/");

        if(params.length != 3)
            throw new ExcepcionRegistroInvalido();

        try{
            nombre = params[0];
            ubicacion = params[1];
            numero = Integer.parseInt(params[2]);
        }catch (NumberFormatException nfe){
            throw new ExcepcionRegistroInvalido();
        }
        
    }

    /**
     * Actualiza los valores del registro con los del registro recibido.
     * @param registro el registro con el cual actualizar los valores.
     * @throws ClassCastException si el registro no es de la instancia correcta.
     */
    @Override
    public void actualiza(Chef registro) {
        if(!(registro instanceof Chef))
            throw new ExcepcionRegistroInvalido();

        Chef chef = (Chef)registro;
        this.nombre = chef.nombre;
        this.ubicacion = chef.ubicacion;
        this.numero = chef.numero;
    }

	@Override
	public void actualizar() {
        System.out.println(String.format("%s, se ha añadido una receta al recetario, te recomendamos revisarla!!!",nombre));		
	}

    
    /**
     * Nos dice si el registro caza el valor dado en el campo especificado.
     * @param campo el campo que hay que cazar.
     * @param valor el valor con el que debe cazar el campo del registro.
     */
    @Override
    public boolean caza(CampoChef campo, Object valor){
        if(campo == null)
            throw new IllegalArgumentException();

        switch(campo){
            case NOMBRE:
                if(valor instanceof String){
                    String nombre = (String)valor;
                    return (getNombre().contains(nombre) && !nombre.equals(""));
                }break;
            case UBICACION:
                if(valor instanceof String){
                    String ubicacion = (String)valor;
                    return (getUbicacion().contains(nombre) && !ubicacion.equals(""));
                }break;
            case NUMERO:
                if(valor instanceof Integer){
                    int numero = (int)valor;
                    return numero == getNumero();
                }break;

            default:
                return false;
        }
        return false;
    }
}
