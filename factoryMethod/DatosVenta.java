/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryMethod;

import java.util.ArrayList;
import pieza.*;

/**
 *
 * @author nano
 */
public class DatosVenta extends Venta{

    public DatosVenta(ArrayList <Pieza> venta) {
        setPiezasVenta(venta);
    }
    
}
