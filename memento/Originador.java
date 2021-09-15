/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memento;

import trabajopatronessoftware.DatosPrograma;

/**
 *
 * @author nano
 */
public class Originador {
    public Recuerdo recuerdo;

    public Originador(DatosPrograma d) {
        recuerdo = new Recuerdo(d);
    }
    
    public Originador(){
        recuerdo = new Recuerdo();
    }
    public DatosPrograma recuperarDatos(){
        return recuerdo.restaurarDatosArchivo();
    }
    
    public void almacenarDatos(){
        recuerdo.almacenarDatosArchivo();
    }
    
    
}
