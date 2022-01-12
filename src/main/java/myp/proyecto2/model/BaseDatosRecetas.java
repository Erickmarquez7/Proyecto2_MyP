public class BaseDatosRecetas extends BaseDatos<Receta>{

    @Override
    public Receta creaRegistro(){
	    return new Receta(null, "", "", 0,0);
    }
}
