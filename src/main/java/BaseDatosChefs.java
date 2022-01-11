public class BaseDatosChefs extends BaseDatos<Chef>{

    @Override
    public Chef creaRegistro(){
	    return new Chef(null, null, 0);
    }
}

