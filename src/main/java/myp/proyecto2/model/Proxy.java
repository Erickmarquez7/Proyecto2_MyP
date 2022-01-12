package myp.proyecto2.model;

public class Proxy implements IProxy{
    private Cuenta cuenta;

    public Proxy(Cuenta cuenta){
        this.cuenta=cuenta;
    }

	public boolean validar(int cuenta, String pass) {
		return this.cuenta.validar(cuenta, pass);
	}

}