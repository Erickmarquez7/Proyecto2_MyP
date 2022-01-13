package myp.proyecto2.view;

//Bibliotecas para la ventana y para eventos.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VistaBuscador extends JPanel{
    private JFrame frame;

    private JLabel texto;

    private JButton botonNombre;
    private JButton botonDificultad;
    private JButton botonTiempo;
    private JButton botonIngredientes;

    public VistaBuscador(){
        initDisplay();
        initBoton();
        //initPantalla();
    }

    public void initDisplay(){
        frame = new JFrame("Cheems Ramsay");
        frame.setSize(800, 600);
        frame.setLocation(200,200);

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
        botonNombre.addActionListener(e -> {
            System.out.println("Por Nombre");
        });



        botonDificultad = new JButton("Por Dificultad");
        botonDificultad.setBounds(400,220,250,80);
        botonDificultad.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonDificultad);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/
        botonDificultad.addActionListener(e -> {
            System.out.println("Buscar por Dificultad");
        });


        botonTiempo = new JButton("Por tiempo");
        botonTiempo.setBounds(150,300,250,80);
        botonTiempo.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonTiempo);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/
        botonTiempo.addActionListener(e -> {
            System.out.println("Buscar por Tiempo");
        });


        botonIngredientes = new JButton("Por Ingredientes");
        botonIngredientes.setBounds(400,300,250,80);
        botonIngredientes.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonIngredientes);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/
        botonIngredientes.addActionListener(e -> {
            System.out.println("Buscar por Ingredientes");
        });

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
        VistaBuscador interfaz1 = new VistaBuscador();
    }
}