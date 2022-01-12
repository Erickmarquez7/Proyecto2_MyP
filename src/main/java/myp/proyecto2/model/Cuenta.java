package myp.proyecto2.model;

public class Cuenta implements IProxy, Registro{
    private String nombre;
    private String pass;
    private int cuenta;

    public Cuenta(String nombre, String pass, int cuenta){
	this.nombre = nombre;
	this.pass = pass;
	this.cuenta = cuenta;
    }

    public boolean validar(int cuenta, String pass) {
        return (this.cuenta == cuenta) && (this.pass.equals(pass));
    }
    
    public String serializa(){
	return String.format("%s\t%s\t%d",nombre,pass,cuenta);
    }

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
}
