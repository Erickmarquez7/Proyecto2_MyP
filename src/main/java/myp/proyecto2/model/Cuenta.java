package myp.proyecto2.model;
/**
 * Clase para cuentas que implemtan Proxy e 
 * implementan registro pues es un objeto "agregable" a la base de datos
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public class Cuenta implements IProxy, Registro<Cuenta,CampoCuenta>{
    private String nombre;
    private String pass;
    private int cuenta;

    public Cuenta(String nombre, String pass, int cuenta){
	this.nombre = nombre;
	this.pass = pass;
	this.cuenta = cuenta;
    }

	/**
    * Verifica la cuenta y la contrasena del usuario
    * @param cuenta la cuenta a verificar 
    * @param pass la contrasena a verificar
    * @return true si se verificó correctamente
     */
    public boolean validar(int cuenta, String pass) {
        return (this.cuenta == cuenta) && (this.pass.equals(pass));
    }

	public String getNombre(){
		return nombre;
	}

	public String getPass(){
		return pass;
	}

	public int getCuenta(){
		return cuenta;
	}
	/**
     * Regresa el registro serializado en una línea de texto.
     * @return la serialización del registro en una línea de texto.
     */
    public String serializa(){
		return String.format("%s\t%s\t%d",nombre,pass,cuenta);
    }

	
	/**
     * Deserializa una línea de texto en las propiedades del registro.
     * @param registro la línea a deserializar.
     * @throws ExcepcionLineaInvalida si la línea recibida es nula, vacía o no
     *         es una serialización válida de un registro.
     */
    public void deserializa(String registro){
	if(registro == null)
	    throw new ExcepcionRegistroInvalido();

	registro = registro.trim();
	String[] params = registro.split("\t");

	if(params.length != 3)
	    throw new ExcepcionRegistroInvalido();

	try{
	    nombre = params[0];
	    pass = params[1];
	    cuenta = Integer.parseInt(params[2]);
	} catch (NumberFormatException nfe){
	    throw new ExcepcionRegistroInvalido();
	}
    }

    public void actualiza(Registro registro){
	if(!(registro instanceof Cuenta))
	    throw new ExcepcionRegistroInvalido();

	Cuenta cuenta = (Cuenta)registro;
	this.nombre = cuenta.nombre;
	this.pass = cuenta.pass;
	this.cuenta = cuenta.cuenta;
    }


	/**
     * Actualiza los valores del registro con los del registro recibido.
     * @param registro el registro con el cual actualizar los valores.
     * @throws ClassCastException si el registro no es de la instancia correcta.
     */
	@Override
	public void actualiza(Cuenta registro) {
		// TODO Auto-generated method stub
		
	}

    /**
     * Nos dice si el registro caza el valor dado en el campo especificado.
     * @param campo el campo que hay que cazar.
     * @param valor el valor con el que debe cazar el campo del registro.
     */
	@Override
	public boolean caza(CampoCuenta campo, Object valor) {
		if(campo == null)
			throw new IllegalArgumentException();

		switch(campo){
			case NOMBRE:
				if(valor instanceof String){
					String nombre = (String)valor;
					return !nombre.equals("") && getNombre().equals(nombre);
				}break;
			case PASS: // No se puede buscar por contraseña
				return false;
			case CUENTA:
				if(valor instanceof Integer){
					int cuenta = (int)valor;
					return cuenta == getCuenta();
				}break;
		}
		return false;
	}
}
