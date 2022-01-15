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
    private String cuenta;

    public Cuenta(String nombre, String pass, String cuenta){
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
    public boolean validar(String cuenta, String pass) {
		if(cuenta == null || pass == null) return false;
        return (this.cuenta.equals(cuenta)) && (this.pass.equals(pass));
    }

	public String getNombre(){
		return nombre;
	}

	public String getPass(){
		return pass;
	}

	public String getCuenta(){
		return cuenta;
	}
	/**
     * Regresa el registro serializado en una línea de texto.
     * @return la serialización del registro en una línea de texto.
     */
    public String serializa(){
		return String.format("%s\t%s\t%s\n",nombre,pass,cuenta);
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

	nombre = params[0];
	pass = params[1];
	cuenta = params[2];
    }

    public void actualiza(Cuenta registro){
	if(!(registro instanceof Cuenta))
	    throw new ExcepcionRegistroInvalido();

	Cuenta cuenta = (Cuenta)registro;
	this.nombre = cuenta.nombre;
	this.pass = cuenta.pass;
	this.cuenta = cuenta.cuenta;
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
				if(valor instanceof String){
					String cuenta = (String)valor;
					return cuenta.equals(getCuenta());
				}break;
		}
		return false;
	}
}
