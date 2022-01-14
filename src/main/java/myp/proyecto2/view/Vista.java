package myp.proyecto2.view;
import myp.proyecto2.controller.Controlador;
import myp.proyecto2.model.Buscador;
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
        VistaAnade anade = new VistaAnade();

        //le añadimos funcionalidad a los botones de las vistas
        //a través de las poderosisimas y mamadisimas lambas 
        // 
        principal.function(e -> {
            System.out.println("Ver todas las recetas");
            muestra.setVisible(true);}, 

            e -> {
                System.out.println("Buscar las recetas");
                buscador.setVisible(true);},

            e -> {
                System.out.println("Suscribir usuario");
                usuario.setVisible(true);},

            e -> {
                System.out.println("Añadir recetas");
                anade.setVisible(true);}
            
        );


        //muestra.function();


        receta.function(e -> {
            System.out.println("Proxy");
            proxy.setVisible(true);}
        );


        usuario.function(e -> {
            System.out.println("Usuario agregado");
            ;}
        );

        //anade.function();

        new Controlador(principal, muestra, buscador, proxy, receta, usuario, anade);
    }

}
