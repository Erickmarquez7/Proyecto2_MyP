package myp.proyecto2.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class BaseDatosRecetas extends BaseDatos<Receta>{

    @Override
    public Receta creaRegistro(){
	    return new Receta(null, "", "", 0,0);
    }

    @Override
    public void carga(String directorio){
        try{
            FileInputStream file = new 
		        FileInputStream(directorio + "Recetas.txt");
            InputStreamReader fileIn = new InputStreamReader(file);
            BufferedReader in = new BufferedReader(fileIn);
            super.carga(in);
        }catch (IOException ioe){
            System.out.println("Error al acceder a la base 1 :(");
            System.exit(0);
        }
    }

}
