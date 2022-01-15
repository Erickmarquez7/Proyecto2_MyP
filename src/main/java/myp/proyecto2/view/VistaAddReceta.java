package myp.proyecto2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import myp.proyecto2.model.*;
/**
 * VistaUsuario
 */
public class VistaAddReceta extends JPanel{
    /*Este es el canvas donde se agregan todos los elementos 
    a desplegar en la interfaz.*/
    private JFrame frame;

    private JLabel instrucciones;
	//Los label sirven para añadir texto a la ventana.
    private JLabel nombre;
    private JLabel ing;
    private JLabel cant;
    private JLabel ins;
    private JLabel tiempo;
    private JLabel dificultad;


    private BaseDatosChefs base = new BaseDatosChefs();

	/*Los JTextField sirven para añadir cuadros de texto 
    donde el usuario puede escribir. Los JPasswordField
    sirven para agregar texto y se depsliegue como un simbolo*/
    private JTextField nombrefield;
    private JTextField ingfield;
    private JTextField cantfield;
    private JTextField insfield;
    private JTextField tiempofield;
    private JTextField dificultadfield;

	/*Los botones sirven para añadir acciones a la interfaz.
    Usualmente se les adjunta una acción cuando ocurre un evento
    (como presionar el boton)*/
    private JButton boton1;

    public VistaAddReceta(){
    	initDisplay();
    	initBoton();
        frame.setLayout(null);
    	//initPantalla();
        //this.getContentPane().setBackground(Color.RED);
    }

    public void initDisplay(){
    	frame = new JFrame("Añadir receta");
        //frame.setBackground(Color.CYAN);
        frame.setSize(800, 600);
        frame.setLocation(200,200);
        frame.getContentPane().setBackground(new Color(204,229,255));

        instrucciones = new JLabel("Por favor escriba la receta:");
        instrucciones.setFont(new Font("Courier", Font.BOLD, 30));
        instrucciones.setBounds(200,50,600,100);
        frame.add(instrucciones);

        //Se asigna un mensaje en la interfaz
        nombre=new JLabel("Nombre: ");
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        nombre.setBounds(100,150,200,50);
        nombre.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(nombre);

        ing=new JLabel("Ingrediente: ");
        ing.setBounds(100,200,200,50);
        ing.setFont(new Font("Courier", Font.BOLD, 20));
        frame.add(ing);

        cant=new JLabel("Cantidad: ");
        cant.setBounds(500,200,150,50);
        cant.setFont(new Font("Courier", Font.BOLD, 20));
        frame.add(cant);

        ins=new JLabel("Número Tel: ");
        ins.setBounds(100,250,200,50);
        ins.setFont(new Font("Courier", Font.BOLD, 20));
        frame.add(ins);

        tiempo=new JLabel("Tiempo prep: ");
        tiempo.setBounds(100,300,200,50);
        tiempo.setFont(new Font("Courier", Font.BOLD, 20));
        frame.add(tiempo);

        dificultad=new JLabel("Dificultad: ");
        dificultad.setBounds(100,350,200,50);
        dificultad.setFont(new Font("Courier", Font.BOLD, 20));
        frame.add(dificultad);

        //Se agrega un campo de texto
        nombrefield=new JTextField();
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        nombrefield.setBounds(300,152,400,46);
        nombrefield.setFont(new Font("Slab Serif", Font.ITALIC, 20));
        //Se agrega al frame
        frame.add(nombrefield);

        //Se agrega un campo de texto
        dirfield=new JTextField();
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        dirfield.setBounds(300,202,400,46);
        dirfield.setFont(new Font("Slab Serif", Font.ITALIC, 20));
        //Se agrega al frame
        frame.add(dirfield);

        /*Se agrega un campo de texto. 
        En este caso apareceran simbolos
        en lugar de caracteres*/
        numerofield=new JTextField();
        numerofield.setBounds(300,252,400,46);
        numerofield.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(numerofield);
    }


    public void initBoton(){
    	//Se agrega un boton con un mensaje
        boton1 = new JButton("Confirmar");
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        boton1.setBounds(450,400,250,50);
        boton1.setForeground(Color.WHITE);
        boton1.setBackground(Color.BLUE);
        boton1.setFont(new Font("Arial", Font.BOLD, 25));
        //Se agrega al frame
        frame.add(boton1);
    }


    public void function(ActionListener listo){
        boton1.addActionListener(e -> {
            String name = nombrefield.getText();
            String addres = dirfield.getText();
            String number = numerofield.getText();
            if(name.length() < 3 || !addres.contains(",") || (number.length() < 9 || number.length() > 10))
                frame = new VistaMensaje("Algún campo vacío o inválido", Color.RED);
            else{
                int num = 1;
                try{
                    num = Integer.parseInt(number);
                }catch(NumberFormatException nfe){
                    frame = new VistaMensaje("Error con en formato número", Color.RED);
                }finally{
                    Chef chef = new Chef(name, addres, num);
                    base.carga("src/main/java/myp/proyecto2/data/");
                    base.agregaRegistro(chef);
                    base.guarda();
                    frame = new VistaMensaje("El registro se ha agregado", Color.BLUE);
                    nombrefield.setText("");
                    dirfield.setText("");
                    numerofield.setText("");
                }
            }
        });
        boton1.addActionListener(listo);
    }

    
    public void setVisible(boolean bln){
        frame.setVisible(bln);
    }
}