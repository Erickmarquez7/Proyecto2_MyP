package myp.proyecto2.model;

public class Ingrediente {
    private String nombre;
    private Medida medida;
    private double cantidad;

    public Ingrediente(String nombre, Medida medida, double cantidad, int porciones){
        this.nombre = nombre;
        this.medida = medida;
        this.cantidad = cantidad;
    }

    public Ingrediente(String ingredienteSer){
        deserializa(ingredienteSer);
    }

    @Override
    public String toString(){
	return String.format("%s   %.3f%s", nombre, cantidad, medida.toString());
    }

    public String serializa(){
        return String.format("%s-%s-%.3f", nombre, medida.valor(), cantidad);
    }

    public void deserializa(String registro){
        if(registro == null){
            throw new ExcepcionRegistroInvalido("El registro es nulo.");
        }
        registro = registro.trim();
        String[] campos = registro.split("-");
	System.out.println("Campos <- " + campos.length);
	for(int i = 0; i < campos.length; i++)
	System.out.println("Ingrediente deserializa" + campos[i]);
        if(campos.length != 3){
            throw new ExcepcionRegistroInvalido("Registro no válido.");
        }
        try{
            this.nombre = campos[0];
            this.medida = Medida.valueOf(campos[1]);
            this.cantidad = Double.parseDouble(campos[2]);
        }catch (NumberFormatException nfe){
            throw new ExcepcionRegistroInvalido("Registro no válido 2.");
        }
    }
}
