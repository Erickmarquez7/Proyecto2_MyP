package myp.proyecto2.view;

//Bibliotecas para la ventana y para eventos.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import myp.proyecto2.model.Buscador;
import myp.proyecto2.model.PorNombre;
import myp.proyecto2.model.*;
import myp.proyecto2.model.RecetarioCheems;

public class VistaBuscador extends JPanel{
    private JFrame frame;
    
    private JLabel texto;

    private Buscador buscador;
    private VistaBusqueda vista;
    private JButton botonNombre;
    private JButton botonDificultad;
    private JButton botonTiempo;
    private JButton botonIngredientes;

    public VistaBuscador(){
        initDisplay();
        initBoton();
        frame.setLayout(null);
        //initPantalla();
    }

    public void initDisplay(){
        frame = new JFrame("Cheems Ramsay");
        frame.setSize(800, 600);
        frame.setLocation(200,200);
        frame.getContentPane().setBackground(new Color(204,229,255));

        texto = new JLabel("¿Cómo quieres buscar?");
        texto.setFont(new Font("Courier", Font.BOLD, 30));
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        //el primer parametro lo mueve en linea horizontal a la derecha
        //el segundo en vertical abajo
        //
        texto.setBounds(200,100,600,100);
        frame.add(texto);
    }

    public void initBoton(){
        botonNombre = new JButton("Buscar por nombre");
        botonNombre.setBounds(150,220,250,80);
        botonNombre.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonNombre);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/
        botonNombre.addActionListener(e ->{
            buscador = new PorNombre();
            Recetario recetario = new RecetarioCheems();
            for(Receta r : buscador.busca("uevo", recetario))
            System.out.println(r.toString());
        });



        botonDificultad = new JButton("Por Dificultad");
        botonDificultad.setBounds(400,220,250,80);
        botonDificultad.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonDificultad);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/


        botonTiempo = new JButton("Por tiempo");
        botonTiempo.setBounds(150,300,250,80);
        botonTiempo.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonTiempo);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/


        botonIngredientes = new JButton("Por Ingredientes");
        botonIngredientes.setBounds(400,300,250,80);
        botonIngredientes.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonIngredientes);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/

    }


    public void function(ActionListener nombre, ActionListener dificultad,
    ActionListener tiempo, ActionListener ingredientes){
        botonNombre.addActionListener(nombre);
        botonDificultad.addActionListener(dificultad);
        botonTiempo.addActionListener(tiempo);
        botonIngredientes.addActionListener(ingredientes);

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

    
    public void setVisible(boolean bln){
        frame.setVisible(bln);
    }
}