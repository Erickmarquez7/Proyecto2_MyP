///package myp.proyecto2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VistaReceta extends JFrame{
    private JFrame frame;

    private JLabel texto;

    private int cantidad;

//    private JButton botonVerRecetas;
//    private JButton botonBuscarRecetas;

    public VistaReceta(){
        initDisplay();
        initBoton();
        initPantalla();
    }

    public <in> void initDisplay(){
        frame = new JFrame("Cheems Ramsay");
        frame.setBackground(Color.CYAN);
        frame.setSize(800, 600);
        frame.setLocation(200,200);

        JScrollPane scroolbar = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.setContentPane(scroolbar);
        /*
        texto = new JLabel("La receta a preparar es:\n");
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        //el primer parametro lo mueve en linea horizontal a la derecha
        //el segundo en vertical abajo
        //
        texto.setFont(new Font("Courier", Font.BOLD, 20));
        texto.setBounds(150,10,600,100);
        frame.add(texto);*/


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
        VistaReceta interfaz1 = new VistaReceta();
    }
}