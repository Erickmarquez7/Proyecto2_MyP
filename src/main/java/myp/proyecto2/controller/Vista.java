package myp.proyecto2.controller;

import myp.proyecto2.view.*;
/**
 * Vista para crear las demás vistas y controlarlas
 * @author Bernal Marquez Erick
 * @author Deloya Andrade Ana Valeria
 * @author Lopez Balcazar Fernando
 */
public class Vista {

    public Vista(){
        //Creacion de vistas
        VistaPrincipal principal = new VistaPrincipal();
        VistaBuscador buscador = new VistaBuscador();
        VistaMuestra muestra = new VistaMuestra();

        VistaProxy proxy = new VistaProxy();
        VistaReceta receta = new VistaReceta();

        VistaUsuario usuario = new VistaUsuario();
        

        //le añadimos funcionalidad a los botones de las vistas
        //a través de las poderosisimas y mamadisimas lambas 
        // 
        principal.function(e -> {
            muestra.setVisible(true);}, 

            e -> {
                buscador.setVisible(true);},

            e -> {
                usuario.setVisible(true);}
        );

        receta.function(e -> {
            proxy.setVisible(true);}
        );

        new Controlador(principal, muestra, buscador, proxy, receta, usuario);
    }

}
