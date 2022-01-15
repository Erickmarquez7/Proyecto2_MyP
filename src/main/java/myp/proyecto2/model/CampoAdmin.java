package myp.proyecto2.model;
/**
 * Enumeracion para los atributos de un chef
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public enum CampoAdmin {
    NOMBRE,

    USUARIO,

    PASS,

    NUMERO;

    @Override
    public String toString(){
        switch(this){
            case NOMBRE:
                return "Nombre";
	    case USUARIO:
		return "Usuario";
	    case PASS:
		return "Contraseña";
            case NUMERO:
                return "Número";
            default:
                return null;
        }
    }
}
