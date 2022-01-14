package myp.proyecto2.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Iterator;
import java.util.LinkedList;
/**
 * Clase abstracta para guardar un base de datos que solo agrega 
 * Cuentas
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public class BaseDatosCuentas extends BaseDatos<Cuenta,CampoCuenta>{

    /**
    * Crea una cuenta vacio
     */
    @Override
    public Cuenta creaRegistro(){
        return new Cuenta(null, null, 0);
    }


	/** 
	* Carga la base de datos de una ruta dada
	* @param directorio la ruta a cargar la base de datos
	 */
    @Override
    public void carga(String directorio){
        try{
            FileInputStream file = new
		        FileInputStream(directorio + "Cuentas.txt");
            InputStreamReader fileIn = new InputStreamReader(file);
            BufferedReader in = new BufferedReader(fileIn);
            super.carga(in);
        }catch (IOException ioe){
            System.out.println("Error al acceder a la base Cuentas :(");
            System.exit(0);
        }
    }


	/**
	* Busca cuentas dado un campo, un atributo, y el valor
	* @param campo el atributo con el que queremos buscar
	* @param objetObject el valor a buscar
    * @return las coincidencias encontradas
	 */
    @Override
    public LinkedList<Cuenta> buscaRegistros(CampoCuenta campo, Object valor) {
        LinkedList<Cuenta> cuentas = new LinkedList<>();

        Iterator<Cuenta> it = super.base.iterator();
        while(it.hasNext()){
            Cuenta c = it.next();
            if(c.caza(campo, valor))
                cuentas.add(c);
        }
        return cuentas;
    }
}
