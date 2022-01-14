package myp.proyecto2.model;
/**
 * Enumeracion para los atributos de una rcuenta
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public enum CampoCuenta {

    NOMBRE,

    CUENTA,

    PASS;

    @Override
    public String toString(){
        switch(this){
            case NOMBRE:
                return "Nombre";
            case PASS:
                return "Contraseña";
            case CUENTA:
                return "Cuenta";
            default:
                return null;
        }
    }
}
