package myp.proyecto2.view;

//Bibliotecas para la ventana y para eventos.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaProxy extends JPanel{

	/*Este es el canvas donde se agregan todos los elementos 
    a desplegar en la interfaz.*/
    private JFrame frame;

    private JLabel instrucciones;
	//Los label sirven para añadir texto a la ventana.
    private JLabel texto;
    private JLabel contra;

	/*Los JTextField sirven para añadir cuadros de texto 
    donde el usuario puede escribir. Los JPasswordField
    sirven para agregar texto y se depsliegue como un simbolo*/
    private JTextField textofield;
    private JPasswordField contrafield;

	/*Los botones sirven para añadir acciones a la interfaz.
    Usualmente se les adjunta una acción cuando ocurre un evento
    (como presionar el boton)*/
    private JButton boton1;

    public VistaProxy(){
    	initDisplay();
    	initBoton();
    	//initPantalla();
        //this.getContentPane().setBackground(Color.RED);
    }

    public void initDisplay(){
    	frame = new JFrame("Cheems Ramsay");
        //frame.setBackground(Color.CYAN);
        frame.setSize(800, 600);
        frame.setLocation(200,200);

        instrucciones = new JLabel("Ingrese a su cuenta");
        instrucciones.setFont(new Font("Courier", Font.BOLD, 30));
        instrucciones.setBounds(250,100,600,100);
        frame.add(instrucciones);

        //Se asigna un mensaje en la interfaz
        texto=new JLabel("Cuenta: ");
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        texto.setBounds(100,230,200,50);
        texto.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(texto);

        contra=new JLabel("Contraseña: ");
        contra.setBounds(100,280,200,50);
        contra.setFont(new Font("Courier", Font.BOLD, 20));
        frame.add(contra);

        //Se agrega un campo de texto
        textofield=new JTextField();
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        textofield.setBounds(300,230,400,50);
        textofield.setFont(new Font("Slab Serif", Font.ITALIC, 20));
        //Se agrega al frame
        frame.add(textofield);

        /*Se agrega un campo de texto. 
        En este caso apareceran simbolos
        en lugar de caracteres*/
        contrafield=new JPasswordField();
        contrafield.setBounds(300,280,400,50);
        contrafield.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(contrafield);
    }

    public void initBoton(){
    	//Se agrega un boton con un mensaje
        boton1 = new JButton("OK");
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        boton1.setBounds(550,400,150,50);
        boton1.setFont(new Font("Arial", Font.BOLD, 30));
        //Se agrega al frame
        frame.add(boton1);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/
        boton1.addActionListener(e -> {
	    System.out.println(textofield.getText());
            System.out.println("Prozy");
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
        VistaProxy interfaz1 = new VistaProxy();
    }
}
