package myp.proyecto2.view;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

import myp.proyecto2.controller.Controlador;

import java.awt.*;


public class Vista extends JFrame{
    

    private CardLayout vistas;


    public Vista(){
        super("Cheems Ramsay");
        vistas = new CardLayout();
        VistaPrincipal principal = new VistaPrincipal();
        VistaBuscador buscador = new VistaBuscador();
        VistaMuestra muestra = new VistaMuestra();

        setLayout(vistas);
        new Controlador(principal, muestra, buscador);

        add(principal, "principal");
        add(buscador, "buscador");
        add(muestra, "muestra");

        principal.function(e -> vistas.show(Vista.this.getContentPane(), "muestra")
        , e -> vistas.show(Vista.this.getContentPane(), "buscador"));



    }

    public static void main(String[] args) {
        

    }


   
}