package myp.proyecto2.view;

import java.util.LinkedList;

import myp.proyecto2.model.BaseDatosRecetas;
import myp.proyecto2.model.Receta;
import myp.proyecto2.model.RecetarioCheems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Vista para las que muestre todas las recetas de una busqueda o en general
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public class VistaMuestra extends JPanel{

    private JFrame frame; 
    //para mostrar un receta en especifico 
    VistaReceta muestra;
    //para saber cual es la
    private Receta parametro;

    private JLabel texto;

    private LinkedList<Receta> recetas = new LinkedList<>();


//    private JButton botonVerRecetas;
//    private JButton botonBuscarRecetas;

    public VistaMuestra(){
        RecetarioCheems recetario = new RecetarioCheems();
        recetas = recetario.getRecetas();
        initDisplay();
        //initBoton();
        frame.setLayout(null);
    }

    public VistaMuestra(LinkedList<Receta> recetas){
        this.recetas = recetas;
        initDisplay();
        frame.setLayout(null);
        //initBoton();
    }


    /**
     * Incializa la pantalla así como el texto
     * y los campos de texto
     */
    public void initDisplay(){
        frame = new JFrame("Cheems Ramsay");
        frame.setBackground(Color.CYAN);
        frame.setSize(800, 600);
        frame.setLocation(200,200);
        frame.getContentPane().setBackground(new Color(204,229,255));

        if(recetas.isEmpty()){
            texto = new JLabel("No hay recetas que \ncoindicen con tu búsqueda :(");
            texto.setFont(new Font("Arial", Font.BOLD, 40));
            texto.setBounds(200,250,400,100);
            texto.setForeground(Color.RED);
            frame.add(texto);
            return;
        }

        texto = new JLabel("Las recetas que coinciden con ");
        texto.setFont(new Font("Courier", Font.BOLD, 30));
        texto.setBounds(100,50,600,50);
        frame.add(texto);

        JLabel texto2 = new JLabel("tu búsqueda son: ");
        texto2.setFont(new Font("Courier", Font.BOLD, 30));
        texto2.setBounds(100,80,600,50);
        frame.add(texto2);

        

        int contador = 0;
        for(Receta r : recetas){
            JLabel receta = new JLabel("*" + r.getNombre());
            receta.setFont(new Font("Arial", Font.PLAIN,20));
            receta.setBounds(130, 150+contador*30,300,30);
            frame.add(receta);

            JButton botonReceta = new JButton("Ver receta");
            botonReceta.setFont(new Font("Courier", Font.ITALIC,20));
            botonReceta.setBounds(450,150+contador*30,300,30);
            frame.add(botonReceta);
            contador++;

            botonReceta.addActionListener(e -> {
                parametro = r;
                muestra = new VistaReceta(r);
                muestra.setVisible(true);
            });
        }
    }


    /**
     * Cambia las recetas que queremos mostrar
     * @param recetas las nuevas recetas a mostrar
     */
    public void setRecetas(LinkedList<Receta> recetas){
        this.recetas = recetas;
    }


    /**
     * Cambia la visibilidad del frame
     * @param bln el valor de la visibilidad del frame
     */   
    public void setVisible(boolean bln){
        frame.setVisible(bln);
    }


}