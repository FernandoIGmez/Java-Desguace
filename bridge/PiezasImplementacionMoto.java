/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import java.util.ArrayList;
import pieza.Pieza;
import trabajopatronessoftware.DatosPrograma;

/**
 *
 * @author nano
 */
public class PiezasImplementacionMoto extends PiezasImplementacion{

    public PiezasImplementacionMoto(DatosPrograma d) {
        datos=d;
        piezasTemporales= new ArrayList<Pieza>();
    }
    
    @Override
    public ArrayList<Pieza> getPiezas() {
        ArrayList<Pieza> piezasAux = new ArrayList<Pieza>();
        for (int i=0 ; i< getDatos().getListaPiezas().size(); i++){
            if (getDatos().getListaPiezas().get(i).getTipoVehiculo().equals("Moto")){
                piezasAux.add(getDatos().getListaPiezas().get(i));
            }
        }
        piezasTemporales=piezasAux;
        return piezasTemporales;
    }

}
