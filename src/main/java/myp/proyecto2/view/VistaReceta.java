package myp.proyecto2.view;

import java.util.LinkedList;
import myp.proyecto2.model.*;
import javax.swing.*;
import java.awt.*;

public class VistaReceta extends JPanel{
    private JFrame frame;

    private JLabel texto;

    private int cantidad;

    private JButton pedir;

    private Receta receta;

//    private JButton pedir;
//    private JButton botonBuscarRecetas;

    public VistaReceta(){}
    public VistaReceta(Receta receta){
        this.receta = receta;
        //initDisplay();
        //initBoton();
//        initPantalla();
    }

    public void initDisplay(){
        frame = new JFrame("Cheems Ramsay");
        frame.setBackground(Color.CYAN);
        frame.setSize(800, 600);
        frame.setLocation(200,200);

        JScrollBar scrollbar = new JScrollBar(JScrollBar.VERTICAL);
        frame.setContentPane(scrollbar);
        
        //Se muestra el nombre
        JLabel name = new JLabel(receta.getNombre());
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setBounds(100,30,600,30);
        frame.add(name);

        // Se añaden los ingredintes
        JLabel ingrediente = new JLabel("Ingredintes:");
        ingrediente.setFont(new Font("Arial", Font.BOLD,20));
        ingrediente.setBounds(100,60,600,30);
        frame.add(ingrediente);

        int altura = 10;
        for(Ingrediente i : receta.getIngredientes()){
            ingrediente = new JLabel("* " + i.toString());
            ingrediente.setFont(new Font("Courier", Font.PLAIN,18));
            ingrediente.setBounds(150,altura,200,20);
            frame.add(ingrediente);
            altura += 20;
        }

        // Se añaden las instrucciones
        JLabel instruccion = new JLabel("Instrucciones:");
        instruccion.setFont(new Font("Arial", Font.BOLD, 20));
        instruccion.setBounds(100,altura+10,600,30);
        frame.add(instruccion);
        altura += 40;

        for(String i : receta.getInstrucciones()){
            instruccion = new JLabel("* " + i);
            instruccion.setFont(new Font("Courier", Font.PLAIN,18));
            instruccion.setBounds(150,altura,200,20);
            frame.add(instruccion);
            altura += 20;
        }

        // Se añade el tiempo de preparación
        JLabel tiempo = new JLabel("Tiempo: ");
        tiempo.setFont(new Font("Arial", Font.BOLD, 20));
        tiempo.setBounds(100, altura+10, 200,30);
        frame.add(tiempo);

        tiempo = new JLabel(receta.getTiempoString());
        tiempo.setBounds(180,altura+10,200,30);
        tiempo.setFont(new Font("Courier", Font.PLAIN, 18));
        frame.add(tiempo);
        altura += 40;

        // Se añade la dificultad
        JLabel dificultad = new JLabel("Dificulad: ");
        dificultad.setFont(new Font("Arial", Font.BOLD, 20));
        dificultad.setBounds(100,altura,200,30);
        frame.add(dificultad);

        for(int i = 0; i < receta.getDificultad(); i++){
            dificultad = new JLabel("★");
            dificultad.setFont(new Font("Courier", Font.BOLD, 20));
            dificultad.setBounds(250 + i*30, altura, 30,20);
            frame.add(dificultad);
        }

        
    }

    public void initBoton(){
    	//Se agrega un boton con un mensaje
        pedir = new JButton("Enviar a domicilio");
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        pedir.setBounds(550,400,150,50);
        pedir.setFont(new Font("Courier", Font.BOLD, 30));
        //Se agrega al frame
        frame.add(pedir);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/
        pedir.addActionListener(e -> {
            System.out.println("Envio a domicilio hecho");
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

    /*public static void main(String[] ar) {
        VistaReceta interfaz1 = new VistaReceta();
    }*/
}