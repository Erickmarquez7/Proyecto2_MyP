package myp.proyecto2.controller;

import javax.swing.*;
import java.awt.*;

import  myp.proyecto2.view.*;
import  myp.proyecto2.model.*;

public class Controlador{
    //vista principal
    VistaPrincipal vistaPrincipal; //= new VistaPrincipal();
    //vista que te muestra todas las recetas dado un parametro, los 4 botones
    VistaMuestra vistaMuestra; //= new VistaMuestra();
    //vista para buscar por un parametro
    VistaBuscador vistaBuscador; //= new VistaBuscador();
    //vista para proxy
    VistaProxy vistaProxy; //= new VistaProxy();
    //vista para que te muestre toda la receta
    VistaReceta vistaReceta; //= new VistaReceta();

    VistaUsuario usuario;

    VistaAnade anade;

    public Controlador(VistaPrincipal vistaPrincipal, VistaMuestra vistaMuestra, VistaBuscador vistaBuscador,
    VistaProxy vistaProxy, VistaReceta vistaReceta, VistaUsuario usuario, VistaAnade anade){
        this.vistaPrincipal = vistaPrincipal;
        this.vistaMuestra = vistaMuestra;
        this.vistaBuscador = vistaBuscador;
        this.vistaProxy = vistaProxy;
        this.vistaReceta = vistaReceta;
        this.usuario = usuario;
        this.anade = anade;
    }


    public static void main(String[] args) {
        new Vista();
        Recetario recetario = new RecetarioCheems();

    } 
}

