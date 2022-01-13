package myp.proyecto2.model;

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
}
