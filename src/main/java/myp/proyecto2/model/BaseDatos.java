package myp.proyecto2.model;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Clase abstracta para guardar un base de datos que solo agrega 
 * "objetos agregables" es decir, solo registros
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public abstract class BaseDatos<R extends Registro<R,C>, C extends Enum> {
	//la base de datos es uns simple lista xd
    protected LinkedList<R> base;

    public BaseDatos(){
		this.base = new LinkedList<R>();
    }

    public int getNumRegistros(){
		return base.size();
    }

    public LinkedList<R> getRegistros(){
		return base;
    }


	/** 
	* Agrega un registro a la base de datos
	* @param registro el registro a agregar
	*/
    public void agregaRegistro(R registro){
		base.add(registro);
    }


	/**
	* Elimina un registro de la base de datos
	* @param registro el registro a elminar
	*/
    public void eliminaRegistro(R registro){
		base.remove(registro);
    }

	/**
	* Vacia la base de datos
	*/
    public void limpia(){
		base.clear();
    }


	/**
	* Gurada en un directorio la base de datos de los registros
	* @param out la base a guardar
	 */
    public void guarda(BufferedWriter out) throws IOException{
		try{
	    	for(R r : base)
			out.write(r.serializa());
		}catch (IOException ioe){
	    	throw new IOException("Error en entrada/salida de archivo");
		}
    }

	/** 
	* Carga la base de datos de una ruta dada
	* @param directorio la ruta a cargar la base de datos
	 */
	public abstract void carga(String directorio);


	/** 
	* Carga la base de datos de una ruta en especifico
	* @param in la base a cargar
	 */
    public void carga(BufferedReader in) throws IOException{
		limpia();
		String c;
		while((c = in.readLine()) != null && !(c.trim().equals(""))){
	    	R r = creaRegistro();
	    	try{
			r.deserializa(c);
	    	}catch (ExcepcionRegistroInvalido eri){
			throw new IOException("Error entrada y salida");
	    	}
	    	agregaRegistro(r);
		}
    }


	/**
	* Crea un registro dependiendo la base de datos
	 */
    public abstract R creaRegistro();


	/**
	* Busca un registro dado un campo, un atributo, y el valor
	* @param campo el atributo con el que queremos buscar
	* @param objetObject el valor a buscar
	* @return las coincidencias encontradas
	 */
	public abstract LinkedList<R> buscaRegistros(C campo, Object valor);
}
