public class test{

    public static void main(String[] args){
	String s = "nombre/ingrediente1-medida1-3,ingrediente2-medida2-3/instruccion1,instruccion2/5/3";
	String[] params = s.split("/");
	for(int i = 0; i < params.length; i++) System.out.println(i + " " + params[i]);
	try{
	    double d = Double.parseDouble(params[3]);
	    int e = Integer.parseInt(params[4]);
	}catch (NumberFormatException nfe){System.out.println("kk");}

	String[] params2 = params[1].trim().split("-");
	for(int i = 0; i < params2.length; i++) System.out.println(i + " <- " + params2[i]);
    }
}
