package myp.proyecto2.view;
import myp.proyecto2.controller.Controlador;

public class Vista {
    
    public Vista(){
        VistaPrincipal principal = new VistaPrincipal();
        VistaBuscador buscador = new VistaBuscador();
        VistaMuestra muestra = new VistaMuestra();


        VistaProxy proxy = new VistaProxy();
        VistaReceta receta = new VistaReceta();

        VistaUsuario usuario = new VistaUsuario();
        VistaAnade anade = new VistaAnade();



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


        buscador.function(e -> {
            System.out.println("Buscar por Nombre");//
            //
            receta.setVisible(true);}, 

            e -> {
            System.out.println("Buscar por Dificultad");
            muestra.setVisible(true);}, 

            e -> {
            System.out.println("Buscar por Tiempo");
            muestra.setVisible(true);}, 

            e -> {
            System.out.println("Buscar por Ingredientes");
            muestra.setVisible(true);}
        );        


        //muestra.function();


        receta.function(e -> {
            System.out.println("Proxy");
            proxy.setVisible(true);}
        );


        usuario.function(e -> {
            System.out.println("Usuario agregado");
            muestra.setVisible(true);}
        );

        //anade.function();



        new Controlador(principal, muestra, buscador, proxy, receta, usuario, anade);
    }

}
