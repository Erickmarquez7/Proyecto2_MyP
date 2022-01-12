package myp.proyecto2.view;

import javax.swing.*;
import java.awt.*;

public class VistaReceta extends JFrame{
    private JFrame frame;

    private JLabel texto;

    private int cantidad;

    private JButton pedir;

//    private JButton pedir;
//    private JButton botonBuscarRecetas;

    public VistaReceta(){
        initDisplay();
        initBoton();
        initPantalla();
    }

    public void initDisplay(){
        frame = new JFrame("Cheems Ramsay");
        frame.setBackground(Color.CYAN);
        frame.setSize(800, 600);
        frame.setLocation(200,200);

        JScrollPane scroolbar = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.setContentPane(scroolbar);
        

        String nombre = "Con cebolla y arroz";
        String[] ings = new String[200];
        for(int j = 0; j < 200; j++)
            ings[j] = String.format("Ingrediente %d", j);
        int tiempo = 150;
        int dificultad = 3;
        //String preparacion =  "poner un kilo de hueva a preparar";

        int altura =110;
        JLabel neim = new JLabel("Nombre : " + nombre);
        neim.setFont(new Font("Courier", Font.BOLD, 20));
        neim.setBounds(100,50,400,30);
        frame.add(neim);
        neim = new JLabel("Ingredientes:");
        neim.setBounds(100,80,200,20);
        neim.setFont(new Font("Courier", Font.BOLD, 20));
        frame.add(neim);
        for(String ing : ings){
            JLabel ingrediente = new JLabel("* "+ing);
            ingrediente.setFont(new Font("Courier", Font.BOLD,20));
            ingrediente.setBounds(150,altura,200,20);
            frame.add(ingrediente);
            altura += 20;
        }
        neim = new JLabel("Tiempo:");
        neim.setBounds(100,altura, 200,30);
        neim.setFont(new Font("Courier", Font.BOLD, 20));
        frame.add(neim);
        neim = new JLabel(String.format("%d mins",tiempo));
        neim.setBounds(200,altura, 200,30);
        neim.setFont(new Font("Courier", Font.ITALIC, 20));
        frame.add(neim);
        altura += 30;
        neim = new JLabel("Dificultad: ");
        neim.setBounds(100,altura, 200,30);
        neim.setFont(new Font("Courier", Font.BOLD, 20));
        frame.add(neim);
        
        for(int i = 0; i < dificultad; i++){
            JLabel estrella = new JLabel("★");
            estrella.setFont(new Font("Courier", Font.BOLD,20));
            estrella.setBounds(250+i*30,altura,30,20);
            frame.add(estrella);

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