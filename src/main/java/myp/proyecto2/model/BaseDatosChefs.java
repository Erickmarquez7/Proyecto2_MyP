package myp.proyecto2.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Iterator;
/**
 * Clase abstracta para guardar un base de datos que solo agrega 
 * chefs
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public class BaseDatosChefs extends BaseDatos<Chef, CampoChef>{

    /**
    * Crea un chef vacio
     */
    @Override
    public Chef creaRegistro(){
	    return new Chef(null, null, 0);
    }


	/** 
	* Carga la base de datos de una ruta dada
	* @param directorio la ruta a cargar la base de datos
	 */
    @Override
    public void carga(String directorio){
        try{
            FileInputStream file = new 
		FileInputStream(directorio + "Chefs.txt");
            InputStreamReader fileIn = new InputStreamReader(file);
            BufferedReader in = new BufferedReader(fileIn);
            super.carga(in);
        }catch (IOException ioe){
            System.out.println("Error al acceder a la base Chefs :(");
            System.exit(0);
        }
    }


	/**
	* Busca cheefs dado un campo, un atributo, y el valor
	* @param campo el atributo con el que queremos buscar
	* @param objetObject el valor a buscar
    * @return las coincidencias encontradas
	 */
    @Override
    public LinkedList<Chef> buscaRegistros(CampoChef campo, Object valor) {
        LinkedList<Chef> chefs = new LinkedList<>();

        Iterator<Chef> it = super.base.iterator();
        while(it.hasNext()){
         Chef c = it.next();
            if(c.caza(campo, valor))
                chefs.add(c);
        }
        return chefs;
    }
}

