public class Chef implements Registro, Observer{

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


    @Override
    public String serializa() {
        return String.format("%s/%s/%d", nombre, ubicacion, numero);
    }

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

    @Override
    public void actualiza(Registro registro) {
        if(!(registro instanceof Chef))
            throw new ExcepcionRegistroInvalido();

        Chef chef = (Chef)registro;
        this.nombre = chef.nombre;
        this.ubicacion = chef.ubicacion;
        this.numero = chef.numero;
    }

	@Override
	public void agrega(Receta receta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(Receta receta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifica() {
		// TODO Auto-generated method stub
		
	}
    
}
