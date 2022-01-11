import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class BaseDatos<R extends Registro> {

    private LinkedList<R> base;

    public BaseDatos(){
		this.base = new LinkedList<R>();
    }

    public int getNumRegistros(){
		return base.size();
    }

    public LinkedList<R> getRegistros(){
		return base;
    }

    public void agregaRegistro(R registro){
		base.add(registro);
    }

    public void eliminaRegistro(R registro){
		base.remove(registro);
    }

    public void limpia(){
		base.clear();
    }

    public void guarda(BufferedWriter out) throws IOException{
		try{
	    	for(R r : base)
			out.write(r.serializa());
		}catch (IOException ioe){
	    	throw new IOException("Error en entrada/salida de archivo");
		}
    }

    public void carga(BufferedReader in) throws IOException{
		limpia();
		String c;
		while((c = in.readLine()) != null && !(c.trim().equals(""))){
	    	R r = creaRegistro();
	    	try{
			r.deserializa(c);
	    	}catch (ExcepcionRegistroInvalido eri){
			throw new IOException("Error entrada y salida");
	    	}
	    	agregaRegistro(r);
		}
    }

    public abstract R creaRegistro();
}
