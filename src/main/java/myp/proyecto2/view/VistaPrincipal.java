package myp.proyecto2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VistaPrincipal extends JFrame{
    private JFrame frame;

    private JLabel texto;

    private JButton botonVerRecetas;
    private JButton botonBuscarRecetas;

    
    public VistaPrincipal(){
        initDisplay();
        initBoton();
        initPantalla();
    }

    public void initDisplay(){
        frame = new JFrame("Cheems Ramsay");
        frame.setBackground(Color.CYAN);
        frame.setSize(800, 600);
        frame.setLocation(200,200);

        texto = new JLabel("Selecciona que quieres hacer");
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        //el primer parametro lo mueve en linea horizontal a la derecha
        //el segundo en vertical abajo
        //
        texto.setFont(new Font("Courier", Font.BOLD, 30));
        texto.setBounds(150,100,600,100);
        frame.add(texto);
    }


    public void initBoton(){
        botonVerRecetas = new JButton("Ver todas las recetas");
        botonVerRecetas.setBounds(200,250,400,50);
        botonVerRecetas.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonVerRecetas);


        botonBuscarRecetas = new JButton("Buscar recetas");
        botonBuscarRecetas.setFont(new Font("Courier", Font.BOLD, 20));
        botonBuscarRecetas.setBounds(200,300,400,50);
        //Se agrega al frame
        frame.add(botonBuscarRecetas);

    }

    public void function(ActionListener verRecetas, ActionListener buscarRecetas){
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/
        botonVerRecetas.addActionListener(verRecetas);
        botonBuscarRecetas.addActionListener(buscarRecetas);
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

    /*  public static void main(String[] ar) {
        VistaPrincipal interfaz1 = new VistaPrincipal();
    }*/
}