package myp.proyecto2.controller;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

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

    Buscador b;

    LinkedList<Receta> recetas = new LinkedList<Receta>();
    LinkedList<Receta> base = new LinkedList<Receta>();;



    public Controlador(VistaPrincipal vistaPrincipal, VistaMuestra vistaMuestra, VistaBuscador vistaBuscador,
    VistaProxy vistaProxy, VistaReceta vistaReceta, VistaUsuario usuario){
        this.vistaPrincipal = vistaPrincipal;
        this.vistaMuestra = vistaMuestra;
        this.vistaBuscador = vistaBuscador;
        this.vistaProxy = vistaProxy;
        this.vistaReceta = vistaReceta;
        this.usuario = usuario;

/*        vistaBuscador.function(e -> {
            System.out.println("Buscar por Nombre");
            b = new PorNombre();
            recetas = b.busca("nombre", base);
            vistaMuestra.setRecetas(recetas);
            vistaMuestra.setVisible(true);}, 


            e -> {
            System.out.println("Buscar por Dificultad");
            b = new PorDificultad();
            vistaMuestra.setVisible(true);}, 

            e -> {
            System.out.println("Buscar por Tiempo");
            b = new PorTiempo();
            vistaMuestra.setVisible(true);}, 

            e -> {
            System.out.println("Buscar por Ingredientes");
            b = new PorIngredientes();
            vistaMuestra.setVisible(true);}
        );*/

    }


    public static void main(String[] args) {
        new Vista();
        Recetario recetario = new RecetarioCheems();

    } 
}

