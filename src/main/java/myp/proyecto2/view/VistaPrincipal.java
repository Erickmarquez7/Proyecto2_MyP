package myp.proyecto2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Vista principal, la que se va a mostrar iniciando el programa
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public class VistaPrincipal extends JPanel{

    private JFrame frame;

    private JLabel texto;
    //los difrentes botones del menu
    private JButton botonVerRecetas;
    private JButton botonBuscarRecetas;

    private JButton botonSuscribir;
    private JButton botonAddReceta;


    
    public VistaPrincipal(){
    setLayout(new GridBagLayout());
        initDisplay();
        initBoton();
        initPantalla();
    }

    
    /**
     * Incializa la pantalla así como el texto
     * y los campos de texto
     */    
    public void initDisplay(){
        frame = new JFrame("Cheems Ramsay");
        frame.setSize(800, 600);
        frame.setLocation(200,200);
        frame.getContentPane().setBackground(new Color(204,229,255));

        JLabel saludo = new JLabel("Bienvenido al recetario de");
        saludo.setBounds(100,100,700,50);
        saludo.setFont(new Font("Courier", Font.ITALIC, 40));
        saludo.setForeground(new Color(102,0,51));
        frame.add(saludo);

        JLabel saludo2 = new JLabel("Cheems Ramsay");
        saludo2.setFont(new Font("Courier", Font.ITALIC, 40));
        saludo2.setBounds(250,150,700,50);
        saludo2.setForeground(new Color(102,0,51));
        frame.add(saludo2);

        texto = new JLabel("Selecciona que deseas hacer");
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        //el primer parametro lo mueve en linea horizontal a la derecha
        //el segundo en vertical abajo
        //
        texto.setFont(new Font("Courier", Font.BOLD, 30));
        texto.setBounds(150,220,600,100);
        frame.add(texto);

    }

    /**
     * Inicializa la funcionalidad de los botones 
     */
    public void initBoton(){
        botonVerRecetas = new JButton("Ver todas las recetas");
        botonVerRecetas.setBounds(200,350,400,50);
        //botonVerRecetas.setPreferredSize(new Dimension(400,50));
        botonVerRecetas.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonVerRecetas);
        

        botonBuscarRecetas = new JButton("Buscar recetas");
        botonBuscarRecetas.setFont(new Font("Courier", Font.BOLD, 20));
        botonBuscarRecetas.setBounds(200,400,400,50);
        //botonVerRecetas.setPreferredSize(new Dimension(400,50));
        //Se agrega al frame
        frame.add(botonBuscarRecetas);
        //add(botonBuscarRecetas);

	    botonAddReceta = new JButton("Añadir receta");
	    botonAddReceta.setFont(new Font("Courier", Font.BOLD, 15));
	    botonAddReceta.setBounds(550,600,200,30);
	    frame.add(botonAddReceta);
        //add(botonAddReceta);

	    botonSuscribir = new JButton("Suscribir");
	    Font fontSuscribir = new Font("Courier", Font.BOLD, 18);
	    botonSuscribir.setFont(fontSuscribir);
	    botonSuscribir.setBounds(550,20,200,40);
	    botonSuscribir.setBackground(Color.RED);
	    botonSuscribir.setForeground(Color.WHITE);
	    frame.add(botonSuscribir);
        //add(botonSuscribir);
	    
    }



    public void function(ActionListener verRecetas, ActionListener buscarRecetas, 
    ActionListener suscribe, ActionListener addreceta){
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/
        botonVerRecetas.addActionListener(verRecetas);
        //botonVerRecetas.addActionListener(e ->{frame = new Ejemplo7b();});
        botonBuscarRecetas.addActionListener(buscarRecetas);

        botonSuscribir.addActionListener(suscribe);
        botonAddReceta.addActionListener(addreceta);

    }


    /**
     * Cambia las propiedades del frame a mostrar
     */
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

    
    /**
     * Cambia la visibilidad del frame
     * @param bln el valor de la visibilidad del frame
     */   
    public void setVisible(boolean bln){
        frame.setVisible(bln);
    }

    
	public void function(ActionListener verRecetas, ActionListener buscarRecetas,
			ActionListener suscribe) {
                       
        botonVerRecetas.addActionListener(verRecetas);
        //botonVerRecetas.addActionListener(e ->{frame = new Ejemplo7b();});
        botonBuscarRecetas.addActionListener(buscarRecetas);

        botonSuscribir.addActionListener(suscribe);

	}

}
