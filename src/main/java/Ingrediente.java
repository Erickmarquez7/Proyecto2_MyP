public class Ingrediente{
    private String nombre;
    private String medida;
    private float cantidad;

    public Ingrediente(String nombre, String medida, float cantidad){
        this.nombre = nombre;
        this.medida = medida;
        this.cantidad = cantidad;
    }

    public String getNombre(){
        return nombre;
    }

    public String getMedida(){
        return medida;
    }
    
    public float getCantidad(){
        return cantidad;
    }
}