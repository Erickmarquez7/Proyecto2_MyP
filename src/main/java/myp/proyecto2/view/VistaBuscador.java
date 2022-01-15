package myp.proyecto2.view;

//Bibliotecas para la ventana y para eventos.
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

import myp.proyecto2.model.*;
/**
 * Vista para las diferentes formas de buscar una receta
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */

public class VistaBuscador extends JPanel{
    private JFrame frame;
    
    private JLabel texto;
    //buscador para las diferentes formas de buscar, aqui implmentamos strategy
    private Buscador buscador;
    //para mostrar las recetas obtenidas
    private VistaMuestra mostrador;
    //Campo de busqueda
    private JTextField busqueda;
    //private VistaBusqueda vista;
    private JButton botonNombre;
    private JButton botonDificultad;
    private JButton botonTiempo;
    private JButton botonIngredientes;
    private JButton ok;

    private Recetario recetario;
    //botones para las recetas encontradas
    private LinkedList<JButton> botones;

    public VistaBuscador(){
        initDisplay();
        initBoton();
        frame.setLayout(null);
        //initPantalla();
    }


    /**
     * Incializa la pantalla así como el texto
     * y los campos de texto
     */
    public void initDisplay(){
        recetario = new RecetarioCheems();
        frame = new JFrame("Cheems Ramsay");
        frame.setSize(800, 600);
        frame.setLocation(200,200);
        frame.getContentPane().setBackground(new Color(204,229,255));

        texto = new JLabel("¿Cómo quieres buscar?");
        texto.setFont(new Font("Courier", Font.BOLD, 30));
        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        //el primer parametro lo mueve en linea horizontal a la derecha
        //el segundo en vertical abajo
        //
        texto.setBounds(200,80,600,100);
        frame.add(texto);

        busqueda = new JTextField();
        busqueda.setBounds(120,200,470,50);
        busqueda.setFont(new Font("Courier", Font.ITALIC, 18));
        frame.add(busqueda);
    }


    /**
     * Inicializa la funcionalidad de los botones 
     */
    public void initBoton(){
        botones = new LinkedList<>();

        botonNombre = new JButton("Buscar por nombre");
        botonNombre.setBounds(150,300,250,80);
        botonNombre.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        botones.add(botonNombre);
        frame.add(botonNombre);
        

        botonDificultad = new JButton("Por Dificultad");
        botonDificultad.setBounds(400,300,250,80);
        botonDificultad.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonDificultad);
        botones.add(botonDificultad);
        

        botonTiempo = new JButton("Por tiempo");
        botonTiempo.setBounds(150,380,250,80);
        botonTiempo.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonTiempo);
        botones.add(botonTiempo);
        

        botonIngredientes = new JButton("Por Ingredientes");
        botonIngredientes.setBounds(400,380,250,80);
        botonIngredientes.setFont(new Font("Courier", Font.BOLD, 20));
        //Se agrega al frame
        frame.add(botonIngredientes);
        botones.add(botonIngredientes);


        ok = new JButton("Buscar");
        ok.setBounds(600,200,150,50);
        ok.setFont(new Font("Courier", Font.BOLD, 20));
        frame.add(ok);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton
        en este caso por nombre
        */
        botonNombre.addActionListener(e ->{
            buscador = new PorNombre();
            colorBotones();
            botonNombre.setBackground(Color.PINK);
        });
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton
        en este caso por dificultad
        */
        botonDificultad.addActionListener(e ->{
            buscador = new PorDificultad();
            colorBotones();
            botonDificultad.setBackground(Color.PINK);
        });
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton
        en este caso por tiempo
        */
        botonTiempo.addActionListener(e ->{
            buscador = new PorTiempo();
            colorBotones();
            botonTiempo.setBackground(Color.PINK);
        });
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton
        en este caso por ingredientes
        */
        botonIngredientes.addActionListener(e ->{
            buscador = new PorIngredientes();
            colorBotones();
            botonIngredientes.setBackground(Color.PINK);
        });

        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton
        */
        ok.addActionListener(e -> {
            String buscar = busqueda.getText();
            if(buscar.equals("")){
                frame = new VistaMensaje("       Campo vacíos", Color.RED);
            }else{
                if(buscador == null)
                    frame = new VistaMensaje("Buscador no seleccionado", new Color(198,61,26));
                else{
                    LinkedList<Receta> resul = buscador.busca(buscar, recetario);
                    if(resul == null)
                        frame = new VistaMensaje("  Debe ingresar un número", Color.RED);
                    else{
                            mostrador = new VistaMuestra(resul);
                    mostrador.setVisible(true);
                    }
                }
            }
        });
    }


    /**
     * Solo colorea los botones, una funcionalidad inutil y que nos llevó vario tiempo
     * buscando en internet para saber como se hacia pero que se ve bonito
     */
    public void colorBotones(){
        for(JButton b : botones)
            b.setBackground(new Color(238,238,238));
    }


    /**
     * Cambia la visibilidad del frame
     * @param bln el valor de la visibilidad del frame
     */   
    public void setVisible(boolean bln){
        frame.setVisible(bln);
    }
}