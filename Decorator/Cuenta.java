/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import java.util.ArrayList;
import pieza.*;
import factoryMethod.*;
/**
 *
 * @author nano
 */
public interface Cuenta {
    
    
    
    public void añadirVenta(Venta v);
    
    public ArrayList<Venta> getHistorialCompras();
}
