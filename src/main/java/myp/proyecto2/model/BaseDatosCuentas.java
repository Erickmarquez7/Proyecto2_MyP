package myp.proyecto2.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class BaseDatosCuentas extends BaseDatos<Cuenta>{

    @Override
    public Cuenta creaRegistro(){
        return new Cuenta(null, null, 0);
    }

    public void carga(){
        try{
            FileInputStream file = new FileInputStream("../data/Cuentas.txt");
            InputStreamReader fileIn = new InputStreamReader(file);
            BufferedReader in = new BufferedReader(fileIn);
            super.carga(in);
        }catch (IOException ioe){
            System.out.println("Error al acceder a la base :(");
            System.exit(0);
        }
    }
}
