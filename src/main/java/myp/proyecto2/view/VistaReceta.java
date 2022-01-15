package myp.proyecto2.view;

//import java.util.LinkedList;
import myp.proyecto2.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Vista Receta para que te muestre una receta en especifico
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */

public class VistaReceta extends JPanel{
    private JFrame frame;
    //proxy para validar los datos
    private VistaProxy proxy = new VistaProxy();
    //boton para pedir la receta
    private JButton pedir;
    //la receta en especifico
    private static Receta receta;


    public VistaReceta(){
        initDisplay();
        initBoton();
        frame.setLayout(null);
    }


    public VistaReceta(Receta receta){
        this.receta = receta;
    
        initDisplay();
        initBoton();
        frame.setLayout(null);
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

        if(receta == null){
            JLabel nula = new JLabel("No se puede cargar la receta");
            nula.setBounds(50,260,700,40);
            nula.setFont(new Font("Courier", Font.BOLD, 30));
            nula.setForeground(Color.RED);
            frame.add(nula);
            return;
        }

        
        //Se muestra el nombre
        JLabel name = new JLabel(receta.getNombre());
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setBounds(100,20,600,35);
        frame.add(name);

        // Se añaden los ingredintes
        JLabel ingrediente = new JLabel("Ingredientes:");
        ingrediente.setFont(new Font("Arial", Font.BOLD,20));
        ingrediente.setBounds(100,60,600,30);
        frame.add(ingrediente);

        int altura = 100;
        //cambiar por while it
        for(Ingrediente i : receta.getIngredientes()){
            ingrediente = new JLabel("* " + i.toString());
            ingrediente.setFont(new Font("Courier", Font.PLAIN,18));
            ingrediente.setBounds(150,altura,700,20);
            frame.add(ingrediente);
            altura += 20;
        }

        // Se añaden las instrucciones
        JLabel instruccion = new JLabel("Instrucciones:");
        instruccion.setFont(new Font("Arial", Font.BOLD, 20));
        instruccion.setBounds(100,altura+10,600,30);
        frame.add(instruccion);
        altura += 40;

        //cambiar por while con it
        for(String i : receta.getInstrucciones()){
            instruccion = new JLabel("* " + i);
            instruccion.setFont(new Font("Courier", Font.PLAIN,18));
            instruccion.setBounds(150,altura,700,20);
            frame.add(instruccion);
            altura += 20;
        }

        // Se añade el tiempo de preparación
        JLabel tiempo = new JLabel("Tiempo: ");
        tiempo.setFont(new Font("Arial", Font.BOLD, 20));
        tiempo.setBounds(100, altura+10, 200,30);
        frame.add(tiempo);

        tiempo = new JLabel(receta.getTiempoString());
        tiempo.setBounds(220,altura+10,200,30);
        tiempo.setFont(new Font("Courier", Font.PLAIN, 20));
        frame.add(tiempo);
        altura += 40;

        // Se añade la dificultad
        JLabel dificultad = new JLabel("Dificultad: ");
        dificultad.setFont(new Font("Arial", Font.BOLD, 20));
        dificultad.setBounds(100,altura,200,30);
        frame.add(dificultad);

        for(int i = 0; i < receta.getDificultad(); i++){
            dificultad = new JLabel("★");
            dificultad.setFont(new Font("Courier", Font.BOLD, 22));
            dificultad.setBounds(250 + i*30, altura+5, 30,20);
            frame.add(dificultad);
        }  
    }


    public void initBoton(){
    	//Se agrega un boton con un mensaje
        pedir = new JButton("Pedir a domicilio");
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        pedir.setBounds(450,500,300,50);
        pedir.setFont(new Font("Courier", Font.BOLD, 20));
        pedir.setBackground(Color.BLUE);
        pedir.setForeground(Color.WHITE);
        //Se agrega al frame
        frame.add(pedir);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/
	    pedir.addActionListener(e -> {
	        proxy.setVisible(true);

	    });
    }

    
    public void setVisible(boolean bln){
        frame.setVisible(bln);
    }


    public void function(ActionListener prox){
            pedir.addActionListener(prox);
    }
}
