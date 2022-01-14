package myp.proyecto2.model;
/**
 * Interfaz para registros. Hace a los objetos que la implementen "agregables"
 */
public interface Registro<R,C extends Enum> {

    /**
     * Regresa el registro serializado en una línea de texto.
     * @return la serialización del registro en una línea de texto.
     */
    public String serializa();

    /**
     * Deserializa una línea de texto en las propiedades del registro.
     * @param registro la línea a deserializar.
     * @throws ExcepcionLineaInvalida si la línea recibida es nula, vacía o no
     *         es una serialización válida de un registro.
     */
    public void deserializa(String registro);

    /**
     * Actualiza los valores del registro con los del registro recibido.
     * @param registro el registro con el cual actualizar los valores.
     * @throws ClassCastException si el registro no es de la instancia correcta.
     */
    public void actualiza(R registro);

    /**
     * Nos dice si el registro caza el valor dado en el campo especificado.
     * @param campo el campo que hay que cazar.
     * @param valor el valor con el que debe cazar el campo del registro.
     */
    public boolean caza(C campo, Object valor);
}
