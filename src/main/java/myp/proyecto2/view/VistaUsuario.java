package myp.proyecto2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * VistaUsuario
 */
public class VistaUsuario extends JPanel{
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

    public VistaUsuario(){
    	initDisplay();
    	initBoton();
        frame.setLayout(null);
    	//initPantalla();
        //this.getContentPane().setBackground(Color.RED);
    }

    public void initDisplay(){
    	frame = new JFrame("Cheems Ramsay");
        //frame.setBackground(Color.CYAN);
        frame.setSize(800, 600);
        frame.setLocation(200,200);
        frame.getContentPane().setBackground(new Color(204,229,255));

        instrucciones = new JLabel("Ingrese su nueva cuenta");
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
        
    }


    public void function(ActionListener listo){
        boton1.addActionListener(listo);
    }

    
    public void setVisible(boolean bln){
        frame.setVisible(bln);
    }

    
}