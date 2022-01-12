public class Ingrediente {
    private String nombre;
    private Medida medida;
    private double cantidad;
    private int porciones;

    public Ingrediente(String nombre, Medida medida, double cantidad, int porciones){
        this.nombre = nombre;
        this.medida = medida;
        this.cantidad = cantidad;
        this.porciones = porciones;
    }

    public Ingrediente(String ingredienteSer){
        deserializa(ingredienteSer);
    }

    public String serializa(){
        return String.format("%s-%s-%.3f-%d", nombre, medida.toString(), cantidad, porciones);
    }

    public void deserializa(String registro){
        if(registro == null){
            throw new ExcepcionRegistroInvalido("El registro es nulo.");
        }
        registro = registro.trim();
        String[] campos = registro.split("-");
        if(campos.length != 4){
            throw new ExcepcionRegistroInvalido("Registro no válido.");
        }
        try{
            this.nombre = campos[0];
            this.medida = Medida.valueOf(campos[1]);
            this.cantidad = Double.parseDouble(campos[2]);
            this.porciones = Integer.parseInt(campos[3]);
        }catch (NumberFormatException nfe){
            throw new ExcepcionRegistroInvalido("Registro no válido.");
        }
    }
}
