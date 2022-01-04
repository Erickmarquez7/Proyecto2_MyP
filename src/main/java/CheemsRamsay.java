import java.util.Scanner;
import java.util.LinkedList;

public class CheemsRamsay{

    private TipoPlatillo tipoPlatillo;
    private TipoComida tipoComida;

    public static void main(String[] args){
        System.out.println("Selecciona cómo quieres buscar tu platillo"+
        "\n1.- Por nombre de platillo"+
        "\n2.- Por ingredientes"+
        "\n3.- Por tiempo de preparación"+
        "\n0.- Para finalizar el programa");
        CheemsRamsay cheems = new CheemsRamsay();
        Scanner sc = new Scanner(System.in);
        String op = sc.nextLine();
        String busca = "";
        do{
            switch (op) {
                case "1":
                System.out.println("Ingresa el nombre del platillo: ");
                busca = sc.nextLine();
                Receta r = cheems.busca(busca);
                break;
                        

                case "2":
                System.out.println("Ingrese los ingredientes en español y singular separados por comas.");
                System.out.printf("Ingredientes: ");
                String ingredientesCadena = sc.nextLine();
                String[] ingredientes = ingredientesCadena.split(",");

                cheems.busca(ingredientes);
                break;
        

                case "3":
                System.out.printf("Ingrese el tiempo de preparacion del platillo en minutos: ");
                while(!sc.hasNextInt()){
                    System.out.println("No es un número, prueba de nuevo.");
                    sc.next(); 
                }

                int tiempo = sc.nextInt();
                cheems.busca(tiempo);
                
                break;
        
        
                default:
                    System.out.println("Opción invalida, intente de nuevo");
                break;
            }
        }while(op != "0");
        
    }


    public Receta busca(String nombre){
        return tipoComida.busca(nombre);
    }


    public Receta busca(Ingrediente[] ingredientes){
        return tipoComida.busca(ingredientes);
    }


    public Receta busca(int tiempo){
        return tipoComida.busca(tiempo);
    }
    
}