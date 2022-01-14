package myp.proyecto2.model;
/**
 * Enumeracion para las posibles medidad de una receta
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */

public enum Medida {
    OZ,
    TZ,
    G,
    ML,
    KG,
    PZ;

    @Override
    public String toString(){
        switch(this){
            case OZ:
                return "onzas";
            case TZ:
                return "tazas";
            case G:
                return "gramos";
            case ML:
                return "mililitros";
            case KG:
                return "kilogramos";
            case PZ:
                return "piezas";
            default:
                return null;
        }
    }

    public String valor(){
	switch(this){
	    case OZ:
		return "OZ";
	    case TZ:
		return "TZ";
	    case G:
		return "G";
	    case ML:
		return "ML";
	    case KG:
		return "KG";
	    case PZ:
		return "PZ";
	    default:
		return null;
	}
    }
}
