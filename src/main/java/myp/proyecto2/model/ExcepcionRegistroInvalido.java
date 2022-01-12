package myp.proyecto2.model;

public class ExcepcionRegistroInvalido extends IllegalArgumentException{
    public ExcepcionRegistroInvalido(){}

    public ExcepcionRegistroInvalido(String mensaje){
        super(mensaje);
    }
}
