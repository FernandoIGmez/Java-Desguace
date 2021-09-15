/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import java.util.ArrayList;
import pieza.Pieza;
import trabajopatronessoftware.*;

/**
 *
 * @author nano
 */
class PiezasImplementacionAll extends PiezasImplementacion {

    public PiezasImplementacionAll(DatosPrograma d) {
        datos=d;
        piezasTemporales= new ArrayList<Pieza>();
    }
    
    
    @Override
    public ArrayList<Pieza> getPiezas() {
        piezasTemporales=(datos.getListaPiezas());
        return piezasTemporales;
    }
}
