package myp.proyecto2.model;
/**
 * Proxy para validar la informacion del usuario
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */

public class Proxy implements IProxy{
    private Cuenta cuenta;

    public Proxy(Cuenta cuenta){
        this.cuenta=cuenta;
    }

    public Proxy(){}

    /**
    * Verifica la cuenta y la contrasena del usuario
    * @param cuenta la cuenta a verificar 
    * @param pass la contrasena a verificar
    * @return true si se verificó correctamente
     */
	public boolean validar(String cuenta, String pass) {
		return this.cuenta.validar(cuenta, pass);
	}

}