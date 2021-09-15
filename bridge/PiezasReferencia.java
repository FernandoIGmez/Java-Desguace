/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;
import java.util.ArrayList;
import pieza.*;
import trabajopatronessoftware.*;
/**
 *
 * @author nano
 */
public class PiezasReferencia {
    PiezasImplementacion piezasImplementacion;
    
    PiezasImplementacionAll pAll;
    PiezasImplementacionCamion pCamion;
    PiezasImplementacionTurismo pTurismo;
    PiezasImplementacionMoto pMoto;
    PiezasImplementacionFurgoneta pFurgoneta;
    
    public PiezasReferencia(DatosPrograma d){
        
        pAll= new PiezasImplementacionAll(d);
        pCamion= new PiezasImplementacionCamion(d);
        pTurismo= new PiezasImplementacionTurismo(d);
        pMoto= new PiezasImplementacionMoto(d);
        pFurgoneta= new PiezasImplementacionFurgoneta(d);
        piezasImplementacion=pAll;
    }
    
    
    //FUNCION QUE DEVOLVERA EL ARRAY A MOSTRAR EN LA LISTA DE PIEZAS
    public ArrayList<Pieza> piezasBusqueda(String fabricante, String modelo, int año){
        return piezasImplementacion.getPiezasFabricanteModeloAño(fabricante, modelo, año);
    }
    
  /*  public ArrayList<Pieza> seleccionTipoVehiculo(){
        
    }
    
    public ArrayList<Pieza> seleccionFabricanteModeloAño(){
        
    } */

    public PiezasImplementacion getPiezasImplementacion() {
        return piezasImplementacion;
    }

    public void setPiezasImplementacion(PiezasImplementacion piezasImplementacion) {
        this.piezasImplementacion = piezasImplementacion;
    }
    
    public void setImplementadorTodosVehiculos(){
        piezasImplementacion=pAll;
    }
    
    public void setImplementadorCamion(){
        piezasImplementacion=pCamion;
    }
    public void setImplementadorTurismo(){
        piezasImplementacion=pTurismo;
    }
    public void setImplementadorMoto(){
        piezasImplementacion=pMoto;
    }
    public void setImplementadorFurgoneta(){
        piezasImplementacion=pFurgoneta;
    }
    
    
}
