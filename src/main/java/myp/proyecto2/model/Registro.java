package myp.proyecto2.model;
/**
 * Interfaz para registros. Los registros deben de poder serializarse a y
 * deserializarse de una línea de texto. También deben poder determinar si sus
 * campos cazan valores arbitrarios y actualizarse con los valores de otro
 * registro.
 */
public interface Registro {

    /**
     * Regresa el registro serializado en una línea de texto. La línea de texto
     * que este método regresa debe ser aceptada por el método {@link
     * Registro#deserializa}.
     * @return la serialización del registro en una línea de texto.
     */
    public String serializa();

    /**
     * Deserializa una línea de texto en las propiedades del registro. La
     * serialización producida por el método {@link Registro#serializa} debe
     * ser aceptada por este método.
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
    public void actualiza(Registro registro);
}
