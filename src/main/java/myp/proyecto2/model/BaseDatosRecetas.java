package myp.proyecto2.model;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Iterator;
import java.util.LinkedList;
/**
 * Clase abstracta para guardar un base de datos que solo agrega 
 * recetas
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public class BaseDatosRecetas extends BaseDatos<Receta,CampoBuscador>{

    private String directorio;
    /**
    * Crea una receta vacia
     */
    @Override
    public Receta creaRegistro(){
	    return new Receta(null, null, null, 0,0);
    }

    /** 
	* Carga la base de datos de una ruta dada
	* @param directorio la ruta a cargar la base de datos
	 */
    @Override
    public void carga(String directorio){
	this.directorio = directorio;
        try{
            FileInputStream file = new 
		        FileInputStream(directorio + "Recetas.txt");
            InputStreamReader fileIn = new InputStreamReader(file);
            BufferedReader in = new BufferedReader(fileIn);
            super.carga(in);
	    in.close();
        }catch (IOException ioe){
            System.out.println("Error al acceder a la base 1 :(");
            System.exit(0);
        }
    }

    public void guarda(){
	try{
	    FileOutputStream file = new FileOutputStream(directorio + "Chefs.txt");
	    OutputStreamWriter fileOut = new OutputStreamWriter(file);
	    BufferedWriter out = new BufferedWriter(fileOut);
	    super.guarda(out);
	    out.close();
	}catch (IOException ioe){
	    System.out.println("Error al guargar en la base");
	    System.exit(0);
	}
    }

	/**
	* Busca recetas dado un campo, un atributo, y el valor
	* @param campo el atributo con el que queremos buscar
	* @param objetObject el valor a buscar
    * @return las coincidencias encontradas
	 */
    @Override
    public LinkedList<Receta> buscaRegistros(CampoBuscador campo, Object valor) {
        LinkedList<Receta> recetas = new LinkedList<>();

        Iterator<Receta> it = super.base.iterator();
        while(it.hasNext()){
            Receta r = it.next();
            if(r.caza(campo, valor))
                recetas.add(r);
        }
        return recetas;
    }

}
