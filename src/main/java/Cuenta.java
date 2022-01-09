public class Cuenta implements IProxy{
    private int cuenta = 072030;
    private String pass = "pass123word";

	public boolean validar(int cuenta, String pass) {
        return (this.cuenta == cuenta) && (this.pass.equals(pass));
	}
    
}