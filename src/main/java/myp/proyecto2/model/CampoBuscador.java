package myp.proyecto2.model;
/**
 * Enumeracion para los atributos de una receta
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public enum CampoBuscador {
    NOMBRE,

    INGREDIENTES,

    INSTRUCCIONES,

    TIEMPO,
    
    DIFICULTAD;

    @Override
    public String toString(){
        switch(this){
            case NOMBRE:
                return "Nombre";
            case INGREDIENTES:
                return "Ingredientes";
            case INSTRUCCIONES:
                return "Instrucciones";
            case TIEMPO:
                return "Tiempo";
            case DIFICULTAD:
                return "Dificultad";
            default:
                return null;
        }
    }
}
