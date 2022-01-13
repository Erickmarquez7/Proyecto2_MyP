package myp.proyecto2.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class BaseDatosChefs extends BaseDatos<Chef>{

    @Override
    public Chef creaRegistro(){
	    return new Chef(null, null, 0);
    }

    @Override
    public void carga(String directorio){
        try{
            FileInputStream file = new 
		FileInputStream(directorio + "Chefs.txt");
            InputStreamReader fileIn = new InputStreamReader(file);
            BufferedReader in = new BufferedReader(fileIn);
            super.carga(in);
        }catch (IOException ioe){
            System.out.println("Error al acceder a la base :(");
            System.exit(0);
        }
    }
}

