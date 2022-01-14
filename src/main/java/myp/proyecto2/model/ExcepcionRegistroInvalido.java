package myp.proyecto2.model;
/**
 * Excepcion propia para registros inavlidos
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public class ExcepcionRegistroInvalido extends IllegalArgumentException{
    public ExcepcionRegistroInvalido(){}

    public ExcepcionRegistroInvalido(String mensaje){
        super(mensaje);
    }
}
