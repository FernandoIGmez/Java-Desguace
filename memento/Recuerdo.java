/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memento;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import trabajopatronessoftware.DatosPrograma;
/**
 *
 * @author nano
 */


public class Recuerdo implements Serializable{
    @SuppressWarnings({ "unchecked" })
   
    private DatosPrograma datos;
    
    public Recuerdo (DatosPrograma d){
        datos = d;
    }
    
    public Recuerdo (){
        datos = new DatosPrograma();
    }
    
    public void setDatosPrograma(DatosPrograma d){
        datos=d;
    }
    
    public void almacenarDatosArchivo(){


        try {
            System.out.print("Guardando datos en el fichero objetos.dat\n");

            ObjectOutputStream escribiendoFichero = new ObjectOutputStream( 
            new FileOutputStream("objetos.dat") );
            escribiendoFichero.writeObject(datos);
            escribiendoFichero.close();
            System.out.println("Datos guardados con exito ok!");
            
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }

    }
    
    public DatosPrograma getDatosPrograma(){
        return datos;
    }
    
    public DatosPrograma restaurarDatosArchivo(){
       try{
          
            System.out.println("Leyendo DatosPrograma de objetos.dat");

            ObjectInputStream leyendoFichero = new ObjectInputStream( 
            new FileInputStream("objetos.dat") );
            DatosPrograma datos= (DatosPrograma)leyendoFichero.readObject();
            leyendoFichero.close();

            System.out.println("ok!");
            System.out.println("Datos leídos del fichero:");
            //if (datos == null) System.out.println("ERROR RECUERDO DATOS=NULL");
            return datos;
    }catch (Exception e){
           System.out.println("Error al restaurar los datos del programa");
    }
       return null;
}

}
