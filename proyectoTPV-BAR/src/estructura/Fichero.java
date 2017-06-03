package estructura;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.regex.Pattern;

public class Fichero implements Serializable{
	private static final long serialVersionUID = 1L;
	public static Tpv tpv = new Tpv();
	private static final Pattern EXTENSION = Pattern.compile("^((\\w)+(\\.obj))$");

	
	/**
	 * Abrir
	 * Permite la lectura del fichero al programa.
	 * */
	public static void abrir(File file) throws IOException, ClassNotFoundException{
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
			tpv = (Tpv)in.readObject();
		}
	}
	
	
	/**
	 * Comprueba que el nombre del fichero sea el correcto
	 * @param file
	 * @return Fichero con extension
	 */
	public static File comprobarFichero(File file){
		if(EXTENSION.matcher(file.getName()).matches())
			return file;
		else{
			return  new File(file.getAbsolutePath()+".obj");
		}
	}
	

	/**
	 *  Guardar
	 * @param obj
	 * @throws IOException
	 */
	public static void guardar(Object obj, File fichero) throws IOException{
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))){	
			out.writeObject(obj);	
		}
	}	
	
	
}
