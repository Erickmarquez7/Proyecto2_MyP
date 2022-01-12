package myp.proyecto2.model;

import java.util.LinkedList;
import java.util.Scanner;

public class CheemsRamsay{

    Buscador buscador;

    public void setBuscador(Buscador buscador){
        this.buscador=buscador;
    }


    public LinkedList<Receta> busca(String cadena){
        return buscador.busca(cadena, null);
    }



    public static void main(String[] args) {
        CheemsRamsay chef = new CheemsRamsay();
        
        Scanner sc = new Scanner(System.in);
        //Receta receta = new Receta();
        
        int opcion;
        int eleccion;
        
        do{
            System.out.println("*Escribe 1 para ver las recetas \n" +
                               "*Escribe 2 para buscar recetas \n" +
                               "*Escribe 0 para terminar  \n");

            while(!sc.hasNextInt()){
                System.out.println("No es un número, prueba de nuevo.");
                sc.next(); 
            }

            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                //metodo para ver las recetas xd ps si
                break;

                //metodo para buscar
                case 2:
                    System.out.println("¿Por cual forma quieres buscar?\n"+
                    "1.- Por nombre\n"+
                    "2.- Por tiempo\n"+
                    "3.- Por dificultad\n"+
                    "4.- Por ingredientes");

                    while(!sc.hasNextInt()){
                        System.out.println("No es un número, prueba de nuevo.");
                        sc.next(); 
                    }

                    eleccion = sc.nextInt();
        
                    
                    if(eleccion == 1){
                        System.out.println("Escribe el nombre de la receta:\n");
                        String nombre = sc.nextLine();
                        chef.setBuscador(new PorNombre());                       
                        chef.busca(nombre);
                    }


                    if(eleccion == 2){
                        System.out.println("Escribe el tiempo de preparacion de la receta:\n");

                     /*   while(!sc.hasNextInt()){
                            System.out.println("No es un número, prueba de nuevo.");
                            sc.next(); 
                        }
*/
                        String tiempo = sc.nextLine();
                        chef.setBuscador(new PorTiempo());
                        chef.busca(tiempo);
                    }


                    if(eleccion == 3){
                        System.out.println("Escribe el nivel de dificultad la receta del 1 al 5:\n");

  /*                      while(!sc.hasNextInt()){
                            System.out.println("No es un número, prueba de nuevo.");
                            sc.next(); 
                        }
                        
*/
                        String dif = sc.nextLine();
                        chef.setBuscador(new PorDificultad());
                        chef.busca(dif);
                    }


                    if(eleccion == 4){
                        System.out.println("Escribe los ingredientes de la receta separados por comas y en singular:\n");
                        String ingredientes = sc.nextLine();
                        chef.setBuscador(new PorIngredientes());
                        chef.busca(ingredientes);                        
                    }

                break;


                default:
	            System.out.println("Saliste del programa.");
                return;
            }
        } while(opcion != 0);          
    }

}