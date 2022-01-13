package myp.proyecto2.view;

import java.util.LinkedList;
import myp.proyecto2.model.Receta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VistaMuestra extends JPanel{

    private LinkedList<Receta> recetas;

    private JFrame frame;

    private JLabel texto;

    private int cantidad = 10;

//    private JButton botonVerRecetas;
//    private JButton botonBuscarRecetas;

    public VistaMuestra(){}

    public VistaMuestra(LinkedList<Receta> recetas){
        this.recetas = recetas;
        initDisplay();
        initBoton();
        //initPantalla();
    }

    public void initDisplay(){
        frame = new JFrame("Cheems Ramsay");
        frame.setBackground(Color.CYAN);
        frame.setSize(800, 600);
        frame.setLocation(200,200);

        if(recetas.isEmpty()){
            texto = new JLabel("No hay recetas que coindicen con tu búsqueda :(");
            texto.setFont(new Font("Arial", Font.BOLD, 40));
            texto.setBounds(200,300,400,100);
            texto.setForeground(Color.RED);
            frame.add(texto);
            return;
        }

        texto = new JLabel("Las recetas que coinciden con tu búsqueda son: ");
        texto.setFont(new Font("Courier", Font.BOLD, 30));
        texto.setBounds(150,50,600,50);
        frame.add(texto);
        

        int altura = 80;
        int contador = 0;
        for(Receta r : recetas){
            JLabel receta = new JLabel("*" + r.getNombre());
            receta.setFont(new Font("Arial", Font.PLAIN,20));
            receta.setBounds(150, 100+contador*30,300,30);
            frame.add(receta);

            JButton botonReceta = new JButton();
            botonReceta.setFont(new Font("Courier", Font.ITALIC,20));
            botonReceta.setBounds(450,100+contador*30,300,30);
            frame.add(botonReceta);

            botonReceta.addActionListener(e -> {
                System.out.println("á");
            });
        }
        //int i = 100;
        /*
        for(int i = 0; i < cantidad; i++){
            JLabel receta = new JLabel("Receta " + i);
            receta.setFont(new Font("Courier", Font.ITALIC, 20));
            receta.setBounds(150, 100+(i*30),300,30);
            frame.add(receta);
            
            JButton botonReceta = new JButton("Ver receta");
            botonReceta.setFont(new Font("Courier", Font.ITALIC,20));
            botonReceta.setBounds(450,100+(i*30),300,30);
            frame.add(botonReceta);

            botonReceta.addActionListener(e -> {
                System.out.println("Ver la receta ");
            });

        }
        */

    }

    private void verReceta(Receta receta){

    }


    public void initBoton(){


    }


    public void initPantalla(){
        /*Esta linea sirve para que al cerrar la ventana de la interfaz, 
        el thread que maneja la ventana realmente termine su ejecucion*/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*Esta linea determina que toda la disposicion de los elementos
        (donde se ubicaran) depende completamente de nosotros.*/
        frame.setLayout(null);
        //Se asigna al frame como visible
        frame.setVisible(true);
    }

      public static void main(String[] ar) {
        VistaMuestra interfaz1 = new VistaMuestra();
    }
}