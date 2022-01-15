package myp.proyecto2.view;

//Bibliotecas para la ventana y para eventos.
import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;

import myp.proyecto2.model.Proxy;
import myp.proyecto2.model.IProxy;
import myp.proyecto2.model.Cuenta;
import myp.proyecto2.model.BaseDatosCuentas;
import myp.proyecto2.model.CampoCuenta;

import java.awt.*;
/**
 * Vista proxy para valida la informacion del ususario
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
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

    //proxy para la validacion de datos
    private IProxy proxy;

    /* La base de datos de las cuentas asociadas al sitio. */
    private BaseDatosCuentas base = new BaseDatosCuentas();


    public VistaProxy(){
    	initDisplay();
    	initBoton();
        frame.setLayout(null);
    	//initPantalla();
        //this.getContentPane().setBackground(Color.RED);
    }


    /**
     * Incializa la pantalla así como el texto
     * y los campos de texto
     */
    public void initDisplay(){
    	frame = new JFrame("Cheems Ramsay");
        //frame.setBackground(Color.CYAN);
        frame.setSize(800, 600);
        frame.setLocation(200,200);
        frame.getContentPane().setBackground(new Color(204,229,255));

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


    /**
     * Inicializa la funcionalidad de los botones 
     */
    public void initBoton(){
    	//Se agrega un boton con un mensaje
        boton1 = new JButton("OK");

        //Se asigna su posicion y su dimension. Los parametros son (x,y,ancho,alto)
        boton1.setBounds(50,400,100,100);

        boton1.setFont(new Font("Arial", Font.BOLD, 30));
        //Se agrega al frame
        frame.add(boton1);
        /*Se le asigna un ActionListener que permitira actuar
        de cierta forma cuando se presione el boton*/
        boton1.addActionListener(e -> {
            System.out.println(contrafield.getPassword());
            System.out.println(textofield.getText());
            base.carga("src/main/java/myp/proyecto2/data/");
            
            //sacamos las cuenta
            LinkedList<Cuenta> cuentas = base.buscaRegistros(CampoCuenta.CUENTA, textofield.getText());
            for(Cuenta c : base.getRegistros())
                System.out.println(c.getCuenta());
            //sacamos la cuenta
            Cuenta cuenta  = cuentas.isEmpty() ? null : cuentas.getFirst();

            
            //verificamos que la cuenta no sea null
            if(cuenta != null){
                //en caso de no ser null la pasamos al proxy
                proxy = new Proxy(cuenta);
                //lo validamos con el proxy
                if(proxy.validar(cuenta.getCuenta(), new String(contrafield.getPassword()) )){
                    frame = new VistaMensaje("   Su pedido va en camino", Color.BLUE);
                    textofield.setText("");
                    contrafield.setText("");
                }
                //en caso de que los campos ambos campos sean correctos imprimos el mensaje valido
                //false en otro caso
                else{
                frame = new VistaMensaje("Datos de cuenta inválidos", Color.RED);
                System.out.println("Entra en el else");
                contrafield.setText("");
                }

            }else{
                System.out.println("Cuenta nula");
                frame = new VistaMensaje("   Cuenta no encontrada", Color.RED);
            }
        }   
        
        );
        
    }
    

    
    /**
     * Cambia la visibilidad del frame
     * @param bln el valor de la visibilidad del frame
     */   
    public void setVisible(boolean bln){
        frame.setVisible(bln);
    }
}
