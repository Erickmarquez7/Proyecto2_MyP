package myp.proyecto2.view;

import java.util.LinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Vista para diferentes mensaje que queramos poner 
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */

public class VistaMensaje extends JFrame{

    private JLabel texto;
    //le pasamos el mensaje a mostrar y el color del mensaje
    public VistaMensaje(String mensaje, Color color){
        setLayout(null);
        setLocation(800,600);
        setSize(500,300);
        setTitle(mensaje);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        getContentPane().setBackground(new Color(204,229,255));

        texto = new JLabel(mensaje);//, SwingConstants.CENTER);
        texto.setFont(new Font("Courier", Font.BOLD, 25));
        texto.setBounds(50,100,500,50);
        texto.setForeground(color);

        add(texto);

        setVisible(true);
    }
}