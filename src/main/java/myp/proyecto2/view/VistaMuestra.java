package myp.proyecto2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VistaMuestra extends JFrame{
    private JFrame frame;

    private JLabel texto;

    private int cantidad = 10;

//    private JButton botonVerRecetas;
//    private JButton botonBuscarRecetas;

    public VistaMuestra(){
        initDisplay();
        initBoton();
        initPantalla();
    }

    public void initDisplay(){
        frame = new JFrame("Cheems Ramsay");
        frame.setBackground(Color.CYAN);
        frame.setSize(800, 600);
        frame.setLocation(200,200);

        texto = new JLabel("Tus recetas son: ");
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        //el primer parametro lo mueve en linea horizontal a la derecha
        //el segundo en vertical abajo
        //
        texto.setFont(new Font("Courier", Font.BOLD, 30));
        texto.setBounds(150,50,600,100);
        frame.add(texto);

        //int i = 100;
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

    }

    public void initBoton(){

        
        /*
        botonVerRecetas = new JButton("Ver todas las recetas");
        botonVerRecetas.setBounds(200,250,400,50);
        botonVerRecetas.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonVerRecetas);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/
  /*      botonVerRecetas.addActionListener(e -> {
            System.out.println("Ver todas las recetas");
        });

*/

    }


    private void initPantalla(){
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