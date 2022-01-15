package myp.proyecto2.model;
/**
 * Clase para cheefs que son observadore y están al tanto de 
 * implementan registro pues es un objeto "agregable" a la base de datos
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public class Administrador implements Registro<Administrador,CampoAdmin>{

    private String nombre;
    private String usuario;
    private String pass;
    private int numero;

    public Administrador(String nombre, String usuario, String pass, int numero){
        this.nombre = nombre;
        this.usuario = usuario;
	this.pass = pass;
        this.numero = numero;
    }

    public String getNombre(){
        return nombre;
    }

    public String getUsuario(){
        return usuario;
    }

    public int getNumero(){
        return numero;
    }

    public boolean verificaPassword(String pass){
	if(pass == null)
	    throw new IllegalArgumentException("Campo nulo");
	return this.pass.equals(pass);
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setUsuairo(String usuario){
	System.out.println("No se puede cambiar el nombre de usuario");
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    /**
     * Regresa el registro serializado en una línea de texto.
     * @return la serialización del registro en una línea de texto.
     */
    @Override
    public String serializa() {
        return String.format("%s/%s/%s/%d\n", nombre, usuario, pass, numero);
    }


    /**
     * Deserializa una línea de texto en las propiedades del registro.
     * @param registro la línea a deserializar.
     * @throws ExcepcionLineaInvalida si la línea recibida es nula, vacía o no
     *         es una serialización válida de un registro.
     */
    @Override
    public void deserializa(String registro) {
        if(registro == null)
            throw new ExcepcionRegistroInvalido();

        registro = registro.trim();
        String[] params = registro.split("/");

        if(params.length != 4)
            throw new ExcepcionRegistroInvalido();

        try{
            nombre = params[0];
            usuario = params[1];
	    pass = params[3];
            numero = Integer.parseInt(params[3]);
        }catch (NumberFormatException nfe){
            throw new ExcepcionRegistroInvalido();
        }
        
    }

    /**
     * Actualiza los valores del registro con los del registro recibido.
     * @param registro el registro con el cual actualizar los valores.
     * @throws ClassCastException si el registro no es de la instancia correcta.
     */
    @Override
    public void actualiza(Administrador registro) {
        if(!(registro instanceof Administrador))
            throw new ExcepcionRegistroInvalido();

        Administrador administrador = (Administrador)registro;
	this.nombre = administrador.nombre;
	this.usuario = administrador.usuario;
	this.pass = administrador.pass;
	this.numero = administrador.numero;
    }

    /**
     * Nos dice si el registro caza el valor dado en el campo especificado.
     * @param campo el campo que hay que cazar.
     * @param valor el valor con el que debe cazar el campo del registro.
     */
    @Override
    public boolean caza(CampoAdmin campo, Object valor){
        if(campo == null)
            throw new IllegalArgumentException();

        switch(campo){
            case NOMBRE:
                if(valor instanceof String){
                    String nombre = (String)valor;
                    return (getNombre().contains(nombre) && !nombre.equals(""));
                }break;
            case USUARIO:
                if(valor instanceof String){
                    String usuario = (String)valor;
                    return (getUsuario().contains(usuario) && !usuario.equals(""));
                }break;
	    case PASS: // No se puede buscar por contraseña
		return false;
            case NUMERO:
                if(valor instanceof Integer){
                    int numero = (int)valor;
                    return numero == getNumero();
                }break;
        }
        return false;
    }
}
