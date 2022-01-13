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
        VistaProxy proxy = new VistaProxy();
        VistaReceta receta = new VistaReceta();


        setLayout(vistas);
        new Controlador(principal, muestra, buscador, proxy, receta);
//
//
        add(principal, "principal");
        add(muestra, "muestra");
        add(buscador, "buscador");

        add(proxy, "proxy");
        add(receta,"receta");


        principal.function(e -> {vistas.show(Vista.this.getContentPane(), "muestra");
        System.out.println("Me quiero morir");}
        , e -> vistas.show(Vista.this.getContentPane(), "buscador"));

        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
   
}